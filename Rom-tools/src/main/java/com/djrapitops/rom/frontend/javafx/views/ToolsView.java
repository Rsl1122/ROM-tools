package com.djrapitops.rom.frontend.javafx.views;

import com.djrapitops.rom.backend.Log;
import com.djrapitops.rom.backend.processes.MainProcesses;
import com.djrapitops.rom.frontend.javafx.JavaFXFrontend;
import com.djrapitops.rom.frontend.javafx.Style;
import com.djrapitops.rom.frontend.javafx.components.SelectedTextContainer;
import com.djrapitops.rom.frontend.state.State;
import com.djrapitops.rom.frontend.state.Updatable;
import com.djrapitops.rom.game.Game;
import com.djrapitops.rom.util.MethodReference;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Tools view in the UI.
 *
 * @author Rsl1122
 */
public class ToolsView extends BorderPane implements Updatable<State> {

    private final JavaFXFrontend frontend;
    private final ImageView imageView;

    public ToolsView(JavaFXFrontend frontend, BorderPane mainContainer) {
        prefWidthProperty().bind(mainContainer.widthProperty());

        this.frontend = frontend;
        State state = this.frontend.getState();

        imageView = new ImageView(
                new Image(JavaFXFrontend.class.getResourceAsStream("/Logo-text.png"))
        );
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(300);

        update(state);
        state.addStateListener(this);

        JFXListView<JFXButton> buttons = new JFXListView<>();
        buttons.prefWidthProperty().bind(widthProperty());

        JFXButton moveSingleFolderButton = new JFXButton("Move selected to a single folder");
        JFXButton copySingleFolderButton = new JFXButton("Copy selected to a single folder");
        JFXButton moveSubFoldersButton = new JFXButton("Move selected under a folder in new subfolders");
        JFXButton copySubFoldersButton = new JFXButton("Copy selected under a folder in new subfolders");

        moveSingleFolderButton.setOnAction(getActionEventForFolderSelect(MainProcesses::processFileMoveToGivenFolder));
        copySingleFolderButton.setOnAction(getActionEventForFolderSelect(MainProcesses::processFileCopyToGivenFolder));
        moveSubFoldersButton.setOnAction(getActionEventForFolderSelect(MainProcesses::processFileCopyToSubFolders));
        copySubFoldersButton.setOnAction(getActionEventForFolderSelect(MainProcesses::processFileCopyToSubFolders));

        ObservableList<JFXButton> obsButtons = FXCollections.observableArrayList(
                moveSingleFolderButton,
                moveSubFoldersButton,
                copySingleFolderButton,
                copySubFoldersButton
        );
        obsButtons.forEach(button -> {
            button.setAlignment(Pos.CENTER_LEFT);
            button.setStyle(Style.BUTTON_SQUARE + Style.BG_DARK_CYAN);
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        });

        buttons.setItems(obsButtons);
        // Removes the blue "on focus" box around the list
        buttons.setFocusTraversable(false);

        setCenter(buttons);
    }

    @Override
    public void update(State state) {
        VBox topContainer = new VBox();
        topContainer.prefWidthProperty().bind(widthProperty());
        topContainer.setAlignment(Pos.CENTER);
        topContainer.getChildren().add(imageView);
        topContainer.getChildren().add(new SelectedTextContainer(state));
        setTop(topContainer);
    }

    private EventHandler<ActionEvent> getActionEventForFolderSelect(MethodReference.Dual<File, List<Game>> methodToCall) {
        return event -> {
            if (frontend.getState().getSelectedGames().isEmpty()) {
                Log.log("No Games Selected.");
                return;
            }

            DirectoryChooser fileChooser = new DirectoryChooser();
            fileChooser.setTitle("Select Folder to search recursively");
            File chosenFolder = fileChooser.showDialog(frontend.getStage().getOwner());

            if (chosenFolder == null) {
                return;
            }

            methodToCall.call(chosenFolder, new ArrayList<>(frontend.getState().getSelectedGames()));
        };
    }

}
