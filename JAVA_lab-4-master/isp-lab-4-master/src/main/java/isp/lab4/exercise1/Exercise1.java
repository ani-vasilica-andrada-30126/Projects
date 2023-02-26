package isp.lab4.exercise1;

//import isp.lab4.exercise0.CarAlarm; //NU ASA

public class Exercise1 {

    public static void main(String[] args) {
        //instantiati obiect
        TemperatureSensor ts = new TemperatureSensor(8,"Bordeaux");
        System.out.println(ts.getLocation());
        System.out.println(ts.getValue());
        System.out.println(ts.toString());
        
    }
}
