/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.hadoop.hive.ql.metadata;

import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.metastore.api.FieldSchema;
import org.apache.hadoop.hive.ql.metadata.Partition;
import org.apache.hadoop.hive.ql.metadata.Table;

/**
 * Interface to format table and index information.  We can format it
 * for human readability (lines of text) or for machine readability
 * (json).
 */
public interface MetaDataFormatter {
    /**
     * Write error message.
     */
    public void error(DataOutputStream out, String msg)
        throws HiveException;

    /**
     * Describe table.
     */
    public void describeTable(DataOutputStream out,
                              String colPath, String tableName,
                              Table tbl, Partition part, List<FieldSchema> cols,
                              boolean isFormatted, boolean isExt)
        throws HiveException;

    /**
     * Show the table status.
     */
    public void showTableStatus(DataOutputStream out,
                                Hive db,
                                HiveConf conf,
                                List<Table> tbls,
                                Map<String, String> part,
                                Partition par)
        throws HiveException;
}

