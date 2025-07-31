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

package io.github.thierrysquirrel.butterfly.init;

import io.github.thierrysquirrel.butterfly.annotation.FlowerFilter;
import io.github.thierrysquirrel.butterfly.core.factory.FlowerFilterFactory;
import io.github.thierrysquirrel.butterfly.core.filter.Filter;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * ClassName: FlowerFilterInit
 * Description:
 * date: 2020/1/29 22:47
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class FlowerFilterInit implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@PostConstruct
	public void init() {
		applicationContext.getBeansWithAnnotation(FlowerFilter.class).forEach((beanName, bean) -> FlowerFilterFactory.addFilter((Filter) bean));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
