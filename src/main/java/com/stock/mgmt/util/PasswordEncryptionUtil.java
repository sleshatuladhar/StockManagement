package com.stock.mgmt.util;

public class PasswordEncryptionUtil {
	/**
	 * This method encrypts the plain password Using MD5 algorithm
	 * @param password
	 * @return encrypted password
	 */
   public static String encryptPassword(String password) {
	   try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(password.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}

}