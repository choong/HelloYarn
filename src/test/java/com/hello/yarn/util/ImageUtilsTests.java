package com.hello.yarn.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.hello.yarn.HelloYarnApplication;

import static org.mockito.Mockito.*; 

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=HelloYarnApplication.class)
public class ImageUtilsTests {

	@Autowired
	private ImageUtils imageUtils;
	
	private static File img;
	
	
	@BeforeClass
	public static void setupFile(){
		img = new File("C:\\TEMP\\KakaoTalk_20161123_152237149.jpg");
	}
	
	org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
	@Test
	public void testImageFileLoad() throws JpegProcessingException, IOException, MetadataException{
		Metadata meta = imageUtils.loadToMetadata(img);
		
		log.info(ToStringBuilder.reflectionToString(imageUtils.setImgageMetaInfo(meta)));		
		
	}
}
