package Models;

public class PhotoPost extends Post {

	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String generateContentHtml() {
		String retval = "<div class=\"img-simple\"><div class=\"image\"><img src=\"" + img + "\" alt=\"\"></div></div>";
		return retval;
	}
}
