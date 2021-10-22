package h3_oneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class H4_Fetch {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H2_Gunluk.class).addAnnotatedClass(H1_Kisi.class).buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //id=101 olan kisinin bilgilerini getir sorgula

        System.out.println(session.get(H1_Kisi.class, 101));

        //id=12 olan gunlugun bilgilerini getirini

        System.out.println(session.get(H2_Gunluk.class, 12));

        System.out.println();

        //kisiler ve günlükler tablolarındaki ortak olan kayıtların, kisi adı, yazılar kısmı, kisi yasını sorgulayınız
        //bunu hibernate ile tek satırda halledebiliriz ama şimdi SQL ile yapacağız


        String sorgu = "SELECT k.kisiAd  , g.yazilar , k.kisiYas "
                + "FROM kisiler k INNER JOIN gunlukler g ON k.kisiId=g.kisi_id ";

        List<Object[]> sonucList = session.createSQLQuery(sorgu).getResultList();

        for (Object[] w : sonucList) {
            System.out.println("sql " + Arrays.toString(w));
        }


        tx.commit();

    }
}
