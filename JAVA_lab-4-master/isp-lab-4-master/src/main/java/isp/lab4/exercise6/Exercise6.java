package isp.lab4.exercise6;

public class Exercise6 {

    public static void main(String[] args) {
        Employee a = new ComissionEmployee("Smith", "Anna", 100, 40);
        Employee b = new HourlyEmployee("Jones", "Will", 50.2, 3);
        Employee c = new SalariedEmployee("Brown", "John", 1400);

       System.out.println( a.getPaymentAmount());
       System.out.println( b.getPaymentAmount());
       System.out.println( c.getPaymentAmount());

        Employee[] e = new Employee[6];
        e[0] = new ComissionEmployee("Jah", "Wolf", 150, 8);
        
        e[1] = new ComissionEmployee("Caylee", "Bob", 200, 55);
        
        e[2] = new HourlyEmployee("Bre", "Eden", 13.4, 5);
      
        e[3] = new HourlyEmployee("Hanna", "Navi", 70, 4);
       // System.out.println(e[3].getPaymentAmount());
        e[4] = new SalariedEmployee("Alice", "Garo", 213.76);
       // System.out.println(e[4].getPaymentAmount());
        e[5] = new SalariedEmployee("Ken", "Bali", 7000);
       //System.out.println(e[5].getPaymentAmount());

        
        double totalPaym=0;
        for(int i=0;i<6;i++){
            totalPaym = totalPaym + e[i].getPaymentAmount();
            
        }
        System.out.println(totalPaym);
    }

}
