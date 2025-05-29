package com.smartcamp.smartcamp.controller;




import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/")
public class HomeController {

	

	
	
	@RequestMapping("event")
	public String home() {
		return "event";
	}
	
	
	@RequestMapping("planner")
	public String planner()
	{
		return "planner";
	}
	
	@RequestMapping("faculty")
	public String facultydirectory()
	{
		return "faculty";
	}
	

	@RequestMapping("menu")
	public String menu()
	{
		return "menu";
	}

	@RequestMapping("links")
	public String links()
	{
		return "links";
	}

	@RequestMapping("complain")
	public String complain()
	{
		return "complain";
	}

	@RequestMapping("library")
	public String library()
	{
		return "library";
	}

	@RequestMapping("unifreelance")
	public String unifreelance()
	{
		return "unifreelance";
	}

	@RequestMapping("found")
	public String lost()
	{
		return "found";
	}

	@RequestMapping("note")
	public String note()
	{
		return "note";
	}

	@RequestMapping("privacy")
	public String privacy()
	{
		return "privacy";
	}
	
	@RequestMapping("terms")
	public String terms()
	{
		return "terms";
	}
	
	@RequestMapping("cookies")
	public String cookies()
	{
		return "cookies";
	}
	
	@RequestMapping("learn-more")
	public String learn()
	{
		return "learn-more";
	}
	
}
