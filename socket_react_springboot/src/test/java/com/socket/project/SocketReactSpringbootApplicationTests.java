package com.socket.project;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.socket.project.domain.test.TestsRepository;
import com.socket.project.domain.test.Tests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocketReactSpringbootApplicationTests {

	@Autowired
	TestsRepository testsRepository;
	
	@After
	public void cleanup() {
		/**
		 *  이후 테스트 코드에 영향을 끼치지 않기 위해
		 *  테스트 메소드가 끝날때마다 repositroy 전체 비우는 코드  
		 **/
		testsRepository.deleteAll();
	}
	/*
	 *  given
	 *  테스트 기반 환경을 구축하는 단계
	 *  when
	 *  테스트 하고자 하는 행위 선언
	 *  then
	 *  테스트 결과 검증
	 *  H2
	 *  DB가 적용 안되어 있는데 오류가 안나는 이유는
	 *  메모리 DB인 H2를 기본적으로 사용하기 때문이다.
	 *  테스트 코드가 실행하는 시점에서 H2 DB를 실행시키고
	 *  테스트가 끝나면 H2 DB도 같이 종료된다. 
	 */
	@Test
	public void contextLoads() {
		// .builder 는 lombok.jar 을 다운받아서 인스톨 해야 사용가능
		// given
		testsRepository.save(Tests.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("keke0123")
				.build());
		// when
		List<Tests> testList = testsRepository.findAll();
		
		// then
		Tests tests = testList.get(0);
		assertThat(tests.getTitle(), is("테스트 게시글"));
		assertThat(tests.getContent(), is("테스트 본문"));
	}

}

