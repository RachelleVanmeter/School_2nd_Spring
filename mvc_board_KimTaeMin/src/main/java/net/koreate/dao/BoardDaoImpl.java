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

	String getResult(int result) {
		String msg = "FAIL";
		if (result > 0)
			msg = "SUCCESS";
		return msg;
	}

	@Override
	public String register(BoardVo board) {
		return getResult(session.insert(namespase + ".register", board));
	}

	@Override
	public List<BoardVo> listPage(Criteria cri) {
		return session.selectList(namespase + ".listPage", cri);
	}

	@Override
	public BoardVo readPage(int bno) {
		return session.selectOne(namespase + ".readPage", bno);
	}

	@Override
	public String modify(BoardVo board) {
		return getResult(session.update(namespase + ".modify", board));
	}

	@Override
	public String remove(int bno) {
		return getResult(session.delete(namespase + ".remove", bno));
	}

	@Override
	public void updateViewCnt(int bno) {
		session.update(namespase + ".updateViewCnt", bno);
	}

	@Override
	public int totalCount() {
		return session.selectOne(namespase + ".totalCount");
	}

}
