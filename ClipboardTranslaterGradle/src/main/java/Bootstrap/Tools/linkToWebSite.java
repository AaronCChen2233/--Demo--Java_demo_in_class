package Bootstrap.Tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class linkToWebSite {
    public static String getInnerStringByElementId(String url, String id) {
        Document document = null;
        String content = "";
        try {
            document = Jsoup.connect(url).get();
            content = document.getElementById(id).outerHtml();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static Elements getElementsByClass(String url, String className) {
        Document document = null;
        Elements content = new Elements();
        try {
            document = Jsoup.connect(url).get();
            content = document.select(className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
