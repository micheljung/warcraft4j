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
@DbcMapping(file = "ChrSpecialization.dbc")
public class CharacterSpecializationEntry implements DbcEntry {
    private static final DbcType ENTRY_TYPE = DbcType.CHARACTER_SPECIALIZATION;

    @DbcFieldMapping(order = 1, dataType = DbcDataType.UINT32)
    private int id;
    @DbcFieldMapping(order = 2, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String backgroundFile;
    @DbcFieldMapping(order = 3, dataType = DbcDataType.UINT32)
    private int classId;
    @DbcFieldMapping(order = 4, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] masterySpellId;
    @DbcFieldMapping(order = 5, dataType = DbcDataType.UINT32)
    private int orderIndex;
    @DbcFieldMapping(order = 6, dataType = DbcDataType.UINT32)
    private int petTalentType;
    @DbcFieldMapping(order = 7, dataType = DbcDataType.UINT32)
    private int role; // (0 - Tank, 1 - Healer, 2 - DPS)
    @DbcFieldMapping(order = 8, dataType = DbcDataType.UINT32)
    private int iconId;
    @DbcFieldMapping(order = 9, dataType = DbcDataType.UINT32)
    private int raidBuffs;
    @DbcFieldMapping(order = 10, dataType = DbcDataType.UINT32)
    private int flags;
    @DbcFieldMapping(order = 11, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String name;
    @DbcFieldMapping(order = 12, dataType = DbcDataType.STRINGTABLE_REFERENCE, knownMeaning = false)
    private String name2;// Same as name_lang?
    @DbcFieldMapping(order = 13, dataType = DbcDataType.STRINGTABLE_REFERENCE)
    private String description;
    @DbcFieldMapping(order = 14, dataType = DbcDataType.UINT32, numberOfEntries = 2)
    private int[] primaryStatOrder; // 2

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