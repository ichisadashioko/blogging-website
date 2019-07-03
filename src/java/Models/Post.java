package Models;

import java.util.*;
import Utils.*;

public abstract class Post {

	private int id;
	private String heading;
	private String iconClass;
	private Date dc;

	public abstract String generateContentHtml();

	public String getDate() {
		return BlogUtils.formatDate(dc);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public Date getDc() {
		return dc;
	}

	public void setDc(Date dc) {
		this.dc = dc;
	}

	public String getIconClass() {
		return iconClass;
	}

	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
}
