package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarPredicate;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Car> cars = List.of(new Car("white", 1999), new Car("black", 2025), new Car("silver", 2012));

    public static void main(String[] args) {
        List<Car> silverCars = filter(cars, car -> car.getColor().equals("silver"));
        List<Car> yearBeforeCars = filter(cars, car -> car.getYear() < 2012);
        System.out.println(silverCars);
        System.out.println(yearBeforeCars);
    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (carPredicate.test(car)){
                filterCar.add(car);
            }
        }
        return filterCar;
    }

}
