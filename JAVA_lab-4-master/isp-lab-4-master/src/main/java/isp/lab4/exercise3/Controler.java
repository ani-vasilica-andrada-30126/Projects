
package isp.lab4.exercise3;

public class Controler {
    
    private TemperatureSensor temperatureSensor;
    private FireAlarm fireSensor;
    
    
    public void controlStep(){
       if(this.temperatureSensor.getValue() > 50)
       {
          this.fireSensor.setActive();
          System.out.println("Fire alarm started");
       }
       else
           System.out.println("Fire alarm not started");
    }

    public Controler(TemperatureSensor temperatureSensor, FireAlarm fireSensor) {
        this.temperatureSensor = temperatureSensor;
        this.fireSensor = fireSensor;
    }

    
    
    
    
    
}
