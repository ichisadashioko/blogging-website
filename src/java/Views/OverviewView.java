package Views;

import java.util.*;
import Models.*;

public class OverviewView extends BaseView {

	private List<MonthlyEntry> entryList;

	public List<MonthlyEntry> getEntryList() {
		return entryList;
	}

	public void setEntryList(List<MonthlyEntry> entryList) {
		this.entryList = entryList;
	}

}
