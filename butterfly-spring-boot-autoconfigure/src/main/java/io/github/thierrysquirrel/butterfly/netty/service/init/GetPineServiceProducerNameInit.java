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

package io.github.thierrysquirrel.butterfly.netty.service.init;

import io.github.thierrysquirrel.butterfly.autoconfigure.ButterflyProperties;
import io.github.thierrysquirrel.butterfly.core.factory.execution.ThreadPoolExecutorExecution;
import io.github.thierrysquirrel.butterfly.netty.service.core.factory.ThreadPoolFactory;
import io.github.thierrysquirrel.butterfly.netty.service.core.factory.constant.ThreadPoolSizeConstant;
import io.github.thierrysquirrel.butterfly.netty.service.thread.execution.GetPineServiceProducerThreadExecution;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * ClassName: GetPineServiceProducerNameInit
 * Description:
 * date: 2019/10/19 14:45
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class GetPineServiceProducerNameInit {
    private final ButterflyProperties butterflyProperties;

    public GetPineServiceProducerNameInit(ButterflyProperties butterflyProperties) {
        this.butterflyProperties = butterflyProperties;
    }

    @PostConstruct
    public void init() {
        ScheduledThreadPoolExecutor getPineServiceProducerNameThreadPool = ThreadPoolFactory.createGetPineServiceProducerNameThreadPool ();
        GetPineServiceProducerThreadExecution getPineServiceProducerThreadExecution = new GetPineServiceProducerThreadExecution (butterflyProperties.getPineServiceUrl ());
        ThreadPoolExecutorExecution.statsTimingThread (getPineServiceProducerNameThreadPool,
                getPineServiceProducerThreadExecution,
                ThreadPoolSizeConstant.GET_PINE_SERVICE_PRODUCER_NAME_CORE_POOL_SIZE.getValue (),
                butterflyProperties.getUpdateProducerClusterCacheDelay ());
    }

}
