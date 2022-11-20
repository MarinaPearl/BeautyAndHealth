package ru.Demchuck.BeautyAndHealth.Parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class WriterInCSV {
    private ArrayList<String> url;
    private static char delimiter = ';';
    private String fullPath = "src/main/resources/";
    public WriterInCSV(ArrayList<String> url, String path) {
        fullPath = fullPath + path;
        this.url = url;
    }

    public void write() {
        try (PrintWriter writer = new PrintWriter(fullPath, StandardCharsets.UTF_8)) {
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
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
