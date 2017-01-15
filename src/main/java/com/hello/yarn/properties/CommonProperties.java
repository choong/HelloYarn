package com.hello.yarn.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("common")
public class CommonProperties {

	private String imageTemPath;
	private String imageDomain;
	private String tempImageUri;
	public String getImageTemPath() {
		return imageTemPath;
	}

	public void setImageTemPath(String imageTemPath) {
		this.imageTemPath = imageTemPath;
	}

	public String getImageDomain() {
		return imageDomain;
	}

	public void setImageDomain(String imageDomain) {
		this.imageDomain = imageDomain;
	}

	public String getTempImageUri() {
		return tempImageUri;
	}

	public void setTempImageUri(String tempImageUri) {
		this.tempImageUri = tempImageUri;
	}

	
	
	
}
