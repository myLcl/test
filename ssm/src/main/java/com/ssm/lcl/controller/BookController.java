package com.ssm.lcl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.lcl.entity.Book;
import com.ssm.lcl.service.BookService;


@Controller
@RequestMapping("/book") 
public class BookController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	//jsp:  localhost:8088/ssm/jsp/BookController/list.jsp
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Book> list = bookService.getList();
		for (Book book : list) {
			logger.debug(book.toString());
		}
		model.addAttribute("list", "list");
		return "BookController/list"; 
	}
	
	//freemarker:  localhost:8088/ssm/ftl/BookController/index.ftl
	 @RequestMapping(value="index",method=RequestMethod.POST)
	 public ModelAndView index() {
	      ModelAndView view = new ModelAndView("BookController/index");
	      view.addObject("message", "Say hi for Freemarker.");
	      return view;
	 }


}
