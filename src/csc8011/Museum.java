package csc8011;

import java.util.ArrayList;


public class Museum {
    //declare class variables as private (Encapsulation).
    private String mName;
    private ArrayList<Exhibit> exhibits = new ArrayList<>();


    public Museum(String mName) {  //class constructor
        this.mName = mName;

    }

    public String getmName() { //public "get" method to access and update the value of the private variable "mName" of the class Museum.

        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean addExhibit(Exhibit e) //method for adding exhibits/objects to the ArrayList.
    {

        return exhibits.add(e);
    }

    public ArrayList<Exhibit> getExhibits() //access and update the private ArrayList of exhibits.
    {

        return exhibits;
    }

       public Exhibit getHvalueExhibit()  //method, calculate the highest value exhibit.
    {
        Exhibit Hvalue = exhibits.get(0);
        for (Exhibit e : exhibits)
        {
            if (e.getValue() > Hvalue.getValue())
            {
                Hvalue = e;
            }
        }
        return Hvalue;
    }

    public Exhibit getFirstExhibit()   //method, calculate the first exhibit acquired.
    {
        Exhibit first = exhibits.get(0);
        for (Exhibit e : exhibits)
        {
            if (e.getYear() < first.getYear())
            {
                first = e;
            }
        }
        return first;
    }

    public double getAverageExhibit() {    //method, calculate the average value of exhibits.
        double sum = 0;
        for ( Exhibit e : exhibits) {
            sum += e.getValue();
        }
        return sum / exhibits.size();
    }
}


