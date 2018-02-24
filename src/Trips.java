public class Trips {
    Trip[] trips;

    public Trips(Trip[] trips) {
        this.trips = trips;
    }

    public Trips() {
    }

    //2
    public void print() {
        for (Trip trip : trips) {
            System.out.println(trip);
        }
        System.out.println();
    }

    //3
    public void copy(Trips copyData) {
        trips = new Trip[copyData.getTrips().length];
        for (int i = 0; i < trips.length; i++) {
            trips[i] = copyData.getTrips()[i];
        }
    }

    //4
    public void sortByTime() {
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for (int i = trips.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
                if (trips[j].getTime() > trips[j + 1].getTime()) {
                    Trip tmp = trips[j];
                    trips[j] = trips[j + 1];
                    trips[j + 1] = tmp;
                }
            }
        }
    }

    public boolean isATripBetween(int min, int max) {
        for (int i = 0; i < trips.length; i++) {
            if (trips[i].getTime() >= min || trips[i].getTime() <= max) {
                return true;
            }
        }
        return false;
    }

    public Trip[] getTrips() {
        return trips;
    }
}
