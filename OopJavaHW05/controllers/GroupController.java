package OopJavaHW05.controllers;

import OopJavaHW05.models.User;
import OopJavaHW05.services.GroupService;

import java.util.List;

public class GroupController {
	private final GroupService groupService;

	public GroupController(GroupService groupService) {
		this.groupService = groupService;
	}

	public List<User> getAllUsersFromGroup(String groupTitle) {
		return groupService.getAllUsersFromGroup(groupTitle);
	}
}