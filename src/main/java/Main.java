package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Controllers/sample.fxml"));
        primaryStage.setTitle("Cat Management");
        primaryStage.setScene(new Scene(root, 700, 450));
        primaryStage.show();
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
