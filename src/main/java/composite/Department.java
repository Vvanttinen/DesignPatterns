package composite;

import java.util.ArrayList;
import java.util.List;

public class Department extends OrgComponent {
    private final List<OrgComponent> children = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    void add(OrgComponent component) {
        children.add(component);
    }

    @Override
    void remove(OrgComponent component) {
        children.remove(component);
    }

    @Override
    double getTotalSalary() {
        double total = 0;
        for (OrgComponent component : children) {
            total += component.getTotalSalary();
        }
        return total;
    }

    @Override
    void toXml(StringBuilder sb, int indent) {
        sb
                .append(" ".repeat(indent))
                .append("<department>\n")
                .append(" ".repeat(indent + 2))
                .append("<name>").append(getName()).append("</name>\n")
                .append(" ".repeat(indent + 2))
                .append("<children>\n");
        for (OrgComponent component : children) {
            component.toXml(sb, indent + 4);
        }
        sb
                .append(" ".repeat(indent + 2))
                .append("</children>\n")
                .append(" ".repeat(indent))
                .append("</department>\n");
    }
}
