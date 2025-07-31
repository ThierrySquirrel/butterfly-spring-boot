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

package io.github.thierrysquirrel.butterfly.core.domain;

import io.github.thierrysquirrel.pine.common.netty.domain.PineRequestContext;
import com.google.common.collect.Maps;
import lombok.Data;
import org.springframework.util.ObjectUtils;

import java.util.Map;

/**
 * ClassName: PineRequestContextFilterDomain
 * Description:
 * date: 2020/1/29 21:56
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Data
public class PineRequestContextFilterDomain {
	private PineRequestContext pineRequestContext;

	public PineRequestContextFilterDomain(PineRequestContext pineRequestContext) {
		this.pineRequestContext = pineRequestContext;
	}

	public void setAttachment(String key, String value) {
		Map<String, String> attachment = pineRequestContext.getAttachment();
		if (ObjectUtils.isEmpty(attachment)) {
			attachment = Maps.newConcurrentMap();
			pineRequestContext.setAttachment(attachment);
		}
		attachment.put(key, value);
	}

	public String getAttachment(String key) {
		Map<String, String> attachment = pineRequestContext.getAttachment();
		if (ObjectUtils.isEmpty(attachment)) {
			return null;
		}
		return attachment.get(key);
	}
}
