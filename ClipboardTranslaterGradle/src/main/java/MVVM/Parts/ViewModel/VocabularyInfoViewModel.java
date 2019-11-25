package MVVM.Parts.ViewModel;

import Bootstrap.Tools.ListTool;
import Bootstrap.Tools.ReaderWriter;
import MVVM.Parts.View.VocabularyInfoView;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class VocabularyInfoViewModel implements IMVVM_ViewModel {
    boolean isNotFound;
    String vocabulary;
    String speechMP3URL;
    List<String> definitionInEnglish;
    List<String> definitionInChinese;
    List<String> example;
    List<String> imgSrcList;



    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String getSpeechMP3URL() {
        return speechMP3URL;
    }

    public void setSpeechMP3URL(String speechMP3URL) {
        this.speechMP3URL = speechMP3URL;
    }

    public List<String> getDefinitionInEnglish() {
        return definitionInEnglish;
    }

    public void setDefinitionInEnglish(List<String> definitionInEnglish) {
        this.definitionInEnglish = definitionInEnglish;
    }

    public List<String> getDefinitionInChinese() {
        return definitionInChinese;
    }

    public void setDefinitionInChinese(List<String> definitionInChinese) {
        this.definitionInChinese = definitionInChinese;
    }

    public List<String> getExample() {
        return example;
    }

    public void setExample(List<String> example) {
        this.example = example;
    }

    public List<String> getImgSrcList() {
        return imgSrcList;
    }

    public void setImgSrcList(List<String> imgSrcList) {
        this.imgSrcList = imgSrcList;
    }

    public boolean isNotFound() {
        return isNotFound;
    }

    public void setNotFound(boolean notFound) {
        isNotFound = notFound;
    }

    int showCount = 5;
    static VocabularyInfoView vocabularyInfoView;

    public VocabularyInfoViewModel() {
        vocabularyInfoView = new VocabularyInfoView();
    }

    public void reloadInfo(String vocabulary, String[] definitionInEnglish, String[] definitionInChinese, String[] example, String[] imgSrcList,String speechMP3URL) {
        isNotFound = false;
        this.vocabulary = vocabulary;
        this.speechMP3URL = speechMP3URL;
        this.definitionInEnglish = (List<String>) Arrays.asList(definitionInEnglish);
        this.definitionInChinese = (List<String>) Arrays.asList(definitionInChinese);
        this.example = (List<String>) Arrays.asList(example);
        this.imgSrcList = (List<String>) Arrays.asList(imgSrcList);
        setInfoShowCount();
        vocabularyInfoView.windowPopUp(this);
    }

    private void setInfoShowCount() {
        definitionInEnglish = ListTool.subList(definitionInEnglish, showCount);
        definitionInChinese = ListTool.subList(definitionInChinese, showCount);
        imgSrcList = ListTool.subList(imgSrcList, 30);
    }

    public void showNotFound() {
        isNotFound = true;
        vocabulary = "404 Not found!";
        vocabularyInfoView.windowPopUp(this);
    }


    public void save() {
        /*ClipboardTranslaterSave.txt*/
        String savePath = System.getProperty("user.dir") + "\\ClipboardTranslaterSave.txt";
        File file = new File(System.getProperty("user.dir"), "ClipboardTranslaterSave.txt");
        if (file.isFile()) {
            /*If file exist*/
            ReaderWriter.pushWriterStandardCharset(savePath, convertFormatForAnki(), StandardCharsets.UTF_8);
        } else {
            /*If file not exist*/
            ReaderWriter.writerStandardCharset(savePath, convertFormatForAnki(),StandardCharsets.UTF_8);
        }
    }

    private String convertFormatForAnki() {
        String saveString = vocabulary;
        saveString += "\t";
        saveString += String.join("<br>", definitionInChinese).replaceAll("\n", "<br>");
        saveString += String.join("<br>", definitionInEnglish).replaceAll("\n", "<br>");
        saveString += String.join("<br>", example).replaceAll("\n", "<br>");
        return saveString;
    }
}
