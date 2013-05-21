package src.com.codejam.R1Q3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.codejam.R1Q1.Solve;


public class CJEngine {

	static int numberOfTestcases = 0;
	static ArrayList<String> testCases;
	static ArrayList<String> testCasesResults;
	
	public static void main(String[] args) {
		
		File smallInputFile;
		File smallOutputFile;
		File largeInputFile;
		File largeOutputFile;
		
    	//smallInputFile = new File("C-small-practice.in.txt");
    	//smallOutputFile = new File("C-small-practice.out.txt");
		//largeInputFile = new File("C-large-practice.in.txt");
		//largeOutputFile = new File("C-large-practice.out.txt");
 
		smallInputFile = new File("test.txt");
		smallOutputFile = new File("testout.txt");
		
		 testCases = new ArrayList<String>();
		 parseFile(smallInputFile);
		 Solve solveSmallInput = new Solve(numberOfTestcases, testCases);
		 testCasesResults = solveSmallInput.getResults();
		 printOutput(numberOfTestcases,testCasesResults,smallOutputFile);
		 
		 
		 /*testCases = new ArrayList<String>();
		 parseFile(largeInputFile);
		 Solve solveLargeInput = new Solve(numberOfTestcases, testCases);
		 testCasesResults = solveLargeInput.getResults();
		 printOutput(numberOfTestcases,testCasesResults,largeOutputFile);*/

	}


	private static void parseFile(File inputFile) {
		
		FileReader reader;
		try {
			reader = new FileReader(inputFile);
			BufferedReader buffer = new BufferedReader(reader);
			String strLine;
			boolean nFlag=false;
			
			while((strLine = buffer.readLine()) != null)
			{
				if(!nFlag)
				{
					numberOfTestcases = new Integer(strLine);
					nFlag = true;
				}
				else
				{
					testCases.add(strLine);
				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	private static void printOutput(int numberOfTestcases2,
			ArrayList<String> caseResult, File outputFile) {
		
		BufferedWriter buffer= null;
		FileWriter writer = null;
	
		try {
			writer = new FileWriter(outputFile);
			buffer = new BufferedWriter(writer);
			
			
			for(int i=0;i<numberOfTestcases;i++)
			{
				buffer.write("Case #"+(i+1)+": "+caseResult.get(i));
				buffer.newLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            //Close the BufferedWriter
            try {
                if (buffer != null) {
                    buffer.flush();
                    buffer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
		
	}

}
