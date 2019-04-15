package edu.autocar.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class SHA256Util {
	public static String generateSalt() {
		byte[] salt = new byte[8];

		Random random = new Random();
		random.nextBytes(salt);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < salt.length; i++) {
			sb.append(String.format("%02x", salt[i]));
		}
		return sb.toString();
	}

	public static String getEncrypt(String source, String salt) {
		String result = "";
		String temp = source + salt;
		byte[] bytes = temp.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);
			byte[] byteData = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(String.format("%02x", byteData[i]));
			}
			result = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}
}
