package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cxd.blog.model.Article;
import cxd.blog.model.Comment;
import cxd.blog.service.ArticleService;
import cxd.blog.service.CommentService;
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
			
		//do nothing
		String id = request.getParameter("id");
			
		ArticleService articleService = ArticleService.getInstance();
		articleService.addVisit(id);
		Article article = articleService.getSingleArticle("id", id);
		
		CommentService commentService = CommentService.getInstance();
		List<Comment> commentList = commentService.getArticleComment(id);
		for(Comment c: commentList) {
			System.out.println(c.getCommenderNickName());
		}
			
		request.setAttribute("article", article);
		request.setAttribute("comment_list", commentList);
			
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








