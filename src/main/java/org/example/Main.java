package org.example;

public class Main {
    public static void main(String[] args) {
        StringList stringList = new StringListService();
        stringList.add("1");
        stringList.add(1,"2");
        System.out.println(stringList.toString());
        stringList.set(1,"3");
        System.out.println(stringList.toString());
        stringList.add("3");
        System.out.println(stringList.toString());
        stringList.remove("3");
        System.out.println(stringList.toString());
        stringList.add("4");
        System.out.println(stringList.toString());
        stringList.remove(1);
        System.out.println(stringList.toString());
        stringList.add("5");
        System.out.println(stringList.toString());
        System.out.println(stringList.contains("5"));
        stringList.add("6");
        System.out.println(stringList.lastIndexOf("6"));
        System.out.println(stringList.get(2));
        System.out.println(stringList.isEmpty());


    }
}