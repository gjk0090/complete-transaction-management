package com.gjk.controller;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gjk.domain.Book;
import com.gjk.repository.BookRepository;

@RestController
@RequestMapping("/rest")
public class RestfulController {

	@Autowired
	private BookRepository bookRepository;
	
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

	@RequestMapping("/findAll")
	public Iterable<Book> getList() {
		return bookRepository.findAll();
	}
}
