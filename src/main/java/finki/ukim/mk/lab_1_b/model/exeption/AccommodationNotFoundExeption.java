package finki.ukim.mk.lab_1_b.model.exeption;

public class AccommodationNotFoundExeption extends RuntimeException {
    public AccommodationNotFoundExeption(Long id) {
        super(String.format("Accommodation with id %d not exists!"));
    }
}
