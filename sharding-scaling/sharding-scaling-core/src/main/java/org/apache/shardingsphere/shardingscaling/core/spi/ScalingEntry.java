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

package org.apache.shardingsphere.shardingscaling.core.spi;

import org.apache.shardingsphere.shardingscaling.core.execute.executor.checker.DataSourceChecker;
import org.apache.shardingsphere.shardingscaling.core.execute.executor.dumper.JDBCDumper;
import org.apache.shardingsphere.shardingscaling.core.execute.executor.position.LogPositionManager;
import org.apache.shardingsphere.shardingscaling.core.execute.executor.dumper.LogDumper;
import org.apache.shardingsphere.shardingscaling.core.execute.executor.importer.Importer;
import org.apache.shardingsphere.underlying.common.database.type.DatabaseTypeAwareSPI;

/**
 * Scaling entry.
 */
public interface ScalingEntry extends DatabaseTypeAwareSPI {
    
    /**
     * Get JDBC dumper type.
     *
     * @return JDBC dumper type
     */
    Class<? extends JDBCDumper> getJdbcDumperClass();
    
    /**
     * Get log dumper type.
     *
     * @return log dumper type
     */
    Class<? extends LogDumper> getLogDumperClass();

    /**
     * Get log position manager type.
     *
     * @return log manager type
     */
    Class<? extends LogPositionManager> getLogPositionManager();
    
    /**
     * Get importer type.
     *
     * @return importer type
     */
    Class<? extends Importer> getImporterClass();

    /**
     * Get checker type.
     * @return checker type
     */
    Class<? extends DataSourceChecker> getCheckerClass();
}
