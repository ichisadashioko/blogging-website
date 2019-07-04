
import java.sql.*;
import java.util.*;
import Models.*;
import DAO.*;
import Utils.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// us-123my-life.simplesite.com
		populateBlogPosts(100);

	}

	public static final char[] subset = "0123456789abcdefghijklmnopqrstuvwxyz ".toCharArray();

	public static Random r = new Random();

	public static String randomString(int length) {
		char buf[] = new char[length];
		for (int i = 0; i < buf.length; i++) {
			int index = r.nextInt(subset.length);
			buf[i] = subset[index];
		}
		return new String(buf);
	}

	public static void populateBlogPosts(int size) throws Exception {
		for (int i = 0; i < size; i++) {
			// year between 2000 and 2010
			// month between 1 and 12
			// date between 1 and 28
			// blog type ['article', 'photo', 'quote']
			String[] blogTypes = {"article", "photo", "quote"};
			String[] images = {
				"images/test_images/asuw.png",
				"images/test_images/chal.png",
				"images/test_images/chal_swim.png",
				"images/test_images/asuw.png",
				"images/test_images/chal_swim-closeup.png",
				"images/test_images/chal-closeup.png",};
			// 1. blog type
			int blogIdx = r.nextInt(blogTypes.length);
			String blogType = blogTypes[blogIdx];
			// 2. title
			String title = randomString(32);
			// 3. year/month/date
			int year = 2000 + r.nextInt(10);
			int month = 1 + r.nextInt(12);
			int date = 1 + r.nextInt(28);
			String datetimeStr = String.format("%04d%02d%02d", year, month, date);
			// 4. random more info base on the blog type
			if (blogIdx == 0) {
				BlogPost p = new BlogPost();
				p.setHeading(title);

				// 4.1 random content
				String content = randomString(200);
				p.setContent(content);
				// 4.2 random has image
				boolean hasImage = r.nextBoolean();

				if (hasImage) {
					// 4.2.1 random image
					p.setImg(images[r.nextInt(images.length)]);
				}
				BlogPostDAO.insertPost(p, datetimeStr);
			} else if (blogIdx == 1) {
				PhotoPost p = new PhotoPost();
				p.setHeading(title);
				// 4.3 random image
				p.setImg(images[r.nextInt(images.length)]);
				BlogPostDAO.insertPost(p, datetimeStr);
			} else if (blogIdx == 2) {
				int quoteLength = 1 + r.nextInt(10);
				String quote = randomString(48);
				for(int j = 0; j < quoteLength; j++){
					quote += "\n";
					quote += randomString(48);
				}
				
				QuotePost p = new QuotePost();
				p.setHeading(title);
				p.setQuote(quote);
				p.setAuthor(randomString(10));
				BlogPostDAO.insertPost(p, datetimeStr);
			}
		}
	}
}
