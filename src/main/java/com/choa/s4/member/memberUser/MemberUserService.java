package com.choa.s4.member.memberUser;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.MemberService;
import com.choa.s4.util.FileSaver;

@Service
public class MemberUserService implements MemberService {
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	@Autowired
	private FileSaver fileSaver;
	
	@Override
	public MemberDTO getMemberIdCheck(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberIdCheck(memberDTO);
	}
	
	@Override
	public int setMemberJoin(MemberDTO memberDTO, MultipartFile photo, HttpSession session) throws Exception {
		//HDD 폴더에, 이름 
		//저장할 폴더 경로
		String path = session.getServletContext().getRealPath("/resources/upload/member");//파일을 저장할 폴더 경로
		System.out.println(path);
		File file = new File(path);
		
		fileSaver.saveCopy(file, photo);
		
		
		
		return 0;//memberUserDAO.setMemberJoin(memberDTO);
	}
	
	@Override
	public int setMemberDelete(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberDelete(memberDTO);
	}
	
	@Override
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.setMemberUpdate(memberDTO);
	}
		
	@Override
	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		return memberUserDAO.getMemberLogin(memberDTO);
	}


	

}
