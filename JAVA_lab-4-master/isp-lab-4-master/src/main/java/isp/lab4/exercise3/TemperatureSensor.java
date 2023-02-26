
package isp.lab4.exercise3;

public class TemperatureSensor {
    //atribute
    int value;
    String location;
   
    //constructori
    
    //metode

    public TemperatureSensor(int value, String location) {
        this.value = value;
        this.location = location;
    }

    public TemperatureSensor() {
    }

    public int getValue() {
        return value;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "TemperatureSensor{" + "value=" + value + ", location=" + location + '}';
    }
    
    
}
