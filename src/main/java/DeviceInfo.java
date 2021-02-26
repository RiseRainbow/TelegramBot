import org.apache.commons.codec.language.bm.Rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfo {

    String a = "Совпадений не найдно";
    String pat = "/model";

    String [] array = {"Samsung","Xiaomi","Honor" };




    public String getMore (String message) {
        String[][] ar = new String[5][2];
        ar[0][0] = "Samsung";
        ar[1][0] = "Artem";
        ar[2][0] = "asd";
        ar[0][1] = "Honor";
        ar[1][1] = "asd";
        ar[2][1] = "asd";



        boolean ident = false;
        //System.out.println(message);
        Pattern pattern = Pattern.compile(pat);
        Matcher m = pattern.matcher(message);
        //System.out.println(m.matches());
        /*if (m.matches()){
            a = "yes";
        } else {
            a = "NO: ";
        }*/
        while (m.find()) {
            for (int j = 0; j <= m.groupCount(); j++) {
                //System.out.println("comlete");
                ident = true;
            }
        }
        if (ident == true) {
           System.out.println(StringSplit(message));
            for(int i = 0; i < 2; i++)
            {
                if(ar[0][i].equals(StringSplit(message)))
                {
                    System.out.println("Есть совпадение");
                    a = ar[0][i];
                    break;
                }
            }
        }
      return a;
    };

    private String StringSplit (String message){
        String[] words = message.split("\\s"); // Разбиение строки на слова с помощью разграничителя (пробел)
        String str = "";
        // Вывод на экран
        for(String subStr:words) {
            //System.out.println(subStr);
            str = subStr;
        }
        return str;
    }

}
