package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class FairNSquare {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("C-large-2.in"));
				FileWriter fstream = new FileWriter("C-large-2.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	
		        	BigInteger start = new BigInteger(str[0]);
		        	BigInteger end = new BigInteger(str[1]);
		        	boolean pal=false;
		        	boolean sq = false;
		        	int palSqCount=0;
		        	int sqCount=0;
		        	
		        	BigInteger incr = new BigInteger("1");
		        			
		        	for(BigInteger n=start;n.equals(end);n.add(new BigInteger("1")))
		        	{
		        		
		        		pal = checkPalindrome(n);
		        		if(pal)
		        		{
		        			sq = checkSquare(n);
			        		
			        		if(pal && sq)
			        			palSqCount++;
		        		}
		        		
		        		
		        	}
		        	
		        		
		        		out.write("Case #"+(i+1)+": "+palSqCount+"\n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	private static boolean checkSquare(BigInteger n) {
		
		long a = (long) Math.sqrt(n.longValue());
		if((a*a)==n.longValue())
		{
			if(checkPalindrome(a))
				return true;
			else
				return false;
		}
			
		else
			return false;
	}

	private static boolean checkPalindrome(long number) {
		
		long num = number;
		long n = num; //used at last time check
		long reverse=0,remainder;
		while(num > 0){
			remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		if(reverse == n)
			return true;
		else
			return false;
	}
private static boolean checkPalindrome(BigInteger number) {
		
		long num = number.longValue();
		long n = num; //used at last time check
		long reverse=0,remainder;
		while(num > 0){
			remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		if(reverse == n)
			return true;
		else
			return false;
	}
	
	
}
