/**
 * Copyright 2020 the original author or authors.
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

package io.github.thierrysquirrel.butterfly.core.factory;

import io.github.thierrysquirrel.butterfly.core.domain.PineRequestContextFilterDomain;
import io.github.thierrysquirrel.butterfly.core.filter.Filter;
import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;

import java.util.Iterator;

/**
 * ClassName: FilterFactory
 * Description:
 * date: 2020/1/29 22:31
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
public class FilterFactory {

	private FilterFactory() {
	}

	private static void filter(Iterator<Filter> filterIterator, PineRequestContext pineRequestContext) {
		PineRequestContextFilterDomain pineRequestContextFilterDomain = PineRequestContextFilterDomainFactory.createPineRequestContextFilterDomain(pineRequestContext);
		while (filterIterator.hasNext()) {
			filterIterator.next().filter(pineRequestContextFilterDomain);
		}
	}

	public static void butterflyFilter(PineRequestContext pineRequestContext) {
		filter(ButterflyFilterFactory.get(), pineRequestContext);
	}

	public static void flowerFilter(PineRequestContext pineRequestContext) {
		filter(FlowerFilterFactory.get(), pineRequestContext);
	}
}
