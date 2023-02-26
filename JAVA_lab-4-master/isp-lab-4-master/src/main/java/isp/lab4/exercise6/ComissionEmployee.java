package isp.lab4.exercise6;

public class ComissionEmployee extends Employee {

    private double grossSales;
    private double comissionSales;

    public ComissionEmployee(String firstName, String lastName, double grossSales, double comissionSales) {
        super(firstName, lastName);
        this.grossSales = grossSales;
        this.comissionSales = comissionSales;
    }

    public ComissionEmployee() {
    }

    public ComissionEmployee(double grossSales, double comissionSales) {
        this.grossSales = grossSales;
        this.comissionSales = comissionSales;
    }

    @Override
    public double getPaymentAmount() {
        super.getPaymentAmount(); 
        System.out.println("Payment Comission Employee:");
        return comissionSales/100 * grossSales;
    }

    
}


