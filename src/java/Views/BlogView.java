package Views;

import Models.*;
import java.util.*;

public class BlogView extends BaseView {

	private Post post;

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
