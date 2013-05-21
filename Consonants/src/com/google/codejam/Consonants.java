package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Consonants {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
				FileWriter fstream = new FileWriter("A-large.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	//System.out.println("******testcase("+i+")*******");
		        	String[] str = br.readLine().split(" ");
		        	
		        	
		        	String name = str[0];
		        	int n = Integer.parseInt(str[1]);
		        	int y=0;
		        	
		        	String sub;
		        	
		        	String[] strin = new String[50000000];
		        	int arrn=0;
		        	ArrayList al = new ArrayList<String>();
		        	
		        	
		        	for(int c=0;c<name.length();c++)
		            {
		                for(int j=1;j<=name.length()-c;j++)
		                {
		                   // sub = name.substring(c,c+j);
		                    strin[arrn++]=name.substring(c,c+j);
		                }
		            }

		           
					//HashSet hs = new HashSet();
		            //hs.addAll(al);
		            //al.clear();
		            //al.addAll(hs);
		            
		            //Iterator it = strin
		            
		            
		            int len = name.length();
		            
		            //System.out.println("n-value: "+n);
		            
		            boolean flag = false;
		            
		            int l=0;
		           
		            for(int k=0;k<arrn;k++)
		            	System.out.println(strin[k]);
		            
		            
		            while(l<arrn-1)
		            {
		            	
		            	l++;
		            	//flag=false;
		            	String s = strin[l];
		            	//if(s.length()>=2)
		            	//System.out.println(s);
		            	Pattern pattern = Pattern.compile("[^aeiou]"+"{"+n+"}");
		            	
			            Matcher matcher = pattern.matcher(s);
			            if (matcher.find()) {
		            		y++;
		            		//System.out.println("Match:: "+matcher.group());
			            }
			            
		            }
		            	
		            
		            
		            

		            //Iterator it = new al.
		            
//		            for(String strn:al)
//		            {
//		                System.out.println(strn);
//		            }
		        	                     
		        	
		        	//System.out.println("Case #"+(i+1)+": "+y+"\n");
		        	out.write("Case #"+(i+1)+": "+y+"\n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}

	
	
}
