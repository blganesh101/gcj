package com.codejam.m;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Solve {

	ArrayList<String> testCases;
	ArrayList<String> caseResult;
	ArrayList<String> fieldMatrix;
	
	public Solve(int n, ArrayList<String> testCasesArrayList){
	
		testCases = testCasesArrayList;
		caseResult = new ArrayList<String>();
		System.out.println("num of test cases : "+n);
		for(int i=0;i<n;i++)
			parseTestCase(i);
	}

	private void parseTestCase(int i) {
		
		int combineStringsCount = new Integer(testCases.get(i).split(" ")[0]).intValue();
		int opposeStringCount = new Integer(testCases.get(i).split(" ")[combineStringsCount+1]).intValue();
		int invokeElementsCount = new Integer(testCases.get(i).split(" ")[combineStringsCount+opposeStringCount+2]).intValue();
		
		ArrayList<String> combineStrings = new ArrayList<String>();
		ArrayList<String> opposeStrings = new ArrayList<String>();
		ArrayList<String> invokeElements = new ArrayList<String>();
		
		String[] array = testCases.get(i).split(" ");
		
		if(combineStringsCount>0)
			for(int j=1;j<=combineStringsCount;j++)
				combineStrings.add(array[j]);
		
		if(opposeStringCount>0)
			for(int j=(combineStringsCount+2);j<=(combineStringsCount+opposeStringCount+1);j++)
				opposeStrings.add(array[j]);

		invokeElements.add(array[combineStringsCount+opposeStringCount+3]);
		
		System.out.println("TestCase: "+i);
		System.out.println("combineStringCount: "+combineStringsCount);
		System.out.println("opposeStringCount: "+opposeStringCount);
		System.out.println("invokeElementCount: "+invokeElementsCount);
		System.out.println("combineStrings: "+combineStrings);
		System.out.println("opposeStrings: "+opposeStrings);
		System.out.println("invokeELements: "+invokeElements);
		
		solveProblem(combineStringsCount, opposeStringCount,invokeElementsCount,combineStrings,opposeStrings,invokeElements);
	}

	
	
	private void solveProblem(int combineStringsCount,int opposeStringCount, int invokeElementsCount, ArrayList<String> combineStrings,ArrayList<String> opposeStrings,ArrayList<String> invokeElements) {
		
		String invoke = invokeElements.get(0);
		
		char[] c = invoke.toCharArray();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Character> base = new ArrayList<Character>();
		char prevChar;
		char nextChar;
		
		for(int i=0;i<c.length;i++)
		{
			if(base.isEmpty())
			{
				base.add(c[i]);
				System.out.println("adding char: "+c[i]);
			}
			else
			{
				
				if(i>0)
				{
					
					char replace = combineCharacters(c[i],c[i-1],combineStringsCount,combineStrings);
					
					if(temp.contains(new Integer(i-1)))
						replace = '0';
					
					boolean clear = opposeCheck(base,c[i],opposeStringCount,opposeStrings);
				
					if(!new Character(replace).equals(new Character('0')))
					{
						base.remove(base.size()-1);
						base.add(replace);
						
						temp.add(i-1);
						temp.add(i);
						
						
						System.out.println("removing char: "+c[i-1]+" because of char: "+c[i]);
						
						System.out.println("replacing with char "+replace);
					}
					else if(clear)
					{
						System.out.println("clear List");
						base = new ArrayList<Character>();
						
						temp.add(i);
					}
					else
					{
						base.add(c[i]);
						System.out.println("adding char: "+c[i]);
					}
						
					
					
				}
				
				
			}
			
			
			
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		
		for(int i=0;i<base.size();i++)
		{
			sb.append(base.get(i));
			if(base.size()!=(i+1))
				sb.append(", ");
		}
		sb.append("]");
		System.out.println("OUTPUT:: "+sb.toString());
		caseResult.add(sb.toString());
		
	}

	private boolean opposeCheck(ArrayList<Character> base, char c, int opposeStringCount, ArrayList<String> opposeStrings) {
		
		boolean flag=false;
		
		if(opposeStringCount<=0)
			return flag;
		
		for(int i=0;i<opposeStringCount;i++)
		{
			char[] oppChars = opposeStrings.get(i).toCharArray();
			
			if(new Character(oppChars[0]).equals(new Character(c)))
			{
				char checkChar = oppChars[1];
				for(int j=0;j<base.size();j++)
				{
					if(base.get(j).equals(new Character(checkChar)))
					{
						flag=true;
						return flag;
					}
				}
			}
			else if(new Character(oppChars[1]).equals(new Character(c)))
			{
				char checkChar = oppChars[0];
				for(int j=0;j<base.size();j++)
				{
					if(base.get(j).equals(new Character(checkChar)))
					{
						flag=true;
						return flag;
					}
				}
					
			}
			else
			{
				flag=false;
			}
				
		}
		
		return flag;
	}

	private char combineCharacters(char c, char d, int combineStringsCount, ArrayList<String> combineStrings) {
		
	   if(combineStringsCount<=0)
			return '0';
	   
	   System.out.println("combine called with "+c+ "and "+d);
		
		for(int i=0;i<combineStringsCount;i++)
		{
			char[] comArray = combineStrings.get(i).toCharArray();
			
			if((new Character(comArray[0]).equals(new Character(c)) && new Character(comArray[1]).equals(new Character(d)))
					|| (new Character(comArray[0]).equals(new Character(d)) && new Character(comArray[1]).equals(new Character(c))))
				return comArray[2];
		}
		return '0';
	}

	public ArrayList<String> getResults() {
		return caseResult;
	}
	
}
