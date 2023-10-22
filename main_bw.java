package Java.Java_Seminar_6;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * main
 */
public class main_bw {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public static void main(String[] args) {
        int a1 = 8563244;        
        int a2 = 8562314;        
        int a3 = 8652314;
        int a4 = 8546321;
        int a5 = 8965423;        
        int a6 = 8965132;
        int a7 = 8956475;
        int a8 = 8914782;

        String s1 = "Anton";
        String s2 = "Stepan";
        String s3 = "Vova";
        String s4 = "Artem";
        add(s1, a1);
        add(s2, a2);
        add(s3, a3);
        add(s4, a4);        
        add(s1, a5);
        add(s1, a6);
        add(s2, a7);
        add(s3, a8);


        System.out.println(getPhoneBook());
        System.out.println(find(s4));
        System.out.println(find("fdsfsd"));
    }

    public static void add(String s, Integer n) {
        if(phoneBook.containsKey(s)) {
            phoneBook.get(s).add(n);
        } else {
            ArrayList<Integer> values = new ArrayList<>();
            values.add(n);
            phoneBook.put(s, values);
        }
        
    }

    public static ArrayList<Integer> find(String name) {
        ArrayList<Integer> numb = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            numb.addAll(phoneBook.get(name));
        }
        return numb;
    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}