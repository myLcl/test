package com.ssm.lcl.service.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssm.lcl.BaseTest;
import com.ssm.lcl.dto.AppointExecution;
import com.ssm.lcl.service.BookService;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;
	 private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1;
		long studentId = 6;//下一次调用该方法该参数需要+1
		AppointExecution execution = bookService.appoint(bookId, studentId);
		logger.debug(execution.toString());
//		System.out.println(execution);
	}

}
