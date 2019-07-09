/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croftventory.Types;

import javafx.beans.property.*;
import java.time.LocalDate;

/**
 *
 * Defines the Booking object
 * 
 * @author kamron
 * 
 */

public class Booking {
    // Properties
    // These are used over variables as they can utilize events
    // Additionally they are useful for the TableView
    private SimpleStringProperty StrStudent = new SimpleStringProperty();
    private SimpleIntegerProperty IntDevice = new SimpleIntegerProperty();
    private SimpleIntegerProperty IntQuantity = new SimpleIntegerProperty();
    private SimpleObjectProperty<LocalDate> DateLent = new SimpleObjectProperty<>();
    private SimpleObjectProperty<LocalDate> DateDue = new SimpleObjectProperty<>();
    private SimpleBooleanProperty BoolReturned = new SimpleBooleanProperty();
    private SimpleIntegerProperty IntID = new SimpleIntegerProperty();
    
    // Initialiser
    // Uses polymorphisem to handle storing and retrieving data from database
    // As ID is generated by database itself (for security reasons)
    public Booking(String student, int device, int quantity, LocalDate lent, LocalDate due, boolean returned, int ID) {
        this.StrStudent.set(student);
        this.IntDevice.set(device);
        this.IntQuantity.set(quantity);
        this.DateLent.set(lent);
        this.DateDue.set(due);
        this.BoolReturned.set(returned);
        this.IntID.set(ID);
    }
    
    public Booking(String student, int device, int quantity, LocalDate lent, LocalDate due, boolean returned) {
        this.StrStudent.set(student);
        this.IntDevice.set(device);
        this.IntQuantity.set(quantity);
        this.DateLent.set(lent);
        this.DateDue.set(due);
        this.BoolReturned.set(returned);
    }
    
    // Getters
    // Getters which return properties
    // Useful for UI elements
    public StringProperty StudentProperty() { return StrStudent; }
    public IntegerProperty DeviceProperty() { return IntDevice; }
    public IntegerProperty QuantityProperty() { return IntQuantity; }
    public ObjectProperty<LocalDate> LentProperty() { return DateLent; }
    public ObjectProperty<LocalDate> DueProperty() { return DateDue; }
    public BooleanProperty ReturnedProperty() { return BoolReturned; }
    public IntegerProperty IDProperty() { return IntID; }
    
    //Getters for variables
    //Useful for validation and other purposes
    public String getStrStudent() { return StrStudent.get(); }
    public Integer getIntDevice() { return IntDevice.get(); }
    public Integer getIntQuantity() { return IntQuantity.get(); }
    public LocalDate getDateLent() { return DateLent.get(); }
    public LocalDate getDateDue() { return DateDue.get(); }
    public Boolean getBoolReturned() { return BoolReturned.get(); }
    public Integer getIntID() { return IntID.get(); }
    
   // Setters
    public void setDateDue(LocalDate value) { DateDue.set(value); }
    public void setBoolReturned(Boolean value) { BoolReturned.set(value); }
   // Note, ID, device, quantity and datelent are all read only, and so there are no setter for those properties
    
}
