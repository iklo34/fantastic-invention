package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class Scrap {
    public static void main(String[] args) {
        String url = "https://ua.puma.com/";

        try {
            Document document = Jsoup.connect(url).get();

            Elements links = document.select("a[href]");
            for (Element link : links) {
                System.out.println(link.attr("href"));
            }

            Elements headings = document.select("h1");
            for (Element heading : headings) {
                System.out.println(heading.text());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}