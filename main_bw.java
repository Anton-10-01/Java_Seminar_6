package Java.Java_Seminar_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;


/**
 * main
 */
public class main_bw {
    private static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
    //private static LinkedHashMap<String, ArrayList<String>> linkPhoneBook = new LinkedHashMap<>();
    public static void main(String[] args) {
        String a1 = "8563244";        
        String a2 = "8562314";        
        String a3 = "8652314";
        String a4 = "8546321";
        String a5 = "8965423";        
        String a6 = "8965132";
        String a7 = "8956475";
        String a8 = "8914782";
        String a9 = "8956482";
        String a10 = "895474";

        String s1 = "Anton";
        String s2 = "Stepan";
        String s3 = "Vova";
        String s4 = "Artem";
        //phoneBook = new HashMap<>();
        add(s1, a1);
        add(s2, a2);
        add(s3, a3);
        add(s4, a4);        
        add(s1, a5);
        add(s1, a6);
        add(s2, a7);
        add(s3, a8);
        add(s3, a9);
        add(s1, a10);

        interfacePhoneBooke();

        
    }

    public static void interfacePhoneBooke() {
        try (Scanner iScanner = new Scanner(System.in)) {
            boolean s = true;
            while(s != false) {
                System.out.println("1. Добавить контакт");
                System.out.println("2. Показать все контакты");
                System.out.println("3. Поиск контактов");
                System.out.println("4. Удаление контакта");
                System.out.println("5. Выход");
                System.out.printf("Введите номер команды: ");
                int n = iScanner.nextInt();
                switch (n) {
                case 1:
                    System.out.print("Ввeдите имя: ");
                    String name = iScanner.next();

                    System.out.printf("Введите номер: ");
                    String numb = iScanner.next();
                        add(name, numb);
                    break;
                case 2: 
                    if (phoneBook.size() == 0) {
                        System.out.println("***************");
                        System.out.println("Контактная книга пуста");
                        System.out.println("***************");
                    } else {
                    printGetPhoneBook();
                    }
                    break;
                case 3:
                    System.out.print("Ввeдите имя: ");
                    String nameFind = iScanner.next();
                    printFind(nameFind);
                    break;
                case 4:
                System.out.print("Ввeдите имя: ");
                String nameRem = iScanner.next();
                removeContact(nameRem);
                break;
                case 5: s = false;
                default:
                    break;
            }
        }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void printGetPhoneBook() {
        //sortphoneBook();
        LinkedHashMap<String, ArrayList<String>> linkPhoneBook = sortphoneBook();
        System.out.println("***************");
        for(var item: linkPhoneBook.entrySet()) {
            ArrayList<String> numb = new ArrayList<>();
            numb.addAll(item.getValue());
            if (numb.size() > 1) {
            System.out.println(item.getKey() + " - " + numb.size() + " номера");
            } else {
                System.out.println(item.getKey() + " - " + numb.size() + " номер");
            }
            for(String phone: numb) {
                System.out.println(phone);
            }
            
        }
        System.out.println("***************");
    }

    public static void printFind(String name) {
        System.out.println("***************");
        ArrayList<String> numb = new ArrayList<>();
        numb.addAll(find(name));
        if (phoneBook.get(name).size() > 1) {
            System.out.println(name + " - " + phoneBook.get(name).size() + " номера");
            } else {
               System.out.println(name + " - " + phoneBook.get(name).size() + " номер");
            }
        for(String item: numb) {
            System.out.println(item);
        }
        System.out.println("***************");
    }

    public static void add(String s, String n) {
        if(phoneBook.containsKey(s)) {
            phoneBook.get(s).add(n);
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(n);
            phoneBook.put(s, values);
        }
        
    }

    public static ArrayList<String> find(String name) {
        ArrayList<String> numb = new ArrayList<>();
        if (phoneBook.containsKey(name)) {
            numb.addAll(phoneBook.get(name));
        }
        return numb;
    }


    public static LinkedHashMap<String, ArrayList<String>> sortphoneBook() {
        LinkedHashMap<String, ArrayList<String>> linkPhoneBook = new LinkedHashMap<>();
        ArrayList<String> str = new ArrayList<>();
        String strPhone = "";
        for(var item: phoneBook.entrySet()) {
            str.add(item.getKey());
        }
        for (int i = 0; i < str.size(); i++) {
            for (var item: phoneBook.entrySet()) {
                //System.out.println(phoneBook.get(str.get(i)));
                if(phoneBook.get(str.get(i)).size() > item.getValue().size()) {
                    strPhone = str.get(i);
                }
            }
            if(strPhone != "") {
                linkPhoneBook.put(strPhone, phoneBook.get(strPhone));
            }
        }
        for(var item: phoneBook.entrySet()) {
            linkPhoneBook.putIfAbsent(item.getKey(), item.getValue());
        }
        return linkPhoneBook;
    }

    public static HashMap<String, ArrayList<String>> removeContact(String name) {
        phoneBook.remove(name);
        return phoneBook;
    }
}