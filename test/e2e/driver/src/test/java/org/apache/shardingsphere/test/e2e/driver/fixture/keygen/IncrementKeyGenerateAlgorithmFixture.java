/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.e2e.driver.fixture.keygen;

import org.apache.shardingsphere.infra.keygen.core.algorithm.KeyGenerateAlgorithm;
import org.apache.shardingsphere.infra.keygen.core.context.KeyGenerateContext;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class IncrementKeyGenerateAlgorithmFixture implements KeyGenerateAlgorithm {
    
    private final AtomicInteger count = new AtomicInteger();
    
    @Override
    public Collection<Comparable<?>> generateKeys(final KeyGenerateContext keyGenerateContext, final int keyGenerateCount) {
        return IntStream.range(0, keyGenerateCount).mapToObj(each -> count.incrementAndGet()).collect(Collectors.toList());
    }
    
    @Override
    public String getType() {
        return "JDBC.INCREMENT.FIXTURE";
    }
    
    @Override
    public boolean isSupportAutoIncrement() {
        return true;
    }
}
