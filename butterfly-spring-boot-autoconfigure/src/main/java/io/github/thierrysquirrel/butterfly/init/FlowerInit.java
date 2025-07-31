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

import io.github.thierrysquirrel.butterfly.annotation.Flower;
import io.github.thierrysquirrel.butterfly.annotation.Fragrance;
import io.github.thierrysquirrel.butterfly.core.domain.FlowerMethodDomain;
import io.github.thierrysquirrel.butterfly.core.factory.FlowerMethodDomainContainerFactory;
import io.github.thierrysquirrel.butterfly.core.factory.FlowerMethodDomainFactory;
import io.github.thierrysquirrel.butterfly.netty.service.core.utils.AnnotatedMethodsUtils;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * ClassName: FlowerInit
 * Description:
 * date: 2019/10/19 18:06
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class FlowerInit implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        applicationContext.getBeansWithAnnotation (Flower.class).forEach ((beanName, bean) ->
                AnnotatedMethodsUtils.getMethodAndAnnotation (bean, Fragrance.class).
                        forEach ((method, fragrance) -> {
                            FlowerMethodDomain flowerMethodDomain = FlowerMethodDomainFactory.createFlowerMethodDomain (method, bean);
                            FlowerMethodDomainContainerFactory.putContainer (fragrance.value (), flowerMethodDomain);
                        })
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
