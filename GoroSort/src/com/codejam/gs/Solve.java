package com.codejam.gs;

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
		for(int i=0;i<testCasesArrayList.size();i+=2)
			parseTestCase(i);
	}

	private void parseTestCase(int i) {
		
		int noOfElements = new Integer(testCases.get(i));
		ArrayList<Integer> elements = new ArrayList<Integer>();
		
		for(int j=0;j<noOfElements;j++)
			elements.add(new Integer(testCases.get(i+1).split(" ")[j]));
		
		solveProblem(noOfElements,elements);

	}

	
	
	private void solveProblem(int length,ArrayList<Integer> elements) {
		
		ArrayList<Integer>tempList = new ArrayList<Integer>();
		tempList.addAll(elements);
		double probability=0.000000;
		Collections.sort(tempList);
		
		//System.out.println("Sorted List: "+tempList);
		///System.out.println("Unsorted List : "+elements);
		for(int i=0;i<length;i++)
		{
			//System.out.println("tempList.get(i)"+tempList.get(i));
			//System.out.println("elements.get(i)"+elements.get(i));
			
			if(!tempList.get(i).equals(elements.get(i)))
			{
				//System.out.println("unequl");
				probability++;
			}	
		}
		
		caseResult.add(new Double(probability).toString()+"00000");
		
	}

	public ArrayList<String> getResults() {
		return caseResult;
	}
	
}
