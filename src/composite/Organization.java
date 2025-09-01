package composite;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private String name;
    private List<Department> departments = new ArrayList<>();

    public Organization(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void add(Department component) {
        departments.add(component);
    }

    void remove(Department component) {
        departments.remove(component);
    }

    void printSalary() {
        System.out.printf("Total salary: %.2fn", this.getTotalSalary());
    }

    double getTotalSalary() {
        double total = 0;
        for (Department department : departments) {
            total += department.getTotalSalary();
        }
        return total;
    }

    void printXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<organization>\n");
        sb.append(" ".repeat(2));
        sb.append("<name>").append(this.getName()).append("</name>\n");
        sb.append(" ".repeat(2));
        sb.append("<total_salary>").append(this.getTotalSalary()).append("</total_salary>\n");
        sb.append(" ".repeat(2));
        sb.append("<departments>\n");
        for (Department department : departments) {
            department.toXml(sb, 4);
        }
        sb.append(" ".repeat(2));
        sb.append("</departments>\n");
        sb.append("</organization>\n");
        System.out.print(sb);
    }
}
