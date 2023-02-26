package isp.lab4.exercise3;

public class Exercise3 {
    
    public static void main(String[] args) { 
    
        
    TemperatureSensor ts = new TemperatureSensor(2,"Iasi");
    FireAlarm f = new FireAlarm(false);
    
    Controler c = new Controler(ts,f);
    c.controlStep();
    
    }
   
}
