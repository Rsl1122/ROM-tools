package com.djrapitops.rom.game;

import java.io.File;

/**
 * Object that contains information about a file that stores the game.
 *
 * @author Rsl1122
 */
public class GameFile {

    private final FileExtension extension;
    private final String filePath;
    private final String binaryHash;

    private File file;

    public GameFile(FileExtension extension, String filePath, String binaryHash) {
        this.extension = extension;
        this.filePath = filePath;
        this.binaryHash = binaryHash;
    }

    private File getFile() {
        if (file == null) {
            file = new File(filePath);
        }
        return file;
    }

    public boolean exists() {
        return getFile().exists();
    }

    public String getFileName() {
        return getFile().getName();
    }

    public boolean matchesHash() {
        // TODO Implement
        return exists();
    }
}
