package com.avekshaa.com.traning.jsonxmlrequest;

public class LikedislikeRequest {
	private int like;
	private int dislike;
	private int userAction;
	
	

	public LikedislikeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LikedislikeRequest(int like, int dislike, int userAction) {

		this.like = like;
		this.dislike = dislike;
		this.userAction = userAction;

	}

	public int getlike() {
		return like;
	}

	public void setlike(int like) {
		this.like = like;
	}

	public int getdislike() {
		return dislike;
	}

	public void setdislike(int dislike) {
		this.dislike = dislike;
	}

	public int getuserAction() {
		return userAction;
	}

	public void setuserAction(int userAction) {
		this.userAction = userAction;
	}

	@Override
	public String toString() {
		return "LikedislikeRequest [like=" + like + ", dislike=" + dislike + ", userAction=" + userAction + "]";
	}
	
}