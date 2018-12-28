import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    private ArrayList<Character> allChars = new ArrayList<>();
    private ArrayList<String> allStrings = new ArrayList<>();

    public String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public String removeUnalphabeticChars(String input) {
        return input.replaceAll("[^A-Za-z]+" , "");
    }


    public void readChars(String stringOfFile) {
        File file = new File(stringOfFile);


        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() > 0) {
                char currentChar = (char) fileInputStream.read();
                allChars.add(currentChar);
            }
        } catch (IOException e) {
            System.out.println("readStringException" + e);
        }
    }


    public void readStrings (ArrayList<Character> characterArrayList) {
        ArrayList<Character> currentArray = new ArrayList<>();

        for (int i = 0; i < characterArrayList.size(); i++) {

           if (!Character.isWhitespace(characterArrayList.get(i))) {

               char currentChar = characterArrayList.get(i);
               currentArray.add(currentChar);

           } else if (currentArray.size() > 0){

               String currentString = getStringRepresentation(currentArray);
               currentString = removeUnalphabeticChars(currentString);
               allStrings.add(currentString);
               currentArray.clear();
           }


        }
    }



    public ArrayList<Character> getAllChars () {
            return allChars;
    }

    public  ArrayList<String> getAllStrings() {
        return allStrings;
    }

    public Reader() {


    }

}
