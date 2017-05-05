package com.ssm.lcl.dao;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



import com.ssm.lcl.BaseTest;
import com.ssm.lcl.entity.Book;

public class BookDaoTest extends BaseTest {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private BookDao bookDao;

	@Test
	public void testQueryById() throws Exception {
		long bookId = 1;
		Book book = bookDao.queryById(bookId);
		logger.debug(book.toString());
	}

	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}

	@Test
	public void testReduceNumber() throws Exception {
		long bookId = 1000;
		int update = bookDao.reduceNumber(bookId);
		System.out.println("update=" + update);
	}

}
