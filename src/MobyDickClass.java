import jdk.internal.org.objectweb.asm.Handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class MobyDickClass {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\Miguel.Acevedo\\IdeaProjects\\MobyDick\\src\\MobyDick.txt");

        System.out.println(countOccur(file));


    }

    public static HashMap<String, Integer> countOccur(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;
        while (input.hasNext()){
            String word = input.next();
            word = word.toLowerCase().replaceAll("(?:(?<!\\S)\\p{Punct}+)|(?:\\p{Punct}+(?!\\S))", "");

            if (map.containsKey(word)){
                int old = map.get(word);
                int newValue = old + 1;
                map.replace(word, old, newValue);
            } else {
                map.put(word, 1);
            }

        }



        input.close();

        return map;
    }
}
