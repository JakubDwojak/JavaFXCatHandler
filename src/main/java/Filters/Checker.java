package main.java.Filters;

import javafx.scene.control.Alert;
import main.java.Controllers.AddController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class Checker {
    //Checking if name format is correct (capital letter is needed ex: Anna)
    public static boolean checkName(String name){
        if(!Pattern.matches("[A-Z][a-z]+", name)) {
            alert(AddController.Para.NAME);
            return false;
        }
        return true;
    }
    //Checking if weight format is correct (ex 2.5  12,23 , 133.23 would not be accepted because we can't find that fat cats :) )
    public static boolean checkWeight(String weight){
        if(!Pattern.matches("[0-9]{1,2}\\.[0-9]+", weight)) {
            alert(AddController.Para.WEIGHT);
            return false;
        }
        return true;
    }
    //Checking if date format is correct (yyyy.mm.dd ex: 1996.06.25)
    public static boolean checkDate(String dateInput){
            Date date = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
                try
                {
                    date = sdf.parse(dateInput);
                }
                catch (ParseException pe)
                {
                    alert(AddController.Para.DATE);
                    return false;
                }
            return true;
        }
    //Checking if owner full name format is correct (Ex: Jan Kowalski)
    public static boolean checkOwner(String owner){
        if(!Pattern.matches("[A-Z][a-z]+ [A-Z][a-z]+",owner)) {
            alert(AddController.Para.OWNER);
            return false;
        }
        return true;
    }
    //Alert handler
    public static void alert(AddController.Para para){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error!");
        alert.setHeaderText("Wrong format!");
        switch (para) {
            case NAME:
                alert.setContentText("Remember to use capitals! (Example: Andy)");
                break;
            case DATE:
                alert.setContentText("Format of date is yyyy.mm.dd (Example: 2007.06.25)");
                break;
            case OWNER:
                alert.setContentText("Remember to use capitals and full name! (Example: Matt Smith)");
                break;
            case WEIGHT:
                alert.setContentText("Example: 5.2");
                break;
        }
        alert.showAndWait();
    }
}
