package com.chrisali.adventofcode.challenges;

import java.util.ArrayList;

import org.apache.commons.lang3.StringEscapeUtils;

import com.chrisali.adventofcode.utilities.AdventUtilities;

public class AdventDay8 {
	// Day 8
	public static void matchStick(String fileName) {
		ArrayList<String> matchStickInput = AdventUtilities.readInput(fileName);
		int strLitlLen, strValLen;
		int totLitLen = 0;
		int totValLen = 0;
		
		System.out.printf("%-50s\t%10s\t%10s\t%10s\n","String","Literal","Unescaped","Difference");
		for (int i=0; i<101; i++)
			System.out.print("=");
		System.out.println("");
		
		for (String line : matchStickInput) {
			strLitlLen = line.length();
			strValLen = StringEscapeUtils.unescapeJava(line.substring(1, (line.length()-1))).length();
			
			System.out.printf("%-50s\t%10d\t%10d\t%10d\n",line,strLitlLen,strValLen,(strLitlLen-strValLen));
			
			totLitLen += strLitlLen;
			totValLen += strValLen;
		}
		
		for (int i=0; i<101; i++)
			System.out.print("-");
		System.out.printf("\n%-50s\t%10d\t%10d\t%10d\n","Totals: ",totLitLen,totValLen,(totLitLen-totValLen));
	}
}
