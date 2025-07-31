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

package io.github.thierrysquirrel.butterfly.netty.service.event;

import io.github.thierrysquirrel.butterfly.annotation.ButterflyServiceEvent;
import io.github.thierrysquirrel.butterfly.annotation.ButterflyServiceHandler;
import io.github.thierrysquirrel.butterfly.core.factory.execution.FlowerMethodDomainContainerFactoryExecution;
import io.github.thierrysquirrel.pine.common.netty.core.client.factory.PineRequestContextFactory;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Command;
import io.github.thierrysquirrel.pine.common.netty.domain.constant.Modular;
import io.netty.channel.ChannelHandlerContext;

import java.lang.reflect.InvocationTargetException;

/**
 * ClassName: ConsumptionHandler
 * Description:
 * date: 2019/10/19 17:22
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@ButterflyServiceHandler
public class ConsumptionHandler {
    @ButterflyServiceEvent(modular = Modular.CONSUMPTION, command = Command.RPC)
    public void rpc(ChannelHandlerContext ctx, PineRequestContext msg, String coordinate, Object[] args) throws InvocationTargetException, IllegalAccessException {
        Object execution = FlowerMethodDomainContainerFactoryExecution.execution (coordinate, args);
        PineRequestContext rpcResponse = PineRequestContextFactory.createRpcResponse (execution);
        ctx.channel ().writeAndFlush (rpcResponse);
    }
}
