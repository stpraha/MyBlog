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

/**
 * Servlet implementation class AllCommentSerlvet
 */
@WebServlet("/CpageSerlvet")
public class CommentpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentpageServlet() {
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
				
		CommentService commentService = CommentService.getInstance();
		
		//System.out.println(user.getNickName() + "qwerqwer");
		
		List<Comment> commentList = commentService.getAllComment();

					
		request.setAttribute("comment_list", commentList);
		
		request.getRequestDispatcher("/page/commentPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
