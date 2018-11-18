package com.company.Interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Main controller is the main class that everything operates from. This class is created by the JavaFX system as it reads and loads the FXML file in the fxmlWindow class. This controller manages all interactions with the user interface for the main window.
 * <p>
 * Any component that is declared in the FXML that you wish to interact with in the controller must be declared as a global variable in the class with the @FXML tag. This then gives access to the controller to change properties or add events to the component. For example adding the CSS name so the JavaFX core can style the component as specified in the CSS file.
 * <p>
 * Note: Not all components need to be listed as global variables only those who you wish to edit via code. Functions that are used by JavaFX components that have been declared in the FXML file must be declared as a public function and must have the same name as that in the FXML file.
 * <p>
 * This class contains a JavaFX tab system that is mixed with a custom tab class. This is managed in a dynamic system via an ArrayList. This ArrayList allows for items to added and removed quickly and is a built in Java object.
 * <p>
 * The System has a variable for the current tab package that contains all of the individual information needed for that session. This is obtained from the dynamic memory system when you change tabs.
 */
public class MainController implements Initializable {
    @FXML
    private TextArea outputConsole = new TextArea();
    @FXML
    private Button compileButton = new Button();
    @FXML
    private Button executeButton = new Button();
    @FXML
    private Button lineStepButton = new Button();
    @FXML
    private Button saveButton = new Button();
    @FXML
    private Button saveAllButton = new Button();
    @FXML
    private Button openButton = new Button();
    @FXML
    private ToggleButton instructionSetButton = new ToggleButton();
    @FXML
    private ToggleButton toggleGridPane = new ToggleButton();
    @FXML
    private TabPane TabManager = new TabPane();
    @FXML
    private Pane topLevelPane = new Pane();
    @FXML
    private VBox topPane = new VBox();
    @FXML
    private MenuBar menuBar = new MenuBar();
    @FXML
    private SplitPane mainContent = new SplitPane();
    @FXML
    private GridPane memory = new GridPane();
    @FXML
    private Label stepUser1 = new Label();
    @FXML
    private Label stepUser2 = new Label();
    @FXML
    private Label stepUser3 = new Label();
    @FXML
    private Label stepUser4 = new Label();
    @FXML
    private Label stepTheory1 = new Label();
    @FXML
    private Label stepTheory2 = new Label();
    @FXML
    private Label stepTheory3 = new Label();
    @FXML
    private Label stepTheory4 = new Label();


    // Initialisation

    /**
     * Called to initialize a controller after its root element has been completely processed.
     *
     * @param location  the location used to resolve relative paths, should they be needed.
     * @param resources The resources used to localize the root object, should any be needed.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setup();

    }

    private void setup() {
        Tab tab = new Tab("Tab 1");

        TextArea textArea = new TextArea("Some Text");
        textArea.getStyleClass().add("codeEditorCss");

        tab.setContent(textArea);
        TabManager.getTabs().add(tab);
    }

    private void changeFXML(String fxml) {
        try {
            Stage stage = (Stage) executeButton.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));

            Parent root = loader.load(); // load the fxml
            stage.getScene().setRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeRun() {
        changeFXML("login.fxml");
        createPopup();
        setup();
    }

    private void createPopup() {
    }

    public void updateToggleGrid() {
        boolean isSelected = toggleGridPane.isSelected();
        assert (isSelected);
        if (isSelected) {
            changeFXML("login.fxml");

        } else {
            changeFXML("MainWindow.fxml");
        }

    }

}
