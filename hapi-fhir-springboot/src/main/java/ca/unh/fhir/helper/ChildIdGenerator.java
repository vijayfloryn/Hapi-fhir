package ca.unh.fhir.helper;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ChildIdGenerator {
	 private static final String PREFIX = "child";
	    private static final int ID_LENGTH = 5;
	    private int sequence = 0;

	    public String generateChildId() {
	        sequence++;
	        String sequenceStr = String.format("%05d", sequence);
	        return PREFIX + sequenceStr;
	    }
}
