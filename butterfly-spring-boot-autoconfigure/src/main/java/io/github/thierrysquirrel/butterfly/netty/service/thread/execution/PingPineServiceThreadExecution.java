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

package io.github.thierrysquirrel.butterfly.netty.service.thread.execution;

import io.github.thierrysquirrel.butterfly.netty.service.thread.AbstractPingPineServiceThread;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.ClientClusterFactory;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.PineRequestContextFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import lombok.extern.slf4j.Slf4j;


/**
 * ClassName: PingPineServiceThreadExecution
 * Description:
 * date: 2019/10/19 16:28
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class PingPineServiceThreadExecution extends AbstractPingPineServiceThread {
    public PingPineServiceThreadExecution(String pineServiceUrl, String butterflyServiceName, String butterflyServiceUrl) {
        super (pineServiceUrl, butterflyServiceName, butterflyServiceUrl);
    }

    @Override
    protected void pingPineService(String pineServiceUrl, String butterflyServiceName, String butterflyServiceUrl) {

        PineRequestContext pingPineRequestContext = PineRequestContextFactory.createPingPineRequestContext (butterflyServiceName, butterflyServiceUrl);
        try {
            ClientClusterFactory.request(pineServiceUrl,pineServiceUrl,pingPineRequestContext);
        } catch (Exception e) {
            log.error ("PingPineService Error", e);
        }
    }
}
