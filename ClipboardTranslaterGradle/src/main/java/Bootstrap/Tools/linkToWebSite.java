package Bootstrap.Tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class linkToWebSite {
    public static String getStringByElementId(String url, String id) {
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
}
