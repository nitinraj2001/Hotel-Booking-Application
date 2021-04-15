package com.nitinraj.hotelbooking.utility;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class ImageUtil {

	 public String getImgData(byte[] byteData) {
	        return Base64.getMimeEncoder().encodeToString(byteData);
	    }

	public ImageUtil() {
		super();
		
	}
}
