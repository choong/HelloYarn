/**
 * 
 */
package com.hello.yarn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author choonghyun
 *
 */

@Controller
public class MainController {

	@RequestMapping("/")
	public String main(){
		return "main";
	}
}
