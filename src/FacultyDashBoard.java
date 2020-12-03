import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;
import subjects.FirstYearSubjects;
import subjects.SecondYearSubjects;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

public class FacultyDashBoard extends JFrame {

	private JPanel contentPane;
	private JTextField text_desgn;
	private JTextField text_joining;
	private JTextField text_speciality;
	private JTextField text_degree;
	private JTextField text_branch;
	private JTextField text_email;
	private JComboBox<String> select_Branch;
	private JComboBox<String> select_year;
	private JComboBox<String> semester;
	private JComboBox<String> section;
	
	public static int year;
	public static String sem;
	public static String subject;
	public static String branch;
	
	public FacultyDashBoard() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setTitle("College Academics Management System | Faculty Dashboard");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(186, 85, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 324, 663);
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel.setBounds(51, 5, 216, 200);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Profile");
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 139, 139));
		btnNewButton.setBounds(0, 273, 324, 48);
		panel.add(btnNewButton);
		
		JButton btnUploadMarks = new JButton("Upload Marks & Attendance");
		btnUploadMarks.setForeground(new Color(0, 0, 0));
		btnUploadMarks.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUploadMarks.setBackground(new Color(0, 139, 139));
		btnUploadMarks.setBounds(0, 354, 324, 48);
		panel.add(btnUploadMarks);
		
		JButton btnOthers = new JButton("Others");
		btnOthers.setForeground(new Color(0, 0, 0));
		btnOthers.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOthers.setBackground(new Color(0, 139, 139));
		btnOthers.setBounds(0, 436, 324, 48);
		panel.add(btnOthers);
		
		JButton btnExit = new JButton("Logout");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBackground(new Color(0, 139, 139));
		btnExit.setBounds(0, 514, 324, 48);
		panel.add(btnExit);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(153, 255, 51));
		tabbedPane.setBounds(324, 25, 962, 638);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel faculty_Name = new JLabel("Name");
		faculty_Name.setHorizontalAlignment(SwingConstants.CENTER);
		faculty_Name.setFont(new Font("Tahoma", Font.BOLD, 18));
		faculty_Name.setBounds(83, 10, 687, 54);
		panel_1.add(faculty_Name);
		
		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(28, 110, 152, 33);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Designation");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(28, 176, 152, 33);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Year Of Joining");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(28, 243, 152, 33);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Speciality");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_3.setBounds(28, 312, 152, 33);
		panel_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Degree");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_4.setBounds(28, 377, 152, 33);
		panel_1.add(lblNewLabel_2_4);
		
		text_desgn = new JTextField();
		text_desgn.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_desgn.setEditable(false);
		text_desgn.setBounds(211, 176, 442, 33);
		panel_1.add(text_desgn);
		text_desgn.setColumns(10);
		
		text_joining = new JTextField();
		text_joining.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_joining.setEditable(false);
		text_joining.setColumns(10);
		text_joining.setBounds(211, 243, 442, 33);
		panel_1.add(text_joining);
		
		text_speciality = new JTextField();
		text_speciality.setFont(new Font("Tahoma", Font.BOLD, 14));
		text_speciality.setEditable(false);
		text_speciality.setColumns(10);
		text_speciality.setBounds(211, 312, 442, 33);
		panel_1.add(text_speciality);
		
		text_degree = new JTextField();
		text_degree.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_degree.setEditable(false);
		text_degree.setColumns(10);
		text_degree.setBounds(211, 377, 442, 33);
		panel_1.add(text_degree);
		
		text_branch = new JTextField();
		text_branch.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_branch.setEditable(false);
		text_branch.setColumns(10);
		text_branch.setBounds(211, 110, 442, 33);
		panel_1.add(text_branch);
		
		JLabel lblNewLabel_3 = new JLabel("image");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(690, 116, 242, 292);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("Email");
		lblNewLabel_2_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_4_1.setBounds(28, 442, 152, 33);
		panel_1.add(lblNewLabel_2_4_1);
		
		text_email = new JTextField();
		text_email.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_email.setEditable(false);
		text_email.setColumns(10);
		text_email.setBounds(211, 442, 442, 33);
		panel_1.add(text_email);
		String branchArray[] = {"Computer Science And Engineering(CSE)", 
				"Electronic Communication Engineering(ECE)", 
				"Electrical Electronics Engineering(EEE)", 
				"Electronics Instrumentation Engineering(EIE)",
				"Information Science Engineering(ISE)",
				"Mechanical Engineering(MECH)"};
		
		String yearArray[] = {"First", "Second", "Third", "Fourth"};
		
		
		String first_year_semArray[] = {"I", "II"};
		String second_year_semArray[] = {"III", "IV"};
		String third_year_semArray[] = {"V", "VI"};
		String fourth_year_semArray[] = {"VII", "VIII"};
		String secArray[] = {"A", "B", "C", "D", "E", "F", "G"};
		
		
		String subject_1[] = new String[7];
		String subject_2[] = new String[8];
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Others", null, panel_4, null);
		panel_4.setLayout(null);
		
		JButton upload_notes = new JButton("Upload Notes");
		upload_notes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from faculty_database;");
					
					JFileChooser jFile = new JFileChooser();
					jFile.setDialogTitle("Choose file");
					int result = jFile.showSaveDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						File file = jFile.getSelectedFile();
						FileReader reader = new FileReader(file.getAbsolutePath());
						while(res.next()) {
							if(LoginWindow.facultyname.equals(res.getString
									("faculty_name"))) {
								java.util.Date date = new java.util.Date();
								java.sql.Date sqlDate = new java.sql.Date(date.getTime());
								java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
								int status = dbo.uploadNotes(conn, 
										res.getString("faculty_name"), reader, sqlDate, sqlTime);
							}
						}
						JOptionPane.showMessageDialog(null,"File Uploaded");
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage());
					exp.printStackTrace();
				}
			}
		});
		upload_notes.setFont(new Font("Tahoma", Font.BOLD, 18));
		upload_notes.setBackground(new Color(153, 255, 153));
		upload_notes.setBounds(39, 38, 404, 142);
		panel_4.add(upload_notes);
		
		JButton btnNewButton_1_1 = new JButton("Upload Paper");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from faculty_database;");
					
					JFileChooser jFile = new JFileChooser();
					jFile.setDialogTitle("Choose file");
					int result = jFile.showSaveDialog(null);
					if(result == JFileChooser.APPROVE_OPTION) {
						File file = jFile.getSelectedFile();
						FileReader reader = new FileReader(file.getAbsolutePath());
						while(res.next()) {
							if(LoginWindow.facultyname.equals(res.getString
									("faculty_name"))) {
								java.util.Date date = new java.util.Date();
								java.sql.Date sqlDate = new java.sql.Date(date.getTime());
								java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
								int status = dbo.uploadPaper(conn, 
										res.getString("faculty_name"), reader, sqlDate, sqlTime);
							}
						}
						JOptionPane.showMessageDialog(null,"File Uploaded");
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage());
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1.setBackground(new Color(255, 204, 204));
		btnNewButton_1_1.setBounds(518, 38, 404, 142);
		panel_4.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Online Pay");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2.setBackground(new Color(204, 255, 204));
		btnNewButton_1_2.setBounds(39, 233, 404, 142);
		panel_4.add(btnNewButton_1_2);
		
		JButton update_profile = new JButton("Update Profile");
		update_profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateFacultyProfile frame = new UpdateFacultyProfile();
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		update_profile.setFont(new Font("Tahoma", Font.BOLD, 18));
		update_profile.setBackground(new Color(204, 204, 102));
		update_profile.setBounds(518, 233, 404, 142);
		panel_4.add(update_profile);
		
		JButton btnNewButton_1_2_1 = new JButton("Upload Assignment");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1_2_1.setBounds(39, 430, 404, 142);
		panel_4.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Student Queries");
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_1_1_1.setBackground(new Color(153, 153, 204));
		btnNewButton_1_1_1_1.setBounds(518, 430, 404, 142);
		panel_4.add(btnNewButton_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Upload Marks & Attendance", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Branch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(14, 111, 142, 38);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Year");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(14, 159, 142, 38);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Semester");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(14, 207, 142, 38);
		panel_2.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Section");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1_1.setBounds(14, 255, 142, 38);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		select_Branch = new JComboBox<String>();
		select_Branch.setFont(new Font("Tahoma", Font.BOLD, 18));
		select_Branch.addItem("---Select---");
		for(int i=0;i<branchArray.length;i++) {
			select_Branch.addItem(branchArray[i]);
		}
		select_Branch.setBounds(172, 111, 448, 38);
		panel_2.add(select_Branch);
		
		select_year = new JComboBox<String>();
		select_year.setFont(new Font("Tahoma", Font.BOLD, 18));
		select_year.addItem("---Select---");
		for(int i=0;i<yearArray.length;i++) {
			select_year.addItem(yearArray[i]);
		}
		select_year.setBounds(172, 159, 448, 38);
		panel_2.add(select_year);
		
		JButton connect_with_year = new JButton("Connect Year");
		
		connect_with_year.setBackground(new Color(221, 160, 221));
		connect_with_year.setFont(new Font("Tahoma", Font.BOLD, 16));
		connect_with_year.setBounds(656, 159, 195, 38);
		panel_2.add(connect_with_year);
		
		semester = new JComboBox<String>();
		semester.setFont(new Font("Tahoma", Font.BOLD, 18));
		semester.addItem("---Select---");
		connect_with_year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(select_year.getSelectedItem().equals("First")) {
						year = 1;
						semester.removeAllItems();
						semester.addItem("---Select---");
						semester.addItem(first_year_semArray[0]);
						semester.addItem(first_year_semArray[1]);
					}else if(select_year.getSelectedItem().equals("Second")) {
						year = 2;
						semester.removeAllItems();
						semester.addItem("---Select---");
						semester.addItem(second_year_semArray[0]);
						semester.addItem(second_year_semArray[1]);
					}else if(select_year.getSelectedItem().equals("Third")) {
						year = 3;
						semester.removeAllItems();
						semester.addItem("---Select---");
						semester.addItem(third_year_semArray[0]);
						semester.addItem(third_year_semArray[1]);
					}else if(select_year.getSelectedItem().equals("Fourth")) {
						year = 4;
						semester.removeAllItems();
						semester.addItem("---Select---");
						semester.addItem(fourth_year_semArray[0]);
						semester.addItem(fourth_year_semArray[1]);
					}
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		semester.setBounds(172, 207, 448, 38);
		panel_2.add(semester);
		
		
		section = new JComboBox<String>();
		section.setFont(new Font("Tahoma", Font.BOLD, 18));
		for(int i=0;i<secArray.length; i++) {
			section.addItem(secArray[i]);
		}
		section.setBounds(172, 255, 448, 38);
		panel_2.add(section);
		
		JButton Upload_window = new JButton("Go To Upload Window");
		
		Upload_window.setBackground(new Color(0, 250, 154));
		Upload_window.setFont(new Font("Tahoma", Font.BOLD, 16));
		Upload_window.setBounds(339, 423, 281, 49);
		panel_2.add(Upload_window);
		
		JLabel subject_label = new JLabel("Subject");
		subject_label.setFont(new Font("Tahoma", Font.BOLD, 18));
		subject_label.setBounds(14, 303, 142, 38);
		panel_2.add(subject_label);
		
		JComboBox<String> subject_Box = new JComboBox<String>();
		subject_Box.setFont(new Font("Tahoma", Font.BOLD, 14));
		subject_Box.setBounds(172, 303, 448, 38);
		panel_2.add(subject_Box);
		
		JButton connect_with_sem = new JButton("Connect Semester");
		
		connect_with_sem.setFont(new Font("Tahoma", Font.BOLD, 16));
		connect_with_sem.setBackground(new Color(221, 160, 221));
		connect_with_sem.setBounds(656, 207, 195, 38);
		panel_2.add(connect_with_sem);
		connect_with_sem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(semester.getSelectedItem().equals("I")) {
						sem = "I";
						subject_Box.removeAllItems();
						FirstYearSubjects sem_1 = new FirstYearSubjects(subject_1, 
								select_Branch.getSelectedItem().toString(),"I");
						subject_Box.addItem("---Select---");
						for(int i=0 ;i<subject_1.length ;i++) {
							subject_Box.addItem(subject_1[i]);
						}
					} else if(semester.getSelectedItem().equals("II")) {
						sem = "II";
						subject_Box.removeAllItems();
						FirstYearSubjects sem_2 = new FirstYearSubjects(subject_1,
								select_Branch.getSelectedItem().toString(), "II");
						subject_Box.addItem("---Select---");
						for(int i=0 ;i<subject_1.length ;i++) {
							subject_Box.addItem(subject_1[i]);
						}
					} else if(semester.getSelectedItem().equals("III")) {
						sem = "III";
						subject_Box.removeAllItems();
						SecondYearSubjects sem_3 = new SecondYearSubjects(subject_2,
								select_Branch.getSelectedItem().toString(), "III");
						subject_Box.addItem("---Select---");
						for(int i=0 ;i<subject_2.length ;i++) {
							subject_Box.addItem(subject_2[i]);
						}
					} else if(semester.getSelectedItem().equals("IV")) {
						sem = "IV";
						subject_Box.removeAllItems();
						SecondYearSubjects sem_4 = new SecondYearSubjects(subject_2,
								select_Branch.getSelectedItem().toString(), "IV");
						subject_Box.addItem("---Select---");
						for(int i=0 ;i<subject_2.length ;i++) {
							subject_Box.addItem(subject_2[i]);
						}
					}
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(0);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnUploadMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(1);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(2);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		Upload_window.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					subject = subject_Box.getSelectedItem().toString();
					branch = select_Branch.getSelectedItem().toString();
					dispose();
					UploadMA frame = new UploadMA();
					frame.setVisible(true);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		try {
			DatabaseOperation dbo = new DatabaseOperation();
			Database db = new Database();
			Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("select * from faculty_database;");
			while(res.next()) {
				if(LoginWindow.facultyname.equals(res.getString("faculty_name"))) {
					faculty_Name.setText(res.getString("faculty_name"));
					text_branch.setText(res.getString("faculty_branch"));
					text_desgn.setText(res.getString("designation"));
					text_joining.setText(res.getString("year_of_joining"));
					text_speciality.setText(res.getString("speciality"));
					text_degree.setText(res.getString("degree"));
					text_email.setText(res.getString("faculty_email"));
				}
			}
		} catch(Exception exp) {
			exp.printStackTrace();
		}
		

	}
}
