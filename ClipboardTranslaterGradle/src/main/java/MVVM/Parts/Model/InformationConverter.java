package MVVM.Parts.Model;

import Bootstrap.Tools.GetConfigProperty;
import MVVM.Parts.ViewModel.VocabularyInfoViewModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class InformationConverter {
    static VocabularyInfoViewModel vocabularyInfoViewModel = new VocabularyInfoViewModel();

    public static void ConvertInformationToVocabularyInfo(String word) {
        String vocabulary = word;
        String[] definitionInEnglish = new String[0];
        String[] definitionInChinese = new String[0];
        String[] example = new String[0];
        String[] imgSrcList = new String[0];

        List<String> tempExample = new ArrayList<>();
        /*definitionInChinese Part*/
        String[] Temp;
        String info = GetTranslateInfo.getByVoiceTube(word);
        if (!info.equals("")) {
            Temp = info.split("<h3>([^<]*)</h3>");
            for (int i = 0; i < Temp.length; i++) {
                Temp[i] = Temp[i].replace("\n", "");
                Temp[i] = Temp[i].replace("  ", " ");
                Temp[i] = Temp[i].replace("<br>", "\n");
                Temp[i] = Temp[i].replaceAll("<.*?>", "");
            }
            Temp[1] = Temp[1].replaceAll("\n \n", "\n");
            definitionInChinese = Temp[1].split("\n\n");


            /*example Part*/
            /*VoiceTube may not have example*/
            if (Temp.length == 3) {
                tempExample = new ArrayList<String>(Arrays.asList((Temp[2].split("\n \n"))));
            }
        }

        /*definitionInEnglish Part*/
        Document tempDocument = GetTranslateInfo.getOxfordDocument(word);
        Elements tempElements = new Elements();
        List<String> tempStringList = new ArrayList<>();
        if (tempDocument != null) {
            tempElements = tempDocument.select(GetConfigProperty.oFDclass);
            tempStringList = tempElements.stream()
                    .map((Element::outerHtml)).collect(Collectors.toList());

            tempElements = tempDocument.select("span.x");
            List<String> list = new ArrayList<String>(tempElements.stream().map((Element::outerHtml)).collect(Collectors.toList()));
            tempExample.addAll(list);

            definitionInEnglish = new String[tempStringList.size()];
            definitionInEnglish = tempStringList.toArray(definitionInEnglish);
            for (int i = 0; i < definitionInEnglish.length; i++) {
                /*Remove definitionInEnglish html tag*/
                definitionInEnglish[i] = definitionInEnglish[i].replaceAll("<.*?>", "");
            }
        }


        /*if vocabulary is found*/
        if (!(info.equals("") && tempElements.size() == 0)) {
            /*imgSrcList Part*/
            tempElements = GetTranslateInfo.getImgSrcs(word).select("img");
            tempStringList = tempElements.stream()
                    .map(t -> t.attr("abs:data-src")).filter(t -> !t.equals("")).collect(Collectors.toList());
            imgSrcList = new String[tempStringList.size()];
            imgSrcList = tempStringList.toArray(imgSrcList);
            
            example = new String[tempExample.size()];
            example = tempExample.toArray(example);
            for (int i = 0; i < example.length; i++) {
                /*Remove example html tag*/
                example[i] = example[i].replaceAll("<.*?>", "");
            }

            vocabularyInfoViewModel.reloadInfo(word, definitionInEnglish, definitionInChinese, example, imgSrcList);
        }
        else {
            vocabularyInfoViewModel.showNotFound();
        }
    }
}
