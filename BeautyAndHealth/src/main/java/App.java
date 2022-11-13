import org.apache.http.client.utils.URIBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.Console;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class App {
    public static void main(String[] args) {
        try {
            PrintWriter writer = new PrintWriter("src/main/resources/input.txt", StandardCharsets.UTF_8);
            Document document = Jsoup.connect("https://goldapple.ru/15082200004-hydra-24-regard-glacon").userAgent("Chrome/4.0.249.0 Safari/532.5").get();
            Elements elements = document.select("#maincontent > div > div > section > section.pdp__extra > section.pdp__extra-right > section > section.pdp__info > div > ul > li.info-tabs__item._current > article > div > section.product-description__description");
           // document.querySelector("#maincontent > div > div > section > section.pdp__extra > section.pdp__extra-right > section > section.pdp__info > div > ul > li.info-tabs__item._current > article > div > section.product-description__description")
//            System.out.println(elements.text());
            writer.println(elements.text());
            //writer.println(elements.text());
           // String e =  document.attr("div.page-wrapper");
           // writer.println(e);

           // writer.println(document.toString());
           // writer.println(document.title());
//            Elements e = document.select("ul.menu-burger__main-list");
//            for (Element element : e) {
//                Elements elements = element.select("a");
//                //writer.println(elements.get(5).attr("href"));
//                URIBuilder uriBuilder = new URIBuilder(elements.get(5).attr("href"));
//                URL url = uriBuilder.build().toURL();
//                System.out.println(url.toString());
//               Document document1 = Jsoup.connect(url.toString()).get();
//              // writer.println(document1.toString());
//
//            }
           writer.close();
        } catch (Exception error) {
            error.printStackTrace();
        }

    }

}
