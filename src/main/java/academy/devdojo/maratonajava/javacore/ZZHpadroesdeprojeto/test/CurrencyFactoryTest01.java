package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio.CurrencyFactory;

public class CurrencyFactoryTest01 {
    public static void main(String[] args) {
        Currency currency = CurrencyFactory.newCurrency(Country.BRAZIL);
        Currency currency1 = CurrencyFactory.newCurrency(Country.USA);
        Currency currency2 = CurrencyFactory.newCurrency(Country.FRANCA);
        System.out.println(currency.getSymbol());
        System.out.println(currency1.getSymbol());
        System.out.println(currency2.getSymbol());
    }
}
