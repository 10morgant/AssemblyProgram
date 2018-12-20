package com.company.jfoenixVersion;

import com.company.Data.Constants;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

/**
 * fxmlWindow is the starting class for the program. This class extends the JavaFX class Application which allows it to start the FXML.
 * <p>
 * The FXML is a markup language the details the layout of the window. This method of creating the window is good because it reduces the amount of code needed in the controller or starting class as the containers, layouts and components can be defined in the file reducing the need to create objects and nesting components in them in a starting class.
 * <p>
 * This is an example of implementation on a method level as it the Application class contains an abstract method, start, which provides the object to create the window.
 */
public class MainWindowStarter extends Application {
    /**
     * The default java starting method. This will start the JavaFX process and start building the window by calling the start function.
     *
     * @param args the commandline parameters
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml")); // load the fxml

            Scene main = new Scene(root, 1920, 1000); //create the scene with the loaded objects. Set temp

            // resolution to fulfill parameter request.

//            main.getStylesheets().add(String.valueOf(getClass().getResource("FXMLCSS.css").toExternalForm()));
            primaryStage.setTitle(Constants.PROGRAM_NAME.getValue()); // set the program name using a constant value
            primaryStage.setScene(main); // set the view of the screen to be the loaded fxml
            primaryStage.setResizable(true); // allow the window to resize
            primaryStage.setMaximized(true);
            primaryStage.show(); // make the window visible
            primaryStage.setX(1940);
            primaryStage.setOnCloseRequest(event -> {
                System.exit(0); // when the window is closed stop the java process.
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}