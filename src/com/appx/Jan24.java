package com.appx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.*;

public class Jan24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet hs = new HashSet();
		hs.add(8);
		hs.add("a");
		//printAll(hs);
		
		ArrayList ay = new ArrayList();
		//printAll2(ay);
		ay.add(666);
		//System.out.println("arrayList type= "+ ay.get(0) instanceof String);
		//System.out.println("arrayList = "+ ay.get(0));
		
		ArrayList<String> ayStr = new ArrayList();
		TreeSet ts = new TreeSet();
		ts.add(new MyPoint(6,1));
		ts.add(new MyPoint(5,2));
		ts.add(new MyPoint(3,3));
		//ts.add(new MyPoint());
		System.out.println("ts = " + ts);
		
		HashMap map = new HashMap();
		map.put("test", "Hi");
		map.put("Hi", "Hello");
		//map.put("Hi", "Hello2"); key重複會直接被蓋掉
		
		///System.out.println(map);
		//System.out.println(map.get("test"));
		//System.out.println(map.);
		//System.out.println(map.keySet());
		
		for(Object k : map.keySet().toArray()){
			System.out.println(k + "," +map.get(k));
		}

	}
	
	static void printAll(HashSet hs){
		Iterator it = hs.iterator();
		
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	static void printAll2(Collection c){
		Iterator it = c.iterator();
		while(it.hasNext()){
			System.out.println(it);
		}
	}

}
