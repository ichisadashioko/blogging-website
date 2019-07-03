package Views;

import Models.*;
import java.util.*;

public class IndexView extends BaseView{

	private List<Post> posts;
	private List<Integer> pageCounterItems;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
}
