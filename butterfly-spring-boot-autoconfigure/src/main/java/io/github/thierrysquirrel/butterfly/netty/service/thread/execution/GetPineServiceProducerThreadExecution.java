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

import io.github.thierrysquirrel.butterfly.core.factory.ProduceNameFactory;
import io.github.thierrysquirrel.butterfly.netty.service.thread.AbstractGetPineServiceProducerThread;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.ClientClusterFactory;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.PineRequestContextFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.PineResponse;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ClassName: GetPineServiceProducerThreadExecution
 * Description:
 * date: 2019/10/19 17:02
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class GetPineServiceProducerThreadExecution extends AbstractGetPineServiceProducerThread {

    public GetPineServiceProducerThreadExecution(String pineServiceUrl) {
        super (pineServiceUrl);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void getPineServiceProducerName(String pineServiceUrl) {
        List<String> produceNameList = ProduceNameFactory.getProduceNameList ();
        for (String produceName : produceNameList) {
            PineRequestContext byProducersNameGetUrlsRequest = PineRequestContextFactory.createByProducersNameGetUrlsRequest (produceName);
            try {
                PineRequestContext request = ClientClusterFactory.request(pineServiceUrl, pineServiceUrl,byProducersNameGetUrlsRequest);
                PineResponse pineResponse = request.getPineResponse ();
                Object data = pineResponse.getData ();
                if (data != null) {
                    ProduceNameFactory.setProduceNameUrl (produceName, (List<String>) data);
                }
            } catch (NullPointerException nullPointerException) {
                log.warn (produceName + "Non-existent");
            } catch (Exception e) {
                log.error ("GetPineServiceProducerName Error", e);
            }
        }
    }
}
