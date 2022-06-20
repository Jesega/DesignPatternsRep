package patterns.creational.singleton;

//Since implementing a singleton is easy, you have a different challenge: write a method called isSingleton().
//This method takes a factory method that returns an object and it's up to you to determine wether or not that object 
//is a singleton instanceCount

import java.util.function.Supplier;

//import org.apache.commons.lang3.SerializationUtils;

class SingletonTester
{
	public static boolean isSingleton(Supplier<Object> func)
	{
		Object instance1 = func.get();
		Object instance2 = func.get();
		
		return instance1.equals(instance2);
	}
}