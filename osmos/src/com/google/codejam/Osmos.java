package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class Osmos {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("A-small-attempt2.in"));
				FileWriter fstream = new FileWriter("A-small-attempt2.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	
		        	long arminMote = Long.parseLong(str[0]);
		        	int numOfMotes = Integer.parseInt(str[1]);
		        	int changeCount = 0;
		        	
		        	//System.out.println("armin size: "+arminMote);
		        	//System.out.println("num mote: "+numOfMotes);
		        	
		        	long[] motes = new long[numOfMotes];
		        	
		        	String[] str1 = br.readLine().split(" ");
		        	
		        	
		        	
		        	for(int j=0;j<numOfMotes;j++)
		        	{
		        		//System.out.println(str1[j]);
		        		motes[j] = Long.parseLong(str1[j]);
		        	}
		        	
		        	Arrays.sort(motes);
		        	for(int j=0;j<numOfMotes;j++)
		        	{
		        		//System.out.println(motes[j]);
		        	}
		        	
		        	long sum=arminMote;
		        	
		        	for(int j=0;j<numOfMotes-1;j++)
		        	{
		        		sum+=motes[j];
		        	}
		        	
		        	long newMote = arminMote;
		        	
	        		for(int j=0;j<numOfMotes;j++)
		        	{
	        			if(newMote>motes[j])
		        		{
		        			newMote = newMote+motes[j];
		        		}
		        		else
		        		{
		        			//adding
		        			if((newMote*2-1)>motes[j])
		        			{
		        				changeCount+=1;
	        					motes[j]=newMote - 1;
			        			newMote=newMote*2 -1;
		        			}
		        			else
		        			{
		        				changeCount+=1;
		        			}
		        			
		        		}
		        	}
		        			
		        	
		        	
		        	//System.out.println("change Count : "+changeCount);
		        	//System.out.println("*****************************");
		        		
		        	out.write("Case #"+(i+1)+": "+changeCount+"\n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	
	
}
