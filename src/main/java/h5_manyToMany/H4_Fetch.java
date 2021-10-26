package h5_manyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class H4_Fetch {

    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Mirasyediler.class).addAnnotatedClass(H2_Arsalar.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        System.out.println(session.get(H2_Arsalar.class, 22));

        Object mrs1 = session.createQuery("FROM H1_Mirasyediler m WHERE m.isim='muhittin topalak'").getSingleResult();

        System.out.println(mrs1);

        List<Object[]> liste = session.createQuery("SELECT a.sehir FROM H2_Arsalar a").getResultList();

        System.out.println(liste);
        List<Object[]> liste2 = session.createQuery("SELECT m.isim FROM H1_Mirasyediler m").getResultList();

        System.out.println(liste2);

        tx.commit();
    }

}
