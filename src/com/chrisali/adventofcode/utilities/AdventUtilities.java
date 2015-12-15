package com.chrisali.adventofcode.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventUtilities {
	protected static final String filePath = ".\\ChallengeInputs\\";
	protected static final String adventURL = "http://adventofcode.com/day/";
	
	public static ArrayList<String> readInput(String fileName) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		File instructionFile = new File(sb.append(filePath).append(fileName).toString());
		
		ArrayList<String> stringList = new ArrayList<>();
		
		try {
			 String currentLine;
			 br = new BufferedReader(new FileReader(instructionFile));
			 
			 while ((currentLine = br.readLine())!=null)
				 stringList.add(currentLine);
		 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return stringList;
	}
	
	public static ArrayList<String> readInput(int adventDay) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String> stringList = new ArrayList<>();
		
		try {
			URL inputURL = new URL(sb.append(adventURL).append(Integer.toString(adventDay)).append("/input").toString());
			Scanner urlScan = new Scanner(inputURL.openStream());	
			String currentLine;
			 
			while ((currentLine = urlScan.nextLine())!=null)
				stringList.add(currentLine);
			 
			urlScan.close();		 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return stringList;
	}
	
	public static ArrayList<String[]> readAndSplitInput(String fileName, String delimiter) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		File instructionFile = new File(sb.append(filePath).append(fileName).toString());
		
		ArrayList<String[]> splitList = new ArrayList<>();
		
		try {
			 String currentLine;
			 br = new BufferedReader(new FileReader(instructionFile));
			 
			 while ((currentLine = br.readLine())!=null) {
				 String[] splitLine = currentLine.split(delimiter); 
				 splitList.add(splitLine);
			 }
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return splitList;
	}
	
	public static ArrayList<String[]> readAndSplitInput(int adventDay, String delimiter) {
		StringBuilder sb = new StringBuilder();
		ArrayList<String[]> splitList = new ArrayList<>();
		
		try {
			URL inputURL = new URL(sb.append(adventURL).append(Integer.toString(adventDay)).append("/input").toString());
			Scanner urlScan = new Scanner(inputURL.openStream());			
			String currentLine;
			
			while ((currentLine = urlScan.nextLine())!=null) {
				String[] splitLine = currentLine.split(delimiter); 
				splitList.add(splitLine);
			 }
			 
			urlScan.close();		 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return splitList;
	}
	
	public static String readInputSingleLine(String fileName) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		File instructionFile = new File(sb.append(filePath).append(fileName).toString());
		
		String fileLine = new String();
		
		try {
			 br = new BufferedReader(new FileReader(instructionFile));
			 
			 fileLine = br.readLine();
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return fileLine;
	}
	
	public static String readInputSingleLine(int adventDay) {
		StringBuilder sb = new StringBuilder();
		String fileLine = new String();

		try {
			URL inputURL = new URL(sb.append(adventURL).append(Integer.toString(adventDay)).append("/input").toString());
			Scanner urlScan = new Scanner(inputURL.openStream());

			fileLine = urlScan.nextLine();

			urlScan.close();		 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return fileLine;
	}

}
