
package isp.lab4.exercise4;

public class Controler {
    
    private TemperatureSensor[] temperatureSensors = new TemperatureSensor[3];
    private FireAlarm fireSensor;

   public Controler(TemperatureSensor [] temperatureSensors, FireAlarm fireSensor)
   {
       for(int i=0;i<3;i++)
       {
         this.temperatureSensors[i] = temperatureSensors[i];
         this.fireSensor = fireSensor; 
       }
   
   }
 
   public void controlStep(){
       if(this.temperatureSensors[0].getValue() >50 && this.temperatureSensors[1].getValue() >50 && this.temperatureSensors[2].getValue()>50){
           this.fireSensor.setActive();
           System.out.println("Fire alarm started" );
       }
       else System.out.println("Fire alarm not started ");
    
   }
    
    
}
