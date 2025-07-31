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

import io.github.thierrysquirrel.butterfly.core.domain.FlowerMethodDomain;
import io.github.thierrysquirrel.butterfly.core.factory.FlowerMethodDomainContainerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName: FlowerMethodDomainContainerFactoryExecution
 * Description:
 * date: 2019/10/19 18:28
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class FlowerMethodDomainContainerFactoryExecution {

    private FlowerMethodDomainContainerFactoryExecution() {
    }

    public static Object execution(String container, Object... args) throws InvocationTargetException, IllegalAccessException {
        FlowerMethodDomain flowerMethodDomain = FlowerMethodDomainContainerFactory.getContainer (container);
        Method method = flowerMethodDomain.getMethod ();
        Object object = flowerMethodDomain.getObject ();
        return method.invoke (object, args);
    }
}
