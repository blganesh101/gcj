package com.google.codejam;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Pogo {

	 public static void main(String[] args){
			try {
				//File for input and output
				BufferedReader br = new BufferedReader(new FileReader("A-large.in"));
				FileWriter fstream = new FileWriter("A-large.out");
				BufferedWriter out = new BufferedWriter(fstream);

				int testcasenum = Integer.parseInt(br.readLine());
		        for(int i = 0; i < testcasenum; i++){
		        	String[] str = br.readLine().split(" ");
		        	
		        	int x = Integer.parseInt(str[0]);
		        	int y = Integer.parseInt(str[1]);
		        	
		        	String move=null;
		        	
		        	String startDir = null;
		        	
		        	long path =1;
		        	 
		        	Point src = new Point(0,0);
		        	Point dest = new Point(x,y);
		        	
		        	ArrayList matrix = new ArrayList<List>();
		        	
		        	
		        	
		        	
		        	
		        	//System.out.println("Case #"+(i+1)+": "+noOfCircles+"\n");
		        	out.write("Case #"+(i+1)+": "+move+"\n");
		        }
		        out.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}


	 class Queue {
		    private int head, tail, size;
		    private int[] data;
		    public Queue(int max) {
		        data = new int[max];
		    }
		    public boolean isEmpty() {
		        return size == 0;
		    }
		    public void add(int x) {
		        data[tail++] = x;
		        tail %= data.length;
		        size++;
		    }
		    public int remove() {
		        int tmp = data[head++];
		        head %= data.length;
		        size--;
		        return tmp;
		    }
	 }
	
}
