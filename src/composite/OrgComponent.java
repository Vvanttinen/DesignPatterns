package composite;

import javax.swing.*;

public abstract class OrgComponent {
    protected String name;
    public OrgComponent(String name) {
        this.name = name;
    }

    abstract String getName();
    abstract void add(OrgComponent component);
    abstract void remove(OrgComponent component);
    protected void printSalary() {
        System.out.printf("Total salary: %.2f\n", this.getTotalSalary());
    }
    abstract double getTotalSalary();
    abstract void toXml(StringBuilder sb, int indent);
}
