package forgalomiranyitas.foprogram.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "megnevezes")
public class Megnevezes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="nev")
    private String nev;

    @OneToMany(mappedBy = "megnevezes", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    public List<Korlatozas> korlatozasok;

    public Megnevezes() {
    }

    public Megnevezes(String nev, List<Korlatozas> korlatozasok) {
        this.nev = nev;
        this.korlatozasok = korlatozasok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public List<Korlatozas> getKorlatozasok() {
        return korlatozasok;
    }

    public void setKorlatozasok(List<Korlatozas> korlatozasok) {
        this.korlatozasok = korlatozasok;
    }
}
