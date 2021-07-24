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

package com.github.thierrysquirrel.butterfly.netty.service.init;

import com.github.thierrysquirrel.butterfly.autoconfigure.ButterflyProperties;
import com.github.thierrysquirrel.butterfly.core.factory.execution.ThreadPoolExecutorExecution;
import com.github.thierrysquirrel.butterfly.netty.service.core.factory.ThreadPoolFactory;
import com.github.thierrysquirrel.butterfly.netty.service.core.factory.constant.ThreadPoolSizeConstant;
import com.github.thierrysquirrel.butterfly.netty.service.thread.execution.PingPineServiceThreadExecution;

import javax.annotation.PostConstruct;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * ClassName: PingPineServiceInit
 * Description:
 * date: 2019/10/19 14:43
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class PingPineServiceInit {
    private ButterflyProperties butterflyProperties;

    public PingPineServiceInit(ButterflyProperties butterflyProperties) {
        this.butterflyProperties = butterflyProperties;
    }

    @PostConstruct
    public void init() {
        ScheduledThreadPoolExecutor pingPineServiceThreadPool = ThreadPoolFactory.createPingPineServiceThreadPool ();
        PingPineServiceThreadExecution pingPineServiceThreadExecution = new PingPineServiceThreadExecution (butterflyProperties.getPineServiceUrl (),
                butterflyProperties.getButterflyServiceName (),
                butterflyProperties.getButterflyServiceUrl ());
        ThreadPoolExecutorExecution.statsTimingThread (pingPineServiceThreadPool, pingPineServiceThreadExecution,
                ThreadPoolSizeConstant.PING_PINE_SERVICE_INITIAL_DELAY.getValue (),
                butterflyProperties.getPingPineServiceDelay ());

    }
}
