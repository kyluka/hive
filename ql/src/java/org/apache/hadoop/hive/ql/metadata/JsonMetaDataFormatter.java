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

import java.util.List;
import org.apache.hadoop.hive.metastore.api.FieldSchema;

/**
 * Format table and index information for machine readability using
 * json.
 */
public class JsonMetaDataFormatter implements MetaDataFormatter {
    public String displayColsUnformatted(List<FieldSchema> cols)
        throws HiveException
    {
        StringBuilder colBuffer = new StringBuilder(8192);
        colBuffer.append("{ \"columns\": [\n");
        boolean first = true;
        for (FieldSchema col : cols) {
            if (! first)
                colBuffer.append("  ,\n");
            first = false;
            colBuffer.append("  {");
            colBuffer.append("\"name\": \"");
            colBuffer.append(col.getName());
            colBuffer.append("\",");
            colBuffer.append("\"type\": \"");
            colBuffer.append(col.getType());
            colBuffer.append("\",");
            colBuffer.append("\"comment\": \"");
            colBuffer.append(col.getComment() == null ? "" : col.getComment());
            colBuffer.append("\"");
            colBuffer.append("}\n");
        }
        colBuffer.append("] }");
        return colBuffer.toString();
    }
}

