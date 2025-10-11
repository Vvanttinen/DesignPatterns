package bridge;

public class SmartRemote extends AdvancedRemote {
  public SmartRemote(Device device) {
    super(device);
  }

  public void voiceControl(String command) {
    if (this.device instanceof SmartTv smartTv) {
      if (!smartTv.isEnabled()) {
        System.out.println("Smart Remote: TV is not connected to the internet.");
        return;
      }

      System.out.println("Remote: voice control - " + command);
      if (command.equalsIgnoreCase("volume up")) {
        device.setVolume(device.getVolume() + 10);
      } else if (command.equalsIgnoreCase("volume down")) {
        device.setVolume(device.getVolume() - 10);
      } else if (command.equalsIgnoreCase("channel up")) {
        device.setChannel(device.getChannel() + 1);
      } else if (command.equalsIgnoreCase("channel down")) {
        device.setChannel(device.getChannel() - 1);
      } else if (command.equalsIgnoreCase("mute")) {
        mute();
      } else if (command.equalsIgnoreCase("power")) {
        power();
      } else if (command.equalsIgnoreCase("browse internet")) {
        smartTv.browseInternet();
      } else {
        System.out.println("Command not recognized.");
      }
    } else {
      System.out.println("Smart Remote: Voice control is only available for Smart TV.");
    }
  }
}
