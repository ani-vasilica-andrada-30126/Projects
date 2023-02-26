
package isp.lab4.exercise6;


public class HourlyEmployee extends Employee{
    
    private double wage;
    private double hours;
    
    public HourlyEmployee(String firstName, String lastName, double wage, double hours) {
        super(firstName, lastName);
        this.wage = wage;
        this.hours = hours;
    }
    
    public double getPaymentAmount(){
        super.getPaymentAmount();
        System.out.println("Payment Hourly employee:");
        return wage*hours;
    }
    
}
