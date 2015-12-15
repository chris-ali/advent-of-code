package com.chrisali.adventofcode.challenges;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay1 {	
	// Day 1
	public static void elevatorInstructions(String fileName) {
		int floors = 0;
		StringBuilder translatedInstruction = new StringBuilder();
		String instruction = AdventUtilities.readInputSingleLine(fileName);
		
		for (int i=0; i<instruction.length(); i++) {
			if (instruction.charAt(i)==')')
				floors++;
			else if (instruction.charAt(i)=='(')
				floors--;
			else {
				System.out.println("Invalid characters in note!");
				return;
			}
		}
		
		if (floors>0)
			translatedInstruction.append("go up ").append(Integer.toString(floors)).append(" floors!");
		else if (floors<0)
			translatedInstruction.append("go down ").append(Integer.toString(Math.abs(floors))).append(" floors!");
		else
			translatedInstruction.append("stay on the ground floor!");
		
		System.out.println("According to the coded note, Santa must " + translatedInstruction.toString());	
	}
}
