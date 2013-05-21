package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class Treasure {

	  class Chest {
			 int keyToOpen;
			 int numKeys;
			 int[] keys;
		 }
	  
	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("D-small-attempt2.in"));
				FileWriter fstream = new FileWriter("D-small-attempt2.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	
		        	
		        	System.out.println("**** Executing testcase "+i+" ****");
		        	String[] str = br.readLine().split(" ");
		        	
		        	int numKeys = Integer.parseInt(str[0]);
		        	int numChests = Integer.parseInt(str[1]);
		        	int[] keys = new int[numKeys];
		        	String[] chests;
		        	
		        	String[] keysStr = br.readLine().split(" ");
		        	for(int nk=0;nk<numKeys;nk++)
		        	{
		        		keys[nk] = Integer.parseInt(keysStr[nk]);
		        	}
		        	
		        	
		        	Treasure t = new Treasure();
		        	Chest cs[] = new Chest[numChests];
		        	for(int j=0;j<numChests;j++)
		        	{
		        		cs[j] = t.new Chest();
		        		chests = br.readLine().split(" ");
		        		int move=0;
		        		cs[j].keyToOpen=Integer.parseInt(chests[move++]);
		        		cs[j].numKeys=Integer.parseInt(chests[move++]);
		        		cs[j].keys = new int[cs[j].numKeys];
		        	
		        		for(int n=0;n<cs[j].numKeys;n++)
		        		{
		        		
		        			cs[j].keys[n]=Integer.parseInt(chests[move++].trim());
		        		
		        		}
		        		
		        		
		        	}
		        	
		        	
//		        	System.out.println("numkeys "+numKeys);
//		        	System.out.println("numchests "+numChests);
//		        	System.out.println("keys in hand");
//		        	for(int ij=0;ij<numKeys;ij++)
//		        	{
//		        		System.out.println(keys[ij]);
//		        	}
//		        	
//		        	for (int jk = 0; jk < cs.length; jk++) {
//						System.out.println("chest "+jk);
//						System.out.println("krytoopen "+cs[jk].keyToOpen);
//						System.out.println("num of keys "+cs[jk].numKeys);
//						System.out.println("keys");
//						for(int ik=0;ik<cs[jk].keys.length;ik++)
//							System.out.println(cs[jk].keys[ik]);
//					}
//		        	System.out.println("*****************************");
//		        	
//		        	
		        	
		        	//test num of keys and chests
		        	if(numKeys<1 || numChests<1)
		        	{
		        		System.out.println("IMPOSSIBLE1");
		        		out.write("Case #"+(i+1)+": IMPOSSIBLE \n");
		        		continue;
		        	}
		        	
		        	//test if the available keys can open any chest
		        	boolean conFlag=false;
		        	for (int j2 = 0; j2 < numKeys; j2++) {
						
		        		for (int j = 0; j < cs.length; j++) {
			        	
		        			if(keys[j2]==cs[j].keyToOpen)
								conFlag=true;

						}
					}
		        	if(!conFlag)
		        	{
		        		System.out.println("IMPOSSIBLE2");
		        		out.write("Case #"+(i+1)+": IMPOSSIBLE \n");
		        		System.out.println("*******************");
		        		continue;
		        	}
		        		
		        	
		        	//find if you have all the keys
		        	int numOfTotalKeys=0;
		        	boolean keyFound=false;
		        	numOfTotalKeys=numOfTotalKeys+numKeys;
		        	for (int j = 0; j < cs.length; j++) {
		        		int keytoOpen = cs[j].keyToOpen;
		        		keyFound=false;
		        		for(int k=0;k<numKeys;k++)
		        		{
		        			if(keytoOpen==keys[k])
		        			{
		        				keyFound=true;
		        				break;
		        			}     				
		        		}
		        		
		        		if(keyFound)
		        			continue;
		        		else
		        		{
		        			for (int k = 0; k < cs.length; k++) {
								
		        				if(k!=j)
		        				{
		        					for (int k2 = 0; k2 < cs[k].numKeys; k2++) {
										if(keytoOpen==cs[k].keys[k2])
										{
											keyFound=true;
					        				break;
										}
									}
		        				}
		        				if(keyFound)
		        					break;
							}
		        			
		        			if(keyFound)
		        				continue;
		        			else
		        			{
		        				System.out.println("IMPOSSIBLE");
		        				out.write("Case #"+(i+1)+": IMPOSSIBLE \n");
		        				System.out.println("*******************");
				        		continue;
		        			}
		        			
		        		}
		        		
		        		
					}
		        	
		        	
		        	//find solution
		        	//int[] soln = new int[numChests];
		        	
		        	ArrayList soln = new ArrayList();
		        	int count=0;
		        	
		        	
		        	for (int j = 0; j < numKeys; j++) {
		        		
		        		int keyToOpen = keys[j];
		        		boolean done=false;
		        		for (int k = 0; k < cs.length; k++) {
		        			
		        			
		        			if(cs[k].keyToOpen==keyToOpen)
							{
		        				if(cs[k].numKeys!=0)
		        					soln.clear();
		        				System.out.println("key "+keyToOpen+" opens chest "+k);
								soln.add(k);
								
							}
								
							for (int k2 = 0; k2 < cs[k].numKeys; k2++) {
								
								int keyOpen = cs[k].keys[k2];
								for (int k3 = 0; k3 < cs.length; k3++) {
									
									if(cs[k3].keyToOpen==keyOpen)
									{
										if(!soln.contains(k3))
										{
											soln.add(k3);
											System.out.println("key "+keyOpen+" opens chest "+k3);
											continue;
										}
											
									}
									
								}
								
								
								
							}
							

			        		if(soln.size()==numChests)
			        			break;
						}
		        		
		        		if(soln.size()==numChests)
		        			break;
					}
		        	System.out.println("solution");
		        	Iterator it = soln.iterator();
		        	String sol="";
		        	while(it.hasNext())
		        	{
		        		int n = (Integer) it.next();
		        		sol = n+ " "+ sol;
		        				
		        		System.out.println(n+1);
		        	}
		        	
		        	System.out.println("******************* ");
		        	
		        		
		        	out.write("Case #"+(i+1)+": "+sol+" \n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	
}
