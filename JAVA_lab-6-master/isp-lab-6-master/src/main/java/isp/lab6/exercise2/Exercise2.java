package isp.lab6.exercise2;

import java.util.List;
import java.util.Map;

public class Exercise2 {

    public static void main(String[] args) {

        EquipmentController ep = new EquipmentController();

        Equipment e1 = new Equipment("Echip Cont0", "21211", "Yasmin");
        Equipment e2 = new Equipment("Echip Cont1", "25134", "Grich");
        Equipment e3 = new Equipment("Echip Cont2", "52556", "Borad");

        ep.addEquipment(e1);
        ep.addEquipment(e2);
        ep.addEquipment(e3);
        
        Map<String, List<Equipment>> lq = ep.getEquipmentsGroupedByOwner();
        System.out.println(ep.getNumberOfEquipments());
       
        
        List<Equipment> l = ep.EqList;
        for (Equipment ec: l)
            System.out.println(ec.getName() + " " + ec.getOwner());
      
        
    }
}
