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

import io.github.thierrysquirrel.butterfly.netty.service.ButterflyServiceInitChannelHandler;
import io.github.thierrysquirrel.butterfly.netty.service.thread.AbstractButterflyServiceInitThread;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.InetSocketAddressFactory;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.constant.IdleStateConstant;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: ButterflyServiceInitThreadExecution
 * Description:
 * date: 2019/10/19 14:28
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Slf4j
public class ButterflyServiceInitThreadExecution extends AbstractButterflyServiceInitThread {
    public ButterflyServiceInitThreadExecution(ThreadPoolExecutor butterflyServiceBusinessThreadPool, String butterflyServiceUrl) {
        super (butterflyServiceBusinessThreadPool, butterflyServiceUrl);
    }

    @Override
    protected void butterflyServiceInit(ThreadPoolExecutor butterflyServiceBusinessThreadPool, String butterflyServiceUrl) {
        EventLoopGroup bossGroup = new NioEventLoopGroup ();
        EventLoopGroup workerGroup = new NioEventLoopGroup ();

        ServerBootstrap b = new ServerBootstrap ();

        b.group (bossGroup, workerGroup)
                .channel (NioServerSocketChannel.class)
                .childHandler (new ButterflyServiceInitChannelHandler (IdleStateConstant.READ_TIMEOUT.getValue (),
                        IdleStateConstant.OTHER_TIMEOUT.getValue (),
                        IdleStateConstant.OTHER_TIMEOUT.getValue (),
                        butterflyServiceBusinessThreadPool));
        try {
            ChannelFuture f = b.bind (InetSocketAddressFactory.getInetSocketAddress (butterflyServiceUrl)).sync ();
            f.channel ().closeFuture ().sync ();
        } catch (InterruptedException e) {
            log.error ("Butterfly Service start failed", e);
            Thread.currentThread ().interrupt ();
        } finally {
            workerGroup.shutdownGracefully ();
            bossGroup.shutdownGracefully ();
        }
    }
}
