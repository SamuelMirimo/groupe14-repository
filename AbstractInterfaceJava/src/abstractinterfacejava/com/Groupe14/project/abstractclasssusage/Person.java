/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractinterfacejava.com.Groupe14.project.abstractclasssusage;

import java.sql.SQLException;


public abstract class Person {   
     protected int id;
	protected String firstName;
	protected String lastName;
	
	public Person() {
	}

	public Person(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Show Person identity without connection to the DataBase
	 */
	public abstract void showIdentity();
	
	/**
	 * Show Person's identity with a connection to the DataBase by using Person ID
	 * @param id
	 * @throws SQLException
	 */
	public abstract void showDynamicIdentity(int id) throws SQLException;

	/**
	 * Insert new Person into the database by passing a Person reference (Any type of Person)
	 * @param p
	 * @return
	 * @throws SQLException
	 */
	public abstract int add(Person p) throws SQLException;
}
