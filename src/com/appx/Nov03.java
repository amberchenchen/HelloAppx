package com.appx;

import java.util.Scanner;

public class Nov03 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 1個佔2個 byte
    System.out.println("Please Enter Your Name");
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    System.out.println("Welcome " + name);
    System.out.println("Length = " + name.length());
    // System.out.println("CharAt = "+name.charAt(3));

    for (int i = name.length() - 1; i >= 0; i--) {
      System.out.print(name.charAt(i));
    }
    System.out.println();
    System.out.println("endsWith : " + name.endsWith("ber"));
    System.out.println("indexOf : " + name.indexOf("b"));
    System.out.println("lastIndexOf : " + name.lastIndexOf("a"));
    System.out.println("replace : " + name.replace("a", "$"));
    String[] nameArr = name.split("a");
    for (int i = 0; i < nameArr.length; i++) {
      System.out.print("split" + i + ":" + nameArr[i] + " ");
    }
    System.out.println();
    System.out.println("toUpperCase : " + name.toUpperCase());
    System.out.println("toLowerCase : " + name.toLowerCase());
    System.out.println("substring : " + name.substring(0, 3));//endIndex 不含endIndex字元
    System.out.println("substring : " + name.substring(2));// start from 2 to endIndex
    System.out.println("trim : " + name.trim());
  }

}
