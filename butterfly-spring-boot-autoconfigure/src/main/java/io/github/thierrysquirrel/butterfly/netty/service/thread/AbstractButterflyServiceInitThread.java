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

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: AbstractButterflyServiceInitThread
 * Description:
 * date: 2019/10/19 14:23
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public abstract class AbstractButterflyServiceInitThread implements Runnable {
    private final ThreadPoolExecutor butterflyServiceBusinessThreadPool;
    private final String butterflyServiceUrl;

    protected AbstractButterflyServiceInitThread(ThreadPoolExecutor butterflyServiceBusinessThreadPool, String butterflyServiceUrl) {
        this.butterflyServiceBusinessThreadPool = butterflyServiceBusinessThreadPool;
        this.butterflyServiceUrl = butterflyServiceUrl;
    }

    /**
     * butterflyServiceInit
     *
     * @param pingServiceBusinessThreadPool ThreadPoolExecutor
     * @param butterflyServiceUrl           String
     */
    protected abstract void butterflyServiceInit(ThreadPoolExecutor pingServiceBusinessThreadPool, String butterflyServiceUrl);

    @Override
    public void run() {
        butterflyServiceInit (this.butterflyServiceBusinessThreadPool, this.butterflyServiceUrl);
    }
}
