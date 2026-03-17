package finki.ukim.mk.lab_1_b.model.exeption;

public class CountryNotFoundExeption extends RuntimeException {
    public CountryNotFoundExeption(Long id) {
        super(String.format("Country with id %d not exists!"));
    }
}
