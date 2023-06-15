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

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class W7T2 {
	public static void main(String[] args) throws IOException {
		Map m=new HashMap();
		m.put("USA", "Washington");
		m.put("Canada", "Ottawa");
		m.put("France", "Paris");
		m.put("Germany", "Berlin");
		m.put("Australia" ,"Canberra");
		m.put("Belgium" ,"Brussels");
		m.put("Austria", "Vienna");
		m.put("Norway" ,"Oslo");
		m.put("Latvia" ,"Riga");
		m.put("Turkey", "Ankara");
		m.put("Bulgaria","Sofia");
		m.put("Ukraine"," Kiev");
		m.put("Mexico","Mexico");
		m.put("Cuba", "Havana");
		m.put("Italy", "Rome");
		m.put("Spain", "Madrid");
		m.put("Portugal", "Lissabon");
		m.put("UK", "London");
		m.put("Ireland","Dublin");
		m.put("Denmark","Copenhagen");
		m.put("Poland","Warsaw");
		m.put("Czechia","Prague");
		m.put("Greece","Athens");
		m.put("Serbia","Belgrad");
		m.put("Sweden", "Stokholm");
		Scanner in=new Scanner(System.in);
		System.out.print("Enter country name: ");
		String name=in.next();
		Iterator iter=m.entrySet().iterator();
		while(iter.hasNext()){ 
			Map.Entry entry=(Map.Entry)iter.next(); 
		    if(entry.getKey().equals(name)){
		    System.out.println("Capital of " + name + " is " + entry.getValue());
		    } 
		}
	}
}