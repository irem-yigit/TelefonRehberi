import java.util.ArrayList;

public class arraylist {

    public static void main(String[] args){
        ArrayList<String> liste=new ArrayList<>();

        liste.add("İrem");                 //add --> listeye eleman eklememi sağladı.
        liste.add("Yiğit");

        System.out.println(liste.get(1)); //get --> Listenin 1. indexsindeki elemanı getirmemi sağladı.

        liste.remove(0);             //remove --> Listenin 0. indexindeki elemanı sildim.
        liste.add("Irem");

        System.out.println(liste);
    }
}
