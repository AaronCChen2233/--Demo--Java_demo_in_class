package MVVM.Parts.Model;

import Bootstrap.Tools.linkToWebSite;

public class GetTranslateInfo {
    private static final String VOICETUBEURL = "https://tw.voicetube.com/definition/";
    private static final String OXFORDURL = "https://www.oxfordlearnersdictionaries.com/us/definition/english/";

    public static String getByVoiceTube(String word) {
        String url = VOICETUBEURL + word;
        return linkToWebSite.getStringByElementId(url,"definition");
    }

}
