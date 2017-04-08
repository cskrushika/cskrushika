package tryouts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashCodeAndEquals {

	public static void main(String[] args) {
		Student s1 = new Student(3, "IS");
		Student s2 = new Student(35, "CS");

		Map<String, Student> students = new HashMap<String, Student>();
		students.put("sri", s2);
		students.put("sri", s1);

		for (String key : students.keySet()) {
			System.out.println("Name: " + key + " ID: " + students.get(key).id + " Branch: " + students.get(key).name);
		}
	}
}
