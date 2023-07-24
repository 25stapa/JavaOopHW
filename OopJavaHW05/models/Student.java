package OopJavaHW05.models;

public class Student extends User{
	public Student(String fullName, Integer age, String phoneNumber, String groupTitle) {
		super(fullName, age, phoneNumber, groupTitle);
	}

	@Override
	public String toString() {
		return String.format("Student has the following properties: " +
						"id: %s, name %s, age %s, phone number %s, group %s",
				getId(),
				getFullName(), getAge(), getPhoneNumber(), getGroupTitle());
	}
}