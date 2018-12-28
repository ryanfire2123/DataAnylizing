import com.sun.tools.javac.code.Attribute;

import java.lang.reflect.Array;
import java.util.*;

public class Analyzer {
   private ArrayList<Character> characterArrayList;
   private ArrayList<String> stringArrayList;
   private HashMap<String, Integer> stringsLength = new HashMap<>();
   private String characterListString;

    public String getKeyStringFromValue(HashMap<String, Integer> map, int value) {
        int howMany = 0;
        boolean foundOne = false;
        String wordFound = "error";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                wordFound = entry.getKey();
                howMany += 1;
            }
        }
        if (howMany == 1) {
            return wordFound;
        } else if (howMany < 0){
            System.out.println("KeyValuePair not found");
            return "error404";
        } else {
            System.out.println("More than 1 winner!");
            return wordFound;
        }
    }

    public HashMap<String, Integer> countTimesWordApperesInArray() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int size = stringArrayList.size();
        for (int i = 0; i < size; i ++) {
            int count = 0;

            String element = stringArrayList.get(i);
            for (int j = 0; j < size; j += 1) {
                if (stringArrayList.get(j).equals(element)) {
                    count += 1;
                }
            }
            hashMap.put(stringArrayList.get(i) , count);

        }
        return hashMap;
    }

    public int howManySentences() {
        int amount = 0;
        for (int i = 0; i < characterArrayList.size(); i++) {
            if (characterArrayList.get(i) == '.' && characterArrayList.get((i + 1)) != '.' ) {
                amount += 1;
            }
        }
        return amount;
    }

    public int howManyOfThisChar(char givenChar) {
        int amount = 0;
        for (int i = 0; i < characterArrayList.size(); i++ ) {
            if (characterArrayList.get(i) == givenChar ) {
                 amount += 1;
            }

        }
        return amount;
    }

    public int howManyOfThisString(String givenString) {
        int amount = 0;
        for (int i = 0; i < stringArrayList.size(); i++ ) {
            if (stringArrayList.get(i).equals(givenString)) {
                amount += 1;
            }
        }
        return amount;
    }

    public void countLegthOfStringInArray(ArrayList<String> givenArray) {

        for (int i = 0; i < givenArray.size(); i++) {
            int currentLength = givenArray.get(i).length();
            String currenString = givenArray.get(i);
            stringsLength.put(currenString, currentLength);
        }

    }

    public int getAverageStringLength() {
        return getTotalLength() / stringsLength.size();
    }

    public int getTotalLength() {
        int totalLength = 0;
        Collection<Integer> lengthValues = stringsLength.values();

        for (Integer i : lengthValues) {
            totalLength += i;
        }
        return totalLength;
    }


    public String mostUsedString(HashMap<String, Integer> hashMap) {

        int maxValue = Collections.max(hashMap.values());
        return getKeyStringFromValue(hashMap, maxValue);

    }

    public String insideHead() {

        return Utility.getCharsFromStringToString(characterListString, "<head>", "</head>");
    }

    public ArrayList<String> listOfPs() {
        String currentSample = characterListString;
        ArrayList<String> currentList = new ArrayList<>();
        boolean stop = false;
        while (!stop) {
            String currentp = insideP(currentSample);
            if (currentp.equals("nothing")) {
                stop = true;
            } else {
                currentList.add(currentp);
            }
            currentSample = currentSample.replace(currentp, "");
        }
        return currentList;
    }

    public ArrayList<String> listOfHrefs(String sample) {
        String currentSample = sample;
        ArrayList<String> currentList = new ArrayList<>();
        boolean stop = false;
        while (!stop) {
            String currentHref = insideHref(currentSample);
            if (currentHref.equals("nothing")) {
                stop = true;
            } else {
                currentList.add(currentHref);
            }
           currentSample = currentSample.replace(currentHref, "");
        }
        return currentList;
    }


    public String insideP(String sample) {
        return Utility.getCharsFromStringToString(sample, "<p>", "</p>");
    }

    public String insideHref(String sample) {
        return Utility.getCharsFromStringToString(sample, "<a href=", "</a>");
    }

    public String hrefText(String href) {
        String currentHref = href.replaceAll("<a href=", "");
        currentHref = currentHref.replaceAll("/a>", "");
        String found = Utility.getCharsFromStringToString(currentHref, ">", "<");
        found = found.replaceAll(">", "");
        found = found.replaceAll("<", "");
        return found;
    }

    public Analyzer(ArrayList<String> givenStringList, ArrayList<Character> givenCharList) {
        characterArrayList = givenCharList;
        stringArrayList = givenStringList;
        characterListString = Utility.getStringRepresentation(characterArrayList);
    }

    public ArrayList<Character> getCharacterArrayList() {
        return characterArrayList;
    }
}
