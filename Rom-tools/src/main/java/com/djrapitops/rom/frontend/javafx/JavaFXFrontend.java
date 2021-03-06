package com.djrapitops.rom.frontend.javafx;

import com.djrapitops.rom.Main;
import com.djrapitops.rom.backend.Backend;
import com.djrapitops.rom.backend.settings.SettingsManager;
import com.djrapitops.rom.exceptions.ExceptionHandler;
import com.djrapitops.rom.frontend.Frontend;
import com.djrapitops.rom.frontend.javafx.components.MainNavigation;
import com.djrapitops.rom.frontend.javafx.components.ProcessBar;
import com.djrapitops.rom.frontend.javafx.views.*;
import com.djrapitops.rom.frontend.state.State;
import com.djrapitops.rom.util.Verify;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.logging.Level;

/**
 * JavaFX Frontend implementation.
 *
 * @author Rsl1122
 */
public class JavaFXFrontend extends Application implements Frontend {

    private Stage primaryStage;

    private Views currentView;
    private final State state;

    // Shared components
    private MainNavigation mainNavigation;

    private BorderPane mainContainer;

    // Scenes
    private GamesView gamesView;
    private ToolsView toolsView;
    private SettingsView settingsView;
    private FiltersView filtersView;
    private StateUpdateTimer updateTimer;

    public JavaFXFrontend() {
        currentView = Views.GAMES;
        state = new State();
    }

    public static void start(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        primaryStage.getIcons().add(new Image(JavaFXFrontend.class.getResourceAsStream("/Logo.png")));

        try {
            primaryStage.setTitle("ROM Tools");

            // Loading scene instance is created, only one loading window.

            mainNavigation = new MainNavigation(this, primaryStage);
            mainContainer = new BorderPane();
            mainContainer.prefWidthProperty().bind(primaryStage.widthProperty());

            Backend backend = Backend.getInstance();
            backend.setExceptionHandler(new JavaFXExceptionHandler(this));
            backend.open(this);

            gamesView = new GamesView(this, mainContainer);
            toolsView = new ToolsView(this, mainContainer);
            settingsView = new SettingsView(mainContainer);
            filtersView = new FiltersView(this, mainContainer);

            mainContainer.setTop(mainNavigation);
            mainContainer.setBottom(new ProcessBar(state));

            changeView(currentView);
            Scene scene = new Scene(mainContainer, Variables.WIDTH, Variables.HEIGHT);
            ObservableList<String> stylesheets = scene.getStylesheets();
            stylesheets.addAll(
                    Main.class.getResource("/css/jfoenix-fonts.css").toExternalForm(),
                    Main.class.getResource("/css/jfoenix-design.css").toExternalForm()
            );
            primaryStage.setScene(scene);
            primaryStage.show();

            updateTimer = new StateUpdateTimer(this);
            updateTimer.start();
        } catch (Exception e) {
            primaryStage.setScene(new FatalErrorScene(e));
            primaryStage.show();
        }
    }

    public void changeView(Views view) {
        Verify.notNull(primaryStage, () -> new IllegalStateException("Application has not been started yet."));

        if (currentView == Views.SETTINGS) {
            SettingsManager.getInstance().save();
        }
        Platform.runLater(() -> {
            currentView = view;
            mainNavigation.update(view);
            mainContainer.setCenter(getView(view));
        });
    }

    private Node getView(Views view) {
        switch (view) {
            case GAMES:
                return gamesView;
            case TOOLS:
                return toolsView;
            case SETTINGS:
                return settingsView;
            case FILTERS:
                return filtersView;
            default:
                ExceptionHandler.handle(Level.WARNING, new IllegalArgumentException("View not defined"));
                return mainContainer.getCenter();
        }
    }

    @Override
    public void stop() {
        updateTimer.stop();
        Backend.getInstance().close();
    }

    public Views getCurrentView() {
        return currentView;
    }

    @Override
    public State getState() {
        return state;
    }

    public Stage getStage() {
        return primaryStage;
    }
}
