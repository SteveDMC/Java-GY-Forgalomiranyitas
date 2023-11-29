package forgalomiranyitas.foprogram.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "uzenetek")
public class Uzenet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull
    @Size(min=5, max=30)
    @Column(name="targy")
    private String targy;
    @NotNull
    @Size(min=50, max=200)
    @Column(name="szoveg")
    private String szoveg;

    @Column(name="datum")
    private LocalDateTime datum;

    @Column(name="nev")
    private String nev;

    public Uzenet() {
    }

    public Uzenet(String targy, String szoveg, LocalDateTime datum, String nev) {
        this.targy = targy;
        this.szoveg = szoveg;
        this.datum = datum;
        this.nev = nev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getTargy() {
        return targy;
    }

    public void setTargy(String targy) {
        this.targy = targy;
    }
}
