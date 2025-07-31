/**
 * Copyright 2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.thierrysquirrel.butterfly.init;

import io.github.thierrysquirrel.butterfly.annotation.ButterflyServiceEvent;
import io.github.thierrysquirrel.butterfly.annotation.ButterflyServiceHandler;
import io.github.thierrysquirrel.butterfly.netty.service.core.utils.AnnotatedMethodsUtils;
import io.github.thierrysquirrel.pine.common.netty.core.domain.MethodContainer;
import io.github.thierrysquirrel.pine.common.netty.core.factory.EventExecutionContainerFactory;
import io.github.thierrysquirrel.pine.common.netty.core.factory.MethodContainerFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * ClassName: ButterflyServiceEventInit
 * Description:
 * date: 2019/10/19 15:35
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class ButterflyServiceEventInit implements ApplicationContextAware {

    private ApplicationContext applicationContext;


    @PostConstruct
    public void init() {
        applicationContext.getBeansWithAnnotation (ButterflyServiceHandler.class).forEach ((beanName, bean) ->
                AnnotatedMethodsUtils.getMethodAndAnnotation (bean, ButterflyServiceEvent.class).
                        forEach ((method, butterServiceEvent) -> {
                            Modular modular = butterServiceEvent.modular ();
                            Command command = butterServiceEvent.command ();
                            MethodContainer methodContainer = MethodContainerFactory.getMethodContainer (method, bean);

                            EventExecutionContainerFactory.setMethodContainer (modular, command, methodContainer);
                        })
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
