package ca.unh.fhir.helper;

import java.util.Random;

public class HelperHapiFhir {
	
	public static String generateOTP() {
	    int OTP_LENGTH = 6; // Set the length of the OTP code
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < OTP_LENGTH; i++) {
	        sb.append(random.nextInt(10));
	    }
	    return sb.toString();
	}

}
