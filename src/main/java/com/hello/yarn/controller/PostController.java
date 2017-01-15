/**
 * 
 */
package com.hello.yarn.controller;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hello.yarn.properties.CommonProperties;

/**
 * @author choonghyun
 *
 */

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private CommonProperties commonProperties;
	
	@RequestMapping(value="/write", method={RequestMethod.GET})
	public String viewPost(){
		return "/post/write";
	}
	
	@RequestMapping(value="/image", method={RequestMethod.POST})
	public @ResponseBody JSONObject uploadImage(@RequestPart MultipartFile uploadFile){
		String result = null;
		if (uplaodFile(uploadFile)){
			result = commonProperties.getImageDomain() + commonProperties.getTempImageUri()
					+ uploadFile.getOriginalFilename();
		}
		
		JSONObject json = new JSONObject();
		json.put("url", result);
		return json;
	}
	
	private boolean uplaodFile(MultipartFile file){
		
		String filePath = commonProperties.getImageTemPath() + file.getOriginalFilename();
		File f = new File(filePath);
		try {
			file.transferTo(f);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
