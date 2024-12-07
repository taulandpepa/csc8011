package csc8011;



public class Exhibit {
    //declare class variables as private.
    private String Id;
    private String Description;
    private int Year;
    private double Value;

    public Exhibit(String Id, String Description, int Year, double Value) {    //class constructor to initialize exhibit objects.

        this.Id = Id;
        this.Description = Description;
        this.Year = Year;
        this.Value = Value;
        ;
    }

    // public "get" and "set" methods to access and update the value of the private variables of the class Exhibit.
    public String getID() {

        return Id;
    }

    public void setID(String newId) {

        Id = newId;
    }


    public String getDescription() {

        return Description;
    }

    public void setDescription(String newDescription) {

        Description = newDescription;
    }


    public int getYear() {

        return Year;
    }

    public void setYear(int newYear) {

        Year = newYear;
    }


    public double getValue() {

        return Value;
    }

    public void setValue(double newValue) {

        Value = newValue;
    }


    @Override
    public String toString() { //toString method
        return String.format("Exhibit Id:%s Description:%s Year acquired:%d Value:£%.2f", Id, Description, Year, Value);
    }
}










