package h4_oneToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class H4_Fetch {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H2_Kitap.class).
                addAnnotatedClass(H1_Ogrenci.class).buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //id=111 olan öğrencinin tüm kitaplarını listeleyin

//  for (H2_Kitap w :  session.get(H1_Ogrenci.class, 111).getKitapListesi() ) {
//	  System.out.println("kitaplar "+ w);
//
//
//  }
//
//  System.out.println();
//
//  //id= 1002 olan kitabın sahibinin bilgilerini listeleyin
//
//  System.out.println("ilkCevap"  + session.get(H2_Kitap.class, 1002).getOgrenci());
//
//  System.out.println();
//
//  //----------------------------------------------------------------
//  //      SİLME İŞLEMİ    tx.commit(); i delete işlemlerinde unutmamalıyız
//  //--------------------------------------------------------------
//
//  //HQL ile tüm kitapları silelim
//  //önce child table silinir
//
//
//  session.createQuery( "DELETE FROM H2_Kitap").executeUpdate();
//  System.out.println("kitaplar silindi");


        //şimdi de parent ı silelim

//  session.delete(session.get(H1_Ogrenci.class, 222));
//
//  System.out.println("222 id li öğrencinin bilgileri silindi");
//
//direk Parent tablodan Exception olmaksizin silebilmek için
        //------------------------------------------
        //
        //  A)ya Once Child sonra parent silinir.YA DA
        //  B) SQL deki gibi Cascade ozelligi aktif hale getirilir.
        // (@OneToMany(mappedBy = "ogrenci", orphanRemoval = true, cascade = CascadeType.ALL)

        //tekrar tabloları oluştur


        session.delete(session.get(H1_Ogrenci.class, 222));


        System.out.println("222 id li öğrencinin bilgileri tekrar silindi");


        tx.commit();

    }

}