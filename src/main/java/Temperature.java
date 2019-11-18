import java.io.*;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
// импорт всех библиотек


//объявление класса
public class ParseValute {

//функция для получения html документа
    private static Document getPage() throws IOException {
        String url = "https://cbr.ru/currency_base/daily/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

//функция для обработки html файла и запись ответа в файл
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element tableWth = page.select("table[class=data]").first();
        Elements predAllValute = tableWth.select("tr");
        String username = System.getProperty("user.name");
        String fileName = "My File.txt";
        String filePath = "C://Users//" + username + "//Desktop";
        File myFile = new File(filePath + "//////" + fileName);
        BufferedWriter writer = new BufferedWriter(new FileWriter(myFile));
        for(Element val: predAllValute){
            String allValute = val.select("td").text();
            if(allValute.length() != 0) {
                String finVal = allValute.substring(8);
                String lineSeparator = System.getProperty("line.separator");
                String promezh;  //промежуточный результат для изменений
                String copy;  //создание копии для проверки
                copy = finVal;
                promezh = lineSeparator + finVal;
                writer.write(promezh);
                if (copy.equals("100 Японских иен 58,8641")){
                    writer.flush();
                    }
                }
            else
                System.out.println();
        }
    }
}
