package com.choa.s4.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.choa.s4.board.BoardDTO;
import com.choa.s4.util.FileSaver;
import com.choa.s4.util.Pager;

@Controller
@RequestMapping(value = "/notice/**")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception{
		System.out.println("Delete");
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		
		String message = "Delete Fail"; 
		
		if(result>0) {
			message = "Delete Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		
		return mv;
	}
		
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate2(BoardDTO boardDTO) throws Exception{
	
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setUpdate(boardDTO);
		
		String message = "Update Fail"; 
		
		if(result>0) {
			message = "Update Success";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", "./noticeList");
		mv.setViewName("common/result");
		
		
		return mv;
		
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception{
		System.out.println("update");
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getOne(boardDTO);
		
		mv.addObject("dto" , boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		
		return mv;
		
		
	}
	

	@GetMapping("noticeSelect")
	public ModelAndView getOne(BoardDTO boardDTO) throws Exception{
		System.out.println("notice select");
		boardDTO = noticeService.getOne(boardDTO);
		ModelAndView mv = new ModelAndView();
		if(boardDTO != null) {
			mv.setViewName("board/boardSelect");
			mv.addObject("dto", boardDTO);
			mv.addObject("board", "notice");
		}else {
			mv.setViewName("common/result");
			mv.addObject("msg", "No Data");
			mv.addObject("path", "./noticeList");
		}
		
		return mv;
	}
	
	@PostMapping("noticeWrite")
	public ModelAndView setInsert(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		System.out.println("qna write");
		ModelAndView mv = new ModelAndView();
		
		for(int i=0;i<files.length;i++) {
			System.out.println(files[i].getOriginalFilename());
		}
		
		//int result = noticeService.setInsert(boardDTO, files, session);
//		String message = "Write fail";
//		if(result>0) {
//			message="Write Success";
//		}
		
//		mv.addObject("msg", message);
//		mv.addObject("path", "./noticeList");
//		
//		mv.setViewName("common/result");
		
//		System.out.println(files.getOriginalFilename());
//		System.out.println(files.getName());
//		System.out.println(files.getSize());
		
		return mv;
	}
	
	
	@GetMapping("noticeWrite")
	public ModelAndView setInsert() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardWrite");
		mv.addObject("board", "notice");
		return mv;
	}
	
	
	//@RequestMapping(value = "noticeList")
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		List<BoardDTO>  ar = noticeService.getList(pager);
		
		mv.addObject("board", "notice");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		System.out.println("Notice List");
		mv.setViewName("board/boardList"); 
		
		return mv;
	}

}
