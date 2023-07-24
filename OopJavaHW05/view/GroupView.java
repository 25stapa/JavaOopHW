package OopJavaHW05.view;

import OopJavaHW05.controllers.GroupController;
public class GroupView {
	private final GroupController controller;

	public GroupView(GroupController controller) {
		this.controller = controller;
	}

	public void printAllFromGroup(String groupTitle) {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("GROUP STUDENTS AND TEACHERS " + groupTitle);
		controller.getAllUsersFromGroup(groupTitle).forEach(System.out::println);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>");
	}
}