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
 * ClassName: ThreadPoolSizeConstant
 * Description:
 * date: 2019/10/19 14:56
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public enum ThreadPoolSizeConstant {
    /**
     * ButterflyServiceInitCorePoolSize
     */
    BUTTERFLY_SERVICE_INIT_CORE_POOL_SIZE (1),
    /**
     * ButterflyServiceInitMaximumPoolSize
     */
    BUTTERFLY_SERVICE_INIT_MAXIMUM_POOL_SIZE (1),
    /**
     * ButterflyServiceInitKeepAliveTime
     */
    BUTTERFLY_SERVICE_INIT_KEEP_ALIVE_TIME (0),
    /**
     * ButterflyServiceInitCapacity
     */
    BUTTERFLY_SERVICE_INIT_CAPACITY (1),
    /**
     * ButterflyServiceBusinessKeepAliveTime
     */
    BUTTERFLY_SERVICE_BUSINESS_KEEP_ALIVE_TIME (0),
    /**
     * PingPineServiceCorePoolSize
     */
    PING_PINE_SERVICE_CORE_POOL_SIZE (1),
    /**
     * PingPineServiceInitialDelay
     */
    PING_PINE_SERVICE_INITIAL_DELAY (0),
    /**
     * GetPineServiceProducerNameCorePoolSize
     */
    GET_PINE_SERVICE_PRODUCER_NAME_CORE_POOL_SIZE (1),
    /**
     * GetPineServiceProducerNameDelay
     */
    GET_PINE_SERVICE_PRODUCER_NAME_DELAY (0);
    private int value;

    ThreadPoolSizeConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
