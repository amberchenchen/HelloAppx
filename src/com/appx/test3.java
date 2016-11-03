package com.appx;

import java.sql.DataTruncation;
import java.util.Scanner;

public class test3 {

  static boolean isNarNum(int num) {
    int orgNum = num;
    double sum=0;
    while (num != 0) {
      sum  = sum + Math.pow(num%10, 3);
      num = (int)num/10;
    }
    
    if((int)sum==orgNum){
      return true;
    }
    else{
      return false;
    }
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    System.out.print("Please Enter a Number :");
    int num = sc.nextInt();
    if(isNarNum(num)){
      System.out.println("是水仙花數");
    }
    else{
      System.out.println("不是水仙花數");
    }
    
    System.out.println("=================");
    
    String data = "US_美國,TW_台灣,CN_大陸";

    String[] dataSp1 = data.split(",");
    for (int i = 0; i < dataSp1.length; i++) {
      System.out.println(dataSp1[i].split("_")[1] + " > " + dataSp1[i].split("_")[0]);
    }
    
  } 

}
