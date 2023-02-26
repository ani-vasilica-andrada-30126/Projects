package isp.lab4.exercise5;

public class Exercise5 {
    
    public static void main(String[] args) {
     FireAlarm f = new FireAlarm(false);
     TemperatureSensor [] t = new TemperatureSensor[3];
    t[0] = new TemperatureSensor(17, "r 1");
    t[1] = new TemperatureSensor(27, "r 2");
    t[2] = new TemperatureSensor(33, "r 3");  
    
    Controler c = new Controler(t,f);
    House h = new House(c);
    c.controlStep();
    
    }
}
