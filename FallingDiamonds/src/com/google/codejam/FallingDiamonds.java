package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class FallingDiamonds {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
				FileWriter fstream = new FileWriter("B-small-attempt0.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	
		        	int numOfDiamonds = Integer.parseInt(str[0]);
		        	int coorX = Integer.parseInt(str[1]);;
		        	int coorY = Integer.parseInt(str[2]);;
		        	
//		        	System.out.println("numOfDiamonds: "+numOfDiamonds);
//		        	System.out.println("coordinates: "+coorX+","+coorY);
		        	
		        	double probability = 0.0;
		        	
		        	int diamondMax = 1;
		        	
		        	probability = numOfDiamonds/(diamondMax*numOfDiamonds);
		        	
		        	int maxDiamondCanReach = diamondMax*numOfDiamonds;
		        	
		        	int maxDiamondX = 0;
		        	int maxDiamondY = 1;
		        	
		        	for(int j=0;j<numOfDiamonds;j++)
		        	{
		        		if(maxDiamondX>maxDiamondY*2)
		        			maxDiamondY = maxDiamondY+2;
		        		else
		        			maxDiamondX = maxDiamondX+1;
		        	}
		        	
//		        	System.out.println("maxDimondX: "+maxDiamondX);
//		        	System.out.println("maxDimondY: "+maxDiamondY);
		        		        			
		        	
		        	double minProb = 0.25;
		        	
		        	if(coorX==0 && coorY==0 && numOfDiamonds>0)
		        		probability=1.0;
		        	else if((maxDiamondX>=coorX && maxDiamondY>=coorY) && (maxDiamondX-1==coorX && maxDiamondY-1==coorY) )
		        		probability=0.75;
		        	else if((maxDiamondX>=coorX && maxDiamondY>=coorY) && ((maxDiamondX-1==coorX && maxDiamondY-1==coorY)
		        			|| (maxDiamondX-1==coorX && maxDiamondY==coorY) 
		        			|| (maxDiamondY-1==coorY && maxDiamondX==coorX)))
		        		probability=0.50;
		        	else if((maxDiamondX>=coorX && maxDiamondY>=coorY) && ((maxDiamondX-2==coorX && maxDiamondY-1==coorY) 
		        			|| (maxDiamondX-2==coorX && maxDiamondY==coorY)
		        			|| (maxDiamondY-2==coorY && maxDiamondX-1==coorX) 
		        			|| (maxDiamondY-2==coorY && maxDiamondX==coorX)))
		        		probability=0.25;
		        	else if((maxDiamondX>=coorX && maxDiamondY>=coorY) && ((maxDiamondX-2==coorX && maxDiamondY-2==coorY)))
		        			probability=0.50;
		        	else
		        		probability=0.0;
		        	
		        	
		        		
		        		
		        	
		        	
//		        	System.out.println("probability  : "+probability);
//		        	System.out.println("*****************************");
		        		
		        	out.write("Case #"+(i+1)+": "+probability+"\n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	
	
	 
	 
}
