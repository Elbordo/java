/**********************************************
Workshop # 7
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 17.11.2022(dd.mm.yyyy)
**********************************************/ 
package test1;

import java.util.*;
import java.io.*;

public class W7T1 {
	
	public static void main(String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a file name for baby name ranking: ");
		String file = in.next();
		File f = new File(file);
		List<String> boys = new ArrayList<>();
	    List<String> girls = new ArrayList<>();
		List<String> common = new ArrayList<>();
		 
		Scanner inf = new Scanner(f);
		while (inf.hasNext()) {
			inf.next();
			boys.add(inf.next());
			inf.next();
			girls.add(inf.next());
			inf.next();
		}
		
		for (int i = 0; i < boys.size(); i++) {
	         for (int j = 0; j < girls.size(); j++) {
	            if (boys.get(i).equals(girls.get(j))) {
	            	common.add(boys.get(i));
	            }
	         }
		}
		System.out.println(common.size() + " names used for both genders");
		System.out.println("They are " + common);	      
	    Set<String> bset = new HashSet<>();
	    Set<String> gset = new HashSet<>();
	    Set<String> cset = new HashSet<>();
	      
	    bset.addAll(boys);
	    gset.addAll(girls);
	    cset.addAll(common);
	    bset.removeAll(cset);
	    gset.removeAll(cset);
	    boys.clear();
	    girls.clear();
	    common.clear();
	    boys.addAll(bset);
	    girls.addAll(gset);   
	    common.addAll(cset);
	    Collections.sort(boys);
	    Collections.sort(girls);
	    Collections.sort(common);

	    System.out.println("Sorted boys: " + boys);
	    System.out.println("Sorted girls: " + girls);
	    System.out.println("Sorted common: " + common);
				        
	}
}