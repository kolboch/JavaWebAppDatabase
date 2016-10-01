package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import beans.User_account;

public class DatabaseUtils {
	
	private static final String PRODUCT_TABLE_NAME = "product";
	private static final String USER_ACCOUNT_TABLE_NAME = "user_account";
	
	public static User_account findUser(Connection conn, String userName, String password) throws SQLException{
		String sql = "SELECT a.user_name, a.password, a.gender FROM " + USER_ACCOUNT_TABLE_NAME  + " a" 
				+ " WHERE a.user_name = ? and a.password = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1, userName);
		prepStmt.setString(2, password);
		ResultSet rs = prepStmt.executeQuery();	
		
		if(rs.next()){
			String gender = rs.getString("gender");
			User_account user = new User_account();
			user.setUser_name(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
	
	public static User_account findUser(Connection conn, String userName) throws SQLException{
		String sql = "SELECT a.user_name, a.password, a.gender FROM " + USER_ACCOUNT_TABLE_NAME  + " a"
				+ " WHERE a.user_name = ?";
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		prepStmt.setString(1,  userName);
		ResultSet rs = prepStmt.executeQuery();
		if(rs.next()){
			String gender = rs.getString("gender");
			String password = rs.getString("password");
			User_account u = new User_account();
			u.setGender(gender);
			u.setPassword(password);
			u.setUser_name(userName);
			return u;
		}
		return null;
	}
	
	public static List<Product> queryProduct(Connection conn) throws SQLException{
		String query = "SELECT a.code, a.name, a.price FROM "+ PRODUCT_TABLE_NAME +" a";
		PreparedStatement prstmt = conn.prepareStatement(query);
		
		ResultSet rs = prstmt.executeQuery();
		List<Product> allProducts = new ArrayList<>();
		String code;
		String name;
		float price;
		while(rs.next()){
			code = rs.getString("code");
			name = rs.getString("name");
			price = rs.getFloat("price");
			Product p = new Product();
			p.setCode(code);
			p.setPrice(price);
			p.setName(name);
			allProducts.add(p);
		}
		return allProducts;
	}
	
	public static Product findProduct(Connection conn, String code) throws SQLException{
		String query = "SELECT a.code, a.name, a.price FROM "+ PRODUCT_TABLE_NAME +" a WHERE a.code = ?";
		PreparedStatement prStmt = conn.prepareStatement(query);
		prStmt.setString(1, code);
		
		ResultSet rs = prStmt.executeQuery();
		while(rs.next()){
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			Product p = new Product(code, name, price);
			return p;
		}
		return null;
	}
	
	public static void updateProduct(Connection conn, Product product) throws SQLException{
		String query = "UPDATE " + PRODUCT_TABLE_NAME + " set name = ?, price = ? WHERE code = ?";
		
		PreparedStatement prStmt = conn.prepareStatement(query);
		prStmt.setString(1, product.getName());
		prStmt.setFloat(2, product.getPrice());
		prStmt.setString(3, product.getCode());
		
		prStmt.executeUpdate();
	}
	
	public static void insertProduct(Connection conn, Product product) throws SQLException{
		String query = "INSERT INTO " + PRODUCT_TABLE_NAME + "(code, name, price)  values(?,?,?)";
		PreparedStatement prStmt = conn.prepareStatement(query);
		
		prStmt.setString(1, product.getCode());
		prStmt.setString(2, product.getName());
		prStmt.setFloat(3, product.getPrice());
		
		prStmt.executeUpdate();
	}
	
	public static void deleteProduct(Connection conn, String code) throws SQLException{
		String query = "DELETE FROM "+ PRODUCT_TABLE_NAME +" a WHERE a.code = ?";
		PreparedStatement prStmt = conn.prepareStatement(query);
		prStmt.setString(1, code);
		prStmt.executeUpdate();
	}
	
}
