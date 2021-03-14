import com.google.common.primitives.Ints;
import org.apache.commons.codec.language.bm.Rule;
import org.telegram.telegrambots.meta.api.objects.File;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeviceInfo {

    String pat_universal = "(\\b\\w+\\b)"; // /([\s\S]+?)\s




    ArrayList<String> arrayList = file();



    public String getMore (String message) {
        String a = "Даш ну камон, чет не так написала значит, я ж не мог накосячить";


        switch (PatternChecker_new(message)) {
            case "find":
                a = SearchDevice(message, arrayList);
                break;
            case "all":
                a =  SearchDevice(arrayList);
        }
      return a;
    };

    private String SearchDevice (String message, ArrayList arr) {

        String a = StringSplit(message);
        Pattern pattern = Pattern.compile(a);
        String results = "";
        for (int i=0; i< arr.size(); i++)
        {
            Matcher m = pattern.matcher((CharSequence) arr.get(i));
            if (m.find()) {
                results += arr.get(i) + "\n";
            }
        }
        return results;
    }

    private String SearchDevice ( ArrayList arr) {

        String results = "";
        for (int i=0; i< arr.size(); i++)
        {
                results += arr.get(i) + "\n";
        }
        return results;
    }

    private String StringSplit (String message){
        String[] words = message.split("\\s", 2);
        String str = "Ничего не найдено";
        for(String subStr:words) {
                str = subStr;
        }

        return str;
    }


    private String PatternChecker_new (String message) {
        String result = "nothing";
        Pattern pattern = Pattern.compile(pat_universal);
        Matcher m = pattern.matcher(message);
        if (m.find()) {
            String a = m.group(m.groupCount());
            switch (m.group(m.groupCount())) { // свитч работает как equals, прикольно, не знал
                case "find":
                    result = "find";
                    break;
                case "all":
                    result = "all";
                    break;

            }
        }
        return result;
    }

    public ArrayList file() {
        ArrayList<String> array = new ArrayList<>();
        try {
            //File file = new File("/Users/prologistic/file.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader("E:\\TelegramBot\\target\\classes\\file.txt");
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                array.add(line);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
        return array;
    }
}
