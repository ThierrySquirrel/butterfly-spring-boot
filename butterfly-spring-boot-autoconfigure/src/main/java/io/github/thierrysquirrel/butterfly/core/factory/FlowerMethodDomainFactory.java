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

package io.github.thierrysquirrel.butterfly.core.factory;

import io.github.thierrysquirrel.butterfly.core.domain.FlowerMethodDomain;

import java.lang.reflect.Method;

/**
 * ClassName: FlowerMethodDomainFactory
 * Description:
 * date: 2019/10/19 18:14
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class FlowerMethodDomainFactory {
    private FlowerMethodDomainFactory() {
    }

    public static FlowerMethodDomain createFlowerMethodDomain(Method method, Object object) {
        FlowerMethodDomain flowerMethodContainer = new FlowerMethodDomain ();
        flowerMethodContainer.setMethod (method);
        flowerMethodContainer.setObject (object);
        return flowerMethodContainer;
    }
}
