package finki.ukim.mk.lab_1_b.model.dto;

public class RoomInfoDto {
    private int brojNaSobi;
    private String sostojba;
    private int broj;

    public RoomInfoDto(int brojNaSobi, String sostojba, int broj) {
        this.brojNaSobi = brojNaSobi;
        this.sostojba = sostojba;
        this.broj = broj;
    }

    public int getBrojNaSobi() { return brojNaSobi; }
    public String getSostojba() { return sostojba; }
    public int getBroj() { return broj; }
}
