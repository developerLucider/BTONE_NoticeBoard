package com.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

    private static Logger logger = LoggerFactory.getLogger(Utils.class);

    /**
     * 
     * @param name
     * @return  이름의 길이에 따라
     * 			0, 1 -> 그대로
     * 		   	2, 3 -> 앞자 1글자 제외 마스킹
     * 			그 이상 -> 앞자 2글자 제외 마스킹
     * @author 김민석
     */
    public static String NameMasking(String name) {
		String res = name;
		logger.info("마스킹 전 이름 = {}", res);
		
		if(name.length() < 2) {
			logger.debug("마스킹 해당 없음");
			return res;
		} else if (1 < name.length() && name.length() < 4) {	// 길이가 2, 3인 경우
			res.replaceAll("(?<=.{1}).", "*");
		} else {	// 그 이상의 길이인 경우
			res.replaceAll("(?<=.{2}).", "*");
		}
		
		logger.info("마스킹 후 이름 = {}", res);		
		return res;
    }         
}