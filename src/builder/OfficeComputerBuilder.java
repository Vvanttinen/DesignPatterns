package builder;

public class OfficeComputerBuilder extends ComputerBuilder {
    @Override
    public void buildProcessor() {
        System.out.println("Select Processor");
        System.out.println("1: Intel Core i5, 2: AMD Ryzen 5");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setProcessor("Intel Core i5");
                break;
            case 2:
                computer.setProcessor("AMD Ryzen 5");
                break;
            default:
                System.out.println("Invalid choice, defaulting to Intel Core i5");
                computer.setProcessor("Intel Core i5");
                break;
        }
    }

    @Override
    public void buildRAM() {
        System.out.println("Select RAM Size (in GB): ");
        int ramSize = scanner.nextInt();
        computer.setRamSize(ramSize);
    }

    @Override
    public void buildHardDrive() {
        System.out.println("Select Hard Drive Type");
        System.out.println("1: 1TB HDD, 2: 512GB SSD");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setHardDrive("1TB HDD");
                break;
            case 2:
                computer.setHardDrive("512GB SSD");
                break;
            default:
                System.out.println("Invalid choice, defaulting to 1TB HDD");
                computer.setHardDrive("1TB HDD");
                break;
        }
    }

    @Override
    public void buildGraphicsCard() {
        System.out.println("Select Graphics Card");
        System.out.println("1: Integrated Graphics, 2: NVIDIA GeForce MX250");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setGraphicsCard("Integrated Graphics");
                break;
            case 2:
                computer.setGraphicsCard("NVIDIA GeForce MX250");
                break;
            default:
                System.out.println("Invalid choice, defaulting to Integrated Graphics");
                computer.setGraphicsCard("Integrated Graphics");
                break;
        }
    }

    @Override
    public void buildOperatingSystem() {
        System.out.println("Select Operating System");
        System.out.println("1: Windows 10 Pro, 2: Ubuntu 20.04 LTS");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setOperatingSystem("Windows 10 Pro");
                break;
            case 2:
                computer.setOperatingSystem("Ubuntu 20.04 LTS");
                break;
            default:
                System.out.println("Invalid choice, defaulting to Windows 10 Pro");
                computer.setOperatingSystem("Windows 10 Pro");
                break;
        }
    }
}
