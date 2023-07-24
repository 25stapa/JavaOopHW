package OopJavaHW05.view;

import OopJavaHW05.controllers.UserController;
import OopJavaHW05.models.User;

import java.util.List;

public class AllUsersView<T extends User> implements UserView {

	private final UserController<T> controller;

	public AllUsersView(UserController<T> controller) {
		this.controller = controller;
	}

	public void sendOnConsole() {
		sendOnConsole(SortType.NONE);
	}

	@Override
	public void sendOnConsole(SortType sortType) {


		List<T> users = switch (sortType) {
			case NONE -> controller.getAll();
			case NAME -> controller.getAllSortByFullName();
			case ID -> controller.getAllSortById();
		};

		if (users == null || users.size() == 0) {
			System.out.println("There is no data to output");
			return;
		}

		System.out.println("===================================");
		System.out.println("Used for withdrawal " + sortType);
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        students.forEach((student) -> System.out.println(student));
		users.forEach(System.out::println);
		System.out.println("===================================");
	}

	@Override
	public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
		controller.create(fullName, age, phoneNumber, groupTitle);
	}

	@Override
	public void removeUser(String fullName) {
		int removeCount = controller.remove(fullName);

		if (removeCount == 0) {
			System.out.println("Removal failed.");
		} else {
			System.out.println("Persons removed: " + removeCount);
		}

	}
}