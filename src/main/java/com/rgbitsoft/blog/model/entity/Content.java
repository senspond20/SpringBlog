package com.rgbitsoft.blog.model.entity;

import javax.persistence.GeneratedValue;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.rgbitsoft.blog.model.constant.ContentStatus;

import javax.persistence.Index;


// import org.hibernate.annotations.ColumnDefault;
// import org.springframework.boot.context.properties.bind.DefaultValue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate 
@Table(name ="content",
		indexes = {@Index(name = "idx_contentNo", 
		columnList="contentNo")})
@ToString
public class Content {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "content_id")
	private Long id;
	
	private Integer contentNo = 0;
	
	@Column(length = 155, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	@Column(name = "AUTHOR")
	// @ManyToOne
	// @JoinColumn(name ="ACCOUNT_ID")
	private String author;

	// @OneToMany
	// @JoinTable(name = "content_reply")
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "content_id")  // <-- 여기!!
//	private List<ContentReply> reply = new ArrayList<>();
	

	// @Column(name = "status", length = 1)
	// @ColumnDefault("'Y'") 
	// private char status
	// ==> "\u0000", 로 들어간다

	// 1 True : 공개 , 0 False : 비공개
	// @Column(name ="status", columnDefinition = "CHAR(1) NOT NULL DEFAULT 'Y'")
//	@Column(name ="status", columnDefinition = "TINYINT(1) NOT NULL DEFAULT 1")
	// @ColumnDefault("'True'")
	// @Convert(converter = BooleanToYNConverter.class)
	
	private String status; // publish(공개), staging(임시저장), private(비공개)
	
	@CreationTimestamp
	private Date createTime;

	// @Column(name ="tiemstamp", columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")

	// @Column(columnDefinition = "TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@UpdateTimestamp
	private Timestamp updateTime;
	

	@Builder // 빌더패턴 적용
	public Content(Integer contentNo, String title, String content, String author, ContentStatus contentStatus) {
		super();
		this.contentNo = contentNo;
		this.title = title;
		this.content = content;
		this.status = contentStatus.getStatus();
		this.author = author;
		// this.createTime = LocalDateTime.now();
		// this.status = "Y";
	}

	// update 수정 setter대신
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}