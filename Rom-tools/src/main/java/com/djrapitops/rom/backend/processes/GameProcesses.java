package com.djrapitops.rom.backend.processes;

import com.djrapitops.rom.backend.Log;
import com.djrapitops.rom.backend.Operations;
import com.djrapitops.rom.game.Game;

import java.util.List;

/**
 * Class that holds methods for CompletableFuture related to GameBackend.
 *
 * @author Rsl1122
 * @see java.util.concurrent.CompletableFuture
 */
public class GameProcesses {

    private GameProcesses() {
        /* Hides constructor */
    }

    /**
     * Add games to the GameBackend.
     *
     * @param games Games to add.
     */
    public static void addGames(List<Game> games) {
        Log.log("Adding games..");
        Operations.ALL_GAMES.save(games);
        Log.log("Added " + games.size() + " games.");
    }

    /**
     * Load games from the GameBackend.
     *
     * @return Loaded games.
     */
    public static List<Game> loadGames() {
        Log.log("Loading games..");
        List<Game> games = Operations.ALL_GAMES.get();
        Log.log("Loaded " + games.size() + " games.");
        return games;
    }

    /**
     * Remove games from the GameBackend.
     *
     * @param games Games to remove.
     */
    public static void removeGames(List<Game> games) {
        Log.log("Removing games..");
        Operations.ALL_GAMES.remove(games);
        Log.log("Removed " + games.size() + " games.");
    }
}