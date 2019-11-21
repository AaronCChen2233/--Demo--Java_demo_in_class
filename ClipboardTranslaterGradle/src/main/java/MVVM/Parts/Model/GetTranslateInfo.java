package MVVM.Parts.Model;

import Bootstrap.Tools.GetConfigProperty;
import Bootstrap.Tools.linkToWebSite;
import org.jsoup.select.Elements;

public class GetTranslateInfo {
    private static final String VURL = GetConfigProperty.vURL;
    private static final String OURL = GetConfigProperty.oFURL;
    private static final String IURL = GetConfigProperty.gISURL;
    private static final String VC = GetConfigProperty.vDclass;
    private static final String OC = GetConfigProperty.oFDclass;
    private static final String IC = GetConfigProperty.Imclass;

    public static String getByVoiceTube(String word) {
        String url = VURL + word;
        return linkToWebSite.getInnerStringByElementId(url, VC);
    }

    public static void getByOxford(String word) {
        String url = OURL + word;
        Elements e = linkToWebSite.getElementsByClass(url, OC);
        System.out.println(linkToWebSite.getElementsByClass(url, OC));
    }

}
