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

package io.github.thierrysquirrel.butterfly.autoconfigure;

import io.github.thierrysquirrel.butterfly.annotation.EnableButterfly;
import io.github.thierrysquirrel.butterfly.aspect.ButterflyAspect;
import io.github.thierrysquirrel.butterfly.core.factory.constant.ComponentScanConstant;
import io.github.thierrysquirrel.butterfly.init.ButterflyFilterInit;
import io.github.thierrysquirrel.butterfly.init.ButterflyServiceEventInit;
import io.github.thierrysquirrel.butterfly.init.FlowerFilterInit;
import io.github.thierrysquirrel.butterfly.init.FlowerInit;
import io.github.thierrysquirrel.butterfly.netty.service.init.ButterflyServiceInit;
import io.github.thierrysquirrel.butterfly.netty.service.init.GetPineServiceProducerNameInit;
import io.github.thierrysquirrel.butterfly.netty.service.init.PingPineServiceInit;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * ClassName: ButterflyAutoConfiguration
 * Description:
 * date: 2019/10/19 12:50
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */

@Configuration
@EnableConfigurationProperties(ButterflyProperties.class)
@ConditionalOnBean(annotation = EnableButterfly.class)
@ComponentScan(basePackages = {ComponentScanConstant.DEFAULT_SCAN})
public class ButterflyAutoConfiguration {
    @Resource
    private ButterflyProperties butterflyProperties;

    @Bean
    @ConditionalOnMissingBean(ButterflyAspect.class)
    public ButterflyAspect butterflyAspect() {
        return new ButterflyAspect ();
    }

    @Bean
    @ConditionalOnMissingBean(ButterflyServiceEventInit.class)
    public ButterflyServiceEventInit butterflyServiceEventInit() {
        return new ButterflyServiceEventInit ();
    }

    @Bean
    @ConditionalOnMissingBean(FlowerInit.class)
    public FlowerInit flowerInit() {
        return new FlowerInit ();
    }

    @Bean
    @ConditionalOnMissingBean(ButterflyServiceInit.class)
    public ButterflyServiceInit butterflyServiceInit() {
        return new ButterflyServiceInit (butterflyProperties);
    }

    @Bean
    @ConditionalOnMissingBean(GetPineServiceProducerNameInit.class)
    public GetPineServiceProducerNameInit getPineServiceProducerNameInit() {
        return new GetPineServiceProducerNameInit (butterflyProperties);
    }

    @Bean
    @ConditionalOnMissingBean(PingPineServiceInit.class)
    public PingPineServiceInit pingPineServiceInit() {
        return new PingPineServiceInit (butterflyProperties);
    }

    @Bean
    @ConditionalOnMissingBean(ButterflyFilterInit.class)
    public ButterflyFilterInit butterflyFilterInit(){
        return new ButterflyFilterInit();
    }

    @Bean
    @ConditionalOnMissingBean(FlowerFilterInit.class)
    public FlowerFilterInit flowerFilterInit(){
        return new FlowerFilterInit();
    }

}
