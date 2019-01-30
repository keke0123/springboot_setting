package com.socket.project.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.socket.project.domain.test.TestsMainResponseDto;
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
	// .map(TestsMainResponseDto::new)는 실제로는
	// .map(tests -> new TestsMainResponseDto(tests)) 와 같다.
	// repository 결과로 넘어온 Tests의 Stream 을 map 을 통해
	// TestsMainResponseDto 로 변환 -> Lists 로 반환하는 메소드
	@Transactional
	public List<TestsMainResponseDto> findAllDesc(){
		return testsRepository.findAllDesc()
				.map(TestsMainResponseDto::new)
				.collect(Collectors.toList());
	}
}
