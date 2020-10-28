package com.choa.s4.member.memberFile;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.s4.MyTestCase;

public class MemberFileDAOTest extends MyTestCase{

	@Autowired
	private MemberFileDAO memberFileDAO;
	
	@Test(expected = RuntimeException.class)//이 메서드가 exception이 나오면 성공
	public void MemberFileTest () throws Exception{
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		
		memberFileDTO.setId("id5asdsd");
		memberFileDTO.setFileName("filename");
		memberFileDTO.setOriName("oriname");
		int result = memberFileDAO.setInsert(memberFileDTO);
		
		assertEquals(1, result);
		
	}
}
