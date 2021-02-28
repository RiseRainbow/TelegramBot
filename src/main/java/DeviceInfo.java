import com.google.common.primitives.Ints;
import org.apache.commons.codec.language.bm.Rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfo {

    String a = "";
    String pat = "/model";
    String pat_ios = "/ios";
    String pat_android = "/android";

    String pat_universal = "/([\\s\\S]+?)\\s";

    String [] array = {"Samsung","Xiaomi","Honor" };




    public String getMore (String message) {
        String a = "Совпадений не найдно";
        String[][] ar = new String[5][2];
        ar[0][0] = "Artem";
        ar[1][0] = "Samsung";
        ar[2][0] = "Android 10.0";
        ar[0][1] = "Dima";
        ar[1][1] = "Honor";
        ar[2][1] = "Android 11.0";


        int q = 2;



        boolean ident = false;
        /*Pattern pattern = Pattern.compile(pat);
        Matcher m = pattern.matcher(message);
        while (m.find()) {
            for (int j = 0; j <= m.groupCount(); j++) {
                ident = true;
            }
        };*/


        switch (PatternChecker(message)) {
            case "model":
                ident = true;
                q = 1;
                break;
            case "ios":
                ident = false;
                q = 2;
                break;
        }

        test(message);


        if (ident == true) {
           //System.out.println(StringSplit(message));
            for(int i = 0; i < 2; i++)
            {
                if(ar[q][i].equals(StringSplit(message)))
                {
                    System.out.println("Есть совпадение");
                    a = ar[0][i] + ", " + ar[1][i] + ", " + ar[2][i];
                    break;
                }
            }
        }
      return a;
    };

    private String StringSplit (String message){
        String[] words = message.split("\\s", 2);
        String str = "";
        for(String subStr:words) {
                str = subStr;
        }
        System.out.println("Split " + str);
        return str;
    }

    private String PatternChecker (String message) { // ЭТУ ФУНКЦИЮ НАДО ВЫПИЛИТЬ НАХЕР, УРОДЛИВЫЙ ФРАНКЕНШТЕЙН ЕБАННЫЙ
        String result = "null";
        Pattern pattern = Pattern.compile(pat);
        Matcher m = pattern.matcher(message);
        while (m.find()) {
            for (int j = 0; j <= m.groupCount(); j++) {
                result = "model";
            }
        }
        pattern = Pattern.compile(pat_ios);
        m = pattern.matcher(message);
        while (m.find() && result != "null") {
            for (int j = 0; j <= m.groupCount(); j++) {
                result = "ios";
            }
        }
        pattern = Pattern.compile(pat_android);
        m = pattern.matcher(message);
        while (m.find() && result != "null") {
            for (int j = 0; j <= m.groupCount(); j++) {
                result = "android";
            }
        }
        System.out.println(result);
        return  result;
    }


    private void test (String message) {
        Pattern pattern = Pattern.compile(pat_universal);
        Matcher m  = pattern.matcher(message);
        if (m.find()){
            String a = m.group(m.groupCount());
            switch (m.group(m.groupCount())) { // свитч работает как equals, прикольно, не знал
                case "model":
                    System.out.println("True 1 case " + m.group(m.groupCount()));
                    break;
                case "ios":
                    System.out.println("True 2 case" + m.group(m.groupCount()));
                    break;
                case "android":
                    System.out.println("True 3 case" + m.group(m.groupCount()));
                    break;

           // if (a == "model") {
           // if (m.group(m.groupCount()).equals("model")) { экуал кнешн крута, но в свитч как его засунуть я хз
               /* System.out.println("True " + m.group(m.groupCount()));
            } else {
                System.out.println("False " + m.group(m.groupCount()));
            }*/
        }
        /*while (m.find() ) {
            for (int j = 0; j <= m.groupCount(); j++) {
                System.out.println("true " + m.matches()  );
            }
        }*/
    }
}

}
