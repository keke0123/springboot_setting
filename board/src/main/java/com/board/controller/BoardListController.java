package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardVO;
import com.board.mapper.BoardMapper;

// restcontroller 를 사용하면 requestbody 가 기본적으로 적용되어 있어 따로 선언할 필요가 없다.
@RestController
public class BoardListController {

	@Autowired
	private BoardMapper boardMapper;
	
	@RequestMapping("/board")
	public List<BoardVO> board() throws Exception{
		List<BoardVO> board = boardMapper.boardList();
		return board;
	}
	
	@RequestMapping("/boardList")
	public ModelAndView boardList() throws Exception{
		List<BoardVO> board = boardMapper.boardList();
		return new ModelAndView("boardList","list",board);
	}
	// @PostMapping / requestmapping 에서 method=post
	// @GetMapping / requestmapping 에서 method=get
}
