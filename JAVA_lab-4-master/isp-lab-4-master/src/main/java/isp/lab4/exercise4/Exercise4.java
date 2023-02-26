package isp.lab4.exercise4;

public class Exercise4 {
    public static void main(String[] args) {
       
       TemperatureSensor [] ts = new TemperatureSensor[3];
       ts[0] = new TemperatureSensor(70,"homeAn");
       ts[1] = new TemperatureSensor(80,"homeDr");
       ts[2] = new TemperatureSensor(75,"homePa");
       FireAlarm f = new FireAlarm(false);
       
       
      
        Controler c = new Controler(ts,f);
        c.controlStep();
        
       }
       
    } 

