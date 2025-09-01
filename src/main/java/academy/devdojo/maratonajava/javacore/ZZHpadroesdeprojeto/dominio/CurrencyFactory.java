package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

public class CurrencyFactory {
    public static Currency newCurrency(Country country){
        switch (country){
            case USA: return new UsDollar();
            case BRAZIL: return new Real();
            case FRANCA: return new Euro();
            default: throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
