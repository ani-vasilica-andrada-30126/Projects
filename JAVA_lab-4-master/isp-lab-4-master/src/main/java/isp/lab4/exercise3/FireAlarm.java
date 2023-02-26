
package isp.lab4.exercise3;

public class FireAlarm {
    
    private boolean active;

    public FireAlarm(boolean active) {
        this.active = active;
    }
    
    public boolean isActive(){
        return this.active==true;
    }
    
    public void setActive(){
       this.active = true;
    
    }

    @Override
    public String toString() {
        return "FireAlarm{" + "active=" + active + '}';
    }
    
    
    
}
