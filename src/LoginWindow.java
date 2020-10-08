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

public class LoginWindow extends JFrame {
	public static String st_usn;
	private JPanel contentPane;
	private JTextField usn;
	private JTextField password;
	public LoginWindow() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setTitle("College Academics Management System | Student Login");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 751, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(51, 232, 142, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(51, 299, 142, 37);
		contentPane.add(lblPassword);
		
		usn = new JTextField();
		usn.setFont(new Font("Tahoma", Font.BOLD, 12));
		usn.setBounds(222, 232, 384, 37);
		contentPane.add(usn);
		usn.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
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
					ResultSet res = st.executeQuery("select * from student_database;");
					while(res.next()) {
						if((usn.getText().toString().equals(res.getString("student_usn"))) && 
								(password.getText().toString().equals(res.getString("student_password")))) {
							st_usn = res.getString("student_usn");
							StudentDashBoard frame = new StudentDashBoard();
							frame.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(null,"Logged in as " + res.getString("student_name"));
						}
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		login.setBackground(new Color(152, 251, 152));
		login.setFont(new Font("Tahoma", Font.BOLD, 22));
		login.setBounds(222, 438, 179, 53);
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
	}
}
