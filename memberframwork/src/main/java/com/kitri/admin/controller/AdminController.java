package com.kitri.admin.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kitri.admin.model.service.AdminService;

@Controller
@RequestMapping("/admin")
//@SessionAttributes("userInfo")
public class AdminController{
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value = "/mvmemberlist.kitri", method = RequestMethod.GET)
	public String Memberlist() {
		return "admin/member/memberlist";
	}
	
	@RequestMapping(value = "/getmemberlist.kitri", method = RequestMethod.GET)
	@ResponseBody
	public String Memberlist(@RequestParam Map<String, String> map) {
		logger.info("왜하는거지? : " + map);
		System.out.println("오잉???");
		String json = adminService.getMemberList(map);
		return json;
	}
	
	
	
}
