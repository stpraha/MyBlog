package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cxd.blog.model.Article;
import cxd.blog.service.ArticleService;
import cxd.blog.utils.LoginUtils;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/ArticleServlet")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served atasdfasd: ").append(request.getContextPath());
		//response.getWriter().append("Served atasdf: ").append(request.getContextPath()).append("  " + id);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/jsp; charset=UTF-8");
		
		try {
			String message = request.getParameter("message");
			if(message.equals("star")) {
				String id = request.getParameter("article_id");
				
				
				System.out.println("有人点赞了！");
				System.out.println(id);
			}
			else if(message.equals("comment")) {
				
				String id = request.getParameter("article_id");
				String comment = request.getParameter("comment_content");
				String commenderNickname = request.getParameter("commender_nickname");
				String commenderEmail = request.getParameter("commender_email");
				
				System.out.println("有人评论了！");
				System.out.println(id);
				System.out.println(comment);
				System.out.println(commenderNickname);
				System.out.println(commenderEmail);
			}
		}catch (Exception e) {
			//do nothing
		}
		
		String id = request.getParameter("id");
		
		ArticleService articleService = ArticleService.getInstance();
		
		Article article = articleService.getSingleArticle("id", id);
		
		request.setAttribute("article", article);
		
		request.getRequestDispatcher("/page/articlePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}








