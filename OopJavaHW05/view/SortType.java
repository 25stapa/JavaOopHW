package OopJavaHW05.view;

public enum SortType {
	NONE("Default sort"),
	NAME("Sort by name"),
	ID("Sort by id");

	private final String sortName;

	@Override
	public String toString() {
		return sortName;
	}

	SortType(String sortName) {
		this.sortName = sortName;
	}

    /*    String NONE = "NONE";
    String NAME = "NAME";
    String ID = "ID";*/
}