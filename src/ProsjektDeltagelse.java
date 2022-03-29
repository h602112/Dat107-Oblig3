import javax.persistence.*;

@Entity
@Table(schema = "oblig3")
public class ProsjektDeltagelse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prosjektdeltagelse_Id;

    private int timer = 0;

    @ManyToOne
    @JoinColumn(name="ansatt_id")
    private Ansatt ansatt;

    @ManyToOne
    @JoinColumn(name="prosjekt_id")
    private Prosjekt prosjekt;

    public ProsjektDeltagelse() {}

    public ProsjektDeltagelse(Ansatt ansatt, Prosjekt prosjekt, int timer) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        this.timer = timer;


        ansatt.leggTilProsjektdeltagelse(this);
        prosjekt.leggTilProsjektdeltagelse(this);
    }

    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk,
                ansatt.getFornavn(), ansatt.getEtternavn(), prosjekt.getNavn(), timer);
    }
}
