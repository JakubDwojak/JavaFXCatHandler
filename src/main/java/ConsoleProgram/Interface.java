package main.java.ConsoleProgram;

import main.java.ObjectClasses.Cat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {
    //open input stream
    static Scanner scanner = new Scanner(System.in);
    //geting user input
    public static String getUserInput() {
        return scanner.nextLine();
    }
    //checking and getting date
    public static Date getDate(){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        do {
            System.out.print("\nEnter date (Format is yyyy.mm.dd) : ");
            String dateInput = getUserInput();
            try
            {
                date = sdf.parse(dateInput);
            }
            catch (ParseException pe)
            {
                System.out.println("Wrong data format!");
            }
        }while(date==null);
        return date;
    }
    //checking and getting weight
    public static float getWeight(){
        String weight;
        boolean weightFlag = false;
        do {
            if(weightFlag) System.out.print("\nWrong format! (Example: 10.0)");
            System.out.print("\nEnter weight : ");
            weight = getUserInput();
            weightFlag = true;
        }while (!Pattern.matches("[0-9]{1,2}\\.[0-9]+", weight));
        return Float.parseFloat(weight);
    }
    //checking and getting name
    public static String getName(){
        String name;
        boolean nameFlag = false;
        do {
            if(nameFlag) System.out.print("\nWrong format! Remember to use capital letter!");
            System.out.print("\nEnter name of cat : ");
            name = getUserInput();
            nameFlag=true;
        }while (!Pattern.matches("[A-Z][a-z]+", name));
        return name;
    }
    //checking and getting owner
    public static String getOwner(){
        String owner;
        boolean ownerFlag = false;
        do {
            if(ownerFlag) System.out.print("Remember to use capital letters!");
            System.out.print("\nEnter full name of owner : ");
            owner = getUserInput();
        }while (!Pattern.matches("[A-Z][a-z]+ [A-Z][a-z]+",owner));
        return owner;
    }
    //cat adding method (returns object which you can add later)
    public static Cat addCat(){
        String name = getName();
        Date date = getDate();
        Float weight = getWeight();
        String owner = getOwner();
        return new Cat(name,date,weight,owner);
    }

    public static void main(String[] args){
        String choice;
        CatDAO cats = new CatDAO();
        do {
            System.out.println("Choose option: ");
            System.out.println("[1] Add Cat");
            System.out.println("[2] Show list of your cats ");
            System.out.println("[x] Close");
            choice = getUserInput();
            if(choice.equals("1")) cats.addCat(addCat());
            if(choice.equals("2")) cats.printCats();
        }while(!Pattern.matches("x",choice));
    }
}
