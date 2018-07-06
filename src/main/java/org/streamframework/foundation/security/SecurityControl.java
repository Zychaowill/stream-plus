package org.streamframework.foundation.security;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class SecurityControl {
	
	public static String numberSecurityFilter(String value) {
		if (StringUtils.isEmpty(value))
			return value;
		String result = null;
		result = value.replaceAll("[^0-9]", "");
		return result;
	}
	
	public static String characterSecurityFilter(String value) {
		if (StringUtils.isEmpty(value))
			return value;
		String result = null;
		result = value.replaceAll("<|>|(|)|\\|/|%|\'|\"|&", "");
		return result;
	}
	
	public static String sequenceSecurityFilter(String value) {
		if (StringUtils.isEmpty(value))
			return value;
		String result = null;
		result = Pattern.compile("", Pattern.CASE_INSENSITIVE).matcher(value).replaceAll("");
		result = encode4HtmlForXSS(result);
		return result;
	}
	
	public static String securityFilter(String value, boolean isIntType, boolean isCharType, boolean isTextType) {
		if (StringUtils.isEmpty(value))
			return value;
		String result = value;
		if (isIntType) {
			result = numberSecurityFilter(result);
		}
		if (isCharType) {
			result = characterSecurityFilter(result);
		}
		if (isTextType) {
			result = sequenceSecurityFilter(result);
		}
		return result;
	}
	
	private static String encode4HtmlForXSS(String value) {
		if (StringUtils.isEmpty(value))
			return value;
		StringBuffer result = new StringBuffer("");
		
		return result.toString();
	}
}
