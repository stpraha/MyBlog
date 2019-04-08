package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cxd.blog.model.Comment;
import cxd.blog.service.ArticleService;
import cxd.blog.service.CommentService;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String message = request.getParameter("message");
			if(message.equals("star")) {
				String articleId = request.getParameter("article_id");
				
				ArticleService as = ArticleService.getInstance();
				as.addStar(articleId);
								
				System.out.println("有人点赞了！");
				System.out.println(articleId);
			}
			else if(message.equals("comment")) {
				String articleId = request.getParameter("article_id");
				String articleTitle = request.getParameter("article_title");
				String commentContent = request.getParameter("comment_content");
				String commenderNickname = request.getParameter("commender_nickname");
				String commenderEmail = request.getParameter("commender_email");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = sdf.format(new Date());
				
				CommentService cs = CommentService.getInstance();
				
				Comment comment = new Comment(1, commenderNickname, commenderEmail, commentContent, Integer.parseInt(articleId), articleTitle, time);
				
				cs.addComment(comment);
				
				System.out.println("有人评论了！");
			}
		} catch (Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
