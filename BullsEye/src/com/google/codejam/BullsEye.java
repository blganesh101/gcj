package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class BullsEye {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
				FileWriter fstream = new FileWriter("A-large.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	
		        	BigInteger rad = new BigInteger(str[0]);
		        	BigInteger pVol = new BigInteger(str[1]);
		        	
		        	long radius = rad.longValue();
		        	long paintVol = pVol.longValue();
		        	
		        	long noOfCircles = 0;
		        	
		        	
		        	int j=1;
		        	boolean flag=true;
		        	
		        	int pi=1;
		        	int thickness=1;
		        	long area=0;
		        	
		        	while(flag)
		        	{
		        		area += pi*thickness*((2*(radius+j))-thickness);
		        		j+=2;
		        		
		        		//System.out.println("area: "+area);
		        		if(area<=paintVol)
		        			noOfCircles++;
		        		else
		        			break;
		        	}
		        		
		        	//System.out.println("Case #"+(i+1)+": "+noOfCircles+"\n");
		        	out.write("Case #"+(i+1)+": "+noOfCircles+"\n");
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
