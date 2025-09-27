public class AirConditionControl implements Sensor {
    @Override
    public void update(boolean occupied) {
        if (occupied) {
            System.out.println("Air conditioning turned on.");
        } else {
            System.out.println("Air conditioning turned off.");
        }
    }
}
