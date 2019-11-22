package MVVM.Parts.ViewModel;

import java.util.Arrays;

public class VocabularyInfoViewModel implements IMVVM_ViewModel {
    String vocabulary;
    String[] definitionInEnglish;
    String[] definitionInChinese;
    String[] example;
    String[] imgSrcList;
    int showCount = 5;

    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
    }

    public String[] getDefinitionInEnglish() {
        return definitionInEnglish;
    }

    public void setDefinitionInEnglish(String[] definitionInEnglish) {
        this.definitionInEnglish = definitionInEnglish;
    }

    public String[] getDefinitionInChinese() {
        return definitionInChinese;
    }

    public void setDefinitionInChinese(String[] definitionInChinese) {
        this.definitionInChinese = definitionInChinese;
    }

    public String[] getExample() {
        return example;
    }

    public void setExample(String[] example) {
        this.example = example;
    }

    public String[] getImgSrcList() {
        return imgSrcList;
    }

    public void setImgSrcList(String[] imgSrcList) {
        this.imgSrcList = imgSrcList;
    }

    public VocabularyInfoViewModel() {

    }

    public VocabularyInfoViewModel(String vocabulary, String[] definitionInEnglish, String[] definitionInChinese, String[] example, String[] imgSrcList) {
        this.vocabulary = vocabulary;
        this.definitionInEnglish = definitionInEnglish;
        this.definitionInChinese = definitionInChinese;
        this.example = example;
        this.imgSrcList = imgSrcList;
    }

    public void reloadInfo(String vocabulary, String[] definitionInEnglish, String[] definitionInChinese, String[] example, String[] imgSrcList) {
        this.vocabulary = vocabulary;
        this.definitionInEnglish = definitionInEnglish;
        this.definitionInChinese = definitionInChinese;
        this.example = example;
        this.imgSrcList = imgSrcList;
        setInfoShowCount();
    }

    private void setInfoShowCount() {
        definitionInEnglish = Arrays.copyOfRange(definitionInEnglish, 0, showCount);
        definitionInChinese = Arrays.copyOfRange(definitionInChinese, 0, showCount);
        example = Arrays.copyOfRange(example, 0, showCount);
        imgSrcList = Arrays.copyOfRange(imgSrcList, 0, showCount);


        /*test*/
        for (int i = 0; i < showCount; i++) {
            System.out.println(definitionInEnglish[i]);
            System.out.println(definitionInChinese[i]);
            System.out.println(example[i]);
            System.out.println(imgSrcList[i]);
        }
        /*test*/
    }
}
