package tryouts;

public class Student {
	public int id;
	public String name;

	public Student(int id, String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public boolean equals(Object m){
		if(m == null || this.getClass()!=m.getClass())
			return false;
		Student ob = (Student) m;
		return (this.id==ob.id && this.name.equals(ob.name)); 
	}
	
	@Override
	public int hashCode(){
		return id%9;
	}
}
