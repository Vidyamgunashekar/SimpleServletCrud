package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.entity.Employee;
import com.nt.utilities.ConnectionFactory;

public class EmpDao {

	public boolean register(Employee e) {
		try {
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getAge());

			int result = ps.executeUpdate();
			if (result == 1)
				return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;

	}

	public boolean update(int id, int age) {
		try {
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement("update emp set age=? where id=?");
			ps.setInt(1, age);
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			if (result == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Employee selectById(int id) {
		try {
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement("select * from emp where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int i = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				return new Employee(i, name, age);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<Employee> allRecords() {
		List<Employee> list = new ArrayList<>();
		try {
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement("select * from emp");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int i = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Employee e = new Employee(i, name, age);
				list.add(e);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean delete(int id) {
		try {
			Connection con = ConnectionFactory.getCon();
			PreparedStatement ps = con.prepareStatement("delete from emp where id=?");
			ps.setInt(1, id);
			int rs = ps.executeUpdate();
			if (rs == 1)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
