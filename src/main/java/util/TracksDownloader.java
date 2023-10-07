package util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TracksDownloader {

    public static void main(String[] args) throws IOException, InterruptedException {

        Document album = Jsoup.connect("https://open.spotify.com/album/0RHX9XECH8IVI3LNgWDpmQ").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/118.0").get();

        Elements songs = album.getElementsByAttributeValue("name", "music:song");
        for(Element s : songs) {

            String url = s.getElementsByAttribute("content").get(0).attr("content");
            System.out.println(url);

        }

    }

}
