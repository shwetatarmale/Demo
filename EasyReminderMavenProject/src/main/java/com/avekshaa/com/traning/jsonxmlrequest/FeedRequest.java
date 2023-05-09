package com.avekshaa.com.traning.jsonxmlrequest;

import java.util.List;

//package Json_xml.Json_xml;
public class FeedRequest {

	private int id;
	private String title;
	private String description;
	private String location;
	private int lng;
	private int lat;
	private int userId;
	private String name;
	private String isdeleted;
	private String profilePicture;
	private int mediatype;
	private int commentCount;
	private List<MultimediaRequest> multiMedia;
	private List<LikedislikeRequest> likeDislike;
	private String createdAt;
	private int code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLng() {
		return lng;
	}

	public void setLng(int lng) {
		this.lng = lng;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public int getMediatype() {
		return mediatype;
	}

	public void setMediatype(int mediatype) {
		this.mediatype = mediatype;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

//	public List<MultimediaRequest> getMultimediaList() {
//		return multimediaList;
//	}

//	public void setMultimediaList(List<MultimediaRequest> multimediaList) {
//		this.multimediaList = multimediaList;
//	}
//
//	public List<LikedislikeRequest> getLikedislikeList() {
//		return likedislikeList;
//	}
//
//	public void setLikedislikeList(List<LikedislikeRequest> likedislikeList) {
//		this.likedislikeList = likedislikeList;
//	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public FeedRequest(int id, String title, String description, String location, int lng, int lat, int userId,
			String name, String isdeleted, String profilePicture, int mediatype, int commentCount,
			List<MultimediaRequest> multiMedia, List<LikedislikeRequest> likedislike, String createdAt,
			int code) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.location = location;
		this.lng = lng;
		this.lat = lat;
		this.userId = userId;
		this.name = name;
		this.isdeleted = isdeleted;
		this.profilePicture = profilePicture;
		this.mediatype = mediatype;
		this.commentCount = commentCount;
		this.multiMedia = multiMedia;
		this.likeDislike = likeDislike;
		this.createdAt = createdAt;
		this.code = code;
	}

	@Override
	public String toString() {
		return "FeedRequest [id=" + id + ", title=" + title + ", description=" + description + ", location=" + location
				+ ", lng=" + lng + ", lat=" + lat + ", userId=" + userId + ", name=" + name + ", isdeleted=" + isdeleted
				+ ", profilePicture=" + profilePicture + ", mediatype=" + mediatype + ", commentCount=" + commentCount
				+ ",  createdAt=" + createdAt + ", code=" + code + ",multimediaList=" + multiMedia + ", likedislikeList=" + likeDislike + "]"; 
//				+ getId() + ", getTitle()=" + getTitle()
//				+ ", getDescription()=" + getDescription() + ", getLocation()=" + getLocation() + ", getLng()="
//				+ getLng() + ", getLat()=" + getLat() + ", getUserId()=" + getUserId() + ", getName()=" + getName()
//				+ ", getIsdeleted()=" + getIsdeleted() + ", getProfilePicture()=" + getProfilePicture()
//				+ ", getMediatype()=" + getMediatype() + ", getCommentCount()=" + getCommentCount()
//				+ ", getMultimediaList()=" + getMultimediaList() + ", getLikedislikeList()=" + getLikedislikeList()
//				+ ", getCreatedAt()=" + getCreatedAt() + ", getCode()=" + getCode() + ", getClass()=" + getClass()
//				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public List<MultimediaRequest> getMultiMedia() {
		return multiMedia;
	}

	public void setMultiMedia(List<MultimediaRequest> multiMedia) {
		this.multiMedia = multiMedia;
	}

	public List<LikedislikeRequest> getLikeDislike() {
		return likeDislike;
	}

	public void setLikeDislike(List<LikedislikeRequest> likeDislike) {
		this.likeDislike = likeDislike;
	}

}
