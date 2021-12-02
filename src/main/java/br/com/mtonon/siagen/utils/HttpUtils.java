package br.com.mtonon.siagen.utils;

import javax.servlet.http.HttpServletRequest;

public final class HttpUtils {
	
	private static final String[] IP_HEADERS = {
	        "X-Forwarded-For",
	        "Proxy-Client-IP",
	        "WL-Proxy-Client-IP",
	        "HTTP_X_FORWARDED_FOR",
	        "HTTP_X_FORWARDED",
	        "HTTP_X_CLUSTER_CLIENT_IP",
	        "HTTP_CLIENT_IP",
	        "HTTP_FORWARDED_FOR",
	        "HTTP_FORWARDED",
	        "HTTP_VIA",
	        "REMOTE_ADDR"
	    };
	
	private HttpUtils() {
    }
	
	public static String getRequestIP(HttpServletRequest request) {

		for(String header: IP_HEADERS) {
			String value = request.getHeader(header);
			if(value == null || value.isEmpty()) {
				continue;
			}
			String[] parts = value.split("\\s*,\\s*");
			return parts[0];
		}
		
		String ip = request.getRemoteAddr();
		if(ip.equals("0:0:0:0:0:0:0:1")) ip = "127.0.0.1";
		
		return ip;
    }
}
