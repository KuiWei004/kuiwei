package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import entity.Address;

public class AddressDao {
	public void add(Address address) {
		try {
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement pstmt= conn.prepareStatement("insert into address(name,street,city,state,zip) values(?,?,?,?,?)");
			pstmt.setString(1,address.getName());
			pstmt.setString(2,address.getStreet());
			pstmt.setString(3,address.getCity());
			pstmt.setString(4,address.getState());
			pstmt.setString(5,address.getZip());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void delete(int id){
		try {
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement pstmt= conn.prepareStatement("delete from address where id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt, conn);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void update(Address address) {
		try {
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement pstmt= conn.prepareStatement("update address set name=?,street=?,city=?,state=?,zip=? where id=?");
			pstmt.setString(1,address.getName());
			pstmt.setString(2,address.getStreet());
			pstmt.setString(3,address.getCity());
			pstmt.setString(4,address.getState());
			pstmt.setString(5,address.getZip());
			pstmt.setInt(6,address.getId());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Address> findAll() {
		List<Address> list=new ArrayList<Address>();//list是基于对象位置的，保存的是对象地址信息
		try {
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement pstmt= conn.prepareStatement("select * from address");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Address address=new Address();
				address.setId(rs.getInt("id"));
				address.setName(rs.getString("name"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setZip(rs.getString("zip"));
				list.add(address);
			}
			JdbcUtil.close(rs,pstmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public Address findById(int id) {
		Address address=new Address();//list是基于对象位置的，保存的是对象地址信息
		try {
			Connection conn=JdbcUtil.getConnection();
			PreparedStatement pstmt= conn.prepareStatement("select * from address where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				address.setId(rs.getInt("id"));
				address.setName(rs.getString("name"));
				address.setStreet(rs.getString("street"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setZip(rs.getString("zip"));
			}
			JdbcUtil.close(rs,pstmt, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
		
	}
}
