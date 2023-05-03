package com.common;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Base64Utils {

    private static Logger logger = LoggerFactory.getLogger(Base64Utils.class);

    public static String base64Encoder(String password) {
        
    	logger.debug("base64Encoder START ---------------------------------------------");
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	
        byte[] targetBytes = password.getBytes();
        
        // Base64 인코딩
        Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode(targetBytes);
                
        logger.debug("base64Encoder   END ---------------------------------------------");
        return new String(encodedBytes);
    }
    
    public static String base64Decoder(String password) {
    	
    	logger.debug("base64Decoder START ---------------------------------------------");
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	
    	byte[] targetBytes = password.getBytes();
    	
    	// Base64 디코딩
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(targetBytes);
    	
    	logger.debug("base64Decoder   END ---------------------------------------------");
    	return new String(decodedBytes);
    }
     
}