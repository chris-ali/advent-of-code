package com.chrisali.adventofcode.challenges;

import java.util.ArrayList;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay5 {
	// Day 5
	public static void naughtyNiceString(String fileName) {	
		class NiceQualifiers {
			boolean threeVowels(String entry) {
				int numVowels = 0;
				char[] vowels = {'a','e','i','o','u'};
				for (int i=0; i<entry.length(); i++) {
					for (int j=0; j<vowels.length; j++) {
						if (entry.toLowerCase().charAt(i) == vowels[j])
							numVowels++;
					}
				}
				return numVowels >= 3;
			}
			boolean doubleLetter(String entry) {
				for (int i=0; i<entry.length()-1; i++) {
					if (entry.toLowerCase().charAt(i) == entry.toLowerCase().charAt(i+1))
						return true;
				}
				return false;
			}
			boolean specialStrings(String entry) {
				String[] specialStrs = {"ab","cd","pq","xy"};
				for (int i=0; i<entry.length()-1; i++) {
					for (int j=0; j<specialStrs.length; j++) {
						if (entry.toLowerCase().substring(i, i+1) == specialStrs[j])
							return false;
					}
				}
				return true;
			}
		}
		NiceQualifiers nq = new NiceQualifiers();
		ArrayList<String> entry = AdventUtilities.readInput(fileName);
		
		for (String entryLine : entry) {
			if(nq.threeVowels(entryLine) && nq.doubleLetter(entryLine) && nq.specialStrings(entryLine))
				System.out.println(entryLine + ":\tNice String!");
			else
				System.out.println(entryLine + ":\tNaughty String!");
		}
		
	}
}
