package OopJavaHW05;

import OopJavaHW05.controllers.*;
import OopJavaHW05.models.*;
import OopJavaHW05.repositories.AllUserRepository;
import OopJavaHW05.services.*;
import OopJavaHW05.view.AllUsersView;
import OopJavaHW05.view.GroupView;


import java.util.Scanner;

public class UniversityApp {
	private static AllUserRepository studentRepository;
	private static StudentService studentService;
	private static TeacherService teacherService;

	private final AllUsersView<Student> studentView;
	private final AllUsersView teacherView;
	private final GroupView groupView;

	private static final String EXIT_COMMAND = "exit";


	public UniversityApp() {

		studentView = getStudentController();
		teacherView = getTeacherController();
		groupView = getGroupView();

	}

	public void run() {


		boolean running = true;
		Scanner scanner = new Scanner(System.in);

		while (running) {
			System.out.print("Enter command: ");
			String command = scanner.nextLine().trim();
			if (command.equalsIgnoreCase(EXIT_COMMAND)) {
				running = false;
			} else {
				processCommand(command);
			}
		}
		scanner.close();
	}

	private void processCommand(String command) {
		String[] parts = command.split("\\s+");
		String operation = parts[0];
		switch (operation) {
			case "create-student" -> {
				if (parts.length != 5) {
					System.out.println("Incorrect number of arguments to create a student");
				} else {
					String fullName = parts[1].replace("_", " ");
					int age = Integer.parseInt(parts[2]);
					String id = parts[3];
					String group = parts[4];
					studentView.create(fullName, age, id, group);
				}
			}
			case "create-teacher" -> {
				if (parts.length != 5) {
					System.out.println("Incorrect number of arguments for teacher creation");
				} else {
					String fullName = parts[1].replace("_", " ");
					int age = Integer.parseInt(parts[2]);
					String id = parts[3];
					String department = parts[4];
					teacherView.create(fullName, age, id, department);
				}
			}
			case "get-student" -> studentView.sendOnConsole();
			case "get-teacher" -> teacherView.sendOnConsole();
			case "remove-student" -> {
				if (parts.length != 2) {
					System.out.println("Incorrect number of arguments to remove a student");
				} else {
					String fullName = parts[1].replace("_", " ");
					studentView.removeUser(fullName);
				}
			}
			case "remove-teacher" -> {
				if (parts.length != 2) {
					System.out.println("Incorrect number of arguments for deleting a teacher");
				} else {
					String fullName = parts[1].replace("_", " ");
					teacherView.removeUser(fullName);
				}
			}
			case "get-group" -> {
				if (parts.length != 2) {
					System.out.println("Incorrect number of arguments for group output");
				} else {
					String group = parts[1];
					groupView.printAllFromGroup(group);
				}
			}
			default -> System.out.println("Unknown input command");
		}
	}


	private static AllUsersView<Student> getStudentController() {
		AllUserRepository<Student> studentRepository = new AllUserRepository<>();
		studentService = new StudentService(studentRepository);
		StudentController studentController = new StudentController(studentService);
		return new AllUsersView<>(studentController);

	}

	private static AllUsersView getTeacherController() {
		AllUserRepository<Teacher> teacherRepository = new AllUserRepository<>();
		teacherService = new TeacherService(teacherRepository);
		TeacherController teacherController = new TeacherController(teacherService);
		return new AllUsersView<>(teacherController);
	}

	private static GroupView getGroupView() {
		GroupService groupService = new GroupService(studentService, teacherService);
		GroupController groupController = new GroupController(groupService);
		return new GroupView(groupController);
	}
}