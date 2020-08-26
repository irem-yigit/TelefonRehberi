import java.io.File;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.zip.Adler32;
import java.io.*;

public class TelefonRehberi {
    public static void main(String[] args){
        File f=new File("C:/Users/IREM/Desktop/TelefonRehberi/Kisiler.txt");
        BufferedWriter writer= null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
            String secenek;
            System.out.println("1-Yeni numara kaydet \n2-Kisi bul \n3-Cikis ");
            System.out.print("Yapmak istediginiz islemi seciniz: ");
            Scanner scan =new Scanner(System.in);
            secenek=scan.next();
            if (secenek.equals("1")){
                System.out.print("Ad giriniz: ");
                String ad = scan.next();
                System.out.print("Soyad giriniz: ");
                String soyad= scan.next();
                System.out.print("Numara giriniz: ");
                long numara = scan.nextLong();
                try {
                    writer.append(ad + ":" + soyad + ":" + numara+"\n");
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Islem basarili bir sekilde kaydedildi...\n");
            }
            else if (secenek.equals("2")){
                try {
                    System.out.print("Arama yapilacak kisi ya da numarayi giriniz: ");
                    String arama = scan.next();
                    ArrayList<String> liste =new ArrayList<>();
                    BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                    try {
                        String kisi = reader.readLine();
                        while(kisi != null ) {
                            liste.add(kisi);
                            kisi = reader.readLine();
                            if (kisi!=null) {
                                String[] dizi=kisi.split(":");
                                if(arama.equals(dizi[0]) || arama.equals(dizi[2])) {
                                    System.out.println("Aradiginiz kisi bulundu:\n" +
                                            "ad: " + dizi[0] + "\n" +
                                            "soyad: " + dizi[1] + "\n" +
                                            "numara: " + dizi[2]);
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (secenek.equals("3")){
                System.out.println("Cikis yapildi...");
                break;
            }
            else{
                System.out.println("Yanlış karakter girdiniz,tekrar deneyin");
            }
        }
    }
}
