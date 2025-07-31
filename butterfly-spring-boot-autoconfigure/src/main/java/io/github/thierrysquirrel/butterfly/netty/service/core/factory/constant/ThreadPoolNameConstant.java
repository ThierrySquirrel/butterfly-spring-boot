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

package io.github.thierrysquirrel.butterfly.netty.service.core.factory.constant;

/**
 * ClassName: ThreadPoolNameConstant
 * Description:
 * date: 2019/10/19 14:54
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public enum ThreadPoolNameConstant {
    /**
     * ButterflyServiceInit
     */
    BUTTERFLY_SERVICE_INIT ("ButterflyServiceInit"),
    /**
     * ButterServiceBusiness
     */
    BUTTER_SERVICE_BUSINESS ("ButterServiceBusiness"),
    /**
     * PingPineService
     */
    PING_PINE_SERVICE("PingPineService"),
    /**
     * GetPineServiceProducerName
     */
    GET_PINE_SERVICE_PRODUCER_NAME("GetPineServiceProducerName");

    private final String value;

    ThreadPoolNameConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
