package patterns.creational.factories;

class Person
{
	public int id;
	public String name;

	public Person(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
}

class PersonFactory
{
	static int idCount = 0;

	public Person createPerson(String name)
	{
		return(new Person(idCount++, name));
	}
}

class Demo{
	public static void main(String[] args) {

	}
}