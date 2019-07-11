/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package croftventory.Types;

import static croftventory.ObjectManager.StorageController.getBookingList;
import java.math.BigDecimal;
import java.util.Objects;
import javafx.beans.property.*;

/**
 *
 * Defines the Device object
 * 
 * @author kamron
 * 
 */

public class Device {
    // Properties
    // These are used over variables as they can utilize events
    private SimpleStringProperty StrName = new SimpleStringProperty();
    private SimpleIntegerProperty IntQuantity = new SimpleIntegerProperty();
    private SimpleObjectProperty<BigDecimal> DeciValue = new SimpleObjectProperty<>();
    private SimpleLongProperty LngID = new SimpleLongProperty();
    
    // Initialisers
    // Uses polymorphisem to handle storing and retrieving data from database
    // As ID is generated by database itself (for security reasons)
    public Device(String name, int quantity, BigDecimal value, long ID) {
        this.StrName.set(name);
        this.IntQuantity.set(quantity);
        this.DeciValue.set(value);
        this.LngID.set(ID);
    }

    public Device(String name, int quantity, BigDecimal value) {
        this.StrName.set(name);
        this.IntQuantity.set(quantity);
        this.DeciValue.set(value);
    }
    
    // Getters
    // Getters which return properties
    // Useful for UI elements
    public StringProperty nameProperty() { return StrName; }
    public IntegerProperty quantityProperty() { return IntQuantity; }
    public ObjectProperty<BigDecimal> valueProperty() { return DeciValue; }
    public LongProperty IDProperty() { return LngID; }
    
    //Getters for variables
    //Useful for validation and other purposes
    public String getStrName() { return StrName.get(); }
    public Integer getIntQuantity() { return IntQuantity.get(); }
    public BigDecimal getDeciValue() { return DeciValue.get(); }
    public Long getLngID() { return LngID.get(); }
    
   // Setters
   public void setStrName(String value) { StrName.set(value); }
   public void setIntQuantity(int value) { IntQuantity.set(value); }
   public void setDeciValue(BigDecimal value) { DeciValue.set(value); }
   // Note, ID is read only, and so there is no setter for the property
   
   // Finds how many of this device currently are not borrowed
   public Integer getRemaining() {
       // Pre-set the remaining number of devices as the total number available
       // Use Integer object instead of primitive int to avoid unboxing
       Integer remaining = IntQuantity.get();
       
       for (Booking booking : getBookingList()) {
           // If the device is not borrowed subtract the number of devices held from the total
           if (Objects.equals(booking.getLngDevice(), LngID.getValue()) && !booking.getBoolReturned()) {
               remaining -= booking.getIntQuantity();
           }
       }
       
       return remaining;
   }
   
   // The toString must be overrided to allow it to work easily with UI elements
    @Override
    public String toString() {
        return StrName.get();
    }
}
