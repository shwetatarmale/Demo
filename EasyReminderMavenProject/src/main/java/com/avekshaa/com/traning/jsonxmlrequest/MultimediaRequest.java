package com.avekshaa.com.traning.jsonxmlrequest;

public class MultimediaRequest {

	private int id;
	private String name;
	private String description;
	private String url;
	private int mediatype;
	private int likeCount;
	private String place;
	private String createAt;
	
	

	public MultimediaRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultimediaRequest(int id, String name, String description, String url, int mediatype, int likeCount,
			String place, String createAt) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.url = url;
		this.mediatype = mediatype;
		this.likeCount = likeCount;
		this.place = place;
		this.createAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMediatype() {
		return mediatype;
	}

	public void setMediatype(int mediatype) {
		this.mediatype = mediatype;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "MultimediaRequest [id=" + id + ", name=" + name + ", description=" + description + ", url=" + url
				+ ", mediatype=" + mediatype + ", likeCount=" + likeCount + ", place=" + place + ", createAt="
				+ createAt + "]";
	}
	

}
