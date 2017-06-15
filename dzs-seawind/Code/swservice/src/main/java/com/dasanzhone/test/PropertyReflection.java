package com.dasanzhone.test;

import java.lang.reflect.Field;

public class PropertyReflection {

	private int salary;
	private String firstname;

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public static boolean set(Object object, String fieldName, Object fieldValue) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				field.set(object, fieldValue);
				return true;
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public static <V> V get(Object object, String fieldName) {
		Class<?> clazz = object.getClass();
		while (clazz != null) {
			try {
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				return (V) field.get(object);
			} catch (NoSuchFieldException e) {
				clazz = clazz.getSuperclass();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("com.dasanzhone.test.PropertyReflection");
		Object instance = clazz.newInstance();
		set(instance, "salary", 15);
		set(instance, "firstname", "John");

		int salary = get(instance, "salary");
		String firstname = get(instance, "firstname");

		System.out.println("salary = " + salary + "; firstname = " + firstname);

		getProperties();
	}

	public static void getProperties() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName("com.dasanzhone.test.PropertyReflection");
		Object instance = clazz.newInstance();
		int salary = get(instance, "salary");
		String firstname = get(instance, "firstname");

		System.out.println("salary = " + salary + "; firstname = " + firstname);
	}

}
