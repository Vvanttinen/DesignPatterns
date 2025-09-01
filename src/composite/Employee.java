package composite;

public class Employee extends OrgComponent {
    private double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    void add(OrgComponent component) {
        throw new UnsupportedOperationException("Cannot add components to an Employee");
    }

    @Override
    void remove(OrgComponent component) {
        throw new UnsupportedOperationException("Cannot remove components from an Employee");
    }

    @Override
    double getTotalSalary() {
        return salary;
    }

    @Override
    void toXml(StringBuilder sb, int indent) {
        sb
                .append(" ".repeat(indent))
                .append("<employee>\n")
                .append(" ".repeat(indent + 2))
                .append("<name>").append(name).append("</name>\n")
                .append(" ".repeat(indent + 2))
                .append("<salary>").append(String.format("%.2f", salary)).append("</salary>\n")
                .append(" ".repeat(indent))
                .append("</employee>\n");
    }
}
