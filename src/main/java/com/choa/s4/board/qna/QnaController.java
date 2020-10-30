package com.choa.s4.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("qnaDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		System.out.println("Delete");
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setDelete(boardDTO);
		
		String message = "Delete Fail"; 
		
		if(result>0) {
			message = "Delete Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		
		return mv;
	}
	
	@PostMapping("qnaUpdate")
	public ModelAndView setUpdate2(BoardDTO boardDTO) throws Exception{
		System.out.println(boardDTO.getTitle());
		System.out.println(boardDTO.getWriter());
		System.out.println(boardDTO.getContents());
		
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setUpdate(boardDTO);
		
		String message = "Update Fail"; 
		
		if(result>0) {
			message = "Update Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		
		return mv;
		
	}
	
	@GetMapping("qnaUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		System.out.println("update");
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getOne(boardDTO);
		
		mv.addObject("dto" , boardDTO);
		mv.addObject("board", "qna");
		mv.setViewName("board/boardUpdate");
		
		return mv;
		
	}
	
	@PostMapping("qnaReply")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setReply(boardDTO);
		
		String message = "Reply Write Fail"; 
		
		if(result>0) {
			message = "Reply Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		mv.setViewName("common/result");
		
		
		return mv;
		
	}
	
	@GetMapping("qnaReply")
	public ModelAndView setReply() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardReply");
		mv.addObject("board", "qna");
		return mv;
		 
		
	}
	
	@GetMapping("qnaSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		System.out.println("qna select");
		boardDTO = qnaService.getOne(boardDTO);
		ModelAndView mv = new ModelAndView();
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "qna");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./qnaList");
		}
		return mv;
	}
	
	@PostMapping("qnaWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		System.out.println("qna write");
		ModelAndView mv = new ModelAndView();
		int result = qnaService.setInsert(boardDTO, files, session);
		String message = "Write fail";
		if(result>0) {
			message="Write Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./qnaList");
		
		mv.setViewName("common/result");
		
		return mv;
	}
	
	
	@GetMapping("qnaWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "qna");
		return mv;
		
	}
	
	@GetMapping("qnaList")
	public ModelAndView getList(Pager pager) throws Exception{
		System.out.println("Qna List");
		
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = qnaService.getList(pager);
		
		BoardDTO boardDTO = ar.get(0);
		QnaDTO qnaDTO = (QnaDTO)boardDTO;
		System.out.println(qnaDTO.getDepth());
		
		mv.addObject("board", "qna");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
	
		return mv;
	}

}
