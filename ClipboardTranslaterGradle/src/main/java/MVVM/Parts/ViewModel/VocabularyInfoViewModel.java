package MVVM.Parts.ViewModel;

import Bootstrap.Tools.ListTool;
import MVVM.Parts.View.VocabularyInfoView;

import java.util.Arrays;
import java.util.List;

public class VocabularyInfoViewModel implements IMVVM_ViewModel {
    boolean isNotFound;
    String vocabulary;
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

    public void reloadInfo(String vocabulary, String[] definitionInEnglish, String[] definitionInChinese, String[] example, String[] imgSrcList) {
        isNotFound = false;
        this.vocabulary = vocabulary;
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
//        definitionInEnglish = ListTool.clearList(definitionInEnglish);
//        definitionInChinese = ListTool.clearList(definitionInChinese);
//        example  = ListTool.clearList(example);
//        imgSrcList = ListTool.clearList(imgSrcList);
        vocabulary = "404 Not found!";
        vocabularyInfoView.windowPopUp(this);
    }



}
