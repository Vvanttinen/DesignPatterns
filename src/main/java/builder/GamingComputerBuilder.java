package builder;

public class GamingComputerBuilder extends ComputerBuilder {
    @Override
    public void buildProcessor() {
        System.out.println("Select Processor");
        System.out.println("1: Intel Core i7, 2: AMD Ryzen 7");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setProcessor("Intel Core i7");
                break;
            case 2:
                computer.setProcessor("AMD Ryzen 7");
                break;
            default:
                System.out.println("Invalid choice, defaulting to Intel Core i7");
                computer.setProcessor("Intel Core i7");
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
        System.out.println("1: 1TB HDD, 2: 512GB SSD, 3: 1TB SSD");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setHardDrive("1TB HDD");
                break;
            case 2:
                computer.setHardDrive("512GB SSD");
                break;
            case 3:
                computer.setHardDrive("1TB SSD");
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
        System.out.println("1: NVIDIA GeForce RTX 3070, 2: AMD Radeon RX 6600 XT");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setGraphicsCard("NVIDIA GeForce RTX 3070");
                break;
            case 2:
                computer.setGraphicsCard("AMD Radeon RX 6600 XT");
                break;
            default:
                System.out.println("Invalid choice, defaulting to NVIDIA GeForce RTX 3070");
                computer.setGraphicsCard("NVIDIA GeForce RTX 3070");
                break;
        }
    }

    @Override
    public void buildOperatingSystem() {
        System.out.println("Select Operating System");
        System.out.println("1: Windows 11, 2: Linux");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                computer.setOperatingSystem("Windows 11");
                break;
            case 2:
                computer.setOperatingSystem("Linux");
                break;
            default:
                System.out.println("Invalid choice, defaulting to Windows 11");
                computer.setOperatingSystem("Windows 11");
                break;
        }
    }
}
