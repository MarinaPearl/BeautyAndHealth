import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class App {
    private static char delimiter = ';';
    private static PrintWriter writer;
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/eyeCream.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            ArrayList<String> url = new ArrayList<String>();
            while (str != null) {
                url.add(str);
                str = bufferedReader.readLine();
            }
            url.remove(url.remove(url.size() - 1));
            fileReader.close();
            bufferedReader.close();
            writer = new PrintWriter("src/main/resources/input.csv", StandardCharsets.UTF_8);
            for (String link : url) {
                Document document = Jsoup.connect(link).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
                Elements elements = document.select("#maincontent > div > div > section > section.pdp__extra > section.pdp__extra-right > section > section.pdp__info > div > ul > li.info-tabs__item._current > article > div > section.product-description__description");
                Elements name = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > header > p");
                Elements brandName = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > header > h1 > a");
                Elements price = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > form > div.pdp-form__price.pdp-price > div > div > span.special-price");
                Elements volume = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > form > div.pdp-form__swatches.pdp-form-swatches > div > div > span.subheading-1.swatch-simple__view");
                Elements unitMeasurement = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > form > div.pdp-form__swatches.pdp-form-swatches > div > div > span.subheading-1.swatch-simple__text");
                writer.println(brandName.text() + delimiter + name.text() + delimiter + volume.text() + " " + unitMeasurement.text()
                        + delimiter + price.text() + delimiter + elements.text());
            }
            writer.close();
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

}
