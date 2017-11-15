package de.fhac.rn.fragen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private static final File FILE = new File("person.ser");

	// Constructor
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	public static void main(String[] args) throws Exception {
		save();
		loadAndShow();
	}

	public static void save() throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
		oos.writeObject(new Person("Uwe", "Duwe"));
		oos.close();
	}

	private static void loadAndShow() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
		System.out.println((Person) ois.readObject());
		ois.close();
	}

}
