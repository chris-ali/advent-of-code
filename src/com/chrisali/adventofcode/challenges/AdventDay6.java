package com.chrisali.adventofcode.challenges;

import java.util.ArrayList;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay6 {
	// Day 6
	public static void christmasLights(String fileName) {		
		class ChristmasLightGrid {
			private boolean[][] lightStates = new boolean[1000][1000];
			
			public ChristmasLightGrid() {
				lightAction(new int[] {0, 0}, new int[] {1000, 1000},"off");
			}
			
			void lightAction(int[] startCoord, int[] endCoord, String action) {
				for (int i=startCoord[0]; i<endCoord[0]; i++) {
					for (int j=startCoord[1]; j<endCoord[1]; j++) {
						switch (action) {
							case "on": lightStates[i][j] = true;
								break;
							case "off": lightStates[i][j] = false;
								break;
							case "toggle": lightStates[i][j] ^= true;
								break;
							default: System.out.println("Invalid Action!");
								return;
						}
					}
				}
			}
			void getLitLights() {
				int numLights = 0;
				
				for (int i=0; i<lightStates.length; i++) {
					for (int j=0; j<lightStates.length; j++) {
						if (lightStates[i][j])
							numLights++;	
					}
				}
				System.out.println("There are currently " + 
								   Integer.toString(numLights) + 
								   " lights swiched on!");
			}
		}
		
		ChristmasLightGrid clg = new ChristmasLightGrid();
		clg.getLitLights();
		
		ArrayList<String[]> lightInstructions = AdventUtilities.readAndSplitInput(fileName, " ");
		int[] startLight = {0,0};
		int[] endLight = {0,0};
		
		for (String[] splitLine : lightInstructions) {	
			if (splitLine[0].equalsIgnoreCase("turn")) {
				String[] splitCoords = splitLine[2].split(",");
				startLight[0] = Integer.parseInt(splitCoords[0]);
				startLight[1] = Integer.parseInt(splitCoords[1]);
				
				splitCoords = splitLine[4].split(",");
				endLight[0] = Integer.parseInt(splitCoords[0]);
				endLight[1] = Integer.parseInt(splitCoords[1]);
				
				clg.lightAction(startLight, endLight, splitLine[1]);
			}
			else if (splitLine[0].equalsIgnoreCase("toggle")) {
				String[] splitCoords = splitLine[1].split(",");
				startLight[0] = Integer.parseInt(splitCoords[0]);
				startLight[1] = Integer.parseInt(splitCoords[1]);
				
				splitCoords = splitLine[3].split(",");
				endLight[0] = Integer.parseInt(splitCoords[0]);
				endLight[1] = Integer.parseInt(splitCoords[1]);
				
				clg.lightAction(startLight, endLight, splitLine[0]);
			}
			else {
				System.out.println("Error Parsing Line!");
				return;
			}
			clg.getLitLights();	
		}	
	}
}
