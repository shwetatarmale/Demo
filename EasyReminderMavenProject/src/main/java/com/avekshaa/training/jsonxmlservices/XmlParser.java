package com.avekshaa.training.jsonxmlservices;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.avekshaa.com.traning.jsonxmlrequest.FeedRequest;
import com.avekshaa.com.traning.jsonxmlrequest.LikedislikeRequest;
import com.avekshaa.com.traning.jsonxmlrequest.MultimediaRequest;



public class XmlParser {


		// Get Document Builder
		public void file(String un) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		// Load the input XML document, parse it and return an instance of the
		// Document class.
	
		Document document = builder.parse(new File(un));
	
		List<FeedRequest> feedList = new ArrayList<FeedRequest>();
		NodeList nodeList = document.getElementsByTagName("feeds");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
//			System.out.println(nodeList.getLength());
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) node;

				int id = Integer
						.parseInt(elem.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue());
				
				String title = elem.getElementsByTagName("title").item(0).getChildNodes().item(0).getNodeValue();
				String description = elem.getElementsByTagName("description").item(0).getChildNodes().item(0)
						.getNodeValue();
				String location = elem.getElementsByTagName("location").item(0).getChildNodes().item(0).getNodeValue();
				int lng = Integer
						.parseInt(elem.getElementsByTagName("lng").item(0).getChildNodes().item(0).getNodeValue());
				int lat = Integer
						.parseInt(elem.getElementsByTagName("lat").item(0).getChildNodes().item(0).getNodeValue());
				int userId = Integer
						.parseInt(elem.getElementsByTagName("userId").item(0).getChildNodes().item(0).getNodeValue());
				String name = elem.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
				String isdeleted = elem.getElementsByTagName("isdeleted").item(0).getChildNodes().item(0)
						.getNodeValue();
				String profilePicture = elem.getElementsByTagName("profilePicture").item(0).getChildNodes().item(0)
						.getNodeValue();
				int mediatype = Integer.parseInt(
						elem.getElementsByTagName("mediatype").item(0).getChildNodes().item(0).getNodeValue());
				int commentCount = Integer.parseInt(
						elem.getElementsByTagName("commentCount").item(0).getChildNodes().item(0).getNodeValue());
				String createdAt = elem.getElementsByTagName("createdAt").item(0).getChildNodes().item(0)
						.getNodeValue();
				int code = Integer
						.parseInt(elem.getElementsByTagName("code").item(0).getChildNodes().item(0).getNodeValue());

				List<MultimediaRequest> multimediaList = new ArrayList<MultimediaRequest>();

				NodeList nodeList2 = elem.getElementsByTagName("multiMedia");
				for (int j = 0; j < nodeList2.getLength(); j++) {
					Node node2 = nodeList2.item(j);
//                   System.out.println(nodeList2.getLength());
					MultimediaRequest elem2 = new MultimediaRequest();

					if (node2.getNodeType() == Node.ELEMENT_NODE) {
						Element elem1 = (Element) node2;

						// Get the value of the ID attribute.

						int id1 = Integer.parseInt(
								elem1.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue());
						elem2.setId(id1);
						String url = "";
						if(elem1.getElementsByTagName("url").item(0).getChildNodes().getLength() != 0) {
						 url = elem1.getElementsByTagName("url").item(0).getChildNodes().item(0)
								.getNodeValue();
						}
						int mediatype1 = Integer.parseInt(elem1.getElementsByTagName("mediatype").item(0).getChildNodes().item(0)
								.getNodeValue());
						int likeCount = Integer.parseInt(
								elem1.getElementsByTagName("likeCount").item(0).getChildNodes().item(0).getNodeValue());
						elem2.setId(id1);
				     	String createAt = elem.getElementsByTagName("createAt").item(0).getChildNodes().item(0)
		 				.getNodeValue();
				     	String name1 = elem.getElementsByTagName("name").item(0).getChildNodes().item(0)
				 				.getNodeValue();
				     	String description1 = elem.getElementsByTagName("description").item(0).getChildNodes().item(0)
				 				.getNodeValue();
						
						elem2.setUrl(url);
//						
						elem2.setMediatype(mediatype1);
						elem2.setName(name1);
						elem2.setDescription(description1);
						elem2.setLikeCount(likeCount);
						
						elem2.setCreateAt(createAt);
						multimediaList.add(elem2);
					}
				}
				List<LikedislikeRequest> likedislikeList = new ArrayList<LikedislikeRequest>();
				NodeList nodeList3 = elem.getElementsByTagName("likeDislike");
				for (int k = 0; k < nodeList3.getLength(); k++) {
					Node node3 = nodeList3.item(k);
					LikedislikeRequest elem3 = new LikedislikeRequest();
					if (node3.getNodeType() == Node.ELEMENT_NODE) {
						Element elem2 = (Element) node3;
						// Get the value of the ID attribute.
						int likes = Integer.parseInt(
								elem2.getElementsByTagName("likes").item(0).getChildNodes().item(0).getNodeValue());
						int dislikes = Integer.parseInt(
								elem2.getElementsByTagName("dislikes").item(0).getChildNodes().item(0).getNodeValue());
						int userAction = Integer.parseInt(elem2.getElementsByTagName("userAction").item(0)
								.getChildNodes().item(0).getNodeValue());
						elem3.setlike(likes);
					
						elem3.setdislike(dislikes);
						
						elem3.setlike(userAction);
						likedislikeList.add(elem3);

					}
				}

				feedList.add(new FeedRequest(id, title, description, location, lng, lat, userId, name, isdeleted,
						profilePicture, mediatype, commentCount, multimediaList, likedislikeList, createdAt, code));

			}
//			System.out.println(feedList);
		}
//		File file = new File("C:\\AVEKSHAA_PROJECTS\\MAVEN\\sample.txt");
//	      PrintStream stream = new PrintStream(file);
//	      System.setOut(stream);
	     
		System.out.println(feedList);
		}

	}
