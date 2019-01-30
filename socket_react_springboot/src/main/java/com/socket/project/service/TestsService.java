package com.socket.project.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.socket.project.domain.test.TestsRepository;
import com.socket.project.domain.test.TestsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TestsService {
	private TestsRepository testsRepository;
	
	// 호출한 쪽에서 저장한 게시글의 id를 알수 있도록 리턴 타입을 Long으로 두고, getId()를 반환
	// Service 메소드는 Entity 를 바로 받지 않고, 
	// save용 dto인 TestsSaveRequestDto 를 받아서 저장
	// @Transactional 은 commit 을 한번에 시키는 어노테이션
	@Transactional
	public Long save(TestsSaveRequestDto dto) {
		return testsRepository.save(dto.toEntity()).getId();
	}
}
