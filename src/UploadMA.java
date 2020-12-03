import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;
import subjects.FirstYearSubjects;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class UploadMA extends JFrame {

	private JPanel contentPane;
	private JTextField name_text;
	private JTextField usn_text;
	private JTextField q1;
	private JTextField q2;
	private JTextField t1;
	private JTextField q3;
	private JTextField q4;
	private JTextField t2;
	private JTextField others;
	private JTextField total;
	
	private int total_cie = 0;
	private int q1_credits = 0, q2_credits = 0, t1_credits = 0, q3_credits = 0, q4_credits = 0, t2_credits = 0;

	public UploadMA() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setTitle("Upload Marks & Attendance");
		
		setBackground(new Color(153, 0, 255));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 51, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 324, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel.setBounds(61, 10, 206, 215);
		panel.add(lblNewLabel);
		
		JButton upl_marks = new JButton("Upload Marks");
		upl_marks.setForeground(new Color(0, 0, 0));
		upl_marks.setFont(new Font("Tahoma", Font.BOLD, 18));
		upl_marks.setBackground(new Color(0, 128, 128));
		upl_marks.setBounds(0, 325, 324, 43);
		panel.add(upl_marks);
		
		JButton upl_attn = new JButton("Upload Attendance");
		upl_attn.setForeground(new Color(0, 0, 0));
		
		upl_attn.setFont(new Font("Tahoma", Font.BOLD, 18));
		upl_attn.setBackground(new Color(0, 128, 128));
		upl_attn.setBounds(0, 402, 324, 43);
		panel.add(upl_attn);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					FacultyDashBoard frame = new FacultyDashBoard();
					frame.setVisible(true);
				}catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnExit.setBackground(new Color(0, 128, 128));
		btnExit.setBounds(0, 477, 324, 43);
		panel.add(btnExit);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(153, 255, 51));
		tabbedPane.setBounds(323, 30, 863, 633);
		contentPane.add(tabbedPane);
		
		JPanel u_marks = new JPanel();
		u_marks.setBackground(Color.WHITE);
		tabbedPane.addTab("Upload Marks", null, u_marks, null);
		u_marks.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 103, 160, 31);
		u_marks.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("USN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(10, 144, 160, 31);
		u_marks.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(10, 185, 160, 31);
		u_marks.add(lblNewLabel_1_2);
		
		name_text = new JTextField();
		name_text.setBounds(180, 103, 470, 31);
		u_marks.add(name_text);
		name_text.setColumns(10);
		
		usn_text = new JTextField();
		usn_text.setColumns(10);
		usn_text.setBounds(180, 144, 470, 31);
		u_marks.add(usn_text);
		
		JLabel lblNewLabel_2 = new JLabel("QUIZ 1");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 219, 97, 31);
		u_marks.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("QUIZ 2");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(117, 219, 97, 31);
		u_marks.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("TEST 1");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(224, 219, 97, 31);
		u_marks.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("QUIZ 3");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_3.setBounds(331, 219, 97, 31);
		u_marks.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("QUIZ 4");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_4.setBounds(438, 219, 97, 31);
		u_marks.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("TEST 2");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_5.setBounds(545, 219, 97, 31);
		u_marks.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Others");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2_6.setBounds(652, 219, 97, 31);
		u_marks.add(lblNewLabel_2_6);
		
		q1 = new JTextField();
		q1.setFont(new Font("Tahoma", Font.BOLD, 14));
		q1.setHorizontalAlignment(SwingConstants.CENTER);
		q1.setBounds(10, 260, 88, 31);
		u_marks.add(q1);
		q1.setColumns(10);
		
		q2 = new JTextField();
		q2.setFont(new Font("Tahoma", Font.BOLD, 14));
		q2.setHorizontalAlignment(SwingConstants.CENTER);
		q2.setColumns(10);
		q2.setBounds(117, 260, 88, 31);
		u_marks.add(q2);
		
		t1 = new JTextField();
		t1.setFont(new Font("Tahoma", Font.BOLD, 14));
		t1.setHorizontalAlignment(SwingConstants.CENTER);
		t1.setColumns(10);
		t1.setBounds(224, 260, 88, 31);
		u_marks.add(t1);
		
		q3 = new JTextField();
		q3.setFont(new Font("Tahoma", Font.BOLD, 14));
		q3.setHorizontalAlignment(SwingConstants.CENTER);
		q3.setColumns(10);
		q3.setBounds(331, 260, 88, 31);
		u_marks.add(q3);
		
		q4 = new JTextField();
		q4.setFont(new Font("Tahoma", Font.BOLD, 14));
		q4.setHorizontalAlignment(SwingConstants.CENTER);
		q4.setColumns(10);
		q4.setBounds(438, 260, 88, 31);
		u_marks.add(q4);
		
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.BOLD, 14));
		t2.setHorizontalAlignment(SwingConstants.CENTER);
		t2.setColumns(10);
		t2.setBounds(545, 260, 88, 31);
		u_marks.add(t2);
		
		others = new JTextField();
		others.setFont(new Font("Tahoma", Font.BOLD, 14));
		others.setHorizontalAlignment(SwingConstants.CENTER);
		others.setColumns(10);
		others.setBounds(652, 260, 88, 31);
		u_marks.add(others);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Total CIE");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(10, 475, 160, 31);
		u_marks.add(lblNewLabel_1_1_1);
		
		total = new JTextField();
		total.setColumns(10);
		total.setBounds(180, 475, 470, 31);
		u_marks.add(total);
		
		JButton total_button = new JButton("Calculate Total");
		
		total_button.setBackground(new Color(204, 102, 255));
		total_button.setFont(new Font("Tahoma", Font.BOLD, 18));
		total_button.setBounds(331, 359, 190, 52);
		u_marks.add(total_button);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnUpload.setBackground(new Color(153, 255, 153));
		btnUpload.setBounds(645, 544, 190, 52);
		u_marks.add(btnUpload);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					name_text.setText("");
					usn_text.setText("");
					t1.setText("");
					t2.setText("");
					q1.setText("");
					q2.setText("");
					q3.setText("");
					q4.setText("");
					others.setText("");
					total.setText("");
				}catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnReset.setBackground(new Color(255, 102, 153));
		btnReset.setBounds(10, 544, 190, 52);
		u_marks.add(btnReset);
		
		JPanel u_attendance = new JPanel();
		u_attendance.setBackground(Color.WHITE);
		tabbedPane.addTab("Upload Attendance", null, u_attendance, null);
		
		upl_marks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(0);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		upl_attn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(1);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		total_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(q1.getText().isEmpty() && q2.getText().isEmpty() && t1.getText().isEmpty() && 
							q3.getText().isEmpty() && q4.getText().isEmpty() && t2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,"Empty Fields");
					} else {
						if(!q1.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							total_cie = q1_credits;
						}
						if(!q1.getText().toString().isEmpty() && !q2.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							q2_credits = Integer.parseInt(q2.getText().toString());
							total_cie = q1_credits + q2_credits;
						}
						if(!q1.getText().toString().isEmpty() && !q2.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							q2_credits = Integer.parseInt(q2.getText().toString());
							total_cie = q1_credits + q2_credits;
						}
						if(!q1.getText().toString().isEmpty() && !q2.getText().toString().isEmpty()
								&& !t1.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							q2_credits = Integer.parseInt(q2.getText().toString());
							t1_credits = Integer.parseInt(t1.getText().toString());
							total_cie = q1_credits + q2_credits+t1_credits;
						}
						if(!q1.getText().toString().isEmpty() && !q2.getText().toString().isEmpty()
								&& !t1.getText().toString().isEmpty() 
								&& !q3.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							q2_credits = Integer.parseInt(q2.getText().toString());
							t1_credits = Integer.parseInt(t1.getText().toString());
							q3_credits = Integer.parseInt(q3.getText().toString());
							total_cie = q1_credits + q2_credits + t1_credits + q3_credits;
						}
						if(!q1.getText().toString().isEmpty() && !q2.getText().toString().isEmpty()
								&& !t1.getText().toString().isEmpty() 
								&& !q3.getText().toString().isEmpty()
								&& !q4.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							q2_credits = Integer.parseInt(q2.getText().toString());
							t1_credits = Integer.parseInt(t1.getText().toString());
							q3_credits = Integer.parseInt(q3.getText().toString());
							q4_credits = Integer.parseInt(q4.getText().toString());
							total_cie = q1_credits + q2_credits + t1_credits + q3_credits
									+ q4_credits;
						}
						if(!q1.getText().toString().isEmpty() && !q2.getText().toString().isEmpty()
								&& !t1.getText().toString().isEmpty() 
								&& !q3.getText().toString().isEmpty()
								&& !q4.getText().toString().isEmpty()
								&& !t2.getText().toString().isEmpty()) {
							q1_credits = Integer.parseInt(q1.getText().toString());
							q2_credits = Integer.parseInt(q2.getText().toString());
							t1_credits = Integer.parseInt(t1.getText().toString());
							q3_credits = Integer.parseInt(q3.getText().toString());
							q4_credits = Integer.parseInt(q4.getText().toString());
							t2_credits = Integer.parseInt(t2.getText().toString());
							total_cie = q1_credits + q2_credits + t1_credits + q3_credits
									+ q4_credits + t2_credits;
						}
						total.setText(Integer.toString(total_cie));
					}
				} catch(Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		
		String subject_1[] = new String[7];
		String subject_2[] = new String[8];
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isPresent = false;
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					PreparedStatement pst, pst1;
					ResultSet res = st.executeQuery("select * from student_database;");
					while(res.next()) {
						if(usn_text.getText().toString().equals(res.getString("student_usn"))) {
							if(FacultyDashBoard.sem == "I") {
								isPresent = false;
								FirstYearSubjects sem_1 = new FirstYearSubjects(subject_1, 
										FacultyDashBoard.branch,"I");
								for(int i=0; i<subject_1.length; i++) {
									if(FacultyDashBoard.subject.equals(subject_1[i])) {
										res = st.executeQuery("select * from 1_cse_i;");
										while(res.next()) {
											if((usn_text.getText().toString().equals(res.getString("usn"))) && 
													(res.getInt("count_insert") > 0)) {
												isPresent = true;
												String update_query = "update 1_cse_i "
														+ "set `" + subject_1[i] + "` = ? where usn = ?;";
												pst1 = conn.prepareStatement(update_query);
												pst1.setInt(1, total_cie);
												pst1.setString(2, usn_text.getText().toString());
												int status1 = pst1.executeUpdate();
											}
										}
										if(isPresent == false) {
											String sql_query = "insert into 1_cse_i(usn, name, `" + subject_1[i] + "`, count_insert) values (?, ?, ?, ?)";
											System.out.println(sql_query);
											pst = conn.prepareStatement(sql_query);
											pst.setString(1, usn_text.getText().toString());
											pst.setString(2, name_text.getText().toString());
											pst.setInt(3, total_cie);
											pst.setInt(4, 1);
											int status = pst.executeUpdate();
										}
									}
								}
							} else if(FacultyDashBoard.sem == "II") {
								isPresent = false;
								FirstYearSubjects sem_1 = new FirstYearSubjects(subject_1, 
										FacultyDashBoard.branch,"II");
								for(int i=0; i<subject_1.length; i++) {
									if(FacultyDashBoard.subject.equals(subject_1[i])) {
										res = st.executeQuery("select * from 1_cse_ii;");
										while(res.next()) {
											if((usn_text.getText().toString().equals(res.getString("usn"))) && 
													(res.getInt("count_insert") > 0)) {
												isPresent = true;
												String update_query = "update 1_cse_ii "
														+ "set `" + subject_1[i] + "` = ? where usn = ?;";
												pst1 = conn.prepareStatement(update_query);
												pst1.setInt(1, total_cie);
												pst1.setString(2, usn_text.getText().toString());
												int status1 = pst1.executeUpdate();
											}
										}
										if(isPresent == false) {
											String sql_query = "insert into 1_cse_ii(usn, name, `" + subject_1[i] + "`, count_insert) values (?, ?, ?, ?)";
											System.out.println(sql_query);
											pst = conn.prepareStatement(sql_query);
											pst.setString(1, usn_text.getText().toString());
											pst.setString(2, name_text.getText().toString());
											pst.setInt(3, total_cie);
											pst.setInt(4, 1);
											int status = pst.executeUpdate();
										}
									}
								}
							} else if(FacultyDashBoard.sem == "III") {
								
							} else if(FacultyDashBoard.sem == "IV") {
								
							}
						}
					}
				} catch(SQLException  exp) {
					exp.printStackTrace();
				}
			}
		});
	}
}
