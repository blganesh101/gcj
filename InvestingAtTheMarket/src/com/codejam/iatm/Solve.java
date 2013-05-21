package com.codejam.iatm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solve {

	ArrayList<String> testCases;
	ArrayList<String> caseResult;
	ArrayList<String> comPrice;
	
	public Solve(int n, ArrayList<String> testCasesArrayList){
	
		testCases = testCasesArrayList;
		caseResult = new ArrayList<String>();
		for(int i=0;i<testCases.size();i=i+2)
			parseTestCase(i);
	}

	private void parseTestCase(int i) {
		
		long money = new Integer((String) testCases.get(i));
		String input = testCases.get(i+1);
		
		StringTokenizer st = new StringTokenizer(input);
		ArrayList<Double> comPrice = new ArrayList<Double>();
		
		while(st.hasMoreTokens())
		{
			String token = st.nextToken();
			comPrice.add(new Double(token));
		}
		
		solveProblem(money,comPrice);
	}

	
	
	private void solveProblem(long money, ArrayList<Double> prices) {
		
		boolean processFlag=false;
		double max = 0;
		int buyIndex = 0;
		int sellIndex = 0;
		double buy = 0;
		double sell = 0;
		for(int i=0;i<12;i++)
			if(prices.get(i)<money)
				processFlag = true;
		
		if(processFlag)
		{
			for(int i=1;i<12;i++)
				for(int j=0;j<i;j++)
				{
					int num = new Double(Math.floor(money/prices.get(j))).intValue();
					
					if(((num*prices.get(i))-(num*prices.get(j)))>max)
					{
						max = num*(prices.get(i)-prices.get(j));
						buyIndex = j;
						sellIndex = i;
					}
					else if(num*(prices.get(i)-prices.get(j)) == max)
					{
						if(num*prices.get(j)<num*prices.get(buyIndex))
						{
							buyIndex = j;
							sellIndex = i;
						}
					}
				}
			
			buy = prices.get(buyIndex);
			sell = prices.get(sellIndex);
			
			System.out.println("max: "+max);
			System.out.println("buy: "+buy);
			System.out.println("sell: "+sell);
			int noOfComodities = new Double(Math.floor(money/buy)).intValue();
			double profit = (noOfComodities * sell) - (noOfComodities*buy) ;//+ (money - (noOfComodities*buy)) ;
			System.out.println("profit: "+profit);
			caseResult.add((buyIndex+1)+" "+(sellIndex+1)+" "+new Integer(new Double(profit).intValue()).toString());
			
		}
		else
		{
			caseResult.add("IMPOSSIBLE");
		}
		
	}

	public ArrayList<String> getResults() {
		return caseResult;
	}
	
}
