package com.chrisali.adventofcode.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay9 {
	// Day 9
	public static void minimumDistance(String fileName) {
		class Route {
			private String origin;
			private String destination;
			private Integer distance;
			
			Route(String origin, String destination, Integer distance) {
				this.origin = origin;
				this.destination = destination;
				this.distance = distance;
			}

			boolean canTravel(String currentLocation, Route route) {
				return (currentLocation.equals(route.origin));
			}
			
			boolean canMakeConnection(Route route1, Route route2) {
				return (route1.destination == route2.origin);
			}
			
			void reverseRoute() {
				String temp = origin;
				origin = destination;
				destination = temp;	
			}

			@Override
			public String toString() {
				StringBuilder sb = new StringBuilder();
				return sb.append(origin).append(" -> ").append(destination).append(": ").append(distance).toString();
			}
			
			String getOrigin() {return origin;}
			
			String getDestination() {return destination;}
			
			
			Integer getDistance() {return distance;}		
		}
		
		ArrayList<String[]> routesInput = AdventUtilities.readAndSplitInput(fileName, " ");
		
		ArrayList<Route> routeList = new ArrayList<>();       // Total routes available
		Set<String> cityAgenda = new HashSet<>();             // Cities needed to visit
		Set<String> visitedCities = new HashSet<>();		  // Cities already visited (can't visit more than once)
		
		String currentLocation = "AlphaCentauri"; // Start here 
		Integer distanceTraveled = 0;
		
		visitedCities.add(currentLocation);                   // Already visited starting (current) location
		
		for (String[] splitString : routesInput) {
			routeList.add(new Route(splitString[0], splitString[2], Integer.parseInt(splitString[4])));
			cityAgenda.add(splitString[0]);
			cityAgenda.add(splitString[2]);
		}
		
		for (Route route : routeList) {
			if (route.canTravel(currentLocation, route)) {
				currentLocation = route.getDestination();
				distanceTraveled += route.getDistance();
				visitedCities.add(currentLocation);
				
				System.out.println(route.toString());				
			}
		}	
		
		System.out.println("\nTotal Distance: " + distanceTraveled);
		
	}
}
