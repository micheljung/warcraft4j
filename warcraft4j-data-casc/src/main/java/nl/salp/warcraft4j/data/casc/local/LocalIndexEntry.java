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
package nl.salp.warcraft4j.data.casc.local;

import nl.salp.warcraft4j.data.casc.CascIndexEntry;
import nl.salp.warcraft4j.data.casc.FileKey;

/**
 * TODO Add description.
 *
 * @author Barre Dijkstra
 */
public class LocalIndexEntry extends CascIndexEntry {
    private final short indexInfoHigh;
    private final long indexInfoLow;

    public LocalIndexEntry(FileKey fileKey, short indexInfoHigh, long indexInfoLow, long fileSize) {
        super(fileKey, getFileNumber(indexInfoHigh, indexInfoLow), getDataFileOffset(indexInfoHigh, indexInfoLow), fileSize);
        this.indexInfoHigh = indexInfoHigh;
        this.indexInfoLow = indexInfoLow;
    }

    public short getIndexInfoHigh() {
        return indexInfoHigh;
    }

    public long getIndexInfoLow() {
        return indexInfoLow;
    }

    private static int getFileNumber(short indexInfoHigh, long indexInfoLow) {
        return ((byte) (indexInfoHigh << 2) | (((int) indexInfoLow & 0xC0000000) >>> 30));
    }

    private static int getDataFileOffset(short indexInfoHigh, long indexInfoLow) {
        return (int) (indexInfoLow & 0x3FFFFFFF);
    }
}
