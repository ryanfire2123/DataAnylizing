import java.util.ArrayList;

public class Utility {



    public static String getCharsFromTo(String givenString, int from, int to) {
        String charsString = "";
        for (int i = from; i < to; i++) {
            charsString += givenString.charAt(i);
        }
        return charsString;
    }

    public static int getCharsIndexUntilString(String givenString, String until, int from) {

    //returns the index of the first character where the string was first found.

        if (from > givenString.length()) {
            System.out.println("Utility.getCharsIndexString.From>givenString");
        }
        boolean found = false;
        int foundFirst = -1;
        while (!found) {
            for (int i = from; i < givenString.length(); i++) {
                if (getCharsFromTo(givenString, i, (i + until.length())).equals(until)) {
                    found = true;
                    foundFirst = i;
                }
            }
        }
        if (foundFirst < 0) {
            System.out.println("Utility.getCharsIndexUntilString.NothingFound");
            System.exit(404);
        }
        return foundFirst;
    }

    public static String getCharsFromStringToString(String givenString, String from, String to) {
        //set first index
        int fromIndex = -1;

        for (int i = 0; i <= (givenString.length() - from.length()); i++) {
            if (getCharsFromTo(givenString, i, (i + from.length())).equals(from)) {
                fromIndex = (i);
            }
        }

        if (fromIndex == -1) {
            return "nothing";
        }
        //set last index
        int toIndex = -1;

        for (int i = fromIndex; i <= (givenString.length() - to.length()); i++) {
            if (getCharsFromTo(givenString, i, (i + to.length())).equals(to)) {
                toIndex = (i + to.length());
            }
        }

        if (toIndex == -1) {
            return "nothing";
        }

        //returnString
        return getCharsFromTo(givenString, fromIndex, toIndex);
    }

    public static String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }


}
