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


@WebServlet("/MainpageServlet")
public class MainpageServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    public MainpageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/jsp; charset=UTF-8");
				
		ArticleService articleService = ArticleService.getInstance();
		
		//System.out.println(user.getNickName() + "qwerqwer");
		
		List<Article> articleList = articleService.getArticleList();
		for(Article a : articleList) {
			a.setContent(" ");
		}
					
		request.setAttribute("article_list", articleList);
		
		request.getRequestDispatcher("/page/mainPage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	private List<Article> getArticleList() {
		List<Article> list = new ArrayList<>();
		
		Article article1 = new Article(0, "Test title 1", "Test author 1", "Test sort 1", "2019-10-02", 1231, 15, 345, "Test content 1 sdfasdffffffffffffffffffffffffffffffffffffffffffffffffffffffffweqrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
		Article article2 = new Article(1, "Test title 2", "Test author 2", "Test sort 2", "2019-10-03", 1243, 16, 346, "Test content 2 98797654654qw6e54r6354456254td51fv2xc1b6s5d4fy98wr7t6weq45gs1d32b1f32v1nsdf54gw6er4w9q8e78z4sd6f5a4s6d54f");
		Article article3 = new Article(2, "Test title 3", "Test author 3", "Test sort 3", "2019-10-04", 1256, 17, 347, "Test content 3");
		
		list.add(article1);
		list.add(article2);
		list.add(article3);
		
		return list;
	}
}
