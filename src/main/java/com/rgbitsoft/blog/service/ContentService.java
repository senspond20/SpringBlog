package com.rgbitsoft.blog.service;

import java.util.List;

import com.rgbitsoft.blog.model.entity.Content;

public interface ContentService {
	
	/**
	 * 모든 컨텐츠 히스토리를 조회
	 * @return
	 */
	List<Content> findAllhistory();
	
	/**
	 * 컨텐츠 번호로 특정 컨텐츠에 대한 히스토리 조회
	 * @param contentNo
	 * @return
	 */
	List<Content> findByContentNoHistory(Integer contentNo);
	
	
	/**
	 * 공개된 컨텐츠 목록 조회
	 * @return
	 */
	List<Content> findAllPublish();
	

	/**
	 * 컨텐츠 번호로 현재 게시되어 있는 컨텐츠 조회
	 * @param contentNo
	 * @return
	 */
	Content findByContentNo(Integer contentNo);
	
	/**
	 * 새로운 컨텐츠 저장
	 * @param content
	 * @return
	 */
	Content saveContent(Content content);
	
}
