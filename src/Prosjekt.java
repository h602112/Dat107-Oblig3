import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "oblig3")
public class Prosjekt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektID;
    private String navn;
    private String beskrivelse;

    @OneToMany(mappedBy = "prosjekt")
    private List<ProsjektDeltagelse> deltagelser;

    public Prosjekt(String navn, String beskrivelse) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
    }

    public Prosjekt() {

    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sProsjekt nr %d: %s", innrykk, prosjektID, navn);
    }

    public void skrivUtMedAnsatte() {
        System.out.println();
        skrivUt("");
        deltagelser.forEach(a -> a.skrivUt("\n   "));
    }

    public void leggTilProsjektdeltagelse(ProsjektDeltagelse prosjektdeltagelse) {
        deltagelser.add(prosjektdeltagelse);
    }

    public void fjernProsjektdeltagelse(ProsjektDeltagelse prosjektdeltagelse) {
        deltagelser.remove(prosjektdeltagelse);
    }

    public int getId() {
        return prosjektID;
    }

    public String getNavn() {
        return navn;
    }

    public List<ProsjektDeltagelse> getDeltagelser() {
        return deltagelser;
    }

}
