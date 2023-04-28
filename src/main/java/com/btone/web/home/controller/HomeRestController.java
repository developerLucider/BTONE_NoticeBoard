package com.btone.web.home.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping(value = "/")
@RestController
public class HomeRestController {

	private static final Logger logger = LoggerFactory.getLogger(HomeRestController.class);
	   
   
}