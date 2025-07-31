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

package io.github.thierrysquirrel.butterfly.netty.service;

import io.github.thierrysquirrel.pine.common.netty.core.AbstractInitChannelHandler;
import io.netty.channel.socket.SocketChannel;
import lombok.Data;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: ButterflyServiceInitChannelHandler
 * Description:
 * date: 2019/10/19 14:31
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class ButterflyServiceInitChannelHandler extends AbstractInitChannelHandler {
    private long readerIdleTime;
    private long writerIdleTime;
    private long allIdleTime;
    private ThreadPoolExecutor butterflyServiceBusinessThreadPool;

    public ButterflyServiceInitChannelHandler(long readerIdleTime, long writerIdleTime, long allIdleTime, ThreadPoolExecutor butterflyServiceBusinessThreadPool) {
        this.readerIdleTime = readerIdleTime;
        this.writerIdleTime = writerIdleTime;
        this.allIdleTime = allIdleTime;
        this.butterflyServiceBusinessThreadPool = butterflyServiceBusinessThreadPool;
    }

    @Override
    protected void initChannel(SocketChannel ch) {
        super.init (ch,
                this.readerIdleTime,
                this.writerIdleTime,
                this.allIdleTime);
        ch.pipeline ().addLast (new ButterflyServiceHandler (this.butterflyServiceBusinessThreadPool));
    }
}
