package com.chrisali.adventofcode.challenges;

import java.util.ArrayList;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay7 {
	// Day 7
	public static void logicGates(String fileName) {
		ArrayList<String[]> logicInstructions = AdventUtilities.readAndSplitInput(fileName," ");

		for (String[] splitLine : logicInstructions) {
			ArrayList<Integer> arguements = new ArrayList<>();
			int logicGateResult;
			
			if (splitLine.length == 3) {
				System.out.println(splitLine[2] + ": " + splitLine[0]);
				arguements.add(Integer.parseInt(splitLine[0]));
			}
			else if (splitLine.length == 4) {
				logicGateResult = ~arguements.get(0);
			}
			else if (splitLine.length == 5) {
				switch(splitLine[1]) {
					case "AND": logicGateResult = arguements.get(0)&arguements.get(1);
						break;
					case "OR": logicGateResult = arguements.get(0)|arguements.get(1);
						break;
					case "XOR": logicGateResult = arguements.get(0)^arguements.get(1);
						break;
					case "LSHIFT": logicGateResult = arguements.get(0)<<arguements.get(1);
						break;
					case "RSHIFT": logicGateResult = arguements.get(0)>>>arguements.get(1);
						break;
					default: System.out.println("Invalid Operator!");
						return;					
				}
				System.out.println(splitLine[2] + ": " + Integer.toString(logicGateResult));
			}
			else {
				System.out.println("Error Parsing Line!");
				return;
			}
		}
	}
}
