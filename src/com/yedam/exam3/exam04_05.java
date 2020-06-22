package com.yedam.exam3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;








public class exam04_05 {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		Connection conn = getConnect();
		
		try {
			String sql = "select first_name, last_name, salary from employees";
			ResultSet rs = conn.prepareStatement(sql).executeQuery();
			while(rs.next()) {
				employees.add(new Employee(rs.getString("first_name"),
										   rs.getString("last_name"), 
										   rs.getInt("salary")
				));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 문제 4
		System.out.println("----------문제4----------");
		employees.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		})
			.map(t -> t.getFirstName())
			.filter(t -> t.startsWith("S"))		
			.forEach(s -> System.out.println(s));
		
		// first_name "S"로 시작하는 사원 수
		long cnt = employees.stream()
				.map(t -> t.getFirstName())
				.filter(t -> t.startsWith("S"))
				.count();
		System.out.println("인원수 : " + cnt );
		
		//문제 5
		// 5000미만인 사람들에 대해서 급여와 이름을 출력하고 합계를 구하는 프로그램
		
		System.out.println("----------문제5----------");
		employees.stream().sorted(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}
		})
		.filter(n -> n.getSalary() < 5000)
		.forEach(s -> System.out.println("이름 :" + s.getFirstName()+ " 급여 : " + s.getSalary()));
				 
	
		int result = employees.stream()
				.filter(n -> n.getSalary() < 5000)
				.mapToInt(s -> s.getSalary())
				.reduce(0, new IntBinaryOperator() {
					@Override
					public int applyAsInt(int left, int right) {
						return left + right; 
					}
				});
		System.out.println(" 결과 : " + result);
		
	}
	public static Connection getConnect() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hr", "hr");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

class Employee {
	private String firstName;
	private String lastName;
	private int salary;

	public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getSalary() {
		return salary;
	}

}

