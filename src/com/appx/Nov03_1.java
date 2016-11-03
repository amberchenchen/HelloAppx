package com.appx;

import java.util.Scanner;

public class Nov03_1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.print("Please Enter Your Email : ");
    Scanner sc = new Scanner(System.in);
    String email = sc.next();

    String[] name = email.split("@");
    System.out.println("Welcome," + name[0]);

    int index = email.indexOf("@");
    System.out.println("Welcome," + email.substring(0, index));

  }

}
