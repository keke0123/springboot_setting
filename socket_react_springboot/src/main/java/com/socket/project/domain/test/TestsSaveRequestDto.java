package com.socket.project.domain.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *  테이블과 매핑되는 Entity 클래스를 Request/Response 
 *  클래스로 사용해서는 안된다.
 *  Entity 클래스가 변경되면 여러 클래스에 영향을 끼치게되는데
 *  Request/Response용 DTO 는 view를 위한 클래스라
 *  정말 자주 변경이 필요하기 때문이다.
 */
@Getter
@Setter
@NoArgsConstructor
public class TestsSaveRequestDto {
	private String title;
	private String content;
	private String author;

	@Builder
	public TestsSaveRequestDto(String title, String content, String author) {
		//super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	public Tests toEntity() {
		return Tests.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}


}
