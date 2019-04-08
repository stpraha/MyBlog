package cxd.blog.model;

public class Comment {
	private int commentId;
	private String commenderNickName;
	private String commenderEmail;
	private String commentContent;
	private int commentArticleId;
	private String commentArticleTitle;
	private String commentTime;
	
	public Comment() {
		
	}
	
	public Comment(int id, String commenderNickNama, String commenderEmail, String commentContent, int commentArticleId, String commentArticleTitle, String commentTime) {
		super();
		this.commentId = id;
		this.commenderNickName = commenderNickNama;
		this.commenderEmail = commenderEmail;
		this.commentContent = commentContent;
		this.commentArticleId = commentArticleId;
		this.commentArticleTitle = commentArticleTitle;
		this.commentTime = commentTime;
	}
	

	public String getCommenderNickName () {
		return commenderNickName;
	}
	public String getCommenderEmail() {
		return commenderEmail;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public int getCommentId() {
		return commentId;
	}
	public int getCommentArticleId() {
		return commentArticleId;
	}
	public String getCommentArticleTitle() {
		return commentArticleTitle;
	}
	public String getCommentTime() {
		return commentTime;
	}
	
	public void setCommenderNickName(String commenderNickName) {
		this.commenderNickName = commenderNickName;
	}
	public void setCommenderEmail(String commenderEmail) {
		this.commenderEmail = commenderEmail;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public void setCommentArticleId(int commentArticleId) {
		this.commentArticleId = commentArticleId;
	}
	public void setCommentArticleTitle(String commentArticleTitle) {
		this.commentArticleTitle = commentArticleTitle;
	}
	public void setCommentTime(String commentArticleTitle) {
		this.commentTime = commentTime;
	}
}
