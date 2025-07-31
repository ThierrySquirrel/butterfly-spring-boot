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

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: ButterflyProperties
 * Description:
 * date: 2019/10/19 12:50
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
@ConfigurationProperties(prefix = ButterflyProperties.BUTTERFLY_PREFIX)
public class ButterflyProperties {
    public static final String BUTTERFLY_PREFIX = "butterfly";
    private String butterflyServiceName;
    private String butterflyServiceUrl;
    private String pineServiceUrl;
    private int butterflyServerBusinessThreadNums = Runtime.getRuntime ().availableProcessors () * 2;
    private int pingPineServiceDelay = 4096;
    private int updateProducerClusterCacheDelay = 4096;

}
