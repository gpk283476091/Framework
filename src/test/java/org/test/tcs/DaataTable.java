package org.test.tcs;

import java.awt.List;
import java.util.*;

public class DaataTable {

	public static void main(String[] args) {
		
	ArrayList<String> a = new ArrayList<String>();
	a.add("one");
	a.add("two");
	a.add("three");
	
	
	String string = a.get(2);
	System.out.println(string);
		
	
	
	ArrayList<ArrayList<String>> emp = new ArrayList<>();
	
	ArrayList<String> ab = new ArrayList<>();
	
	ab.add("hello");
	ab.add("csk");
	ab.add("alpha");
	
	ArrayList<String> bc = new ArrayList<>();
	bc.add("hello");
	bc.add("rcb");
	bc.add("beta");
	
	
	emp.add(ab);
	emp.add(bc);
	
	ArrayList<String> arrayList = emp.get(0);
	
	String string2 = arrayList.get(2);
	System.out.println(string2);
	
	
	}
}
