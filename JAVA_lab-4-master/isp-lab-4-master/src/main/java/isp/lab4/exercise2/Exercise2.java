package isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
    FireAlarm f = new FireAlarm (false);
    System.out.println(f);
    System.out.println(f.isActive());
    f.setActive();
    System.out.println(f.isActive());
    System.out.println(f.toString());
    }
}
