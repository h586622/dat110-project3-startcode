package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {	
		
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(entity.getBytes());
			byte[] encoded = digest.digest();
			String hex = toHex(encoded);
			
			
			hashint = new BigInteger(hex, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest		
		
		// compute the hash of the input 'entity'
			
		// convert the hash into hex format	
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {
		
		BigInteger two = new BigInteger("2");
		
		BigInteger size = (two.pow(bitSize()));
		
		// return the address size
		
		return size;
	}
	
	public static int bitSize() {
		
		MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
		
		int digestlen = digest.getDigestLength();
		
		// find the digest length
		
		int bitSize = digestlen*8;
		
		return bitSize;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}
	
	

}
