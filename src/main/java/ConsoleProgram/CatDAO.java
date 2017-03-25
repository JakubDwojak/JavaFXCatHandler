package main.java.ConsoleProgram;

import main.java.ObjectClasses.Cat;
import java.util.ArrayList;

public class CatDAO {
    //Creating collection for holding cats
    private ArrayList<Cat> cats;
    //add Cat objects to collection
    public void addCat(Cat cat){
        cats.add(cat);
    }
    //print everything in collection
    public void printCats(){
        for(Cat cat: cats)
            System.out.println(cat);
    }
}
