package finki.ukim.mk.lab_1_b.model.exeption;

public class HostNotFoundExeption extends RuntimeException {
    public HostNotFoundExeption(Long id) {
        super(String.format("Host with id %d does not exist!",id));
    }
}
