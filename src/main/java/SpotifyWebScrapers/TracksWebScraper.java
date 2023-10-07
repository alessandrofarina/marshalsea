package SpotifyWebScrapers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TracksWebScraper {

    public static void main(String[] args) throws IOException {

        int albumID = 1;
        Document album = Jsoup.connect("https://open.spotify.com/album/0RHX9XECH8IVI3LNgWDpmQ").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/118.0").get();

        Elements songs = album.getElementsByAttributeValue("name", "music:song");
        for(Element s : songs) {

            String url = s.getElementsByAttribute("content").get(0).attr("content");
            Document song = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/118.0").get();

            String title = song.getElementsByAttributeValue("property", "og:title").get(0).attr("content");
            String trackindex = song.getElementsByAttributeValue("name", "music:album:track").get(0).attr("content");
            String duration = song.getElementsByAttributeValue("name", "music:duration").get(0).attr("content");

            System.out.print("INSERT INTO track(album, title, trackindex, duration) VALUES ");
            System.out.println("(" + albumID + ", '" + title + "', " + trackindex + ", " + duration + ");");

        }

    }

}
