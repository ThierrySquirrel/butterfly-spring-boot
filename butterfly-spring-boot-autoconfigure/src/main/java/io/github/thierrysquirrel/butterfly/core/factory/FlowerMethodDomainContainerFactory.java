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
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ClassName: FlowerMethodDomainContainerFactory
 * Description:
 * date: 2019/10/19 18:18
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class FlowerMethodDomainContainerFactory {
    private FlowerMethodDomainContainerFactory() {
    }

    private static final Map<String, FlowerMethodDomain> CONTAINER = Maps.newConcurrentMap ();

    public static void putContainer(String coordinate, FlowerMethodDomain flowerMethodDomain) {
        CONTAINER.put (coordinate, flowerMethodDomain);
    }

    public static FlowerMethodDomain getContainer(String coordinate) {
        return CONTAINER.get (coordinate);
    }
}
