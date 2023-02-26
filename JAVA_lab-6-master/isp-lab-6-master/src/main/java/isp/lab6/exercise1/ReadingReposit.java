
package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ReadingReposit implements IReadingRepository {
    List<SensorReading> Sens = new ArrayList();
    @Override
    public void addReading(SensorReading reading) {
     Sens.add(reading);  
    }

    public List<SensorReading> getSens() {
        return Sens;
    }

   

    @Override
    public double getAvarageValueByType(Type type, String location) {
       
       double suma = 0;
       int k = 0;
       for(int i = 0;i<Sens.size();i++)
           if((Sens.get(i).getType().equals(type)) && (Sens.get(i).getLocation().equals(location))){
             k++;
             suma = suma + Sens.get(i).getValue();    
           }
       suma = suma /k;
       return suma;
    }

    @Override
    public List<SensorReading> getReadingsByType(Type type) {
       
        List<SensorReading> newL = new ArrayList();
        for(int i=0; i<Sens.size();i++)
            if(Sens.get(i).getType().equals(type))
                newL.add(Sens.get(i));
        return newL;
    }

    @Override
    public void listSortedByLocation() {
        SortedByLocation comp = new SortedByLocation();
        Sens.sort(comp);
        
    }

    @Override
    public void listSortedByValue() {
       
        SortedByValue comp = new SortedByValue();
        Sens.sort(comp);
    
    }

    @Override
    public List<SensorReading> findAllByLocationAndType(String location, Type type) {
   
        List<SensorReading> newL = new ArrayList<>();
        for(SensorReading s : Sens)
            if(s.getLocation().equals(location) && s.getType().equals(type))
                    newL.add(s);
        
        return newL;
        
    }

    private List<SensorReading> add(SensorReading s) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    class SortedByLocation implements Comparator<SensorReading>
    {

        @Override
        public int compare(SensorReading arg0, SensorReading arg1) {
            return arg0.getLocation().compareTo(arg1.getLocation());
        }             
    }
    
    class SortedByValue implements Comparator<SensorReading>{

        @Override
        public int compare(SensorReading arg0, SensorReading arg1) {
            
            return arg0.getValue() - arg1.getValue();

        }
    
        
    
    
    }
    
    
    
}
