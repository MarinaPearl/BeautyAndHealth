package ru.Demchuck.BeautyAndHealth.Parser;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class ConnectionDBEyeCream {
    private ArrayList<String> url;
    private static char delimiter = ';';
    private String fullPath = "src/main/resources/";
    @Getter private ArrayList<DataBaseParametr> list;
    public ConnectionDBEyeCream(ArrayList<String> url) {
        list = new ArrayList<>();
//        fullPath = fullPath + path;
        this.url = url;
    }

    public void write() {
        try  {
            for (String link : url) {
                if (link.length() < 2) {
                    break;
                }
                Document document = Jsoup.connect(link).userAgent("Chrome/4.0.249.0 Safari/532.5").get();
                Elements description = document.select("#maincontent > div > div > section > section.pdp__extra > section.pdp__extra-right > section > section.pdp__info > div > ul > li.info-tabs__item._current > article > div > section.product-description__description");
                Elements name = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > header > p");
                Elements brandName = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > header > h1 > a");
                Elements price = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > form > div.pdp-form__price.pdp-price > div > div > span.special-price");
                String priceCorrect = price.text().replaceAll("[^0-9]", "");
                Elements volume = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > form > div.pdp-form__swatches.pdp-form-swatches > div > div > span.subheading-1.swatch-simple__view");
                Elements unitMeasurement = document.select("#maincontent > div > div > section > section.pdp__product > section.pdp__form-wrapper > div > form > div.pdp-form__swatches.pdp-form-swatches > div > div > span.subheading-1.swatch-simple__text");
//                writer.println(brandName.text() + delimiter + name.text() + delimiter + volume.text() + " " + unitMeasurement.text()
//                        + delimiter + price.text() + delimiter + elements.text());
                var eyeCream = new DataBaseParametr(brandName.text(), name.text(), volume.text(), priceCorrect, description.text());
                list.add(eyeCream);
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
