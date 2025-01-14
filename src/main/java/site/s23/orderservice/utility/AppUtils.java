package site.s23.orderservice.utility;

import java.security.SecureRandom;

public class AppUtils {

	private static final String BASE62_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static SecureRandom random = new SecureRandom();
	public static final String EMAIL_VALIDATION_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

	/*  
	 * Generates a random string of the desired length 
	 */
	private static String randomString(int len){
	   StringBuilder sb = new StringBuilder(len);
	   for(int i = 0; i < len; i++)
	      sb.append(BASE62_STR.charAt(random.nextInt(BASE62_STR.length())));
	   return sb.toString();
	}
	
	public static String generateNewOrderId() {
		return "ORD_"+randomString(7);
	}
}
