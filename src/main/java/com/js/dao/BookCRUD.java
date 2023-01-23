package com.js.dao;

import java.sql.Connection; //statement is a parent interface and prepareStatement is child interface of statement 
import java.sql.DriverManager; // it is used for dynamic operation and we have delimeteres or placeholder for insertion
import java.sql.PreparedStatement; //of values to the table dynamically.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.js.dto.Book;

public class BookCRUD {
	final static String path = "com.mysql.cj.jdbc.Driver";
	final static String address = "jdbc:mysql://localhost:3306/book_store?user=root&password=Manoj@195";
	static Connection c;

	public int insertBook(Book b) {

		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("insert into book values(?,?,?,?,?)");
			ps.setInt(1, b.getBook_id());
			ps.setString(2, b.getBook_name());
			ps.setString(3, b.getAuthor_name());
			ps.setInt(4, b.getPages());
			ps.setDouble(5, b.getPrice());
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int deleteBook(int id) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement pr = c.prepareStatement("delete from Book where book_id=?");
			pr.setInt(1, id);
			return pr.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int updateBook(int id, Book b) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement pt = c.prepareStatement("update book set book_name=?,author_name=?,pages=?,price=? where book_id=?");
			pt.setString(1, b.getBook_name());
			pt.setString(2, b.getAuthor_name());
			pt.setInt(3, b.getPages());
			pt.setDouble(4, b.getPrice());
			pt.setInt(5, id);
			return pt.executeUpdate();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Book getBookById(int id) {
		Book b = null;
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from book where book_id=?");
			ps.setInt(1, id);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				b = new Book();
				b.setBook_id(res.getInt(1));
				b.setBook_name(res.getString(2));
				b.setAuthor_name(res.getString(3));
				b.setPages(res.getInt(4));
				b.setPrice(res.getDouble(5));
				return b;
			} else
				return b;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;

	}

	public ArrayList<Book> getAllBooks() {
		ArrayList<Book> al = new ArrayList<Book>();
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("select * from book");
			ResultSet res = ps.executeQuery();
			while (res.next()) {
				Book b = new Book();
				b.setBook_id(res.getInt(1));
				b.setBook_name(res.getString(2));
				b.setAuthor_name(res.getString(3));
				b.setPages(res.getInt(4));
				b.setPrice(res.getDouble(5));
				al.add(b);
			}
			return al;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return al;
	}

	public boolean batchExecution(ArrayList<Book> books) {
		try {
			Class.forName(path);
			c = DriverManager.getConnection(address);
			PreparedStatement ps = c.prepareStatement("insert into book values(?,?,?,?,?)");
			for (Book book : books) {
				ps.setInt(1, book.getBook_id());
				ps.setString(2, book.getBook_name());
				ps.setString(3, book.getAuthor_name());
				ps.setInt(4, book.getPages());
				ps.setDouble(5, book.getPrice());
				ps.addBatch();
			}
			ps.executeBatch();
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;

	}
}
