package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Question;

public class QuestionDao {

	public int insert(Connection con,Question question)throws Exception{
		
		String sql = "insert into question(queID, queCate, queSubject, queBody, queAns, queDiff, queCon) values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, question.getQueId());
		pstmt.setString(2, question.getQueCate());
		pstmt.setString(3, question.getQueSubject());
		pstmt.setString(4, question.getQueBody());
		pstmt.setString(5, question.getQueAns());
		pstmt.setFloat(6, question.getQueDiff());
		pstmt.setInt(7, question.getQueCon());
	
	return pstmt.executeUpdate();
	
	}
	
	//显示所有问题列表 ----- 
	public List query(Connection con) throws Exception {
		List<Question> list = new ArrayList<Question>();
		String sql = "select * from question";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSet rset = rs;
		System.out.println("查询所有问题");
		while(rs.next()){
			Question question = new Question();
			question.setQueId(rs.getString("queId"));
			question.setQueCate(rs.getString("queCate"));
			question.setQueSubject(rs.getString("queSubject"));
			question.setQueBody(rs.getString("queBody"));
			question.setQueAns(rs.getString("queAns"));
			question.setQueDiff(rs.getFloat("queDiff"));
			question.setQueCon(rs.getInt("queCon"));
			//worker.setId(rs.getInt("id"));
			//worker.setName(rs.getString("name"));
			//worker.setSex(rs.getInt("sex"));
			//worker.setPhone(rs.getString("phone"));
			//worker.setPassword(rs.getString("password"));
			list.add(question);
		}
		return list;
	}
	
	//删除
	public int delete(Connection con , String queId)throws Exception{
		String sql = "delete from question where queId=\"" + queId + "\"";			
		PreparedStatement pstmt = con.prepareStatement(sql);//预编译
		//pstmt.setString(0, queId);
		System.out.println(sql);
		return pstmt.executeUpdate();
	}
	
	//更新
	public int update(Connection con , Question question ) throws SQLException, ParseException{
		String sql = "update question set queCate = ?, queSubject = ?,  queBody=?, where book_id = ? " +
				"queAns = ?, queDiff=?, queCon = ? and queId = ?";			
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(7, question.getQueId());
		pstmt.setString(1, question.getQueCate());
		pstmt.setString(2, question.getQueSubject());
		pstmt.setString(3, question.getQueBody());
		pstmt.setString(4, question.getQueAns());
		pstmt.setFloat(5, question.getQueDiff());
		pstmt.setInt(6, question.getQueCon());
		return pstmt.executeUpdate();
	}
	
	//查询
	public Question queryById(Connection con , String queId)throws Exception{
		String sql = "select * from question where queId=?";			
		PreparedStatement pstmt = con.prepareStatement(sql);//预编译			
		pstmt.setString(1, queId);
		ResultSet rs = pstmt.executeQuery();
		Question question = new Question();
		while(rs.next()){		
			question.setQueId(rs.getString("queId"));
			question.setQueCate(rs.getString("queCate"));
			question.setQueSubject(rs.getString("queSubject"));
			question.setQueBody(rs.getString("queBody"));
			question.setQueAns(rs.getString("queAns"));
			question.setQueDiff(rs.getFloat("queDiff"));
			question.setQueCon(rs.getInt("queCon"));
			//worker.setId(rs.getInt("id"));
			//worker.setName(rs.getString("name"));
			//worker.setSex(rs.getInt("sex"));
			//worker.setPhone(rs.getString("phone"));
			//worker.setPassword(rs.getString("password"));
		}
		return question;
	}
	
}
