package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;

public class Energy{

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("B-small-practice.in"));
				FileWriter fstream = new FileWriter("B-small-practice.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	
		        	BigInteger en = new BigInteger(str[0]);
		        	BigInteger reg = new BigInteger(str[1]);
		        	BigInteger na = new BigInteger(str[2]);
		        	
		        	
		        	long energy = en.longValue();
		        	long regain = reg.longValue();
		        	long numAct = na.longValue();
		        	
		        	
		        	long maxGain = 0;
		        	
		        	
		        	String[] str2 = br.readLine().split(" ");
		        	
		        	long[] actVal = new long[(int) numAct];
		        	
		        	for(int j=0;j<numAct;j++)
		        	{
		        		actVal[j] = Long.parseLong(str2[j]);
		        	}
		        	
		        	
		        	boolean flag = true;
		        	long gain=0;
		        	long enUsed=0;
		        	long energyReq=0;
		        	long energyLeft;
		        	//for(int k=0;k<)
		        	
		        	
		        	for(int k=0;k<energy;k++)
		        		{
			        		energyLeft = energy-k;
			        		
			        		//System.out.println("init energy "+energyLeft);
			        		gain=0;
			        		for(int l=0;l<numAct;l++)
			        		{
			        			//System.out.println("energy left[ "+l+"]:"+energyLeft);
			        			
			        			gain += actVal[l]*(energyLeft);
			        			
			        			enUsed = energyLeft;
			        			energyLeft = energy - enUsed + regain;
			        			//energyReq = energyLeft;
			        			if(energyLeft>energy)
			        				energyLeft=energy;
			        			
			        			long maxTempGain = 0;
			        			
			        			//System.out.println("gain: "+gain);
			        			
//			        			for(int m=0;m<energyLeft;m++)
//				        		{
//			        				long tempEnergy = energyLeft;
//			        				tempEnergy = energyLeft-m;
//			        				//System.out.println("energyLeft: "+energyLeft);
//			        				long tempGain = gain;
//			        				
//			        				for(int n=l+1;n<numAct;n++)
//			        				{
//			        					tempGain += actVal[n]*(tempEnergy);
//				        				
//				        				enUsed = tempEnergy;
//				        				tempEnergy = energy - enUsed + regain;
//					        			//energyReq = energyLeft;
//					        			if(tempEnergy>energy)
//					        				tempEnergy=energy;
//					        			
//					        			
//					        		}
//			        				
//			        				//System.out.println("tempGain: "+tempGain);
//			        				
//			        				if((tempGain)>maxGain)
//			        					maxGain = tempGain;
//				        			//energyLeft-=1;
//			        				
//				        		}
//			        			
			        			//if((maxTempGain+gain)>maxGain)
			        				//maxGain =(maxTempGain+gain) ;
			        			//energyLeft-=1;
			        			
			        			//System.out.println("gain: "+gain);
			        			if((gain)>maxGain)
		        					maxGain = gain;
			        			
			        		}
		        			
		        		}
		        	
		        	
		        	
		        		
		        	//System.out.println("Case #"+(i+1)+": "+maxGain+"\n");
		        	out.write("Case #"+(i+1)+": "+maxGain+"\n");
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
