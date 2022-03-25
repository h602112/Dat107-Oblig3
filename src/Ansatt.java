import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
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
    private LocalDate ansettelsedato;
    private String stilling;
    private int maanedslonn;


    @ManyToOne
    @JoinColumn(name = "avdeling", referencedColumnName = "avdeling")
    private Avdeling avdeling;

    public Ansatt (String brukernavn, String fornavn, String etternavn, LocalDate ansettelsedato, String stilling
                   ,int maanedslonn, Avdeling avdeling) {
        this.brukernavn = brukernavn;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.ansettelsedato = ansettelsedato;
        this.stilling = stilling;
        this.maanedslonn = maanedslonn;
        this.avdeling = avdeling;
    }

    public Ansatt() {

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

    public LocalDate getAnsettelsedato() {
        return ansettelsedato;
    }

    public void setAnsettelsedato(LocalDate ansettelsedato) {
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
                "maanedslonn=%d" + "\n", brukernavn, fornavn, etternavn, ansettelsedato, stilling, maanedslonn);
    }


}
