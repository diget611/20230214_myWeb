package kh.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static kh.common.jdbc.JdbcTemplate.*;
import kh.member.model.vo.MemberVo;

public class MemberDao {
	
	// 회원가입 기능
	public int enroll(Connection conn, MemberVo vo) {
		int result = -1;
		String query = "INSERT INTO TEST_MEMBER VALUES(?, ?, ?, ?)";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			
			// 위치홀더 ? 채우기
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			
			// pstmt 실행 및 결과값 result에 대입
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("DAO enroll() return : " + result);
		return result;
	}
}
