import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query ="select a From Ansatt as a order by a.brukernavn")
public class Ansatt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansattID;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private Date ansettelsedato;
    private String stilling;
    private int maanedslonn;

    @OneToMany(mappedBy = "ansatt", fetch = FetchType.EAGER)
    List<Prosjekt> prosjekter;

    @OneToMany(mappedBy = "ansatt", fetch = FetchType.EAGER)
    List<Avdeling> avdelinger;





    @Override
    public String toString() {
        return String.format("Ansatt: brukernavn=%s, fornavn=%s, etternavn=%s, ansettelsedato=%tF, stilling=%s," +
                "maanedslonn=%d", brukernavn, fornavn, etternavn, ansettelsedato, stilling, maanedslonn);
    }


}
