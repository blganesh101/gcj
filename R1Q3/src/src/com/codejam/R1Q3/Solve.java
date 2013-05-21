package src.com.codejam.R1Q3;

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
		
		int noOfButtons = new Integer(testCases.get(i).split(" ")[0]).intValue();
		
		System.out.println("noOfButtons: "+noOfButtons);
		solveProblem(noOfButtons,testCases.get(i));

	}

	
	
	private void solveProblem(int length,String testcase) {
		
		String[] array = testcase.split(" ");
		
		int time=0;
		int j=0;
		ArrayList<String> color = new ArrayList<String>();
		ArrayList<Integer> button = new ArrayList<Integer>();
		
		for(int i=1;i<array.length;i=i+2)
		{
			color.add(array[i]);
			button.add(new Integer(array[i+1]));
			
		}
		
		String prevColor=color.get(0);
		int prevButton=0;
		
		int prevOrange=1;
		int prevBlue = 1;
		
		int curOrange = 1;
		int curBlue = 1;
		
		int nextOrange=1;
		int nextBlue=1;
		
		for(int k=0;k<color.size();k++)
		{
				
			boolean orangeFlag=false;
			boolean blueFlag=false;
			int steps;
			
			for(int l=k+1;l<color.size();l++)
			{
				if(color.get(l).equals("O") && !orangeFlag)
				{
					nextOrange=button.get(l);
					orangeFlag=true;
				}
				else if(color.get(l).equals("B") && !blueFlag)
				{
					nextBlue=button.get(l);
					blueFlag=true;
				}
			}
			
			System.out.println("k: "+k);
			System.out.println("nextOrange= "+nextOrange);
			System.out.println("nextBlue= "+nextBlue);
			
			
			if(color.get(k).equals("O"))
			{
				steps= Math.abs(button.get(k) - curOrange);
				time+=steps+1;
				
				System.out.println("steps= "+steps);
				
				if(curBlue<nextBlue)
				{
					if((nextBlue-curBlue)>steps)
						curBlue+=(steps+1);
					else
						curBlue=nextBlue;
				}
				else if(curBlue>nextBlue)
				{
					if((curBlue-nextBlue)>steps)
						if(steps>1)
							curBlue-=(steps+1);
						else
							curBlue-=1;
					else
						curBlue=nextBlue;
				}
				curOrange=button.get(k);
				
			}
			else
			{
				
				steps = Math.abs(button.get(k) - curBlue);
				time+=steps+1;
				
				System.out.println("steps= "+steps);
				
				if(curOrange<nextOrange)
				{
					if((nextOrange-curOrange)>steps)
						curOrange+=(steps+1);
					else
						curOrange=nextOrange;
				}
				else if(curOrange>nextOrange)
				{
					if((curOrange-nextOrange)>steps)
						curOrange-=(steps+1);
					else
						curOrange=nextOrange;
				}
				
				curBlue=button.get(k);
			}
			
			System.out.println("curOrange= "+curOrange);
			System.out.println("curBlue= "+curBlue);
			System.out.println("time= "+time);
			/*if(color.get(k).equals(prevColor))
			{
				if(button.get(k)>prevButton)
				{
					//time += (button.get(k)-prevButton)+1;
					
					if(color.get(k).equals("O"))
					{
						time+=(button.get(k)-prevOrange)+1;
						curOrange=button.get(k).intValue();
						if(curBlue<nextBlue)
							curBlue+=1;
						else if(curBlue>nextBlue)
							curBlue-=1;
					}
					else if(color.get(k).equals("B"))
					{
						time+=(button.get(k)-prevBlue)+1;
						curBlue=button.get(k).intValue();
						curOrange+=1;
						
						if(curOrange<nextOrange)
							curOrange+=1;
						else if(curOrange>nextOrange)
							curOrange-=1;
					}
				}
				else
				{
					
					time += (prevButton - button.get(k)) +1;
					
					if(color.get(k).equals("O"))
					{
						curOrange=button.get(k).intValue();
						if(curBlue<nextBlue)
							curBlue+=1;
						else if(curBlue>nextBlue)
							curBlue-=1;
					}
					else if(color.get(k).equals("B"))
					{
						curBlue=button.get(k).intValue();
						if(curOrange<nextOrange)
							curOrange+=1;
						else if(curOrange>nextOrange)
							curOrange-=1;
					}
				}
			}
			else if(!color.get(k).equals(prevColor))
			{
				if((button.get(k)<prevButton))
				{
					time += 1;
					
					if(color.get(k).equals("O"))
					{
						curOrange=button.get(k).intValue();
						if(curBlue<nextBlue)
							curBlue+=1;
						else if(curBlue>nextBlue)
							curBlue-=1;
					}
					else if(color.get(k).equals("B"))
					{
						curBlue=button.get(k).intValue();
						if(curOrange<nextOrange)
							curOrange+=1;
						else if(curOrange>nextOrange)
							curOrange-=1;
					}
				}
				else
				{
					if(color.get(k).equals("O"))
					{
						time+=(button.get(k)-curOrange)+1;
						curOrange=button.get(k).intValue();
						if(curBlue<nextBlue)
							curBlue+=1;
						else if(curBlue>nextBlue)
							curBlue-=1;
					}
					else if(color.get(k).equals("B"))
					{
						time+=(button.get(k)-curOrange)+1;
						curBlue=button.get(k).intValue();
						if(curOrange<nextOrange)
							curOrange+=1;
						else if(curOrange>nextOrange)
							curOrange-=1;
					}
					
				}
			}
			prevButton=button.get(k);
			prevColor=color.get(k);*/
			
			
		}
			
	
			
		
		caseResult.add(new Integer(time).toString());
		
	}

	public ArrayList<String> getResults() {
		return caseResult;
	}
	
}
