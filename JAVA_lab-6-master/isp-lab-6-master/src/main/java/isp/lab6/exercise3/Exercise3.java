package isp.lab6.exercise3;

import java.time.LocalDateTime;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) {
        SensorCluster c = new SensorCluster();
        c.addSensor("1", SensorType.TEMP);
        c.addSensor("21", SensorType.PRES);
        c.addSensor("12", SensorType.HUMID);
        c.addSensor("14", SensorType.TEMP);

        c.writeSensorReading("1", 2, LocalDateTime.now());
        c.writeSensorReading("1", 5, LocalDateTime.now());
        c.writeSensorReading("1", 3, LocalDateTime.now());
        c.writeSensorReading("2", 4, LocalDateTime.now());
        c.writeSensorReading("2", 8, LocalDateTime.now());
        c.writeSensorReading("2", 9, LocalDateTime.now());

        Sensor s1 = c.getSensorById("1");
        System.out.println("\nSorted list by value:");
       // List<SensorReading> rez = s1.getSensorReadingSortedByValue();  
        s1.getSensorReadingSortedByValue();
       
        for (SensorReading sens : s1.readings)
            System.out.println(sens.getValue() + " " + sens.getDateAndTime());
        
       
      /*  Sensor p = c.getSensorById("2");
        for (SensorReading r : p.readings) {
            System.out.println(r.getValue() + " " + r.getDateAndTime());
        }
      */
      
      

    }
}
