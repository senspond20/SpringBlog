package com.rgbitsoft.blog.model.constant;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ContentStatus {
	STAGING("staging"), // 임시저장
	PRIVATE("private"), // 비공개
	PUBLISH("publish"); // 공개
	private int id;
	private String status;
	private ContentStatus() {
	}
	private ContentStatus(String status) {
		this.status = status;
	}
}
