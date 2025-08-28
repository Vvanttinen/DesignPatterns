package composite;

public class Main {
    public static void main(String[] args) {
        Organization org = new Organization("Tietonurkka Oy");

        Department development = new Department("Development");
        Department marketing = new Department("Marketing");
        Department onCallDevelopment = new Department("OnCall Development");

        Employee employee1 = new Employee("Testi Mies", 85000);
        Employee employee2 = new Employee("Nopee Ukko", 120000);
        Employee employee3 = new Employee("Sales Man", 72100);
        Employee employee4 = new Employee("Kauppias", 67500);
        Employee employee5 = new Employee("Ohjelmoija", 85000);
        Employee employee6 = new Employee("Developer", 85000);

        org.add(development);
        org.add(marketing);
        development.add(onCallDevelopment);

        development.add(employee1);
        development.add(employee5);
        development.add(employee6);
        marketing.add(employee3);
        marketing.add(employee4);
        onCallDevelopment.add(employee2);

        marketing.remove(employee3);
        development.printSalary();

        org.printXml();
    }
}
