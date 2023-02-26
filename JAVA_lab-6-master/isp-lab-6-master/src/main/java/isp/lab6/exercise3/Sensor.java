
package isp.lab6.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Sensor {
    List<SensorReading> readings = new ArrayList<>();
    private SensorType type;
    private String id;

    public Sensor(SensorType type, String id) {
        this.type = type;
        this.id = id;
    }
    
    public SensorType getType() {
        return type;
    }
    
    public String getId() {
        return id;
    }
    

    public boolean addSensorReading(SensorReading sr){
        readings.add(sr);
        return true;
    }

    public List<SensorReading> getSensorReadingSortedByValue(){
        ValComp vc = new ValComp();
        readings.sort(vc);
        return readings;
       
    }
    
    public List<SensorReading> getSensorReadingSortedByDateAndTime(){
    
        readings.sort(SensorReading :: compareTo);
        return readings;
    
    }
    
    

    class ValComp implements Comparator<SensorReading>{
    
      public int compare(SensorReading obj1,SensorReading obj2){
      if(obj1.getValue() < obj2.getValue()){
          return -1;    
      }
      else if(obj1.getValue() == obj2.getValue()){
          return 0;
      }
      else return 1; 
      
      }
    }
            
    
    

    
}
