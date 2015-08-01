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
package nl.salp.warcraft4j.clientdata.casc.local;

import nl.salp.warcraft4j.clientdata.casc.Checksum;
import nl.salp.warcraft4j.clientdata.casc.IndexEntry;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO Add description.
 *
 * @author Barre Dijkstra
 */
public class LocalIndexEntry implements IndexEntry {
    private Checksum fileKey; // 9b First 9 bytes of file key.
    private short indexInfoHigh; // 1b High byte of index information
    private long indexInfoLow; // 4b BE Low bytes of index information
    private long fileSize; // 4b LE File size in bytes

    public LocalIndexEntry(Checksum fileKey, short indexInfoHigh, long indexInfoLow, long fileSize) {
        this.fileKey = fileKey;
        this.indexInfoHigh = indexInfoHigh;
        this.indexInfoLow = indexInfoLow;
        this.fileSize = fileSize;
    }

    @Override public Checksum getFileKey() {
        return fileKey;
    }

    @Override public long getFileSize() {
        return fileSize;
    }

    @Override public int getFileNumber() {
        return ((byte) (indexInfoHigh << 2) | (((int) indexInfoLow & 0xC0000000) >>> 30));
    }

    @Override public int getDataFileOffset() {
        return (int) ( indexInfoLow & 0x3FFFFFFF);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
