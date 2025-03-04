package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BoardVo;

//싱글톤으로 할 거임
//싱글톤은 객체 딱 한번 생성
//속도가 빨라짐
public class BoardDao {

	private Connection conn = DbConnection.getConn(); //생성이 아니라 호출해서 사용(싱글톤
	private Connection conn2 = DbConnection.getConn(); //같은 객체임
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	String sql = "";
	
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
			finally {
				pstmtClose();
			}
		}
	}
	
	//게시글 전체 리스트
	public List<BoardVo> getBoardList() {
//		if(conn.equals(conn2)) {
//			System.out.println("같은 객체");
//		}
//		else {
//			System.out.println("다른 객체");
//		}
		List<BoardVo> vos = new ArrayList<BoardVo>();
		try {
			sql = "select * from boardTest order by idx desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardVo vo = new BoardVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHostIP(rs.getString("hostIp"));
				vo.setReadNum(rs.getInt("readNum"));
				vo.setwDate(rs.getDate("wDate"));
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getBoardList): " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}
	
	//게시글 등록처리하기
	public int setBoardInput(BoardVo vo) {
		int res = 0;
		try {
			sql = "insert into boardTest values (default,?,?,?,?,default,default)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4, vo.getHostIP());
			res = pstmt.executeUpdate(); //1번 실행하면 1, 두번은 2
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardInput): " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}
	
	//글 조회수 증가하기
	public void setReadNumUpdate(int idx) {
		try {
			sql = "update boardTest set readNum = readNum + 1 where idx = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setBoardInput): " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
	}
	
	// 글내용 조회하기
		public BoardVo getBoardContent(int idx) {
			BoardVo vo = new BoardVo();
			try {
				sql = "select * from boardTest where idx = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					//vo.setIdx(rs.getInt("idx"));
					vo.setIdx(idx);
					vo.setName(rs.getString("name"));
					vo.setwDate(rs.getDate("wDate"));
					vo.setReadNum(rs.getInt("readNum"));
					vo.setHostIP(rs.getString("hostIp"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));
				}
			} catch (SQLException e) {
				System.out.println("sql오류(setBoardInput) : " + e.getMessage());
			} finally {
				rsClose();
			}
			return vo;
		}
		
		
		// 게시글 삭제처리
		public int setBoardDelete(int idx) {
			int res = 0;
			try {
				sql = "delete from boardTest where idx = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, idx);
				res = pstmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println("sql오류(setBoardDelete) : " + e.getMessage());
			} finally {
				pstmtClose();
			}
			return res;
		}
	
}
