package com.chrisali.adventofcode.challenges;

import java.util.ArrayList;
import java.util.Collections;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay2 {
	// Day 2
	public static void wrappingPaperCalculator(String fileName){	
		int sideOne = 0;
		int sideTwo = 0;
		int sideThree = 0;
		int totalSurfaceArea = 0; 
		
		ArrayList<String[]> dimensionsList = AdventUtilities.readAndSplitInput(fileName, "x");
		
		for (String[] splitLine : dimensionsList) {
			sideOne = Integer.parseInt(splitLine[0])*Integer.parseInt(splitLine[1]);
			sideTwo = Integer.parseInt(splitLine[1])*Integer.parseInt(splitLine[2]);
			sideThree = Integer.parseInt(splitLine[0])*Integer.parseInt(splitLine[2]);
			
			ArrayList<Integer> sides = new ArrayList<>();
			sides.add(sideOne);
			sides.add(sideTwo);
			sides.add(sideThree);
			Collections.sort(sides);
			
			totalSurfaceArea += 2*(sideOne+sideTwo+sideThree)+sides.get(0);
		}

		System.out.println("The elves must purchase " +
						   Integer.toString(totalSurfaceArea) +
						   " square feet of wrapping Paper!");	
	}
}
