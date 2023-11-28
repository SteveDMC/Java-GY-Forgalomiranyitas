package forgalomiranyitas.foprogram;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="felhasznalok")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String csaladi_nev;
    private String utonev;
    private String bejelentkezes;
    private String email;
    private String jelszo;
    private String jogosultsag;
/*
    public User() {}
    public User(Integer id, String csaladi_nev, String utonev, String bejelentkezes, String email, String jelszo, String jogosultsag) {
        this.id = id;
        this.csaladi_nev = csaladi_nev;
        this.utonev = utonev;
        this.bejelentkezes = bejelentkezes;
        this.email = email;
        this.jelszo = jelszo;
        this.jogosultsag = jogosultsag;
    }*/
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCsaladi_nev() {
        return csaladi_nev;
    }
    public void setCsaladi_nev(String csaladi_nev) {
        this.csaladi_nev = csaladi_nev;
    }
    public String getUtonev() {
        return utonev;
    }
    public void setUtonev(String utonev) {
        this.utonev = utonev;
    }
    public String getBejelentkezes() {
        return bejelentkezes;
    }
    public void setBejelentkezes(String bejelentkezes) {
        this.bejelentkezes = bejelentkezes;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getJelszo() {
        return jelszo;
    }
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }
    public String getJogosultsag() {
        return jogosultsag;
    }
    public void setJogosultsag(String jogosultsag) {
        this.jogosultsag = jogosultsag;
    }
}
