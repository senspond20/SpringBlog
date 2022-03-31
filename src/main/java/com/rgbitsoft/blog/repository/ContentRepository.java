package com.rgbitsoft.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgbitsoft.blog.model.entity.Content;
import java.lang.Integer;
import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
	List<Content> findByContentNo(Integer contentno);
}
