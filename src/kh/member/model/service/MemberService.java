package kh.member.model.service;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.MemberVo;

import java.sql.Connection;

public class MemberService {
	
	public int enroll(MemberVo vo) {
		int result = -1;
		Connection conn = getConnection();
		result = new MemberDao().enroll(conn, vo);
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public MemberVo login(MemberVo vo) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().login(conn, vo);
		close(conn);
		return result;
	}
	
	public MemberVo myinfo(String id) {
		MemberVo result = null;
		Connection conn = getConnection();
		result = new MemberDao().myinfo(conn, id);
		close(conn);
		return result;
	}
}
