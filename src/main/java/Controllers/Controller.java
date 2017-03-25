package main.java.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import main.java.ObjectClasses.Cat;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    //Collection holding all of the added cats
    public static ArrayList<Cat> cats = new ArrayList<>();

    //newLine method
    public static String NEWLINE = "\n";

    //importing elements
    @FXML private Button add, show, clear;
    @FXML private TextArea textArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //setting text area Uneditable
        textArea.setEditable(false);
        //add button (opens new window)
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try
                {
                    Parent root = FXMLLoader.load(getClass().getResource("add.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Add Cat");
                    stage.setScene(new Scene(root, 600, 203));
                    stage.show();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
        //show buttons (print cats list)
        show.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cats.size()!=0) {
                    for (Cat cat : cats)
                        textArea.appendText(cat.toString()+ NEWLINE);
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("List is empty!");
                    alert.setContentText("Add some cats first!");
                    alert.showAndWait();
                }

            }
        });
        //clear button (clears text area)
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(!textArea.getText().equals("")) {
                    textArea.setText("");
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Done!");
                    alert.setHeaderText("Text Area is cleared!");
                    alert.setContentText("Now you can proceed!");
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Text Area is already cleared!");
                    alert.setContentText("You need to do something first!");
                    alert.showAndWait();
                }
            }
        });
    }
}
