/*
 * How Reflection Can Break the Singleton Pattern ?
		Reflection in Java allows you to inspect and manipulate classes, methods, and fields at runtime, including private members.
		By using reflection, you can access the private constructor of a Singleton class and create multiple instances, even if the
		constructor is private.

 * Breaking Singleton Using Reflection:

	1. Getting the Constructor:
		The getDeclaredConstructor() method is used to get the private constructor of the Singleton class.
	2. Accessing the Constructor:
		constructor.setAccessible(true) allows access to the private constructor by making it accessible through reflection.
	3. Creating Instances:
		constructor.newInstance() creates a new instance of the Singleton class. Even though the constructor is private and the 
		class is designed to allow only a single instance, reflection allows the creation of multiple instances.
	4. Comparison:
		Finally, we print the instances and check if they are the same using ==. Since reflection bypasses the singleton check,
		 instance1 and instance2 will refer to different objects.
 * 
 */


package com.deepu.singletondesingpattern;

import java.lang.reflect.Constructor;

public class SingletonBreakExample {

	public static void main(String[] args) throws Exception {
		
		// First, get the Singleton class or load the Singleton class
		Class<SingletonEagerInitialization> singletonClass = SingletonEagerInitialization.class;
		
		// Access the private constructor using reflection
		Constructor<SingletonEagerInitialization> constructor = singletonClass.getDeclaredConstructor();
	
		// Allow access to the private constructor
		constructor.setAccessible(true);
		
		SingletonEagerInitialization instance1 = constructor.newInstance();
		SingletonEagerInitialization instance2 = constructor.newInstance();
		
		System.out.println("Instance 1: " + instance1);
        System.out.println("Instance 2: " + instance2);
        
        System.out.println("Are the instances the same? " + (instance1 == instance2));

	}
}
