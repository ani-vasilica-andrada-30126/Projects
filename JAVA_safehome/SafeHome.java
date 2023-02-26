package isp.lab7.safehome;


import java.util.List;
import java.util.Map;

public class SafeHome {

    public static void main(String[] args) throws Exception, InvalidPinException, TooManyAttemptsException, TenantNotFoundException {
       
        Door d = new Door();
        
       
        DoorLockController c = new DoorLockController();
        
        try{
            c.addTenant("2146", "Alvin");
            c.addTenant("8936", "Casandra");
            c.addTenant("9120", "Lucas");
        
        
        } catch(Exception t){
            System.out.println(t.getMessage());
            
            
        }
        
        c.removeTenant("Alvin");
        
        Map<Tenant, AccesKey> ak = c.getValidAcces();
        for(Tenant n : ak.keySet())
            System.out.println(n.getName());
        
        
        try{
        
            c.enterPin("2146");
        } catch (InvalidPinException i) {
             System.out.println(i.getMessage());
            
            
        
        } 
             
        }
    }

