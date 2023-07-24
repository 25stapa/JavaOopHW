package OopJavaHW05.services;

import OopJavaHW05.models.User;
import java.util.ArrayList;
import java.util.List;

public class GroupService {
	private final StudentService studentService;
	private final TeacherService teacherService;

	public GroupService(StudentService studentService, TeacherService teacherService) {
		this.studentService = studentService;
		this.teacherService = teacherService;
	}

	public List<User> getAllUsersFromGroup(String groupTitle) {
		List<User> users = new ArrayList<>();
		users.addAll(studentService.getAllByTitle(groupTitle));
		users.addAll(teacherService.getAllByTitle(groupTitle));

		return users;
	}
}