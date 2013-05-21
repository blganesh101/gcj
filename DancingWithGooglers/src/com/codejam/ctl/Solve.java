package com.codejam.ctl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;


public class Solve {

	ArrayList<String> testCases;
	ArrayList<String> caseResult;
	ArrayList<Integer> blueSegments;
	ArrayList<Integer> redSegments;
	
	public Solve(int n, ArrayList<String> testCasesArrayList){
	
		testCases = testCasesArrayList;
		caseResult = new ArrayList<String>();
		for(int i=0;i<testCases.size();i=i+1)
			parseTestCase(i);
	}

	private void parseTestCase(int i) {
		
		//int testc = new Integer((String) testCases.get(i));
		
		
		
		String input = testCases.get(i);
		
		StringTokenizer st = new StringTokenizer(input);
		
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		//ArrayList<Integer> redSegments = new ArrayList<Integer>();
		
		int n;
		int spCount;
		int p;
		
		String token = st.nextToken();
			
		n = new Integer(token);
		spCount = new Integer(st.nextToken());
		p = new Integer(st.nextToken());
		
		for(int j=0;j<n&&st.hasMoreElements();j++)
			numbers.add(new Integer(st.nextToken()));
		
		System.out.println("n: "+n);
		System.out.println("spCount: "+spCount);
		System.out.println("p: "+p);
		
		Iterator it = numbers.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		solveProblem(n,spCount,p,numbers);
	}

	private void solveProblem(int n, int spCount, int p,
			ArrayList<Integer> numbers) {
		
		
		Iterator it = numbers.iterator();
		
		while(it.hasNext())
		{
			
		}
			
	}

	private void solveProblem(int numberOfSegments,
			ArrayList<Integer> blueSegments, ArrayList<Integer> redSegments) {
		
		if(numberOfSegments <= 1)
			caseResult.add("0");
		else
		{
			int noBlueSegments = blueSegments.size();
			int noRedSegments = redSegments.size();
			
			if(noBlueSegments >0 && noRedSegments >0)
			{

				sortElements(blueSegments);
				sortElements(redSegments);
				
				
				int resultCount = 0;
				resultCount = (noBlueSegments<noRedSegments?noBlueSegments:noRedSegments);
				int intSum=0;
				for(int i=0;i<resultCount;i++)
				{
					intSum += blueSegments.get(i) + redSegments.get(i);
				}
				caseResult.add(new Integer((intSum - 2*resultCount)).toString());
			}
			else
			{
				caseResult.add("0");
			}
		}
	}

	private void sortElements(ArrayList<Integer> segments) {
		
		Collections.sort(segments);
		Collections.reverse(segments);
	}
	
	public ArrayList<String> getResults() {
		return caseResult;
	}
	
}
