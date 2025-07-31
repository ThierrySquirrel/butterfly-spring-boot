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

package io.github.thierrysquirrel.butterfly.netty.service.thread;

/**
 * ClassName: AbstractPingPineServiceThread
 * Description:
 * date: 2019/10/19 16:14
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */

public abstract class AbstractPingPineServiceThread implements Runnable {
    private final String pineServiceUrl;
    private final String butterflyServiceName;
    private final String butterflyServiceUrl;

    protected AbstractPingPineServiceThread(String pineServiceUrl, String butterflyServiceName, String butterflyServiceUrl) {
        this.pineServiceUrl = pineServiceUrl;
        this.butterflyServiceName = butterflyServiceName;
        this.butterflyServiceUrl = butterflyServiceUrl;
    }

    /**
     * pingPineService
     *
     * @param pineServiceUrl       String
     * @param butterflyServiceName String
     * @param butterflyServiceUrl  String
     */
    protected abstract void pingPineService(String pineServiceUrl, String butterflyServiceName, String butterflyServiceUrl);

    @Override
    public void run() {
        pingPineService (this.pineServiceUrl, this.butterflyServiceName, this.butterflyServiceUrl);
    }
}
