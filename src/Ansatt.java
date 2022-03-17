import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query ="select a From Ansatt as a order by a.brukernavn")
public class Ansatt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattId;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private String ansettelsedato;
    private String stilling;
    private int maanedslonn;

    public Ansatt (String brukernavn, String fornavn, String etternavn, String ansettelsedato, String stilling
                   ,int maanedslonn) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansettelsedato = ansettelsedato;
        this.stilling = stilling;
        this.maanedslonn = maanedslonn;
    }


    public int getAnsattId() {
        return ansattId;
    }

    public void setAnsattId(int ansattId) {
        this.ansattId = ansattId;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getAnsettelsedato() {
        return ansettelsedato;
    }

    public void setAnsettelsedato(String ansettelsedato) {
        this.ansettelsedato = ansettelsedato;
    }

    public String getStilling() {
        return stilling;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public int getMaanedslonn() {
        return maanedslonn;
    }

    public void setMaanedslonn(int maanedslonn) {
        this.maanedslonn = maanedslonn;
    }

    @Override
    public String toString() {
        return String.format("Ansatt: brukernavn=%s, fornavn=%s, etternavn=%s, ansettelsedato=%tF, stilling=%s," +
                "maanedslonn=%d", brukernavn, fornavn, etternavn, ansettelsedato, stilling, maanedslonn);
    }


}
