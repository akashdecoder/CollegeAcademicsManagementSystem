import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.*;

public class ExamRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField usn;
	private JTextField branch;
	private JTextField year;
	private JTextField textField_4;
	private JTextField fees;
	public ExamRegistration() {
		setTitle("College Academics Management System | Exam Registration");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setBackground(new Color(255, 248, 220));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1174, 727);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 260, 150, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsn.setBounds(33, 319, 150, 27);
		contentPane.add(lblUsn);
		
		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(33, 371, 150, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Year");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(33, 426, 150, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Semester");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(33, 478, 150, 27);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fees");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(33, 530, 150, 27);
		contentPane.add(lblNewLabel_5);
		
		name = new JTextField();
		name.setBounds(295, 260, 551, 27);
		contentPane.add(name);
		name.setColumns(10);
		
		usn = new JTextField();
		usn.setColumns(10);
		usn.setBounds(295, 319, 551, 27);
		contentPane.add(usn);
		
		branch = new JTextField();
		branch.setBackground(new Color(255, 255, 255));
		branch.setEditable(false);
		branch.setColumns(10);
		branch.setBounds(295, 371, 551, 27);
		contentPane.add(branch);
		
		year = new JTextField();
		year.setBackground(new Color(255, 255, 255));
		year.setEditable(false);
		year.setColumns(10);
		year.setBounds(295, 426, 551, 27);
		contentPane.add(year);
		
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 255, 255));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(295, 478, 551, 27);
		contentPane.add(textField_4);
		
		fees = new JTextField();
		fees.setBackground(new Color(255, 255, 255));
		fees.setEditable(false);
		fees.setColumns(10);
		fees.setBounds(295, 530, 551, 27);
		contentPane.add(fees);
		JButton connect = new JButton("Connect");
		connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					String Usn = usn.getText().toString();
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from student_database;");
					while(res.next()) {
						if(Usn.equals(res.getString("student_usn"))) {
							branch.setText(res.getString("student_branch"));
							year.setText(Integer.toString(res.getInt("student_year")));
							fees.setText("10");
						}
					}
				} catch(Exception exp) {
					
				}
			}
		});
		connect.setBackground(new Color(221, 160, 221));
		connect.setFont(new Font("Tahoma", Font.BOLD, 18));
		connect.setBounds(881, 319, 150, 27);
		contentPane.add(connect);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSubmit.setBackground(new Color(173, 255, 47));
		btnSubmit.setBounds(295, 606, 222, 46);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel_1.setBounds(477, 17, 205, 198);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StudentDashBoard frame = new StudentDashBoard();
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCancel.setBackground(new Color(173, 255, 47));
		btnCancel.setBounds(565, 606, 222, 46);
		contentPane.add(btnCancel);
//		setUndecorated(true);
	}
}
