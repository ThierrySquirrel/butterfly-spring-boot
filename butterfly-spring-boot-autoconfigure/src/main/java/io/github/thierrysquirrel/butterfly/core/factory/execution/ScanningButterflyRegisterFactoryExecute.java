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

package io.github.thierrysquirrel.butterfly.core.factory.execution;

import io.github.thierrysquirrel.butterfly.core.factory.scanning.BeanDefinitionBuilderFactory;
import io.github.thierrysquirrel.butterfly.core.factory.scanning.BeanDefinitionFactory;
import io.github.thierrysquirrel.butterfly.core.factory.scanning.ScanningButterflyRegisterFactory;
import io.github.thierrysquirrel.butterfly.core.scanning.ScanningButterflyRegister;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Set;

/**
 * ClassName: ScanningButterflyRegisterFactoryExecute
 * Description:
 * date: 2019/10/19 13:17
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ScanningButterflyRegisterFactoryExecute {
    private ScanningButterflyRegisterFactoryExecute() {
    }

    public static void execution(Environment environment, ResourceLoader resourceLoader, AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        ScanningButterflyRegister scanningButterflyRegister = ScanningButterflyRegisterFactory.createDefaultScanningButterflyRegister (environment, resourceLoader);
        Set<BeanDefinition> beanDefinition = BeanDefinitionFactory.getBeanDefinition (annotationMetadata, scanningButterflyRegister);
        beanDefinition.forEach (bead -> {
            AnnotatedBeanDefinition annotatedBeanDefinition = (AnnotatedBeanDefinition) bead;
            AnnotationMetadata metadata = annotatedBeanDefinition.getMetadata ();

            ProduceNameFactoryExecution.setProduceName (metadata);

            BeanDefinitionBuilder defaultBeanDefinitionBuilder = BeanDefinitionBuilderFactory.getDefaultBeanDefinitionBuilder (metadata);

            String className = metadata.getClassName ();
            AbstractBeanDefinition abstractBeanDefinition = defaultBeanDefinitionBuilder.getBeanDefinition ();
            BeanDefinitionHolder holder = new BeanDefinitionHolder (abstractBeanDefinition, className);
            BeanDefinitionReaderUtils.registerBeanDefinition (holder, registry);
        });
    }
}
