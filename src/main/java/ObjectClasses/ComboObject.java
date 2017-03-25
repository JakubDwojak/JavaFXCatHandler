package main.java.ObjectClasses;

//class for ComboBox objects
public class ComboObject {
    //fields
    private String id;
    private String value;

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    //constructor
    public ComboObject(String id, String value) {
        this.id = id;
        this.value = value;
    }
    //toString for this class can be found in AddController class to set converter to ComboBox
}
