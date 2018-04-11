package com.djrapitops.rom.frontend.javafx.scenes;

import com.djrapitops.rom.frontend.javafx.JavaFXFrontend;
import com.djrapitops.rom.frontend.javafx.components.GameComponent;
import com.djrapitops.rom.frontend.javafx.components.GamesSceneBottomNav;
import com.djrapitops.rom.frontend.javafx.updating.Updatable;
import com.djrapitops.rom.game.Game;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Games view in the UI.
 *
 * @author Rsl1122
 */
public class GamesView extends BorderPane implements Updatable<List<Game>> {

    private final JavaFXFrontend frontend;
    private final GamesSceneBottomNav bottomNav;

    public GamesView(JavaFXFrontend frontend, BorderPane mainContainer) {
        this.frontend = frontend;
        prefWidthProperty().bind(mainContainer.widthProperty());
        bottomNav = new GamesSceneBottomNav(frontend);
        bottomNav.prefWidthProperty().bind(this.widthProperty());
    }

    /**
     * Updates GamesView to display a list of games.
     *
     * @param with Object used as parameters for the update.
     */
    @Override
    public void update(List<Game> with) {
        VBox container = new VBox();
        container.prefWidthProperty().bind(this.widthProperty());

        JFXListView<GameComponent> list = new JFXListView<>();
        list.setItems(
                FXCollections.observableArrayList(
                        with.stream()
                                .map(GameComponent::new)
                                .collect(Collectors.toList())
                )
        );
        list.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        container.getChildren().add(list);

        setCenter(container);
        setBottom(bottomNav);
    }
}
