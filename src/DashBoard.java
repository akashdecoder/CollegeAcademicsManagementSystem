import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class DashBoard extends JFrame {

	private JPanel contentPane;
	private JTextField text_name;
	private JTextField text_usn;
	private JTextField text_email;
	private JTextField text_password;
	private JTextField text_pssword_confirm;
	private JTextField text_fName;
	private JTextField text_speciality;
	private JTextField text_femail;
	private JTextField text_fpassword;
	private JTextField text_confirmPass;
	public DashBoard() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\akashdecoder.github.io-master\\Sit.png"));
		setTitle("College Academics Management System");
		setBackground(new Color(153, 51, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 1080, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 297, 700);
		contentPane.add(panel);
		
		JButton homeButton = new JButton("Home");
		homeButton.setForeground(new Color(0, 0, 0));
		homeButton.setBackground(new Color(0, 128, 128));
		homeButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		JButton homeButton_1 = new JButton("Student");
		
		homeButton_1.setForeground(Color.BLACK);
		homeButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeButton_1.setBackground(new Color(0, 128, 128));
		
		JButton homeButton_2 = new JButton("Faculty");
		
		homeButton_2.setForeground(Color.BLACK);
		homeButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeButton_2.setBackground(new Color(0, 128, 128));
		
		JButton homeButton_3 = new JButton("Exit");
		homeButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		homeButton_3.setForeground(Color.BLACK);
		homeButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		homeButton_3.setBackground(new Color(0, 128, 128));
		

		JLabel lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(homeButton_3, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
				.addComponent(homeButton_2, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
				.addComponent(homeButton_1, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
				.addComponent(homeButton, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(homeButton, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(homeButton_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(53)
					.addComponent(homeButton_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(homeButton_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(153, 255, 51));
		tabbedPane.setBounds(295, 91, 785, 609);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Home", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Departments");
		btnNewButton.setIcon(new ImageIcon("D:\\icons\\programing.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(204, 51, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(52, 45, 300, 150);
		panel_1.add(btnNewButton);
		
		JButton btnPlacement = new JButton("Placement");
		btnPlacement.setIcon(new ImageIcon("D:\\icons\\recruit.png"));
		btnPlacement.setBackground(new Color(153, 255, 255));
		btnPlacement.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlacement.setForeground(new Color(0, 0, 0));
		btnPlacement.setBounds(430, 45, 300, 150);
		panel_1.add(btnPlacement);
		
		JButton btnAcademicCalender = new JButton("Calender");
		btnAcademicCalender.setIcon(new ImageIcon("D:\\icons\\calendar.png"));
		btnAcademicCalender.setBackground(new Color(204, 204, 255));
		btnAcademicCalender.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAcademicCalender.setBounds(52, 263, 300, 150);
		panel_1.add(btnAcademicCalender);
		
		JButton btnAchievements = new JButton("Contact Us");
		btnAchievements.setIcon(new ImageIcon("D:\\icons\\contacts-book.png"));
		btnAchievements.setBackground(new Color(102, 153, 153));
		btnAchievements.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAchievements.setBounds(430, 263, 300, 150);
		panel_1.add(btnAchievements);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Student", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(84, 80, 178, 29);
		panel_2.add(lblNewLabel);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsn.setBounds(84, 134, 178, 29);
		panel_2.add(lblUsn);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(84, 186, 178, 29);
		panel_2.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(84, 237, 178, 29);
		panel_2.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmPassword.setBounds(84, 299, 178, 29);
		panel_2.add(lblConfirmPassword);
		
		text_name = new JTextField();
		text_name.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_name.setBounds(299, 75, 410, 46);
		panel_2.add(text_name);
		text_name.setColumns(10);
		
		text_usn = new JTextField();
		text_usn.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_usn.setColumns(10);
		text_usn.setBounds(299, 129, 410, 46);
		panel_2.add(text_usn);
		
		text_email = new JTextField();
		text_email.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_email.setColumns(10);
		text_email.setBounds(299, 181, 410, 46);
		panel_2.add(text_email);
		
		text_password = new JTextField();
		text_password.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_password.setColumns(10);
		text_password.setBounds(299, 232, 410, 46);
		panel_2.add(text_password);
		
		text_pssword_confirm = new JTextField();
		text_pssword_confirm.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_pssword_confirm.setColumns(10);
		text_pssword_confirm.setBounds(299, 288, 410, 46);
		panel_2.add(text_pssword_confirm);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					if((text_password.getText().toString().equals(text_pssword_confirm.getText().toString())) && 
							!text_name.getText().toString().isEmpty()) {
						int status = dbo.insertIntoStudentDatabase(conn, text_name.getText().toString()
								, text_usn.getText().toString(),
								text_email.getText().toString(), 
								text_password.getText().toString());
						JOptionPane.showMessageDialog(null,"Registered");
					} else {
						JOptionPane.showMessageDialog(null,"Passsword Mismatch || Empty Fields");
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\add.png"));
		btnNewButton_1.setBackground(new Color(144, 238, 144));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(314, 375, 208, 52);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Login");
		btnNewButton_1_1.setIcon(new ImageIcon("D:\\icons\\user.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginWindow frame = new LoginWindow("Student");
					frame.setVisible(true);
					dispose();
				}catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1_1.setBounds(314, 465, 208, 52);
		panel_2.add(btnNewButton_1_1);
		
		JLabel lblAlreadyRegistered = new JLabel("Already Registered?");
		lblAlreadyRegistered.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlreadyRegistered.setBounds(84, 475, 194, 29);
		panel_2.add(lblAlreadyRegistered);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Faculty", null, panel_2_1, null);
		
		JButton btnNewButton_1_2 = new JButton("Register");
		
		btnNewButton_1_2.setIcon(new ImageIcon("D:\\icons\\add.png"));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2.setBackground(new Color(144, 238, 144));
		btnNewButton_1_2.setBounds(314, 387, 208, 52);
		panel_2_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Login");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoginWindow frame = new LoginWindow("Faculty");
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setIcon(new ImageIcon("D:\\icons\\user.png"));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1_1_1.setBounds(314, 477, 208, 52);
		panel_2_1.add(btnNewButton_1_1_1);
		
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(0);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		homeButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(1);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		homeButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(2);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		JLabel lblAlreadyRegistered_1 = new JLabel("Already Registered?");
		lblAlreadyRegistered_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAlreadyRegistered_1.setBounds(84, 487, 194, 29);
		panel_2_1.add(lblAlreadyRegistered_1);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(74, 20, 134, 29);
		panel_2_1.add(lblNewLabel_1);
		
		text_fName = new JTextField();
		text_fName.setFont(new Font("Tahoma", Font.BOLD, 12));
		text_fName.setBounds(295, 20, 369, 29);
		panel_2_1.add(text_fName);
		text_fName.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Branch");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(74, 59, 134, 29);
		panel_2_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Year Of Joining");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(74, 98, 174, 29);
		panel_2_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Speciality");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(74, 137, 134, 29);
		panel_2_1.add(lblNewLabel_1_3);
		
		text_speciality = new JTextField();
		text_speciality.setFont(new Font("Tahoma", Font.BOLD, 12));
		text_speciality.setColumns(10);
		text_speciality.setBounds(295, 137, 369, 29);
		panel_2_1.add(text_speciality);
		
		JLabel lblNewLabel_1_4 = new JLabel("Degree");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(74, 176, 134, 29);
		panel_2_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Designation");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(74, 212, 134, 29);
		panel_2_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Email");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(74, 251, 134, 29);
		panel_2_1.add(lblNewLabel_1_6);
		
		text_femail = new JTextField();
		text_femail.setFont(new Font("Tahoma", Font.BOLD, 12));
		text_femail.setColumns(10);
		text_femail.setBounds(295, 251, 369, 29);
		panel_2_1.add(text_femail);
		
		JLabel lblNewLabel_1_7 = new JLabel("Password");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(74, 290, 134, 29);
		panel_2_1.add(lblNewLabel_1_7);
		
		text_fpassword = new JTextField();
		text_fpassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		text_fpassword.setColumns(10);
		text_fpassword.setBounds(295, 290, 369, 29);
		panel_2_1.add(text_fpassword);
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int startYear = 1963;
		int currYear = localDate.getYear();
		String yearArray[] = new String[58];
		
		JComboBox<String> joiningBox = new JComboBox<String>();
		joiningBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		joiningBox.addItem("---Select---");
		for(int i=0;i<=57;i++) {
			yearArray[i] = Integer.toString(startYear);
			joiningBox.addItem(yearArray[i]);
			if(startYear == currYear) {
				break;
			}
			startYear+=1;
		}
		joiningBox.setBounds(295, 98, 369, 29);
		panel_2_1.add(joiningBox);
		
		JComboBox<String> degree_box = new JComboBox<String>();
		degree_box.setFont(new Font("Tahoma", Font.BOLD, 10));
		String degreeArray[] = {"B.Tech", "M.Tech", "B.Tech, M.Tech & Phd", "BSC", "MSC", "BSC, MSC & Phd", 
				"B.Com", "M.Com", "B.Com, M.Com & Phd", "B.Tech, M.Tech & MBA", "BSC, MSC & MBA", "BCA", "MCA", 
				"BCA, MCA & MBA"};
		degree_box.addItem("---Select---");
		for(int i=0;i<degreeArray.length; i++) {
			degree_box.addItem(degreeArray[i]);
		}
		degree_box.setBounds(295, 176, 369, 29);
		panel_2_1.add(degree_box);
		
		JComboBox<String> designationBox = new JComboBox<String>();
		designationBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		designationBox.addItem("---Select---");
		String desgn_Array[] = {"Professor & Head", "Professor", "Associate Professor", "Assistant Professor", "Visiting Professor"};
		for(int i = 0;i<desgn_Array.length;i++) {
			designationBox.addItem(desgn_Array[i]);
		}
		designationBox.setBounds(295, 212, 369, 29);
		panel_2_1.add(designationBox);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Confirm Password");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7_1.setBounds(74, 328, 174, 29);
		panel_2_1.add(lblNewLabel_1_7_1);
		
		text_confirmPass = new JTextField();
		text_confirmPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		text_confirmPass.setColumns(10);
		text_confirmPass.setBounds(295, 328, 369, 29);
		panel_2_1.add(text_confirmPass);
		
		JComboBox<String> branchBox = new JComboBox<String>();
		branchBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		branchBox.addItem("---Select---");
		String branchArray[] = {"Computer Science And Engineering(CSE)", 
				"Electronic Communication Engineering(ECE)", 
				"Electrical Electronics Engineering(EEE)", 
				"Electronics Instrumentation Engineering(EIE)",
				"Information Science Engineering(ISE)",
				"Mechanical Engineering(MECH)"};
		for(int i=0;i<branchArray.length;i++) {
			branchBox.addItem(branchArray[i]);
		}
		branchBox.setBounds(295, 59, 369, 29);
		panel_2_1.add(branchBox);
		
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					if((text_fpassword.getText().toString().equals(text_confirmPass.getText().toString())) &&
							!text_fName.getText().toString().isEmpty()) {
						int status = dbo.insertIntoFacultyDatabase(conn, text_fName.getText().toString()
								, branchBox.getSelectedItem().toString(),
								joiningBox.getSelectedItem().toString(),
								text_speciality.getText().toString(),
								degree_box.getSelectedItem().toString(),
								designationBox.getSelectedItem().toString(),
								text_femail.getText().toString(),
								text_fpassword.getText().toString());
						JOptionPane.showMessageDialog(null,"Registered");
					} else {
						JOptionPane.showMessageDialog(null,"Passsword Mismatch || Empty Fields");
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("College Academics Management System");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_3.setBounds(328, 10, 709, 71);
		contentPane.add(lblNewLabel_3);
//		setUndecorated(true);
		setResizable(false);
	}
}
