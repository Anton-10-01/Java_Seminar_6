package Java.Java_Seminar_6;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * main
 */
public class main_bw {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        int a1 = 123;        
        int a2 = 1583;        
        int a3 = 23659;
        int a4 = 3988496;
        String s1 = "Anton";
        String s2 = "Stepan";
        String s3 = "Vova";
        String s4 = "Anton";
        add(s1, a1);
        add(s2, a2);
        add(s3, a3);
        add(s4, a4);
        
    }

    public static void add(String s, int n) {
        if(phoneBook.containsKey(s)) {
            // phoneBook.putAll(s,n);
        } else {

        }
        
    }

    public static ArrayList<Integer> find(String name) {

        return null;
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {

        return phoneBook;
    }
}