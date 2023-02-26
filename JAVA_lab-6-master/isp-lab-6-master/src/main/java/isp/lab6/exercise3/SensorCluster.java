
package isp.lab6.exercise3;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class SensorCluster {
    List<Sensor> sensors = new ArrayList<>();

    public Sensor addSensor(String sensorId, SensorType type){
        Sensor cond = getSensorById(sensorId);
        if(cond==null){ 
            Sensor ss = new Sensor(type,sensorId);
            sensors.add(ss);
            return ss;  
        }     
        return null;
    }

    public boolean writeSensorReading(String sensorId, double value, LocalDateTime dateTime){
        Sensor cond = getSensorById(sensorId);
        if(cond!=null)
        {
          SensorReading sr = new SensorReading(dateTime,value);
          cond.readings.add(sr);
          return true;
        }
        return false;
    }

    public Sensor getSensorById(String sensorId){
        for(Sensor ss : sensors)
            if(ss.getId().equals(sensorId))
                return ss;
        return null;
     

    }

    
    
}
