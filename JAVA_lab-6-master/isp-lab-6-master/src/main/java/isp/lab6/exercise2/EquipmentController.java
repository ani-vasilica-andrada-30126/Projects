package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EquipmentController {

    List<Equipment> EqList = new ArrayList<Equipment>();

    public void addEquipment(final Equipment equipment) {

        EqList.add(equipment);

    }

    /**
     * Get current list of equipments
     *
     * @return list of equipments
     */
    public List<Equipment> getEquipments() {
        System.out.println("List:");
        return EqList;
    }

    /**
     * Get number of equipments
     *
     * @return number of equipments
     */
    public int getNumberOfEquipments() {
        System.out.println("The number of equipments is: ");
        return EqList.size();
    }

    /**
     * Group equipments by owner
     *
     * @return a dictionary where the key is the owner and value is represented
     * by list of equipments he owns
     */
    public Map<String, List<Equipment>> getEquipmentsGroupedByOwner() {

        Map<String, List<Equipment>> map = new HashMap<String, List<Equipment>>();

        for (Equipment eq : EqList) {

            String owner = eq.getOwner();
            if (map.containsKey(owner)) {
                map.get(owner).add(eq);
            } else {
                List<Equipment> ll = new ArrayList<Equipment>();
                ll.add(eq);
                map.put(owner, ll);

            }

        }

        return map;

    }

    /**
     * Remove a particular equipment from equipments list by serial number
     *
     * @param serialNumber - unique serial number
     * @return deleted equipment instance or null if not found
     */
    public Equipment removeEquipmentBySerialNumber(final String serialNumber) {

        for (Equipment k : EqList) {
            if (k.getSerialNumber().equals(serialNumber)) {
                EqList.remove(k);
                return k;

            }
        }
        return null;
    }

    
}
