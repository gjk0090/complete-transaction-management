package com.gjk.controller;

import java.security.Principal;
import java.util.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestfulController {

	@RequestMapping(value = "/initInfo", method = RequestMethod.GET)
	public Map<String, Object> getInitInfo(Principal principal) {

		Map<String, Object> returnMap = new HashMap<String, Object>();

		String userId;
		if (principal != null && !principal.getName().equals("anonymous")) {
			userId = principal.getName();
		} else {
			returnMap.put("error", true);
			returnMap.put("message", "Sorry, failed to get user information, please log in again.");
			return returnMap;
		}

		returnMap.put("userId", userId);
		// todo: User object
		// todo: set session

		return returnMap;
	}

	@RequestMapping
	public String hello() {
		return "Hello Spring-Boot";
	}

	@RequestMapping("/info")
	public Map<String, String> getInfo(@RequestParam String name) {
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		return map;
	}

	@RequestMapping("/list")
	public List<Map<String, String>> getList() {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> map = null;
		for (int i = 1; i <= 5; i++) {
			map = new HashMap<>();
			map.put("name", "gjk-" + i);
			list.add(map);
		}
		return list;
	}
}
