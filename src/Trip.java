public class Trip implements Move {
    private static int idCount = 0;
    private int id;
    private double speed;
    private double theCentralAngleOfTheArc;
    private double timeStop;
    private double distance;
    private double distanseAdd = 0;

    private double time = 0;

    public Trip(double speed, double theCentralAngleOfTheArc, double timeStop, double distance) {
        id = ++idCount;
        this.speed = speed;
        this.theCentralAngleOfTheArc = Math.PI * theCentralAngleOfTheArc / 180;
        this.timeStop = timeStop;
        this.distance = distance;
        calculation();
    }

    public Trip(double speed, double theCentralAngleOfTheArc, double timeStop, double distance, double distanceAdd) {
        if (theCentralAngleOfTheArc != 180.0) {
            try {
                throw new DataException("Невернные данные");
            } catch (DataException e) {
                e.printStackTrace();
            }
        }
        id = ++idCount;
        this.speed = speed;
        this.theCentralAngleOfTheArc = Math.PI * theCentralAngleOfTheArc / 180;
        this.timeStop = timeStop;
        this.distance = distance;
        this.distanseAdd = distanceAdd;
        calculation();
    }

    private void calculation() {
        if (distanseAdd != 0) {
            moveThroughC();
        }
        if (theCentralAngleOfTheArc != 180.0) {
            moveInAnArc();
        }
        moveRight();
    }

    @Override
    public void moveThroughC() {
        distance += distanseAdd;
    }

    @Override
    public void moveInAnArc() {
        distance *= theCentralAngleOfTheArc / Math.sin(theCentralAngleOfTheArc);
    }

    @Override
    public void moveRight() {
        time = timeStop + distance / speed;
    }

    @Override
    public String toString() {
        return String.format("Trip # %03d, time=%1.3e, speed=%1.3e, angle=%3.0f, timeStop=%1.3e, distance=%1.3e, distanceAdd=%1.3e,",
                id, time, speed, theCentralAngleOfTheArc * 180 / Math.PI, timeStop, distance, distanseAdd);

    }

    public double getTime() {
        return time;
    }
}
