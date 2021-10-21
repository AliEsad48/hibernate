package h2_embeddable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ogrenciler")
public class H1_Ogrenci {

    @Id
    private int ogrId;

    private String ogrAd;

    private int ogrNot;

    private H2_Dersler dersler;

    public H1_Ogrenci(int ogrId, String ogrAd, int ogrNot, H2_Dersler dersler) {
        this.ogrId = ogrId;
        this.ogrAd = ogrAd;
        this.ogrNot = ogrNot;
        this.dersler = dersler;
    }


    public H1_Ogrenci() {
    }

    @Override
    public String toString() {
        return "H1_Ogrenci{" +
                "ogrId=" + ogrId +
                ", ogrAd='" + ogrAd + '\'' +
                ", ogrNot=" + ogrNot +
                ", dersler=" + dersler +
                '}';
    }
}
