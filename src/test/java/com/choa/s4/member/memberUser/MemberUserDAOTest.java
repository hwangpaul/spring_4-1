package com.choa.s4.member.memberUser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;
import com.choa.s4.member.MemberDTO;
import com.choa.s4.member.memberUser.MemberUserDAO;

public class MemberUserDAOTest extends MyTestCase{
	
	@Autowired
	private MemberUserDAO memberUserDAO;
	
	//@Test
	public void getMemberLogin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id1");
		memberDTO.setPw("pw1");
		memberDTO = memberUserDAO.getMemberLogin(memberDTO);
		
		assertNotNull(memberDTO);
	}
	
	@Test
	public void getIdTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		
		int result = memberUserDAO.getIdCheck(memberDTO);
		
		assertNotNull(result);
		
	}
	
}
