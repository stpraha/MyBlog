package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cxd.blog.dao.ArticleDao;
import cxd.blog.daoImpl.ArticleDaoImpl;
import cxd.blog.model.Article;
import cxd.blog.service.ArticleService;

import java.util.Date;
import java.text.SimpleDateFormat;


/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/jsp; charset=UTF-8");
		
		String title = request.getParameter("write_title");
		String content = request.getParameter("write_content");
		String author = request.getParameter("write_author");
		String sort = request.getParameter("write_sort");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		
		Article article = new Article(0, title, author, sort, time, 0, 0, 0, content);
		
		ArticleDao articledao = ArticleDaoImpl.getInstance();
		
		articledao.addArticle(article);
		
		System.out.println(time);
		System.out.println(title);
		System.out.println(content);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
