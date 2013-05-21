package com.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class LawnMover {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("B-large.in"));
				FileWriter fstream = new FileWriter("B-large.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	int row = Integer.parseInt(str[0]);
		        	int col = Integer.parseInt(str[1]);
		        	ArrayList<ArrayList<Integer>> testArray = new ArrayList<ArrayList<Integer>>();
		        	for(int r = 0; r < row; r++){
		        		testArray.add(new ArrayList<Integer>());
		        		String[] s1 = br.readLine().split(" ");
		        		for(int c = 0; c < col; c++){
		        			testArray.get(r).add(Integer.parseInt(s1[c]));
		        		}
		        	}

		        	while(true){
		        		int k = 0;
		        		while(k < testArray.size()){
		        			if (testArray.get(k).isEmpty()){
		        				testArray.remove(k);
		        				continue;
		        			}
		        			k++;
		        		}

		        		if(testArray.isEmpty())
		        			break;
		        		int min = Integer.MAX_VALUE;
		        		int minr = 0;
		        		int minc = 0;
		        		// find min
			        	for(int r = 0; r < testArray.size(); r++){
			        		for(int c = 0; c < testArray.get(0).size(); c++){
			        			if (min > testArray.get(r).get(c)){
			        				minr = r;
			        				minc = c;
			        				min = testArray.get(r).get(c);
			        			}
			        		}
			        	}
			        	int numcol = 0, numrow = 0;
			        	boolean rb = true, cb = true;
			        	// whole row check		        	
			        	for(int j = 0; j < testArray.get(minr).size(); j++)
			        		if (testArray.get(minr).get(j) == min)
			        			numrow++;

			        	if (numrow != testArray.get(minr).size())
			        		rb = false;

			        	// whole column check
			        	for(int j = 0; j < testArray.size(); j++)
			        		if (testArray.get(j).get(minc) == min)
			        			numcol++;
			        	if (numcol != testArray.size())
			        		cb = false;

			        	// its a no case
			        	if((cb == false) && (rb == false)){
			        		out.write("Case #"+(i+1)+": NO\n");
			        		break;
			        	}

			        	// if column is nice, clean it
			        	if (cb){
			        		for(int j = 0; j < testArray.size(); j++)
				        		testArray.get(j).remove(minc);
			        		continue;
			        	}
			        	// if row is nice, clean it
			        	else if(rb){
				        	testArray.remove(minr);
			        		continue;
			        	}
		        	}
		        	if(testArray.size() !=0)	
		        		continue;
		        	out.write("Case #"+(i+1)+": YES\n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
}
