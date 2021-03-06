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

package org.gradle.jvm.toolchain.internal;

import org.gradle.api.Transformer;
import org.gradle.api.provider.Provider;
import org.gradle.api.provider.ProviderFactory;

import javax.inject.Inject;
import java.io.File;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class SdkmanInstallationSupplier extends AutoDetectingInstallationSupplier {

    @Inject
    public SdkmanInstallationSupplier(ProviderFactory factory) {
        super(factory);
    }

    @Override
    protected Set<InstallationLocation> findCandidates() {
        final Provider<String> candidatesDir = getEnvironmentProperty("SDKMAN_CANDIDATES_DIR");
        return candidatesDir.map(findJavaCandidates()).getOrElse(Collections.emptySet());
    }

    private Transformer<Set<InstallationLocation>, String> findJavaCandidates() {
        return candidatesDir -> {
            final File[] javaCandidates = new File(candidatesDir, "java").listFiles();
            if (javaCandidates == null) {
                return Collections.emptySet();
            }
            return Stream.of(javaCandidates)
                .filter(File::isDirectory)
                .map(this::asInstallation)
                .collect(toSet());
        };
    }

    private InstallationLocation asInstallation(File file) {
        return new InstallationLocation(file, "SDKMAN");
    }

}
