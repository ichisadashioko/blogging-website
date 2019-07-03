package Models;

import java.util.*;

public class BlogPost extends Post {

	private String content;
	private String img;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String generateContentHtml() {
		StringBuilder sb = new StringBuilder("");
		if (!img.isEmpty()) {
			sb.append("<div class=\"image\"><img src=\"" + img + "\"></div></div>");
		}
		String[] ps = content.split("[\n\r]+");
		for (String p : ps) {
			sb.append("<p>" + p + "</p>");

		}
		return sb.toString();
	}
}
