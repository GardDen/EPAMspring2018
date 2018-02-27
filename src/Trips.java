public class Trips implements Cloneable {
    Trip[] trips;

    public Trips(Trip[] trips) {
        this.trips = trips;
    }

    //2
    public void print() {
        for (Trip trip : trips) {
            System.out.println(trip);
        }
        System.out.println();
    }

    /*//3
    public Trips copy() {
        Trip[] newTrips = new Trip[trips.length];
        System.arraycopy(trips, 0, newTrips, 0, trips.length);
        return newTrips;
    }*/

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /*
    1. Я бы изменил сортировку, sortByTime, пусть по дефолту сортирует по времени, и принимает перегрузку на компаратор
2. getTrips возвращает настоящий массив, эт плохо
переделал через клонирование 4. copy переписать на нативный arraycopy
5. конструктор принимает массив, переделать на varargs
удалил 6. если есть пустой конструктор то должны быть методы для добавления, иначе он бессмысленный
7. Trip не должен следить сам за своим id, имхо
+8. у double и int начальное значение и так 0
клонирование 3. copy принимает массив, но он не статический, зачем он принимает массив?
клонирование 10. copy копирует массив, а не Trips
+ 11. реализуешь клонирование, имплементируй интерфейс - Cloneable
1*. Есть реализованные сортировки лучше их юзать, либо выбрать алгоритм побыстрее
     */
}
