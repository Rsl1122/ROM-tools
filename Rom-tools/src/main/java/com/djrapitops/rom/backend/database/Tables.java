package com.djrapitops.rom.backend.database;

import com.djrapitops.rom.backend.database.table.FileTable;
import com.djrapitops.rom.backend.database.table.GameTable;
import com.djrapitops.rom.backend.database.table.MetadataTable;
import com.djrapitops.rom.exceptions.BackendException;

/**
 * Interface for Table getter methods.
 *
 * @author Rsl1122
 */
public interface Tables {

    FileTable getFileTable();

    GameTable getGameTable();

    /**
     * Creates all tables.
     *
     * @throws BackendException If can't make tables.
     */
    void createTables();

    MetadataTable getMetadataTable();
}
