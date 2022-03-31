package com.rgbitsoft.blog.web.board;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgbitsoft.blog.model.constant.ContentStatus;
import com.rgbitsoft.blog.model.entity.Content;
import com.rgbitsoft.blog.repository.ContentRepository;


@SpringBootTest
@Rollback(false)
public class ContentRepoTests {

	@Autowired
	private ContentRepository contentRepository;

	@Test
	public void saveBoardTest() throws JsonProcessingException {
		Content content11 = Content.builder().contentNo(1).author("test").title("efefe").content("fefefe")
				.contentStatus(ContentStatus.PUBLISH).build();

		contentRepository.save(content11); // 1

		Content content12 = Content.builder().contentNo(1).author("test2").title("efefe2").content("fefefe2")
				.contentStatus(ContentStatus.STAGING).build();

		contentRepository.save(content12); // 2

		Content content13 = Content.builder().contentNo(1).author("test3").title("efefe3")
				.content(""
						+ "fefefe2")
				.contentStatus(ContentStatus.PRIVATE).build();

		contentRepository.save(content13); // 2

		System.out.println("=================");
		System.out.println(content11);
		System.out.println(content12);
		System.out.println("=================");

		Content content21 = Content.builder().contentNo(2).author("test").title("efefe").content("fefefe")
				.contentStatus(ContentStatus.STAGING).build();

		contentRepository.save(content21); // 1

		Content content22 = Content.builder().contentNo(2).author("test2").title("efefe2").content("fefefe2")
				.contentStatus(ContentStatus.PRIVATE).build();

		contentRepository.save(content22); // 2

	}
	
	@AfterEach
	public void after() throws JsonProcessingException {
		String contents = new ObjectMapper().writerWithDefaultPrettyPrinter()
				.writeValueAsString(contentRepository.findAll());

		System.out.println(contents);
		System.out.println("==================================================");
		
		List<Content> contentHistory = contentRepository.findByContentNo(2);
		Content currentContent = contentHistory.get(contentHistory.size()-1);
		
		
		String contentById = new ObjectMapper().writerWithDefaultPrettyPrinter()
				.writeValueAsString(currentContent);

		System.out.println(contentById);
		
		
	}
}
