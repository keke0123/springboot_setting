package com.board;

import java.sql.Connection;
import java.util.TimeZone;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.board.domain.BoardVO;
import com.board.mapper.BoardMapper;

/*
 *  SpringApplicationConfiguration 은 boot 1.3까지
 *  SpringBootTest 는 1.4부터
 */
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BoardApplication.class)
@WebAppConfiguration
public class BoardApplicationTests {
	@Autowired
	private SqlSessionFactory sqlSession; // 작성
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void contextLoads() {
	}
	
//	@Test
//	public void testConnection() throws Exception{ // 작성
//		System.out.println("sqlSession:"+sqlSession);
//	}
	
	@Test
	public void testMapper() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setSubject("제목입니다");
		vo.setContent("내용입니다");
		vo.setWriter("작성자입니다");
		mapper.boardInsert(vo);
	}

}

