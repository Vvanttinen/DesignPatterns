package builder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select Computer Type:");
        System.out.println("1: Gaming Computer, 2: Office Computer");
        int choice = scanner.nextInt();
        ComputerBuilder builder = switch (choice) {
            case 1 -> new GamingComputerBuilder();
            case 2 -> new OfficeComputerBuilder();
            default -> {
                System.out.println("Invalid choice, defaulting to Office Computer");
                yield new OfficeComputerBuilder();
            }
        };

        ComputerDirector director = new ComputerDirector(builder);
        director.constructComputer();
        Computer computer = builder.buildComputer();
        System.out.println("Computer Configuration:");
        System.out.println(computer);
        scanner.close();
    }
}
