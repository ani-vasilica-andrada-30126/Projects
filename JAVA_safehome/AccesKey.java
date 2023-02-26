
package isp.lab7.safehome;

import java.util.Objects;


public class AccesKey {
    private String pin;

    public AccesKey(String pin) {
        this.pin = pin;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    @Override
    public String toString() {
        return "AccesKey{" + "pin=" + pin + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AccesKey other = (AccesKey) obj;
        return Objects.equals(this.pin, other.pin);
    }

     
    
}
