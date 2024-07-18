package base;

public enum SortItemsBy {

	RELEVANCE("Relevance"), 
	POPULARITY("Popularity"), 
	LOW_TO_HIGH("Price -- Low to High"),
	HIGH_TO_LOW("Price -- High to Low"),
	NEWEST_FIRST("Newest First");

	private String displayName;

	SortItemsBy(String displayName) {
		this.displayName = displayName;
	}

	public String displayName() {
		return displayName;
	}

	@Override
	public String toString() {
		return displayName;
	}
}
