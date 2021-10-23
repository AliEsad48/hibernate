package h4_oneToMany;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ogrenciler1")
public class H1_Ogrenci {

    @Id
    private int ogrId;

    private String ogrAd;

    private int ogrNot;

    @OneToMany(mappedBy = "ogrenci")

    private List<H2_Kitap> kitapListesi = new ArrayList<>();

    //burada private H2_Kitap kitap yazamam, bu bir tane kitap olur, çok olacağı için list yaptık,her öğrencinin listesi olacak
    public H1_Ogrenci() {

    }

    public H1_Ogrenci(int ogrId, String ogrAd, int ogrNot) {
        this.ogrId = ogrId;
        this.ogrAd = ogrAd;
        this.ogrNot = ogrNot;
    }

    public int getOgrId() {
        return ogrId;
    }

    public void setOgrId(int ogrId) {
        this.ogrId = ogrId;
    }

    public String getOgrAd() {
        return ogrAd;
    }

    public void setOgrAd(String ogrAd) {
        this.ogrAd = ogrAd;
    }

    public int getOgrNot() {
        return ogrNot;
    }

    public void setOgrNot(int ogrNot) {
        this.ogrNot = ogrNot;
    }

    public List<H2_Kitap> getKitapListesi() {
        return kitapListesi;
    }

    public void setKitapListesi(List<H2_Kitap> kitapListesi) {
        this.kitapListesi = kitapListesi;
    }

    //  @Override  burayı lazy eager muhabbetinde aç, alttaki tostring i kapat
//  public String toString() {
//      return "Ogrenci ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot;
//  }
    @Override
    public String toString() {
        return "Ogrenci ogrId=" + ogrId + ", ogrAd=" + ogrAd + ", ogrNot=" + ogrNot + ", kitapListesi="
                + kitapListesi + "]";
    }

}