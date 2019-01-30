package com.socket.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.socket.project.domain.test.TestsRepository;
import com.socket.project.domain.test.TestsSaveRequestDto;
import com.socket.project.service.TestsService;

import lombok.AllArgsConstructor;

/*
 *  아래에 autowired 가 없는데
 *  스프링 프레임워크 에선 Bean 을 주입받는 방식들이 아래와 같이 있다.
 *  @Autowired, setter, 생성자
 *  이중 가장 권장하는 방식이 생성자로 주입받는 방식이다.
 *  즉, 생성자로 Bean 객체를 받도록 하면 @Autowired 와 동일한 효과를 볼수 있다는 것이다.
 *  여기서 Lombok 의 @AllArgsConstructor 가 생성자로 해결해주는것 
 */
@RestController
@AllArgsConstructor
public class TestController {
	
	//private TestsRepository testsRepository;
	
	private TestsService testsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	// postman 에서
	// post : http://localhost:8080/test
	// body / raw / JSON
	// {"title":"테스트 타이틀","content":"테스트 본문","author":"테스터"}
	@PostMapping("/test")
	public void saveTests(@RequestBody TestsSaveRequestDto dto) {
		testsService.save(dto);
		//testsRepository.save(dto.toEntity());
	}
	@GetMapping("/main")
	public ModelAndView main() {
		return new ModelAndView("main");
	}
	
}
