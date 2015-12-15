package com.chrisali.adventofcode.challenges;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AdventDay4 {
	// Day 4
	public static void adventCoinMining(String key) throws NoSuchAlgorithmException {
		byte[] bytesOfMessage = key.getBytes();
		MessageDigest md = MessageDigest.getInstance(key);
				
		byte[] digest = md.digest(bytesOfMessage);
	}
}
