package h7_crudIslemleri;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        //crud işlemleri için gerekli olan class tan object in türetilmesi
        CrudMetodlar metod = new CrudMetodlar();

        metod.sessionFactoryOlustur();

        Scanner scan = new Scanner(System.in);

        String devam = "";
        while (!devam.equalsIgnoreCase("Q")) {

            System.out.println("Kişi eklemek için 'E' silmek için 'S' tüm personeli listelmek için 'L' maaş güncellemek içim 'M' yazınız");
            String islem = scan.next();

            if (islem.equalsIgnoreCase("E")) {
                System.out.println("Lütfen adı giriniz");
                String ad = scan.next();

                System.out.println("Lütfen soyadı giriniz");
                String soyad = scan.next();


                System.out.println("Lütfen maaşı giriniz");
                int maas = scan.nextInt();


                metod.personelEkle(ad, soyad, maas);

                System.out.println("İşlemi Bitirmek için 'Q' devam etmek için 'E' yazınız");
                devam = scan.next();
            } else if (islem.equalsIgnoreCase("S")) {

                System.out.println("Lütfen silmek istediğiniz kişinin idsini giriniz");
                Long id = scan.nextLong();

                metod.personelSil(id);
                System.out.println("İşlemi Bitirmek için 'Q' devam etmek için 'E' yazınız");
                devam = scan.next();

            } else if (islem.equalsIgnoreCase("L")) {

                metod.tumPersoneliListele();
                System.out.println("İşlemi Bitirmek için 'Q' devam etmek için 'E' yazınız");
                devam = scan.next();

            } else if (islem.equalsIgnoreCase("M")) {
                System.out.println("Lütfen maaş ını güncelelemek istediğiniz kişinin id sini giriniz");
                long id = scan.nextLong();
                System.out.println("Lütfen maaş ını güncelelemek istediğiniz kişinin yeni maaş ını giriniz");
                int maas = scan.nextInt();

                metod.maasGuncelle(id, maas);
                System.out.println("İşlemi Bitirmek için 'Q' devam etmek için 'E' yazınız");
                devam = scan.next();

            } else {
                System.out.println("Hatalı işlem girdiniz lütfen tekrar giriniz");
            }

        }

        metod.tumPersoneliListele();
    }

}