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
 * ClassName: AbstractGetPineServiceProducerThread
 * Description:
 * date: 2019/10/19 16:40
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public abstract class AbstractGetPineServiceProducerThread implements Runnable {
    private final String pineServiceUrl;

    protected AbstractGetPineServiceProducerThread(String pineServiceUrl) {
        this.pineServiceUrl = pineServiceUrl;
    }

    /**
     * getPineServiceProducerName
     *
     * @param pineServiceUrl String
     */
    protected abstract void getPineServiceProducerName(String pineServiceUrl);

    @Override
    public void run() {
        getPineServiceProducerName (this.pineServiceUrl);
    }
}
