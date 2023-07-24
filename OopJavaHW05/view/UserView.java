package OopJavaHW05.view;

public interface UserView {
	void sendOnConsole(); //GET
	void sendOnConsole(SortType sortType); //GET
	void create(String fullName, Integer age, String phoneNumber, String groupTitle);//POST
	void removeUser(String fullName); //DELETE

}