/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croftventory.Types;

import javafx.beans.property.*;

/**
 *
 * Defines the Student object
 * 
 * @author kamron
 * 
 */

public class Student {
    // Properties
    // These are used over variables as they can utilize events
    // Additionally they are useful for the TableView
    private SimpleStringProperty Name = new SimpleStringProperty();
    private SimpleStringProperty Class = new SimpleStringProperty();
    private SimpleStringProperty Email = new SimpleStringProperty();
    private SimpleIntegerProperty DemeritPoints = new SimpleIntegerProperty();
    private SimpleStringProperty ID = new SimpleStringProperty();
    
    // Initialisers
    // Uses polymorphisem to handle storing and retrieving data from database
    // To avoid having to enter demerit points when non-existant
    public Student(String name, String _class, String email, String ID) {
        this.Name.set(name);
        this.Class.set(_class);
        this.Email.set(email);
        DemeritPoints.set(0);
        this.ID.set(ID);
    }
    
    public Student(String name, String _class, String email, Integer demeritPoints, String ID) {
        this.Name.set(name);
        this.Class.set(_class);
        this.Email.set(email);
        this.DemeritPoints.set(demeritPoints);
        this.ID.set(ID);
    }
    
    // Getters
    // Getters which return properties
    // Useful for UI elements
    public StringProperty nameProperty() { return Name; }
    public StringProperty classProperty() { return Class; }
    public StringProperty emailProperty() { return Email; }
    public StringProperty IDProperty() { return ID; }
    
    //Getters for variables
    //Useful for validation and other purposes
    public String getStrName() { return Name.get(); }
    public String getStrClass() { return Class.get(); }
    public String getStrEmail() { return Email.get(); }
    public Integer getIntDemeritPoints() { return DemeritPoints.get(); }
    public String getStrID() { return ID.get(); }
    
    // Setters
    public void setStrName(String value) { Name.set(value); }
    public void setStrClass(String value) { Class.set(value); }
    public void setStrEmail(String value) { Email.set(value); }
    public void setIntDemeritPoints(int value) { DemeritPoints.set(value); }
    // Note, ID is read only, and so there is no setter for the property
    
    // Functions split full name into first and second name
    // By seperating the path before and after a space
    public String getFName() {
        return Name.get().split(" ", 2)[0];
    }
    
    public String getSName() {
        return Name.get().split(" ", 2)[1];
    }
    
    // The toString must be overrided to allow it to work easily with UI elements
    @Override
    public String toString() {
        return Name.get() + " " + ID.get();
    }
}
