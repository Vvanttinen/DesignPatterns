package builder;

import java.util.Scanner;

public abstract class ComputerBuilder {
    protected final Computer computer;
    protected final Scanner scanner;

    public ComputerBuilder() {
        computer = new Computer();
        scanner = new Scanner(System.in);
    }

    public abstract void buildProcessor();
    public abstract void buildRAM();
    public abstract void buildHardDrive();
    public abstract void buildGraphicsCard();
    public abstract void buildOperatingSystem();
    public Computer buildComputer() {
        scanner.close();
        return computer;
    }
}
