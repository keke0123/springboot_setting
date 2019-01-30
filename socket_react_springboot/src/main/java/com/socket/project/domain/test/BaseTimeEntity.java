package com.socket.project.domain.test;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/*
 *  BaseTimeEntity 클래스는 모든 Entity 들의 상위 클래스가 되어
 *  Entity 들의 createdDate, modifiedDate 를 자동으로 관리 하는 역할
 *  @MappedSuperclass
 *  JPA Entity 클래스들이 BaseTimeEntity 을 상송할 경우 필드들
 *  (createdDate, modifiedDate) 도 컬럼으로 인식하도록 합니다.
 *  @EntityListeners(AuditingEntityListener.class)
 *  BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
 *  @CreatedDate
 *  Entity 가 생성되어 저장될 때 시간이 자동 저장된다.
 *  @LastModifiedDate
 *  조회한 Entity 의 값을 변경할 때 시간이 자동 저장된다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	@CreatedDate
	private LocalDateTime createdDate;
	
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
}
