package h01_anotasyonlar;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H02_Save {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H01_Sehir.class);
        //sql verilerinin olduğu cfg.xml clasına bağlandık, bu sayede sql e bağlandık
        //ve H01_Sehir classından işlem yapacağımızı belirttik

        //işlem yapacağımız alanlar için (session) için parent alan oluşturduk
        SessionFactory sf = con.buildSessionFactory();
        //parent alandan kendime küçük alanlar açtım
        Session s = sf.openSession();

        // Acilan session icerisinde islemlere baslayabilmek icin Transaction aciyoruz.
        /*Transactionlar ile bir işlem yarıda kaldıysa veya
         * tam olarak tamamlanadıysa tüm adımlar başa alınır
         * veri ve işlem güvenliği için önemlidir.Kısacası ya hep
         * ya hiç prensibine göre çalışır
         */

        Transaction tx = s.beginTransaction();

        H01_Sehir sehir1 = new H01_Sehir(34, "İstanbul");
        H01_Sehir sehir2 = new H01_Sehir(35, "İzmir");

        s.save(sehir1);
        s.save(sehir2);

        tx.commit();


    }
}
