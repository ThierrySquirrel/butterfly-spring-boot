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

package com.github.thierrysquirrel.butterfly.core.factory.scanning;

import com.github.thierrysquirrel.butterfly.annotation.Butterfly;
import com.github.thierrysquirrel.butterfly.core.scanning.ScanningButterflyRegister;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;

/**
 * ClassName: ScanningButterflyRegisterFactory
 * Description:
 * date: 2019/10/19 13:01
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ScanningButterflyRegisterFactory {
    private ScanningButterflyRegisterFactory() {
    }

    private static ScanningButterflyRegister createScanningButterflyRegister(boolean useDefaultFilters, Environment environment, ResourceLoader resourceLoader, Class<? extends Annotation> annotationClass) {
        ScanningButterflyRegister scanningButterflyRegister = new ScanningButterflyRegister (useDefaultFilters, environment);
        scanningButterflyRegister.setResourceLoader (resourceLoader);

        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter (annotationClass);
        scanningButterflyRegister.addIncludeFilter (annotationTypeFilter);

        return scanningButterflyRegister;
    }

    public static ScanningButterflyRegister createDefaultScanningButterflyRegister(Environment environment, ResourceLoader resourceLoader) {
        return createScanningButterflyRegister (false, environment, resourceLoader, Butterfly.class);
    }
}
