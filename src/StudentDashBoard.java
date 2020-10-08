import javax.swing.JFrame;
import javax.swing.JPanel;

import database.Database;
import database.DatabaseOperation;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class StudentDashBoard extends JFrame {

	private JPanel contentPane;
	private JTextField text_branch;
	private JTextField text_year;
	private JTextField textField_2;
	private JTextField text_email;
	private JTextField text_cgpa;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField txtCie;
	private JTextField txtCredits;
	private JTextField txtEligible;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JLabel lblNewLabel_4_1_2;
	private JTextField textField_38;
	private JTextField textField_39;
	private JLabel lblNewLabel_4_1_3;
	private JTextField textField_40;
	private JTextField textField_41;
	private JLabel lblNewLabel_4_1_4;
	private JTextField textField_42;
	private JTextField textField_43;
	private JLabel lblNewLabel_4_1_5;
	private JTextField textField_44;
	private JTextField textField_45;
	private JLabel lblNewLabel_4_1_6;
	private JTextField textField_46;
	private JTextField textField_47;
	private JLabel lblNewLabel_4_1_7;
	private JTextField textField_48;
	private JTextField textField_49;
	private JLabel lblNewLabel_4_1_8;
	private JTextField textField_50;
	private JTextField textField_51;
	private JLabel lblNewLabel_4_1_9;
	private JTextField textField_52;
	private JTextField textField_53;
	private JLabel lblNewLabel_4_1_10;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField txtEleigible;
	private JTextField txtPercentage;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnNewButton_6;
	public StudentDashBoard() {
		setTitle("College Academics Management System");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 297, 663);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		lblNewLabel.setBounds(10, 0, 277, 226);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 139, 139));
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(0, 282, 297, 45);
		panel.add(btnNewButton);
		
		JButton btnMarks = new JButton("Marks");
		btnMarks.setForeground(new Color(0, 0, 0));
		
		btnMarks.setBackground(new Color(0, 139, 139));
		btnMarks.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMarks.setBounds(0, 357, 297, 45);
		panel.add(btnMarks);
		
		JButton btnAttendance = new JButton("Attendance");
		btnAttendance.setForeground(new Color(0, 0, 0));
		
		btnAttendance.setBackground(new Color(0, 139, 139));
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAttendance.setBounds(0, 440, 297, 45);
		panel.add(btnAttendance);
		
		JButton btnOthers = new JButton("Others");
		btnOthers.setForeground(new Color(0, 0, 0));
		
		btnOthers.setBackground(new Color(0, 139, 139));
		btnOthers.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnOthers.setBounds(0, 514, 297, 45);
		panel.add(btnOthers);
		
		JButton btnEit = new JButton("Exit");
		btnEit.setForeground(new Color(0, 0, 0));
		
		btnEit.setBackground(new Color(0, 139, 139));
		btnEit.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEit.setBounds(0, 591, 297, 45);
		panel.add(btnEit);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(153, 255, 51));
		tabbedPane.setBounds(296, 25, 990, 638);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Profile", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma", Font.BOLD, 20));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(29, 10, 639, 33);
		panel_1.add(name);
		
		JLabel lblNewLabel_2 = new JLabel("image");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(711, 10, 264, 303);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("USN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(29, 101, 165, 39);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Branch");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_1.setBounds(29, 150, 165, 39);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Year");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_2.setBounds(29, 199, 165, 39);
		panel_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Semester");
		lblNewLabel_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_3.setBounds(29, 248, 165, 39);
		panel_1.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("Email");
		lblNewLabel_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_4.setBounds(29, 297, 165, 39);
		panel_1.add(lblNewLabel_3_4);
		
		JTextField USN = new JTextField("");
		USN.setEditable(false);
		USN.setBackground(new Color(255, 255, 255));
		USN.setHorizontalAlignment(SwingConstants.LEFT);
		USN.setFont(new Font("Tahoma", Font.BOLD, 18));
		USN.setBounds(213, 101, 455, 39);
		panel_1.add(USN);
		
		text_branch = new JTextField("");
		text_branch.setBackground(new Color(255, 255, 255));
		text_branch.setHorizontalAlignment(SwingConstants.LEFT);
		text_branch.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_branch.setEditable(false);
		text_branch.setBounds(213, 150, 455, 39);
		panel_1.add(text_branch);
		
		text_year = new JTextField("");
		text_year.setBackground(new Color(255, 255, 255));
		text_year.setHorizontalAlignment(SwingConstants.LEFT);
		text_year.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_year.setEditable(false);
		text_year.setBounds(213, 199, 455, 39);
		panel_1.add(text_year);
		
		textField_2 = new JTextField("");
		textField_2.setBackground(new Color(255, 255, 255));
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField_2.setEditable(false);
		textField_2.setBounds(213, 248, 455, 39);
		panel_1.add(textField_2);
		
		text_email = new JTextField("");
		text_email.setBackground(new Color(255, 255, 255));
		text_email.setHorizontalAlignment(SwingConstants.LEFT);
		text_email.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_email.setEditable(false);
		text_email.setBounds(213, 297, 455, 39);
		panel_1.add(text_email);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("CGPA");
		lblNewLabel_3_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3_4_1.setBounds(29, 350, 165, 39);
		panel_1.add(lblNewLabel_3_4_1);
		
		text_cgpa = new JTextField("");
		text_cgpa.setHorizontalAlignment(SwingConstants.LEFT);
		text_cgpa.setFont(new Font("Tahoma", Font.BOLD, 18));
		text_cgpa.setEditable(false);
		text_cgpa.setBackground(Color.WHITE);
		text_cgpa.setBounds(213, 346, 455, 39);
		panel_1.add(text_cgpa);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Marks", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Subjects");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_4.setBounds(28, 42, 193, 38);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Subjects");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1.setBounds(28, 116, 193, 27);
		panel_2.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Subjects");
		lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(28, 153, 193, 27);
		panel_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Subjects");
		lblNewLabel_4_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_3.setBounds(28, 190, 193, 27);
		panel_2.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("Subjects");
		lblNewLabel_4_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_4.setBounds(28, 227, 193, 27);
		panel_2.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("Subjects");
		lblNewLabel_4_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_5.setBounds(28, 264, 193, 27);
		panel_2.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("Subjects");
		lblNewLabel_4_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_6.setBounds(28, 301, 193, 27);
		panel_2.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("Subjects");
		lblNewLabel_4_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_7.setBounds(28, 338, 193, 27);
		panel_2.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_4_8 = new JLabel("Subjects");
		lblNewLabel_4_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_8.setBounds(28, 375, 193, 27);
		panel_2.add(lblNewLabel_4_8);
		
		JLabel lblNewLabel_4_9 = new JLabel("Subjects");
		lblNewLabel_4_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_9.setBounds(28, 412, 193, 27);
		panel_2.add(lblNewLabel_4_9);
		
		JLabel lblNewLabel_4_10 = new JLabel("Subjects");
		lblNewLabel_4_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_10.setBounds(28, 449, 193, 27);
		panel_2.add(lblNewLabel_4_10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setBounds(440, 116, 106, 27);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(547, 116, 106, 27);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(654, 116, 106, 27);
		panel_2.add(textField_8);
		
		txtCie = new JTextField();
		txtCie.setHorizontalAlignment(SwingConstants.CENTER);
		txtCie.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCie.setText("CIE");
		txtCie.setEditable(false);
		txtCie.setColumns(10);
		txtCie.setBounds(440, 64, 106, 38);
		panel_2.add(txtCie);
		
		txtCredits = new JTextField();
		txtCredits.setHorizontalAlignment(SwingConstants.CENTER);
		txtCredits.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCredits.setText("Credits");
		txtCredits.setEditable(false);
		txtCredits.setColumns(10);
		txtCredits.setBounds(547, 64, 106, 38);
		panel_2.add(txtCredits);
		
		txtEligible = new JTextField();
		txtEligible.setHorizontalAlignment(SwingConstants.CENTER);
		txtEligible.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtEligible.setText("Eligible");
		txtEligible.setEditable(false);
		txtEligible.setColumns(10);
		txtEligible.setBounds(654, 64, 106, 38);
		panel_2.add(txtEligible);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(440, 153, 106, 27);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(547, 153, 106, 27);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(654, 153, 106, 27);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(440, 190, 106, 27);
		panel_2.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(547, 190, 106, 27);
		panel_2.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(654, 190, 106, 27);
		panel_2.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(440, 227, 106, 27);
		panel_2.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(547, 227, 106, 27);
		panel_2.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(654, 227, 106, 27);
		panel_2.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setEditable(false);
		textField_18.setColumns(10);
		textField_18.setBounds(440, 264, 106, 27);
		panel_2.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(547, 264, 106, 27);
		panel_2.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(654, 264, 106, 27);
		panel_2.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setColumns(10);
		textField_21.setBounds(440, 301, 106, 27);
		panel_2.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(547, 301, 106, 27);
		panel_2.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(654, 301, 106, 27);
		panel_2.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBounds(440, 338, 106, 27);
		panel_2.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setEditable(false);
		textField_25.setColumns(10);
		textField_25.setBounds(547, 338, 106, 27);
		panel_2.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setEditable(false);
		textField_26.setColumns(10);
		textField_26.setBounds(654, 338, 106, 27);
		panel_2.add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setEditable(false);
		textField_27.setColumns(10);
		textField_27.setBounds(440, 375, 106, 27);
		panel_2.add(textField_27);
		
		textField_28 = new JTextField();
		textField_28.setEditable(false);
		textField_28.setColumns(10);
		textField_28.setBounds(547, 375, 106, 27);
		panel_2.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setEditable(false);
		textField_29.setColumns(10);
		textField_29.setBounds(654, 375, 106, 27);
		panel_2.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setEditable(false);
		textField_30.setColumns(10);
		textField_30.setBounds(440, 412, 106, 27);
		panel_2.add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setEditable(false);
		textField_31.setColumns(10);
		textField_31.setBounds(547, 412, 106, 27);
		panel_2.add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setEditable(false);
		textField_32.setColumns(10);
		textField_32.setBounds(654, 412, 106, 27);
		panel_2.add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setEditable(false);
		textField_33.setColumns(10);
		textField_33.setBounds(440, 449, 106, 27);
		panel_2.add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setEditable(false);
		textField_34.setColumns(10);
		textField_34.setBounds(547, 449, 106, 27);
		panel_2.add(textField_34);
		
		textField_35 = new JTextField();
		textField_35.setEditable(false);
		textField_35.setColumns(10);
		textField_35.setBounds(654, 449, 106, 27);
		panel_2.add(textField_35);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Attendance", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4_11 = new JLabel("Subjects");
		lblNewLabel_4_11.setBounds(38, 44, 98, 27);
		lblNewLabel_4_11.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_3.add(lblNewLabel_4_11);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Subjects");
		lblNewLabel_4_1_1.setBounds(38, 106, 81, 22);
		lblNewLabel_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_3.add(lblNewLabel_4_1_1);
		
		textField_36 = new JTextField();
		textField_36.setEditable(false);
		textField_36.setColumns(10);
		textField_36.setBounds(558, 106, 106, 27);
		panel_3.add(textField_36);
		
		textField_37 = new JTextField();
		textField_37.setEditable(false);
		textField_37.setColumns(10);
		textField_37.setBounds(665, 106, 106, 27);
		panel_3.add(textField_37);
		
		lblNewLabel_4_1_2 = new JLabel("Subjects");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_2.setBounds(38, 151, 81, 22);
		panel_3.add(lblNewLabel_4_1_2);
		
		textField_38 = new JTextField();
		textField_38.setEditable(false);
		textField_38.setColumns(10);
		textField_38.setBounds(558, 151, 106, 27);
		panel_3.add(textField_38);
		
		textField_39 = new JTextField();
		textField_39.setEditable(false);
		textField_39.setColumns(10);
		textField_39.setBounds(665, 151, 106, 27);
		panel_3.add(textField_39);
		
		lblNewLabel_4_1_3 = new JLabel("Subjects");
		lblNewLabel_4_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_3.setBounds(38, 199, 81, 22);
		panel_3.add(lblNewLabel_4_1_3);
		
		textField_40 = new JTextField();
		textField_40.setEditable(false);
		textField_40.setColumns(10);
		textField_40.setBounds(558, 199, 106, 27);
		panel_3.add(textField_40);
		
		textField_41 = new JTextField();
		textField_41.setEditable(false);
		textField_41.setColumns(10);
		textField_41.setBounds(665, 199, 106, 27);
		panel_3.add(textField_41);
		
		lblNewLabel_4_1_4 = new JLabel("Subjects");
		lblNewLabel_4_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_4.setBounds(38, 250, 81, 22);
		panel_3.add(lblNewLabel_4_1_4);
		
		textField_42 = new JTextField();
		textField_42.setEditable(false);
		textField_42.setColumns(10);
		textField_42.setBounds(558, 250, 106, 27);
		panel_3.add(textField_42);
		
		textField_43 = new JTextField();
		textField_43.setEditable(false);
		textField_43.setColumns(10);
		textField_43.setBounds(665, 250, 106, 27);
		panel_3.add(textField_43);
		
		lblNewLabel_4_1_5 = new JLabel("Subjects");
		lblNewLabel_4_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_5.setBounds(38, 296, 81, 22);
		panel_3.add(lblNewLabel_4_1_5);
		
		textField_44 = new JTextField();
		textField_44.setEditable(false);
		textField_44.setColumns(10);
		textField_44.setBounds(558, 296, 106, 27);
		panel_3.add(textField_44);
		
		textField_45 = new JTextField();
		textField_45.setEditable(false);
		textField_45.setColumns(10);
		textField_45.setBounds(665, 296, 106, 27);
		panel_3.add(textField_45);
		
		lblNewLabel_4_1_6 = new JLabel("Subjects");
		lblNewLabel_4_1_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_6.setBounds(38, 345, 81, 22);
		panel_3.add(lblNewLabel_4_1_6);
		
		textField_46 = new JTextField();
		textField_46.setEditable(false);
		textField_46.setColumns(10);
		textField_46.setBounds(558, 345, 106, 27);
		panel_3.add(textField_46);
		
		textField_47 = new JTextField();
		textField_47.setEditable(false);
		textField_47.setColumns(10);
		textField_47.setBounds(665, 345, 106, 27);
		panel_3.add(textField_47);
		
		lblNewLabel_4_1_7 = new JLabel("Subjects");
		lblNewLabel_4_1_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_7.setBounds(38, 398, 81, 22);
		panel_3.add(lblNewLabel_4_1_7);
		
		textField_48 = new JTextField();
		textField_48.setEditable(false);
		textField_48.setColumns(10);
		textField_48.setBounds(558, 398, 106, 27);
		panel_3.add(textField_48);
		
		textField_49 = new JTextField();
		textField_49.setEditable(false);
		textField_49.setColumns(10);
		textField_49.setBounds(665, 398, 106, 27);
		panel_3.add(textField_49);
		
		lblNewLabel_4_1_8 = new JLabel("Subjects");
		lblNewLabel_4_1_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_8.setBounds(38, 446, 81, 22);
		panel_3.add(lblNewLabel_4_1_8);
		
		textField_50 = new JTextField();
		textField_50.setEditable(false);
		textField_50.setColumns(10);
		textField_50.setBounds(558, 446, 106, 27);
		panel_3.add(textField_50);
		
		textField_51 = new JTextField();
		textField_51.setEditable(false);
		textField_51.setColumns(10);
		textField_51.setBounds(665, 446, 106, 27);
		panel_3.add(textField_51);
		
		lblNewLabel_4_1_9 = new JLabel("Subjects");
		lblNewLabel_4_1_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_9.setBounds(38, 494, 81, 22);
		panel_3.add(lblNewLabel_4_1_9);
		
		textField_52 = new JTextField();
		textField_52.setEditable(false);
		textField_52.setColumns(10);
		textField_52.setBounds(558, 494, 106, 27);
		panel_3.add(textField_52);
		
		textField_53 = new JTextField();
		textField_53.setEditable(false);
		textField_53.setColumns(10);
		textField_53.setBounds(665, 494, 106, 27);
		panel_3.add(textField_53);
		
		lblNewLabel_4_1_10 = new JLabel("Subjects");
		lblNewLabel_4_1_10.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4_1_10.setBounds(38, 542, 81, 22);
		panel_3.add(lblNewLabel_4_1_10);
		
		textField_54 = new JTextField();
		textField_54.setEditable(false);
		textField_54.setColumns(10);
		textField_54.setBounds(558, 542, 106, 27);
		panel_3.add(textField_54);
		
		textField_55 = new JTextField();
		textField_55.setEditable(false);
		textField_55.setColumns(10);
		textField_55.setBounds(665, 542, 106, 27);
		panel_3.add(textField_55);
		
		txtEleigible = new JTextField();
		txtEleigible.setText("Eligible");
		txtEleigible.setHorizontalAlignment(SwingConstants.CENTER);
		txtEleigible.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEleigible.setEditable(false);
		txtEleigible.setColumns(10);
		txtEleigible.setBounds(665, 44, 106, 38);
		panel_3.add(txtEleigible);
		
		txtPercentage = new JTextField();
		txtPercentage.setText("Percentage");
		txtPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		txtPercentage.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtPercentage.setEditable(false);
		txtPercentage.setColumns(10);
		txtPercentage.setBounds(558, 44, 106, 38);
		panel_3.add(txtPercentage);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Others", null, panel_4, null);
		panel_4.setLayout(null);
		
		btnNewButton_1 = new JButton("Update Profile");
		btnNewButton_1.setBackground(new Color(221, 160, 221));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(29, 38, 440, 129);
		panel_4.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Exam Registration");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ExamRegistration frame = new ExamRegistration();
					frame.setVisible(true);
					dispose();
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(152, 251, 152));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(512, 38, 440, 129);
		panel_4.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Subject Registration");
		btnNewButton_3.setBackground(new Color(169, 169, 169));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(29, 219, 440, 129);
		panel_4.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Faculty Profiles");
		btnNewButton_4.setBackground(new Color(250, 235, 215));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_4.setBounds(512, 219, 440, 129);
		panel_4.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Assignments");
		btnNewButton_5.setBackground(new Color(102, 205, 170));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_5.setBounds(29, 402, 440, 129);
		panel_4.add(btnNewButton_5);
		
		btnNewButton_6 = new JButton("Notes");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_6.setBackground(new Color(112, 128, 144));
		btnNewButton_6.setBounds(512, 402, 440, 129);
		panel_4.add(btnNewButton_6);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(0);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(1);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnAttendance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(2);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tabbedPane.setSelectedIndex(3);
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		
		btnEit.addActionListener(new ActionListener() {
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
		
		try {
			DatabaseOperation dbo = new DatabaseOperation();
			Database db = new Database();
			Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
			Statement st = conn.createStatement();
			ResultSet res = st.executeQuery("select * from student_database;");
			while(res.next()) {
				if(LoginWindow.st_usn.equals(res.getString("student_usn"))) {
					name.setText(res.getString("student_name"));
					USN.setText(LoginWindow.st_usn);
					text_branch.setText(res.getString("student_branch"));
					text_year.setText(res.getString("student_year"));
					text_email.setText(res.getString("student_email"));
				}
			}
		} catch(Exception exp) {
			exp.printStackTrace();
		}
//		setUndecorated(true);
		
	}
}
