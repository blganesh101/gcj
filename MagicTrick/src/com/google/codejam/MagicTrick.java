package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MagicTrick {

	private static Set magicCards1;
	private static Set magicCards2;
	private static Set intersection;
	

	public static void main(String[] args) {
		try {

			int a;
			int b;
			String result;
			// File for input and output
			BufferedReader br = new BufferedReader(new FileReader(
					"A-small-attempt1.in"));
			FileWriter fstream = new FileWriter("A-small-attempt1.out");
			BufferedWriter out = new BufferedWriter(fstream);

			int testcasenum = Integer.parseInt(br.readLine());
			for (int i = 0; i < testcasenum; i++) {
				magicCards1 = new HashSet();
				magicCards2 = new HashSet();
				intersection = new HashSet();
				
				
				String[] str = br.readLine().split(" ");
				a = new Integer(str[0]).intValue();

				//System.out.println("first ans "+a);
				
				
				for (int j = 0; j < a-1; j++)
					str = br.readLine().split(" ");
					
				str = br.readLine().split(" ");
				for(int k=0;k<4;k++)
					magicCards1.add(new Integer(str[k]));
				//System.out.println(magicCards1.toString());

				
				for (int j = 0; j < 4-a; j++)
					str = br.readLine().split(" ");
				
				
				str= br.readLine().split(" ");
				a = new Integer(str[0]).intValue();

				//System.out.println("second ans "+a);
				for (int j = 0; j < a-1; j++)
				{
					str = br.readLine().split(" ");
					
				}
				
				str = br.readLine().split(" ");
				for(int k=0;k<4;k++)
					magicCards2.add(new Integer(str[k]));
				//System.out.println(magicCards2.toString());

				b = 4-a;

				for (int j = 0; j < 4-a; j++)
				{
					str = br.readLine().split(" ");
				}
				
				
				//System.out.println("b :"+b);
				//System.out.println(magicCards2);

				result = doMagic(magicCards1, a, magicCards2, b);
				//System.out.println("Case #"+(i+1)+": "+result+"\n");
				out.write("Case #" + (i + 1) + ": " + result + "\n");
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String doMagic(Set card1, int ans1, Set card2, int ans2) {
		String result;

		Set intersection = new HashSet(card1); // use the copy constructor
		intersection.retainAll(card2);

		//System.out.println("intersection "+intersection.size());
		//System.out.println("intersection "+intersection.toString());
		
		if (intersection.size() == 1)
			result = printIntersection(intersection);
		else if (intersection.size() >1)
			result = "Bad magician!";
		else
			result = "Volunteer cheated!";

		return result;
	}
	
	private static String printIntersection(Set s)
	{
		String result=null;
		
		Iterator it = s.iterator();
		while(it.hasNext())
			result = (String) new Integer((Integer)it.next()).toString();
				
		return result;
	}
}
