package Models;

import java.util.*;

public class QuotePost extends Post {

	private String quote;
	private String author;

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String generateContentHtml() {
		StringBuilder sb = new StringBuilder("");
		sb.append("<blockquote class=\"pull-right\"><p>");
		String quoteHtml = quote.replaceAll("[\n\r]+", "<br>");
		sb.append(quoteHtml);
		quoteHtml = "</p><small><cite>" + author + "</cite></small></blockquote>";
		sb.append(quoteHtml);
		String retval = sb.toString();
//		System.out.println(retval);
		return retval;
	}

}
