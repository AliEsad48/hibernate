package h2_emmedable;

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

}
