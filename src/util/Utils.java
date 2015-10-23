package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @name Utils
 * @description Static utility functions
 * @author sam
 */
public class Utils {
    
    /**
     * 
     * @param fileName name of file to read
     * @return  The contents of the file
     * 
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static String readFile(String fileName) throws FileNotFoundException, IOException  {
        StringBuilder sb = new StringBuilder();
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        }
        return sb.toString();
    }
    
    
    /**
     * 
     * @param fileName
     * @param data
     * @throws IOException 
     */
    public static void writeFile(String fileName, String data) throws IOException {
//        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
//            out.println(data);
//        }
        
        Files.write(Paths.get(fileName), data.getBytes(), StandardOpenOption.APPEND);
    }
    
    /**
     * 
     * @param <T>
     * @param items collection of items to join
     * @param seperator character sequence to separate list items
     * @return resulting string from joining list items
     */
    public static <T> String join(T[] items, String seperator) {
        StringBuilder builder = new StringBuilder();

        if(items == null || items.length == 0) {
            return null;
        }
        for (T item : items) {
            builder.append(item).append(seperator);
        }
        builder.delete(builder.length() - seperator.length(), builder.length());

        return builder.toString();
    }
}
