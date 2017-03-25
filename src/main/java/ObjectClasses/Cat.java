package main.java.ObjectClasses;

import java.util.Date;

public class Cat {
    //fields
    String name;
    Date date;
    float weight;
    String owner;
    //constructor
    public Cat(String name, Date date, float weight, String owner) {
        this.name = name;
        this.date = date;
        this.weight = weight;
        this.owner = owner;
    }
    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(date.toString());
        sb.delete(10,24);
        sb.delete(0,4);
        return " Name: " + name +
                " Date: " + sb.toString() +
                " Weight: " + weight + "kg" +
                " Owner: " + owner;
    }
}
