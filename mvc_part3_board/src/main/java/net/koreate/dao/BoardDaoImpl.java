package net.koreate.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.koreate.vo.BoardVo;
import net.koreate.vo.Criteria;

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
		return session.selectOne(namespase + ".read", bno);
	}

	@Override
	public void updateViewCnt(int bno) {
		session.update(namespase + ".updateViewCnt", bno);
	}

	@Override
	public int update(BoardVo board) {
		return session.update(namespase + ".update", board);
	}

	@Override
	public int delete(int bno) {
		return session.delete(namespase + ".delete", bno);
	}

	@Override
	public List<BoardVo> listCri(Criteria cri) {
		return session.selectList(namespase + ".listCri", cri);
	}
	
	@Override
	public int totalCount() {
		return session.selectOne(namespase + ".totalCount");
	}
	
}
