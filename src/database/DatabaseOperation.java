package database;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
public class DatabaseOperation {

	public Connection getConnection(String url, String userName, String userPassword) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, userPassword);
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		return conn;
	}
	
	public int insertIntoStudentDatabase(Connection conn, String name, String usn, String email, String password) {
		int status = 0;
		String branchCode[] = {"CS", "EC", "IS", "EI", "EE", "ME"};
		String branchArray[] = {"Computer Science Engineering",
								"Electronics Communication Engineering",
								"Informtaion Science Engineering",
								"Electronics Instrumentation Engineering",
								"Electrical Electronics Engineering",
								"Mechanical Engineering"};
		String branch = null;
		int year, student_year;
		PreparedStatement pst;
		try {
			for(int i=0;i<branchCode.length;i++) {
				if(usn.substring(5, 7).equalsIgnoreCase(branchCode[i])) {
					branch = branchArray[i];
				}
			}
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			year = localDate.getYear();
			String usn_date = "20"+usn.substring(3,5);
			if(Integer.parseInt(usn_date) == year) {
				student_year = 1;
			} else {
				student_year = year - Integer.parseInt(usn_date) + 1;
			}
			pst = conn.prepareStatement("insert into student_database (student_name, student_usn, student_branch, student_year, student_email,"
					+ "student_password) values (?, ?, ?, ?, ?, ?);");
			pst.setString(1, name);
			pst.setString(2, usn);
			pst.setString(3, branch);
			pst.setInt(4, student_year);
			pst.setString(5, email);
			pst.setString(6, password);
			status = pst.executeUpdate();
			System.out.println("Inserted Successfully");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		return status;
	}
	
	public int insertIntoFacultyDatabase(Connection conn, String name, String branch, String yearOfJoining, String speciality,
			String degree, String designation, String email, String password) {
		int status = 0;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("insert into faculty_database (faculty_name,"
					+ "faculty_branch,"
					+ "year_of_joining,"
					+ "speciality,"
					+ "degree,"
					+ "designation,"
					+ "faculty_email,"
					+ "faculty_password) values (?, ?, ?, ?, ?, ?, ?, ?);");
			pst.setString(1, name);
			pst.setString(2, branch);
			pst.setString(3, yearOfJoining);
			pst.setString(4, speciality);
			pst.setString(5, degree);
			pst.setString(6, designation);
			pst.setString(7, email);
			pst.setString(8, password);
			status = pst.executeUpdate();
			System.out.println("Inserted Successfully");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		return status;
	}
	
	public int uploadPaper(Connection conn, String name, FileReader file, java.sql.Date date, Timestamp time) {
		int status = 0;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("insert into faculty_upload_papers (name, "
					+ "file, date, time) values(?, ?, ?, ?)");
			pst.setString(1, name);
			pst.setCharacterStream(2, file);
			pst.setDate(3, date);
			pst.setTimestamp(4, time);
			status = pst.executeUpdate();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return status;
	}
	
	public int uploadNotes(Connection conn, String name, FileReader file, java.sql.Date date, Timestamp time) {
		int status = 0;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("insert into faculty_upload_notes (name, "
					+ "note_file, date, time) values(?, ?, ?, ?)");
			pst.setString(1, name);
			pst.setCharacterStream(2, file);
			pst.setDate(3, date);
			pst.setTimestamp(4, time);
			status = pst.executeUpdate();
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return status;
	}
	
	public int updateFacultyProfile(Connection conn, String name_to_update,  String name, String branch, String yearOfJoining, String speciality,
			String degree, String designation, String email, String password) {
		
		int status = 0;
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement("update faculty_database "
					+ "set faculty_name = ?, "
					+ "faculty_branch = ?, "
					+ "year_of_joining = ?, "
					+ "speciality = ?, "
					+ "degree = ?, "
					+ "designation = ?, "
					+ "faculty_email = ?, "
					+ "faculty_password = ? "
					+ "where faculty_name = ?;");
			pst.setString(1, name);
			pst.setString(2, branch);
			pst.setString(3, yearOfJoining);
			pst.setString(4, speciality);
			pst.setString(5, degree);
			pst.setString(6, designation);
			pst.setString(7, email);
			pst.setString(8, password);
			pst.setString(9, name_to_update);
			status = pst.executeUpdate();
		} catch (SQLException exp) {
			exp.printStackTrace();
		}
		return status;
	}
	
	public int updateStudentProfile(Connection conn, String profile_to_update, 
			String name, String usn, String email, String password) {
		int status = 0;
		String branchCode[] = {"CS", "EC", "IS", "EI", "EE", "ME"};
		String branchArray[] = {"Computer Science Engineering",
								"Electronics Communication Engineering",
								"Informtaion Science Engineering",
								"Electronics Instrumentation Engineering",
								"Electrical Electronics Engineering",
								"Mechanical Engineering"};
		String branch = null;
		int year, student_year;
		PreparedStatement pst;
		try {
			for(int i=0;i<branchCode.length;i++) {
				if(usn.substring(5, 7).equalsIgnoreCase(branchCode[i])) {
					branch = branchArray[i];
				}
			}
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			year = localDate.getYear();
			String usn_date = "20"+usn.substring(3,5);
			if(Integer.parseInt(usn_date) == year) {
				student_year = 1;
			} else {
				student_year = year - Integer.parseInt(usn_date) + 1;
			}
			pst = conn.prepareStatement("update student_database "
					+ "set student_name = ?, "
					+ "student_usn = ?, "
					+ "student_branch = ?, "
					+ "student_year = ?, "
					+ "student_email = ?, "
					+ "student_password = ? where student_usn = ?;");
			pst.setString(1, name);
			pst.setString(2, usn);
			pst.setString(3, branch);
			pst.setInt(4, student_year);
			pst.setString(5, email);
			pst.setString(6, password);
			pst.setString(7, profile_to_update);
			status = pst.executeUpdate();
			System.out.println("Updated Successfully");
		}catch(Exception exp) {
			exp.printStackTrace();
		}
		return status;
	}
}
