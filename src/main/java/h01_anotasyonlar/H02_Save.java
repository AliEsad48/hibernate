package h01_anotasyonlar;


import org.hibernate.cfg.Configuration;

public class H02_Save {
    public static void main(String[] args) {

        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H01_Sehir.class);
        //sql verilerinin olduğu cfg.xml clasına bağlandık, bu sayede sql e bağlandık
        //ve H01_Sehir classından işlem yapacağımızı belirttik



        H01_Sehir sehir1 = new H01_Sehir(34, "İstanbul");
        H01_Sehir sehir2 = new H01_Sehir(35, "İzmir");


    }
}
