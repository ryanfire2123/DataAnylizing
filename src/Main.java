import java.util.ArrayList;

public class Main {




    public static void main(String[] args) {
        //-----------------------------------------Setup----------------------------------------------------------------
        Welcome mainWelcome = new Welcome();
        Reader mainReader = new Reader();
        boolean stop = false;
        String inputFilePath;
        DisplayStatistics displayStatistics = new DisplayStatistics();

        //-----------------------------------------ChoosingFile---------------------------------------------------------
        //mainWelcome.showDialog();
        //inputFilePath = mainWelcome.getChosenFilePath();
        inputFilePath = "/Users/lodewijk/Downloads/DataAnylizing/src/TEST";

        //----------------------------------------BasicAnalyzing--------------------------------------------------------
        mainReader.readChars(inputFilePath);
        mainReader.readStrings(mainReader.getAllChars());
        Analyzer mainAnalyzer = new Analyzer(mainReader.getAllStrings(), mainReader.getAllChars());

        //mainAnalyzer.countTimesWordApperesInArray();

        //displayStatistics.setFieldAmountWordsAnwser(mainReader.getAllStrings().size());
        //displayStatistics.setFieldAmountSentAnwser(mainAnalyzer.howManySentences());
        //displayStatistics.setFieldMostUsedWordAnwser(mainAnalyzer.mostUsedString(mainAnalyzer.countTimesWordApperesInArray()), mainAnalyzer.countTimesWordApperesInArray().get(mainAnalyzer.mostUsedString(mainAnalyzer.countTimesWordApperesInArray())));


        for (String p: mainAnalyzer.listOfPs()) {

            for (String href : mainAnalyzer.listOfHrefs(p)) {
                System.out.println(mainAnalyzer.hrefText(href));
            }

        }
        //----------------------------------------DisplayStatistics-----------------------------------------------------
       // displayStatistics.showDialog();


    }


}
