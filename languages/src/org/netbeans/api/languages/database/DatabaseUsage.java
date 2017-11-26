/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.api.languages.database;

public class DatabaseUsage extends DatabaseItem {

    private String              name;
    private DatabaseDefinition  definition;
    
    public DatabaseUsage (
        String      name,
        int         offset, 
        int         endOffset
    ) {
        super (offset, endOffset);
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public DatabaseDefinition getDefinition() {
        return definition;
    }
    
    public void setDatabaseDefinition (DatabaseDefinition definition) {
        this.definition = definition;
    }
    
    @Override
    public String toString () {
        return "Usage " + getName ();
    }
}
