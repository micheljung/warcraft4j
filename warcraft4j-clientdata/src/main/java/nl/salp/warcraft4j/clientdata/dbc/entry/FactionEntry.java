/*
 * Licensed to the Warcraft4J Project under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The Warcraft4J Project licenses
 * this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package nl.salp.warcraft4j.clientdata.dbc.entry;

import nl.salp.warcraft4j.clientdata.dbc.DbcEntry;
import nl.salp.warcraft4j.clientdata.dbc.DbcType;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcDataType;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcFieldMapping;
import nl.salp.warcraft4j.clientdata.dbc.mapping.DbcMapping;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO Document class.
 *
 * @author Barre Dijkstra
 */
@DbcMapping(file = "Faction.dbc")
public class FactionEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.FACTION;
    @DbcFieldMapping(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcFieldMapping(order = 2, dataType = DbcDataType.UINT32)
    private int reputationIndex;
    @DbcFieldMapping(order = 3, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationRaceMask; // 4
    @DbcFieldMapping(order = 4, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationClassMask; // 4
    @DbcFieldMapping(order = 5, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationBase; // 4
    @DbcFieldMapping(order = 6, dataType = DbcDataType.UINT32, numberOfEntries = 4)
    private int[] reputationFlags; // 4
    @DbcFieldMapping(order = 7, dataType = DbcDataType.UINT32)
    private int parentFactionId;
    @DbcFieldMapping(order = 8, dataType = DbcDataType.FLOAT, numberOfEntries = 2)
    private float[] parentFactionModifier; // 2
    @DbcFieldMapping(order = 9, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] parentFactionCap; // 2
    @DbcFieldMapping(order = 10, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String name;
    @DbcFieldMapping(order = 11, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String description;
    @DbcFieldMapping(order = 12, dataType = DbcDataType.UINT32)
    private int expansion;
    @DbcFieldMapping(order = 13, dataType = DbcDataType.UINT32)
    private int flags;
    @DbcFieldMapping(order = 14, dataType = DbcDataType.UINT32)
    private int friendshipReputationId;

    @Override
    public DbcType getEntryType() {
        return ENTRY_TYPE;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
