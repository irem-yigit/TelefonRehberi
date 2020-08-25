import java.io.File;
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
            int secenek;
            System.out.println("1-Yeni numara kaydet \n2-Kisi bul \n3-Cikis ");
            System.out.print("Yapmak istediginiz islemi seciniz: ");
            Scanner scan =new Scanner(System.in);
            secenek=scan.nextInt();
            if (secenek==1){
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
            else if (secenek==2){
                try {
                    ArrayList<String> liste =new ArrayList<>();
                    BufferedReader reader =new BufferedReader(new InputStreamReader(new FileInputStream(f)));
                    try {
                        for (int i=0;i< liste.size();i++){
                            String kisi =reader.readLine();      //satır satır okur.
                            liste.add(kisi);
                            System.out.println("Kisiler: "+liste.get(i));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else if (secenek==3){
                System.out.println("Cikis yapildi...");
                break;
            }
            else{
                System.out.println("Yanlış karakter girdiniz,tekrar deneyin");
            }
        }
    }
}
