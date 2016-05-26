package com.gjk.controller;

import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gjk.domain.Book;
import com.gjk.domain.UserInfo;
import com.gjk.repository.BookRepository;
import com.gjk.repository.UserRepository;

@RestController
@RequestMapping("/rest")
public class RestfulController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/initInfo", method = RequestMethod.GET)
	public Map<String, Object> getInitInfo(Principal principal, HttpSession session) {

		Map<String, Object> returnMap = new HashMap<String, Object>();

		String userId;
		if (principal != null && !principal.getName().equals("anonymous")) {
			userId = principal.getName();
		} else {
			returnMap.put("error", true);
			returnMap.put("message", "Sorry, failed to get user id, please log in again.");
			return returnMap;
		}

		UserInfo userInfo = userRepository.findUserInfoByUsername(userId);
		if(userInfo == null){
			returnMap.put("error", true);
			returnMap.put("message", "Sorry, failed to get user information, please log in again.");
			return returnMap;
		}
		returnMap.put("userInfo", userInfo);
		session.setAttribute("userInfo", userInfo);

		return returnMap;
	}

	@RequestMapping
	public String hello() {
		return "Hello Spring-Boot";
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public Iterable<Book> getList() {
		return bookRepository.findAll();
	}
	
	@RequestMapping(value = "/isAdmin", method = RequestMethod.GET)
	public boolean isAdmin() {
		return true;
	}
}
