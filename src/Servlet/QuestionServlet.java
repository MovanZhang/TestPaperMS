package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Question;

import Dao.QuestionDao;
import Util.DbUtil;

public class QuestionServlet extends HttpServlet{

	DbUtil dbutil = new DbUtil();
	QuestionDao questionDao = new QuestionDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("who");
		if(action.equals("insert")){
			insert(request,response);
		}
		else if(action.equals("queryAll")){
			queryAll(request,response);
		}
		else if(action.equals("delete")){
			delete(request,response);
		}
		else if(action.equals("toUpdate")){
			toUpdate(request,response);
		}
		else if(action.equals("update")){
			try {
				update(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(action.equals("chakan")){
			chakan(request,response);
		}
	}
	
	public void insert(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{	
		//String queId = Integer.parseInt(request.getParameter("id"));
		Connection consize = null;
		try {
			consize = dbutil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		QuestionDao questionDaoNum = new QuestionDao();
		List<Question> list = new ArrayList<Question>();
		try {
			list = questionDaoNum.query(consize);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String id = String.format("%5d", list.size()+1).replace(" ", "0");
		
		
		//String queId = request.getParameter("queId");
		String queId = "ST" + id;
		String queCate = request.getParameter("queCate");
		System.out.println("queCate"+queCate);
		String queSubject = request.getParameter("queSubject");
		String queBody = request.getParameter("queBody");
		String queAns = request.getParameter("queAns");
		float queDiff = Float.parseFloat(request.getParameter("queDiff"));
		int queCon = Integer.parseInt(request.getParameter("queCon"));
  		//String name = request.getParameter("name");
  		//int sex = Integer.parseInt(request.getParameter("sex"));
  		//String phone = request.getParameter("phone");
  		//String password = request.getParameter("password");
		Question question = new Question(queId, queCate, queSubject, queBody, queAns, queDiff, queCon);
		
  		//WorkerBean worker = new WorkerBean(id,name,sex,phone,password);
  		
  		QuestionDao questionDao = new QuestionDao();
  		//WorkerDao workerdao = new WorkerDao();
  		DbUtil db = new DbUtil();
  		Connection con;
		try {
			con = db.getCon();
			int result = 0;
			PrintWriter out = response.getWriter();
	  		result = questionDao.insert(con , question);
	  	  	if(result>0){
	  	  		//out.print("添加成功!");
	  	  		System.out.print("添加成功!");
	  	  		out.println("<html><body>");
	  	  		out.print("<font size=6 color=red >添加成功</font>");
	  	  		out.println("</body></html>");
	  	  	}else{
	  	  		System.out.print("添加失败!");
	  	  		//out.print("添加失败");
	  	  		out.println("<html><body>");
	  	  		out.print("<font size=6 color=yellow >添加失败</font>");
	  	  		out.println("</body></html>");
	  	  		}
	  		
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
  		
	}
	
	
	public void queryAll(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		try {
			con = dbutil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		QuestionDao questionDao = new QuestionDao();
		List<Question> list = new ArrayList<Question>();
		try {
			list = questionDao.query(con);
			request.setAttribute("list", list);
	        request.getRequestDispatcher("info-mgt.jsp").forward(request, response); //转发到职工界面
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String queId = request.getParameter("queId");
		PrintWriter out = response.getWriter();
		Connection con = null;
		try {
			
			con = dbutil.getCon();
			int result = questionDao.delete(con, queId);
			if(result > 0){
				System.out.print("删除成功!");
	  			out.println("<html><body>");
	  			out.print("<font size=6 color=red >删除成功</font>");
	  			out.println("</body></html>");
			}
			else{
				System.out.print("删除失败!");
	  			out.println("<html><body>");
	  			out.print("<font size=6 color=red >删除失败</font>");
	  			out.println("</body></html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String queId = request.getParameter("queId");
		Question question = new Question();
		Connection con = null;
		try {
			con = dbutil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		QuestionDao questionDao = new QuestionDao();
		try {
			question = questionDao.queryById(con, queId);
			System.out.println(question.getQueAns());
			request.setAttribute("question", question);
	        request.getRequestDispatcher("info-update.jsp").forward(request, response); //转发到职工界面
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//修改
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,Exception {
		String queId = request.getParameter("queId");
		QuestionDao questionDao = new QuestionDao();
			
		String queCate = request.getParameter("queCate");
		System.out.println("queCate"+queCate);
		String queSubject = request.getParameter("queSubject");
		String queBody = request.getParameter("queBody");
		String queAns = request.getParameter("queAns");
		float queDiff = Float.parseFloat(request.getParameter("queDiff"));
		int queCon = Integer.parseInt(request.getParameter("queCon"));
  		//String name = request.getParameter("name");
  		//int sex = Integer.parseInt(request.getParameter("sex"));
  		//String phone = request.getParameter("phone");
  		//String password = request.getParameter("password");
		Question question = new Question(queId, queCate, queSubject, queBody, queAns, queDiff, queCon);
		
		Connection con = null;
			
		con = dbutil.getCon();
		int result = questionDao.update(con, question);
		PrintWriter out = response.getWriter();
		if(result>0){
			out.println("<html><body>");
			out.print("<font size=6 color=blue >修改成功</font>");
			out.println("</body></html>");
		}else{
			System.out.println("失败");
			out.println("<html><body>");
	  		out.print("<font size=6 color=blue >修改失败</font>");
	  		out.println("</body></html>");
		}
	}
	
	private void chakan(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String queId = request.getParameter("queId");
		Question question = new Question();
		Connection con = null;
		try {
			con = dbutil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
		QuestionDao questionDao = new QuestionDao();
		try {
			question = questionDao.queryById(con, queId);
			System.out.println(question.getQueAns());
			request.setAttribute("question", question);
	        request.getRequestDispatcher("info-view.jsp").forward(request, response); //转发到职工界面
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
