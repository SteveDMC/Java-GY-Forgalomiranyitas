package forgalomiranyitas.foprogram;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "felhasznalok")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String csaladi_nev;
    private String utonev;
    private String bejelentkezes;
    private String email;
    private String jelszo;
    private String jogosultsag;

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
    public String getLongName() {
        return getCsaladi_nev()+" "+getUtonev();
    }
}
