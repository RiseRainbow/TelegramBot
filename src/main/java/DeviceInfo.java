import com.google.common.primitives.Ints;
import org.apache.commons.codec.language.bm.Rule;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfo {

    String a = "";
    String pat = "/model";
    String pat_ios = "/ios";
    String pat_android = "/android";

    String pat_universal = "/([\\s\\S]+?)\\s";






    public String getMore (String message) {
        ArrayList<String> arrayList = new ArrayList<>();
        String a = "Даш ну камон, чет не так написала значит, я ж не мог накосячить";
        String[][] ar = new String[5][5];
        ar[0][0] = "Artem";
        ar[0][1] = "Samsung";
        ar[0][2] = "Android";
        ar[0][3] = "Android 10.0";
        ar[1][0] = "Dima";
        ar[1][1] = "Honor";
        ar[1][2] = "Android";
        ar[1][3] = "Android 11.0";
        ar[2][0] = "Daria";
        ar[2][1] = "iPhone Xs";
        ar[2][2] = "iOS";
        ar[2][3] = "iOS 14.0";
        ar[3][0] = "Artm";
        ar[3][1] = "Samsung";
        ar[3][2] = "Android";
        ar[3][3] = "Android 10.0";


        int q = 2;
        String qwe = "null";



        boolean ident = false;


        switch (PatternChecker_new(message)) {
            case "model":
                ident = true;
                q = 1;
                break;
            case "platform":
                ident = true;
                q = 2;
                break;
            case "version":
                ident = true;
                q = 3;
                qwe = "ios";
                break;
            case "android":
                ident = true;
                q = 3;
                qwe = "android";
                break;
            case "nothing":
                ident = true;
                q = 3;
                break;
        }



        if (ident == true ) {
        String split = StringSplit(message);
            for(int i = 0; i < 4; i++)
            {
                if(ar[i][q].equals(split))
                {
                    arrayList.add(ar[i][0] + ", " + ar[i][1] + ", " + ar[i][3]);
                }
            }
             a  = "";
            for (int s = 0; s <arrayList.size(); s++){
                a += arrayList.get(s) + "\n";
            }

            //System.out.println(a);

        }
      return a;
    };

    private String StringSplit (String message){
        String[] words = message.split("\\s", 2);
        String str = "c";
        for(String subStr:words) {
                str = subStr;
                System.out.println(str);
        }
        if (str.equals("c")){
            System.out.println("clear");
        }

        return str;
    }

    /*private String PatternChecker (String message) { // ЭТУ ФУНКЦИЮ НАДО ВЫПИЛИТЬ НАХЕР, УРОДЛИВЫЙ ФРАНКЕНШТЕЙН ЕБАННЫЙ
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
    }*/


    private String PatternChecker_new (String message) {
        String result = "nothing";
        Pattern pattern = Pattern.compile(pat_universal);
        Matcher m = pattern.matcher(message);
        if (m.find()) {
            String a = m.group(m.groupCount());
            switch (m.group(m.groupCount())) { // свитч работает как equals, прикольно, не знал
                case "model":
                    //System.out.println("True 1 case " + m.group(m.groupCount()));
                    result = "model";
                break;
                case "ios":
                    //System.out.println("True 2 case" + m.group(m.groupCount()));
                    result = "ios";
                break;
                case "android":
                    // System.out.println("True 3 case" + m.group(m.groupCount()));
                    result = "android";
                break;
                case "platform":
                    result = "platform";
                    break;
                case "version":
                    result = "version";
                    break;
            }
        }
        return result;
    }
}
