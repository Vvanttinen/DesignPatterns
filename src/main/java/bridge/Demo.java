package bridge;

public class Demo {
  public static void main(String[] args) {
    testDevice(new Tv());
    testDevice(new Radio());
    testDevice(new SmartTv());
  }

  public static void testDevice(Device device) {
    System.out.println("Tests with basic remote.");
    BasicRemote basicRemote = new BasicRemote(device);
    basicRemote.power();
    device.printStatus();

    System.out.println("Tests with advanced remote.");
    AdvancedRemote advancedRemote = new AdvancedRemote(device);
    advancedRemote.power();
    advancedRemote.mute();
    device.printStatus();

    // Smart remote's voice control only works with SmartTv
    System.out.println("Tests with smart remote.");
    SmartRemote smartRemote = new SmartRemote(device);
    smartRemote.power();
    smartRemote.voiceControl("volume up");
    smartRemote.voiceControl("channel up");
    smartRemote.voiceControl("mute");
    smartRemote.voiceControl("browse internet");
    smartRemote.voiceControl("power");
    device.printStatus();
  }
}
