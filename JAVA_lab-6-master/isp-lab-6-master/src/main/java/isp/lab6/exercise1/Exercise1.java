package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {

    public static void main(String[] args) {

        SensorReading sr1 = new SensorReading(210, "London", Type.PRESSURE);
        SensorReading sr2 = new SensorReading(160, "Berlin", Type.HUMIDITY);
        SensorReading sr3 = new SensorReading(230, "Antwerp", Type.TEMPERATURE);
        SensorReading sr4 = new SensorReading(150, "Leipzig", Type.HUMIDITY);
        SensorReading sr5 = new SensorReading(312, "Paris", Type.PRESSURE);

        ReadingReposit rr = new ReadingReposit();
        rr.addReading(sr1);
        rr.addReading(sr2);
        rr.addReading(sr3);
        rr.addReading(sr4);
        rr.addReading(sr5);

        List<SensorReading> readings = rr.getSens();
        System.out.println("list");

        for (SensorReading sens : readings) {
            System.out.println(sens.getValue() + " " + sens.getLocation() + " " + sens.getType());
        }

        System.out.println("\n Avarage value by type(PRESSURE),Paris: ");
        System.out.println(rr.getAvarageValueByType(Type.PRESSURE, "Paris"));

        List<SensorReading> TypeAndLocation = rr.findAllByLocationAndType("Leipzig", Type.HUMIDITY);
       
        for (SensorReading sens : TypeAndLocation) {
            System.out.println(sens.getValue() + " " + sens.getLocation() + " " + sens.getType());
        }
        
        System.out.println("\nSorted list by location:");
        rr.listSortedByLocation();
        for (SensorReading sens : readings)
            System.out.println(sens.getValue() + " " + sens.getLocation() + " " + sens.getType());

    }
}
