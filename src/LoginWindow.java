import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginWindow extends JFrame {
	public static String st_usn;
	public static String facultyname;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	public LoginWindow(String category) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		if(category.equals("Student")) {
			setTitle("College Academics Management System | Student Login");
		} else {
			setTitle("College Academics Management System | Faculty Login");
		}
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 751, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(51, 232, 142, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(51, 299, 142, 37);
		contentPane.add(lblPassword);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.BOLD, 16));
		username.setBounds(222, 232, 384, 37);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.BOLD, 16));
		password.setColumns(10);
		password.setBounds(222, 299, 384, 37);
		contentPane.add(password);
		
		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					PreparedStatement pstPreparedStatement;
					if(category.equals("Student")) {
						ResultSet res = st.executeQuery("select * from student_database;");
						while(res.next()) {
							
							if((username.getText().toString().equals(res.getString("student_usn"))) && 
									(password.getText().toString().equals(res.getString("student_password")))) {
								st_usn = res.getString("student_usn");
								java.util.Date date = new java.util.Date();
								java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
								dbo.insertIntoLogins(conn, sqlTime, st_usn);
								StudentDashBoard frame = new StudentDashBoard();
								frame.setVisible(true);
								dispose();
								JOptionPane.showMessageDialog(null,"Logged in as " + res.getString("student_name"));
							}
						}
					} else if(category.equals("Faculty")) {
						ResultSet res = st.executeQuery("select * from faculty_database;");
						while(res.next()) {
							if((username.getText().toString().equals(res.getString("faculty_name"))) && 
									(password.getText().toString().equals(res.getString("faculty_password")))) {
								facultyname = res.getString("faculty_name");
								java.util.Date date = new java.util.Date();
								java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
								dbo.insertIntoLogins(conn, sqlTime, facultyname);
								FacultyDashBoard frame = new FacultyDashBoard();
								frame.setVisible(true);
								dispose();
								JOptionPane.showMessageDialog(null,"Logged in as " + res.getString("faculty_name"));
							}
						}
					}
					
				} catch(Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		login.setBackground(new Color(152, 251, 152));
		login.setFont(new Font("Tahoma", Font.BOLD, 22));
		login.setBounds(165, 404, 179, 53);
		contentPane.add(login);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(204, 102, 255));
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		btnNewButton_1.setBounds(10, 10, 76, 73);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel_1.setBounds(261, 10, 203, 200);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Forgot Password ?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SendVerificationMail frame = new SendVerificationMail(category);
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(372, 404, 179, 53);
		contentPane.add(lblNewLabel_2);
	}
}
