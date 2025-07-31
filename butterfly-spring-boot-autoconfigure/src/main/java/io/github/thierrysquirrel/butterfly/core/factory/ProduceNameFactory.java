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

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ProduceNameFactory
 * Description:
 * date: 2019/10/19 16:42
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ProduceNameFactory {
    private ProduceNameFactory() {
    }

    private static final List<String> produceNameList = new ArrayList<> ();
    private static final Map<String, List<String>> produceNameUrlMap = Maps.newConcurrentMap ();

    public static void setProduceName(String produceName) {
        produceNameList.add (produceName);
    }

    public static List<String> getProduceNameList() {
        return produceNameList;
    }

    public static void setProduceNameUrl(String produceName, List<String> produceUrlList) {
        produceNameUrlMap.put (produceName, produceUrlList);
    }

    public static List<String> getProduceNameUrl(String produceName) {
        return produceNameUrlMap.get (produceName);
    }
}
