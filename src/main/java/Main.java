public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        /*1. С помощью одного оператора определить и инициализировать массив из не менее 10 поездок (хотя бы одна поездка
        каждого типа должна быть в массиве; не использовать датчики случайных чисел).*/
        Trips trips = new Trips(new Trip[]{
                new Trip(50.0, 180.0, 1, 100.0),
                new Trip(55, 10.0, 0, 10),
                new Trip(5, 180.0, 0, 100, 200),
                new Trip(55, 180.0, 124.13, 50, 200),
                new Trip(55, 180.0, 0, 100, 200),
                new Trip(55, 180.0, 12, 100, 200),
                new Trip(100, 180.0, 0, 100, 200),
                new Trip(55, 180.0, 5, 150, 10),
                new Trip(50.0, 50.0, 123, 100.0),
                new Trip(50.0, 180.0, 0, 10000000000.0)
        });

        //2. Вывести массив на консоль.
        trips.print();

        //3. Создать копию массива.
        Trips trips2 = (Trips) trips.clone();

        //4. Упорядочить новый массив поездок по убыванию времени поездки.
        trips2.sortByTime();

        //5. Вывести упорядоченный массив на консоль.
        trips2.print();

        //6. Вывести на консоль самую быструю поездку.
        System.out.println("Самая быстрая поездка: " + trips2.getTrips()[0]);

        //7. Определить, есть ли в массиве хотя бы одна поездка длительностью от 25 до 30 минут включительно.
        System.out.println("Есть ли поездка длительностью от 25 до 35 минут: " + trips2.isATripBetween(25, 30));
    }
}
