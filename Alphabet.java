// Alphabet.java - Etude 11 - Oliver O'Connor - 6529968
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class Alphabet {
    public static ArrayList<String> words =  new ArrayList<String>();
    public static ArrayList<String> tempWords =  new ArrayList<String>();
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(args[0]));
        while (sc.hasNext()){
            words.add(sc.next());
        }
        for (String s : words){
            String string = s;
            if (string.startsWith(""+'"')){
                string = string.replaceFirst(""+'"',"");
            }
            if (string.endsWith(".")||string.endsWith(",")||
            string.endsWith(";")||string.endsWith(":")||string.endsWith("?")
            ||string.endsWith("!")||string.endsWith(""+'"')){
                string = string.replaceAll(".$", "");;
            }
            tempWords.add(string);
        }
        words.clear();
        words.addAll(tempWords);
        tempWords.clear();
        for (String s : words){
            int capitalCount = 0;
            for (char c : s.toCharArray()){
                if (Character.isUpperCase(c)){
                    capitalCount++;
                }
            }
            if (capitalCount == 0){
                tempWords.add(s);
            }
            else if (capitalCount == 1){
                if (Character.isUpperCase(s.charAt(0))){
                    tempWords.add(s);
                }
            }
        }
        words.clear();
        words.addAll(tempWords);

        tempWords.clear();
        for (String s : words){
            if (s.matches("^[a-zA-Z]+('[a-z]+)?$")){
                tempWords.add(s);
            }
        }
        words.clear();
        words.addAll(tempWords);
        for (int s = 0; s<words.size();s++){
            String newString = words.get(s).toLowerCase();
            words.add(s, newString);
            words.remove(s+1);
        }
        Collections.sort(words);
        Set<String> set = new LinkedHashSet<String>();
        set.addAll(words);
        words.clear();
        words.addAll(set);
        for (String s: words){
            System.out.println(s);
        }
    }
}