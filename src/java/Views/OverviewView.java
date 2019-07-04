package Views;

import java.util.*;
import Models.*;

public class OverviewView extends BaseView {

	private List<MonthlyEntry> entryList;
	private int numPages;
	private int pageNum;

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<MonthlyEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(List<MonthlyEntry> entryList) {
		this.entryList = entryList;
	}

}
