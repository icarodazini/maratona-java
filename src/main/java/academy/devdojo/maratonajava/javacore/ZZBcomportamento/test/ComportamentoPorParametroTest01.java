package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Car;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Car> cars = List.of(new Car("white", 1999), new Car("black", 2025), new Car("silver", 2012));

    public static void main(String[] args) {
        System.out.println(filterCarByColor(cars, "silver"));
        System.out.println(filterCarByColor(cars, "black"));
        System.out.println(filterCarByColor(cars, "white"));
        System.out.println("--------------------------------------------");
        System.out.println(filterCarByAge(cars, 2012));
    }

    private static List<Car> filterCarByColor(List<Car> cars, String color) {
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getColor().equals(color)) {
                filterCar.add(car);
            }
        }
        return filterCar;
    }

    private static List<Car> filterCarByAge(List<Car> cars, int year) {
        List<Car> filterCar = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() < year) {
                filterCar.add(car);
            }
        }
        return filterCar;
    }
}
