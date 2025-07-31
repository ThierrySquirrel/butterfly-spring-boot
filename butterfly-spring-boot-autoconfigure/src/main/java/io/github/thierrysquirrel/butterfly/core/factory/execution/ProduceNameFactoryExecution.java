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

import io.github.thierrysquirrel.butterfly.annotation.Butterfly;
import io.github.thierrysquirrel.butterfly.core.factory.ProduceNameFactory;
import io.github.thierrysquirrel.butterfly.core.factory.constant.ProduceNameFactoryConstant;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ClassName: ProduceNameFactoryExecution
 * Description:
 * date: 2019/10/19 18:57
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class ProduceNameFactoryExecution {
    private ProduceNameFactoryExecution() {
    }

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    public static String getServiceUrl(String produceName) {
        List<String> produceNameUrlList = ProduceNameFactory.getProduceNameUrl(produceName);

        int increment = ATOMIC_INTEGER.incrementAndGet();
        int offset = increment % produceNameUrlList.size();
        int positiveOffset = (offset + produceNameUrlList.size()) % produceNameUrlList.size();
        return produceNameUrlList.get(positiveOffset);
    }

    public static void setProduceName(AnnotationMetadata metadata) {
        Map<String, Object> attributes = metadata
                .getAnnotationAttributes(
                        Butterfly.class.getCanonicalName());
        String produceName = attributes.get(ProduceNameFactoryConstant.DEFAULT_VALUE.getValue()).toString();
        ProduceNameFactory.setProduceName(produceName);
    }
}
