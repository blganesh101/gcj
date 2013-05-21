package com.codejam.R1Q1;

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
		
		int N = new Integer(testCases.get(i).split(" ")[0]).intValue();
		int PD = new Integer(testCases.get(i).split(" ")[1]).intValue();
		int PG = new Integer(testCases.get(i).split(" ")[2]).intValue();
		
		System.out.println("N: "+N+" PD: "+PD+" PG:"+PG);
		solveProblem(N,PD,PG);

	}

	
	
	private void solveProblem(int N,int PD,int PG) {
		
		String result= null;
		boolean flag=false;
		
		
		for(int i=1;i<=N;i++)
			{
				
				float a,b,c,d;
				c=PD;
				d=i;
				a=(c*d)/100;
				b=Math.round((PD*i)/100);
				if(a==b)
				{
					System.out.println(i);
					
					flag=true;
					break;
				}
				
		}
			
		
		
		if(flag)
		{
			if(PG==100 && PD<PG)
				result="Broken";
			else
				result="Possible";
			
			if(PG==0 && PD==0)
				result="Possible";
			
			if(PG==0 && PD>0)
				result="Broken";
		}
		else
			result="Broken";
		
		System.out.println(result);
		caseResult.add(result);
		
	}

	public ArrayList<String> getResults() {
		return caseResult;
	}
	
}
