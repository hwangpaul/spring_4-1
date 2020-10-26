package com.choa.s4.board.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.s4.util.Pager;
@Repository
public class MemoDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.choa.s4.board.memo.MemoDAO.";

	//insert
	public int setInsert(MemoDTO memoDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setInsert", memoDTO);
	}
	
	//lsit
	public List<MemoDTO> getList(Pager pager) throws Exception{
		return sqlSession.selectList(NAMESPACE+"getList", pager);
		
	}
	
	//count
	public long getCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+"getCount", pager);
	}
	
	//getOne
	public MemoDTO getOne(MemoDTO memoDTO) throws Exception {
		System.out.println("dao :"+memoDTO.getNum());
		return sqlSession.selectOne(NAMESPACE+"getOne", memoDTO);
	}
	
	//setDelete
	public int setDelete(MemoDTO memoDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"setDelete", memoDTO);
		
	}
}
