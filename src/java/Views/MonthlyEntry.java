package Views;
import java.util.*;
import Models.*;

public class MonthlyEntry {
	private String timestamp;
	private List<Post> postList;

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}
}
