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

package io.github.thierrysquirrel.butterfly.aspect;

import io.github.thierrysquirrel.butterfly.annotation.Butterfly;
import io.github.thierrysquirrel.butterfly.annotation.Flutter;
import io.github.thierrysquirrel.butterfly.core.factory.execution.InterceptExecution;
import io.github.thierrysquirrel.butterfly.core.utils.AspectUtils;
import io.github.thierrysquirrel.butterfly.error.ButterflyException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ClassName: ButterflyAspect
 * Description:
 * date: 2019/10/19 18:40
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Aspect
@Slf4j
@Data
public class ButterflyAspect {
    @Pointcut("@annotation(io.github.thierrysquirrel.butterfly.annotation.Flutter)")
    public void coordinatePointcut() {
        log.debug ("Start CoordinatePointcut");
    }

    @Around("coordinatePointcut()")
    public Object butterflyStartsWork(ProceedingJoinPoint point) throws ButterflyException {
        return InterceptExecution.execution (AspectUtils.getDeclaringClassAnnotation (point, Butterfly.class),
                AspectUtils.getAnnotation (point, Flutter.class),
                point.getArgs ());
    }

}
