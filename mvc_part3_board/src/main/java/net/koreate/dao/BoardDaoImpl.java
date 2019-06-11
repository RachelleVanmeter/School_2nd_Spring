package net.koreate.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.vo.BoardVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	SqlSession session;
	
	String namespase = "net.koreate.mappers.BoardMapper";

	@Override
	public int create(BoardVo board) {
		return session.insert(namespase + ".insert", board);
	}

	@Override
	public List<BoardVo> listAll() {
		return session.selectList(namespase + ".listAll");
	}

	@Override
	public BoardVo read(int bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViewCnt(int bno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(BoardVo board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int bno) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
