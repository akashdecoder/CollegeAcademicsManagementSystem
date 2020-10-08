import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FacultyLoginWindow extends JFrame {
	public static String facultyname;
	private JPanel contentPane;
	private JTextField facultyName;
	private JTextField facultyPassword;

	public FacultyLoginWindow() {
		setTitle("College Academics Management System | Faculty Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 725, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(32, 268, 197, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasssword = new JLabel("Passsword");
		lblPasssword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPasssword.setBounds(32, 326, 197, 36);
		contentPane.add(lblPasssword);
		
		facultyName = new JTextField();
		facultyName.setFont(new Font("Tahoma", Font.BOLD, 18));
		facultyName.setBounds(233, 268, 364, 36);
		contentPane.add(facultyName);
		facultyName.setColumns(10);
		
		facultyPassword = new JTextField();
		facultyPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		facultyPassword.setColumns(10);
		facultyPassword.setBounds(233, 326, 364, 36);
		contentPane.add(facultyPassword);
		
		JButton facultyLoginButton = new JButton("Login");
		facultyLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from faculty_database;");
					while(res.next()) {
						if((facultyName.getText().toString().equals(res.getString("faculty_name"))) && 
								(facultyPassword.getText().toString().equals(res.getString("faculty_password")))) {
							facultyname = res.getString("faculty_name");
							FacultyDashBoard frame = new FacultyDashBoard();
							frame.setVisible(true);
							dispose();
							JOptionPane.showMessageDialog(null,"Logged in as " + res.getString("faculty_name"));
						}
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		facultyLoginButton.setBackground(new Color(173, 255, 47));
		facultyLoginButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		facultyLoginButton.setBounds(234, 431, 213, 55);
		contentPane.add(facultyLoginButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel_1.setBounds(224, 16, 201, 201);
		contentPane.add(lblNewLabel_1);
		
		JButton backtoDashBoard = new JButton("");
		backtoDashBoard.addActionListener(new ActionListener() {
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
		backtoDashBoard.setBackground(new Color(204, 102, 255));
		backtoDashBoard.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		backtoDashBoard.setBounds(9, 17, 77, 71);
		contentPane.add(backtoDashBoard);
	}
}
