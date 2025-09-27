public class LightControl implements Sensor {
    @Override
    public void update(boolean status) {
        if (status) {
            System.out.println("Lights turned ON.");
        } else {
            System.out.println("Lights turned OFF.");
        }
    }
}
