import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query ="select a From Ansatt as a order by a.brukernavn")
public class Ansatt {
    @Id private String brukernavn;
    private String fornavn;
    private String etternavn;
    private Date ansettelsedato;
    private String stilling;
    private int maanedslonn;



    @Override
    public String toString() {
        return String.format("Ansatt: brukernavn=%s, fornavn=%s, etternavn=%s, ansettelsedato=%tF, stilling=%s," +
                "maanedslonn=%d", brukernavn, fornavn, etternavn, ansettelsedato, stilling, maanedslonn);
    }


}
