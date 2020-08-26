public class SplitOrnek1 {

    public static void main(String[] args){

        String cumle ="Uzayda :yasamak istiyorum...";
        String[] kelime=cumle.split(":");                //(split) Belli bir dizeyi bölmeye yarar.
        for (String s:kelime)
            System.out.println(s);





    }
}
