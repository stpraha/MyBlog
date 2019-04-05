package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import cxd.blog.dao.ArticleDao;
import cxd.blog.model.Article;
import cxd.blog.model.Tag;
import cxd.blog.model.User;
import cxd.blog.service.ArticleService;
import cxd.blog.utils.LoginUtils;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/jsp; charset=UTF-8");
		
		ArticleService articleService = ArticleService.getInstance();
		
		request.setAttribute("article_list", articleService.getArticleList());
		
		request.getRequestDispatcher("/page/mainPage.jsp").forward(request, response);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}