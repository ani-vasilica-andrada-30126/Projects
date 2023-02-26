
package isp.lab7.safehome;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class DoorLockController implements ControllerInterface {
    private Map<Tenant, AccesKey> validAccess = new HashMap<Tenant, AccesKey>();
     List<Tenant> tenList = new ArrayList();
    Door d = new Door();
    private int c = 0;
     List<AccesKey> acKeyList = new ArrayList();
     List<AccessLog> acLogList = new ArrayList();
     
    
    TenantAlreadyExistsException exception1 = new TenantAlreadyExistsException();
    TooManyAttemptsException exception2 = new TooManyAttemptsException();
    InvalidPinException exception3 = new InvalidPinException();
    TenantNotFoundException exception4 = new TenantNotFoundException();
   
    public DoorLockController(Door d) {
        this.d = d;
    }

    public DoorLockController() {
    }
    

    public Map<Tenant, AccesKey> getValidAcces() {
        return validAccess;
    }
    
     @Override
    public DoorStatus enterPin(String pin) throws InvalidPinException, TooManyAttemptsException {
       
        boolean b = false;
        if(pin.equals(MASTER_KEY)){
            c = 0;
            b = true;
            
            if(d.getStatus() == DoorStatus.OPEN){
              d.lockDoor();
            }
            
            else{
                d.unlockDoor();
            
            }
            
            acLogList.add(new AccessLog("Master K user", LocalDateTime.now(), "Was Inserted", d.getStatus(), "errors not"));
          
            
        } else if(c ==2) {
             acLogList.add(new AccessLog("Unk", LocalDateTime.now(),"pin is wrong", d.getStatus(), "pin is not good,to many tries"));
          
                throw exception2;
           
            
        }
        
        for(AccesKey key: acKeyList) {
        
            if(pin.equals(key.getPin())) {
             
                b = true;
                if(d.getStatus() == DoorStatus.OPEN){
                  d.lockDoor();
                } else {
                    
                    d.unlockDoor();
            }
        }
    }
        if(!b) {
            acLogList.add(new AccessLog("name", LocalDateTime.now(), "wrong p", d.getStatus(), "not correct pin"));
            c++;
            throw exception3;
        }
        
        return d.getStatus();
    }


    @Override
    public void addTenant(String pin, String name) throws TenantAlreadyExistsException {
       
        for(Tenant t : validAccess.keySet()){
        
            if(name.equals(t.getName())){
                acLogList.add(new AccessLog(name,LocalDateTime.now(),"impossible to added",d.getStatus(), "no error"));
                throw exception1;
            }
        }
        Tenant ten = new Tenant(name);
        tenList.add(ten);
        acKeyList.add(new AccesKey(pin));
        validAccess.put(ten,new AccesKey(pin));
        acLogList.add(new AccessLog(name, LocalDateTime.now(),"added",d.getStatus(),"no error"));
    }

   
    @Override
    public void removeTenant(String name) throws Exception {
     
        boolean b2 = true;
        int j = 0;
        
        for(Tenant ten: tenList){
          if(name.equals(ten.getName())) {
              
              b2 = false;
              j = tenList.indexOf(ten);
        }
        
    }
     
        if(b2)
        {
            
            acLogList.add(new AccessLog(name, LocalDateTime.now(), "can't remove tenant", d.getStatus(), "tenant not founded"));
            throw exception4;
        }
        
        acLogList.add(new AccessLog(name, LocalDateTime.now(), "tenant removed", d.getStatus(), "not errors"));
        System.out.println(validAccess.remove(tenList.get(j)));
        acLogList.remove(j);
        tenList.remove(tenList.get(j));
        
    }
    
   
}


