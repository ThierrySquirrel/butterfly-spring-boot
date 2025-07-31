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

package io.github.thierrysquirrel.butterfly.core.scanning;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.env.Environment;

/**
 * ClassName: ScanningButterflyRegister
 * Description:
 * date: 2019/10/19 13:00
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ScanningButterflyRegister extends ClassPathScanningCandidateComponentProvider {
    public ScanningButterflyRegister(boolean useDefaultFilters, Environment environment) {
        super(useDefaultFilters, environment);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition annotatedBeanDefinition) {
        if (annotatedBeanDefinition.getMetadata().isIndependent() && !annotatedBeanDefinition.getMetadata().isAnnotation()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
