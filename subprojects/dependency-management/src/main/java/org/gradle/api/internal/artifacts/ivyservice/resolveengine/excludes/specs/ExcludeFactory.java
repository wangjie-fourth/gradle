/*
 * Copyright 2019 the original author or authors.
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
package org.gradle.api.internal.artifacts.ivyservice.resolveengine.excludes.specs;

import org.gradle.api.artifacts.ModuleIdentifier;
import org.gradle.internal.component.model.IvyArtifactName;

import java.util.List;
import java.util.Set;

public interface ExcludeFactory {
    ExcludeSpec nothing();

    ExcludeSpec everything();

    ExcludeSpec group(String group);

    ExcludeSpec module(String module);

    ExcludeSpec moduleId(ModuleIdentifier id);

    ExcludeSpec artifact(ModuleIdentifier id, IvyArtifactName artifact);

    ExcludeSpec anyOf(ExcludeSpec one, ExcludeSpec two);

    ExcludeSpec allOf(ExcludeSpec one, ExcludeSpec two);

    ExcludeSpec anyOf(List<ExcludeSpec> specs);

    ExcludeSpec allOf(List<ExcludeSpec> specs);

    ExcludeSpec ivyPatternExclude(ModuleIdentifier moduleId, IvyArtifactName artifact, String matcher);

    ExcludeSpec moduleSet(Set<ModuleIdentifier> modules);
}