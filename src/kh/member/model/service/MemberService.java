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
}
