package com.chrisali.adventofcode.challenges;

import java.util.HashSet;
import java.util.Set;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay3 {
	// Day 3
	public static void deliveryInstructions(String fileName) {
		Integer[] santaCoordinates = {0, 0};
		Set<Integer[]> previousCoords = new HashSet<>();
		
		String instruction = AdventUtilities.readInputSingleLine(fileName);
		
		for (int i=0; i<instruction.length(); i++) {
			if (instruction.charAt(i) == '^')
				santaCoordinates[1]++;
			else if (instruction.charAt(i) == 'V')
				santaCoordinates[1]--;
			else if (instruction.charAt(i) == '<')
				santaCoordinates[0]--;
			else if (instruction.charAt(i) == '>')
				santaCoordinates[0]++;
			else {
				System.out.println("Invalid instruction!");
				return;
			}
			previousCoords.add(santaCoordinates);
		}
		
		System.out.println("Santa delivered presents to " +
						   Integer.toString(previousCoords.size()) +
						   " homes!");
	}
}
