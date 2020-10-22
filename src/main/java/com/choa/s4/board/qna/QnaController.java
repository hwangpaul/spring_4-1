package com.choa.s4.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		System.out.println("Qna List");
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
	
		return mv;
	}

}
