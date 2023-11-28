package forgalomiranyitas.foprogram.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="korlatozas")
public class Korlatozas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "az")
    private int id;
    @Column(name = "utszam")
    private int utszam;
    @Column(name = "kezdet")
    private double kezdet;
    @Column(name = "veg")
    private double veg;
    @Column(name = "telepules")
    private String telepules;
    @Column(name = "mettol")
    private Date mettol;
    @Column(name = "meddig")
    private Date meddig;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "megnevid")
    private Megnevezes megnevezes;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mertekid")
    private Mertek mertek;
    @Column(name = "sebesseg")
    private int sebesseg;

    public Korlatozas() {
    }

    public Korlatozas(int utszam, double kezdet, double veg, String telepules, Date mettol, Date meddig, Megnevezes megnevezes, Mertek mertek, int sebesseg) {
        this.utszam = utszam;
        this.kezdet = kezdet;
        this.veg = veg;
        this.telepules = telepules;
        this.mettol = mettol;
        this.meddig = meddig;
        this.megnevezes = megnevezes;
        this.mertek = mertek;
        this.sebesseg = sebesseg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUtszam() {
        return utszam;
    }

    public void setUtszam(int utszam) {
        this.utszam = utszam;
    }

    public double getKezdet() {
        return kezdet;
    }

    public void setKezdet(double kezdet) {
        this.kezdet = kezdet;
    }

    public double getVeg() {
        return veg;
    }

    public void setVeg(double veg) {
        this.veg = veg;
    }

    public String getTelepules() {
        return telepules;
    }

    public void setTelepules(String telepules) {
        this.telepules = telepules;
    }

    public Date getMettol() {
        return mettol;
    }

    public void setMettol(Date mettol) {
        this.mettol = mettol;
    }

    public Date getMeddig() {
        return meddig;
    }

    public void setMeddig(Date meddig) {
        this.meddig = meddig;
    }

    public Megnevezes getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(Megnevezes megnevezes) {
        this.megnevezes = megnevezes;
    }

    public Mertek getMertek() {
        return mertek;
    }

    public void setMertek(Mertek mertek) {
        this.mertek = mertek;
    }

    public int getSebesseg() {
        return sebesseg;
    }

    public void setSebesseg(int sebesseg) {
        this.sebesseg = sebesseg;
    }
}
