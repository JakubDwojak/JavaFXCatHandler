package main.java.Controllers;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;
import main.java.ObjectClasses.Cat;
import main.java.Filters.Checker;
import main.java.ObjectClasses.ComboObject;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    //import elements
    @FXML private TextField name, weight, owner, date, text;
    @FXML private Button add, clear;
    @FXML private ComboBox<ComboObject> box;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //editing text area related to ComboBox status
        text.setEditable(false);
        text.setText("<- Choose value that you want to check");

        //PreSetting ComboBox
        box.setItems(FXCollections.observableArrayList(
                new ComboObject("Name","emptyName"),
                new ComboObject("Date", "emptyDate"),
                new ComboObject("Weight", "emptyWeight"),
                new ComboObject("Owner", "emptyOwner")));

        //Converting ComboBox values
        box.setConverter(new StringConverter<ComboObject>() {
            @Override
            public String toString(ComboObject object) {
                return object.getId();
            }

            @Override
            public ComboObject fromString(String string) {
                return null;
            }
        });

        //ComboBox on selection
        box.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                text.setText(box.getValue().getValue());
            }
        });

        //Getting text from Text Fields
        getText(name, Para.NAME);
        getText(weight, Para.WEIGHT);
        getText(owner, Para.OWNER);
        getText(date, Para.DATE);

        //Add button
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (box.getItems().get(0).getValue() != "emptyName" &&
                    box.getItems().get(1).getValue() != "emptyDate" &&
                    box.getItems().get(2).getValue() != "emptyWeight" &&
                    box.getItems().get(3).getValue() != "emptyOwner") {
                    Date date = null;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                    try
                    {
                        date = sdf.parse(box.getItems().get(1).getValue());
                    }
                    catch (ParseException e)
                    {
                        System.out.print("Wrong data format!");
                    }
                    Controller.cats.add(new Cat(
                            box.getItems().get(0).getValue(),
                            date,
                            Float.parseFloat(box.getItems().get(2).getValue()),
                            box.getItems().get(3).getValue()));
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation info!");
                    alert.setHeaderText("Done!");
                    alert.setContentText("Your cat is added!");
                    clear();
                    alert.showAndWait();
                }else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error!");
                    alert.setHeaderText("Cat is undefined!");
                    alert.setContentText("You need to enter values first!");
                    alert.showAndWait();
                }
            }
        });

        //clear button
        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                clear();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation info!");
                alert.setHeaderText("Done!");
                alert.setContentText("Your parameters are empty now!");
                alert.showAndWait();
            }
        });

    }
    //Enum class
    public enum Para{NAME,WEIGHT,DATE,OWNER}

    //refresh selected position in ComboBox
    public void refresh(String id, String value){
        if(box.getValue()!=null&&box.getValue().getId().equals(id))
            text.setText(value);
    }

    //adding confirmation
    public void added(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation info!");
        alert.setHeaderText("Done!");
        alert.setContentText("Your parameter is added!");
        alert.showAndWait();
    }

    //reset values
    public void clear(){
        box.getItems().get(0).setValue("emptyName");
        box.getItems().get(1).setValue("emptyDate");
        box.getItems().get(2).setValue("emptyWeight");
        box.getItems().get(3).setValue("emptyOwner");
    }

    //getting text from fields method
    public void getText(TextField button, Para parameter){
        button.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode()== KeyCode.ENTER) {
                    String getString = button.getText();
                    button.setText("");
                    switch(parameter){
                        case NAME:
                            if(Checker.checkName(getString))
                            {
                                box.getItems().get(0).setValue(getString);
                                added();
                                refresh("Name", getString);
                            }
                            break;
                        case DATE:
                            if(Checker.checkDate(getString))
                            {
                                box.getItems().get(1).setValue(getString);
                                added();
                                refresh("Date", getString);
                            }
                            break;
                        case WEIGHT:
                            if(Checker.checkWeight(getString))
                            {
                                box.getItems().get(2).setValue(getString);
                                added();
                                refresh("Weight", getString);
                            }
                            break;
                        case OWNER:
                            if(Checker.checkOwner(getString))
                            {
                                box.getItems().get(3).setValue(getString);
                                added();
                                refresh("Name", getString);
                            }
                            break;
                    }
                }
            }
        });
    }
}
