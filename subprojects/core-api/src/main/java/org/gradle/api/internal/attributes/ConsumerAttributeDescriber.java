/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.internal.attributes;

import org.gradle.api.attributes.Attribute;
import org.gradle.api.attributes.AttributeContainer;

import java.util.Set;

public interface ConsumerAttributeDescriber {
    Set<Attribute<?>> getAttributes();
    String describeConsumerAttributes(AttributeContainer attributes);
    String describeCompatibleAttribute(Attribute<?> attribute, Object consumerValue, Object producerValue);
    String describeIncompatibleAttribute(Attribute<?> attribute, Object consumerValue, Object producerValue);
    String describeMissingAttribute(Attribute<?> attribute, Object consumerValue);
    String describeExtraAttribute(Attribute<?> attribute, Object producerValue);
}
