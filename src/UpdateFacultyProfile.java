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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class UpdateFacultyProfile extends JFrame {

	private JPanel contentPane;
	private JTextField f_name;
	private JTextField f_speciality;
	private JTextField f_email;
	private JTextField f_pass;
	private JTextField f_cpass;
	
	public UpdateFacultyProfile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\Sit.png"));
		setResizable(false);
		setTitle("College Academics Management System | Update Faculty Profile");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1136, 677);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1122, 640);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(50, 104, 134, 29);
		panel.add(lblNewLabel_1);
		
		f_name = new JTextField();
		f_name.setFont(new Font("Tahoma", Font.BOLD, 12));
		f_name.setColumns(10);
		f_name.setBounds(271, 104, 466, 29);
		panel.add(f_name);
		
		JLabel lblNewLabel_1_1 = new JLabel("Branch");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(50, 143, 134, 29);
		panel.add(lblNewLabel_1_1);
		
		JComboBox<String> f_branch = new JComboBox<String>();
		f_branch.setFont(new Font("Tahoma", Font.BOLD, 10));
		f_branch.addItem("---Select---");
		String branchArray[] = {"Computer Science And Engineering(CSE)", 
				"Electronic Communication Engineering(ECE)", 
				"Electrical Electronics Engineering(EEE)", 
				"Electronics Instrumentation Engineering(EIE)",
				"Information Science Engineering(ISE)",
				"Mechanical Engineering(MECH)"};
		for(int i=0;i<branchArray.length;i++) {
			f_branch.addItem(branchArray[i]);
		}
		f_branch.setBounds(271, 143, 466, 29);
		panel.add(f_branch);
		
		JLabel lblNewLabel_1_2 = new JLabel("Year Of Joining");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(50, 182, 174, 29);
		panel.add(lblNewLabel_1_2);
		
		JComboBox<String> f_joiningBox = new JComboBox<String>();
		f_joiningBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int startYear = 1963;
		int currYear = localDate.getYear();
		String yearArray[] = new String[58];
		
		f_joiningBox.addItem("---Select---");
		for(int i=0;i<=57;i++) {
			yearArray[i] = Integer.toString(startYear);
			f_joiningBox.addItem(yearArray[i]);
			if(startYear == currYear) {
				break;
			}
			startYear+=1;
		}
		f_joiningBox.setBounds(271, 182, 466, 29);
		panel.add(f_joiningBox);
		
		JLabel lblNewLabel_1_3 = new JLabel("Speciality");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(50, 221, 134, 29);
		panel.add(lblNewLabel_1_3);
		
		f_speciality = new JTextField();
		f_speciality.setFont(new Font("Tahoma", Font.BOLD, 12));
		f_speciality.setColumns(10);
		f_speciality.setBounds(271, 221, 466, 29);
		panel.add(f_speciality);
		
		JLabel lblNewLabel_1_4 = new JLabel("Degree");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(50, 260, 134, 29);
		panel.add(lblNewLabel_1_4);
		
		JComboBox<String> f_degree_box = new JComboBox<String>();
		f_degree_box.setFont(new Font("Tahoma", Font.BOLD, 10));
		String degreeArray[] = {"B.Tech", "M.Tech", "B.Tech, M.Tech & Phd", "BSC", "MSC", "BSC, MSC & Phd", 
				"B.Com", "M.Com", "B.Com, M.Com & Phd", "B.Tech, M.Tech & MBA", "BSC, MSC & MBA", "BCA", "MCA", 
				"BCA, MCA & MBA"};
		f_degree_box.addItem("---Select---");
		for(int i=0;i<degreeArray.length; i++) {
			f_degree_box.addItem(degreeArray[i]);
		}
		f_degree_box.setBounds(271, 260, 466, 29);
		panel.add(f_degree_box);
		
		JLabel lblNewLabel_1_5 = new JLabel("Designation");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_5.setBounds(50, 296, 134, 29);
		panel.add(lblNewLabel_1_5);
		
		JComboBox<String> f_designationBox = new JComboBox<String>();
		f_designationBox.setFont(new Font("Tahoma", Font.BOLD, 10));
		f_designationBox.addItem("---Select---");
		String desgn_Array[] = {"Professor & Head", "Professor", "Associate Professor", "Assistant Professor", "Visiting Professor"};
		for(int i = 0;i<desgn_Array.length;i++) {
			f_designationBox.addItem(desgn_Array[i]);
		}
		f_designationBox.setBounds(271, 296, 466, 29);
		panel.add(f_designationBox);
		
		JLabel lblNewLabel_1_6 = new JLabel("Email");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_6.setBounds(50, 335, 134, 29);
		panel.add(lblNewLabel_1_6);
		
		f_email = new JTextField();
		f_email.setFont(new Font("Tahoma", Font.BOLD, 12));
		f_email.setColumns(10);
		f_email.setBounds(271, 335, 466, 29);
		panel.add(f_email);
		
		JLabel lblNewLabel_1_7 = new JLabel("Password");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7.setBounds(50, 374, 134, 29);
		panel.add(lblNewLabel_1_7);
		
		f_pass = new JTextField();
		f_pass.setFont(new Font("Tahoma", Font.BOLD, 12));
		f_pass.setColumns(10);
		f_pass.setBounds(271, 374, 466, 29);
		panel.add(f_pass);
		
		JLabel lblNewLabel_1_7_1 = new JLabel("Confirm Password");
		lblNewLabel_1_7_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_7_1.setBounds(50, 412, 174, 29);
		panel.add(lblNewLabel_1_7_1);
		
		f_cpass = new JTextField();
		f_cpass.setFont(new Font("Tahoma", Font.BOLD, 12));
		f_cpass.setColumns(10);
		f_cpass.setBounds(271, 412, 466, 29);
		panel.add(f_cpass);
		
		JCheckBox confirm_update = new JCheckBox("Are you sure? You want to update your profile");
		confirm_update.setBackground(new Color(176, 224, 230));
		confirm_update.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirm_update.setBounds(50, 474, 687, 37);
		panel.add(confirm_update);
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag = false;
				try {
					System.out.println(FacultyLoginWindow.facultyname);
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from faculty_database;");
					while(res.next()) {
						if(FacultyLoginWindow.facultyname.equals(res.getString
								("faculty_name")) && 
								f_pass.getText().equals(f_cpass.getText()) && 
								confirm_update.isSelected()) {
							flag = true;
							break;
						}
					}
					if(flag == true) { 
						dbo.updateFacultyProfile(conn, FacultyLoginWindow.facultyname, 
								f_name.getText().toString(), 
								f_branch.getSelectedItem().toString(), 
								f_joiningBox.getSelectedItem().toString(), 
								f_speciality.getText().toString(), 
								f_degree_box.getSelectedItem().toString(), 
								f_designationBox.getSelectedItem().toString(), 
								f_email.getText().toString(), f_pass.getText().toString());
						JOptionPane.showMessageDialog(null,"Profile Updated");
					} else {
						JOptionPane.showMessageDialog(null,"Error, Please Check your details or contact Software Vendor");
					}
					
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null, exp.getMessage());
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 18));
		update.setBackground(new Color(144, 238, 144));
		update.setBounds(112, 563, 208, 52);
		panel.add(update);
		
		JButton cancel = new JButton("Reset");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					f_name.setText("");;
					f_speciality.setText("");;
					f_email.setText("");
					f_pass.setText("");
					f_cpass.setText("");
					f_branch.setSelectedIndex(0);
					f_joiningBox.setSelectedIndex(0);
					f_degree_box.setSelectedIndex(0);
					f_designationBox.setSelectedIndex(0);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cancel.setBackground(new Color(221, 160, 221));
		cancel.setBounds(489, 563, 208, 52);
		panel.add(cancel);
		
		
		
		JLabel lblNewLabel_1_8 = new JLabel("Update Profile");
		lblNewLabel_1_8.setForeground(new Color(186, 85, 211));
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1_8.setBounds(112, 10, 625, 78);
		panel.add(lblNewLabel_1_8);
		
		JButton btnNewButton_1_2_1 = new JButton("Upload Image");
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1_2_1.setBackground(new Color(255, 250, 205));
		btnNewButton_1_2_1.setBounds(843, 237, 208, 52);
		panel.add(btnNewButton_1_2_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					FacultyDashBoard frame = new FacultyDashBoard();
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 76, 73);
		panel.add(btnNewButton_1);
	}
}
