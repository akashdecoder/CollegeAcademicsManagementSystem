import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class UpdateStudentProfile extends JFrame {

	private JPanel contentPane;
	private JTextField st_name;
	private JTextField st_usn;
	private JTextField st_email;
	private JTextField st_pass;
	private JTextField st_cpass;

	public UpdateStudentProfile() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\akashdecoder.github.io-master\\Sit.png"));
		setTitle("College Academics Mangement System | Update Student Profile");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1136, 678);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(2, 0, 1112, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		
		st_name = new JTextField();
		st_name.setFont(new Font("Tahoma", Font.BOLD, 18));
		st_name.setColumns(10);
		st_name.setBounds(281, 164, 483, 46);
		panel.add(st_name);
		
		st_usn = new JTextField();
		st_usn.setFont(new Font("Tahoma", Font.BOLD, 18));
		st_usn.setColumns(10);
		st_usn.setBounds(281, 218, 483, 46);
		panel.add(st_usn);
		
		st_email = new JTextField();
		st_email.setFont(new Font("Tahoma", Font.BOLD, 18));
		st_email.setColumns(10);
		st_email.setBounds(281, 270, 483, 46);
		panel.add(st_email);
		
		st_pass = new JTextField();
		st_pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		st_pass.setColumns(10);
		st_pass.setBounds(281, 321, 483, 46);
		panel.add(st_pass);
		
		st_cpass = new JTextField();
		st_cpass.setFont(new Font("Tahoma", Font.BOLD, 18));
		st_cpass.setColumns(10);
		st_cpass.setBounds(281, 377, 483, 46);
		panel.add(st_cpass);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmPassword.setBounds(66, 388, 178, 29);
		panel.add(lblConfirmPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(66, 326, 178, 29);
		panel.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEmail.setBounds(66, 275, 178, 29);
		panel.add(lblEmail);
		
		JLabel lblUsn = new JLabel("USN");
		lblUsn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsn.setBounds(66, 223, 178, 29);
		panel.add(lblUsn);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(66, 169, 178, 29);
		panel.add(lblNewLabel);
		
		JCheckBox confirm_update = new JCheckBox("Are you sure? You want to update your profile");
		confirm_update.setFont(new Font("Tahoma", Font.BOLD, 18));
		confirm_update.setBackground(new Color(176, 224, 230));
		confirm_update.setBounds(66, 467, 687, 37);
		panel.add(confirm_update);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from student_database;");
					while(res.next()) {
						if(LoginWindow.st_usn.equals(res.getString
							("student_usn")) && 
							st_pass.getText().equals(st_cpass.getText()) && 
							confirm_update.isSelected()){
							flag = true;
						}
					}
					if(flag == true) {
						dbo.updateStudentProfile(conn, LoginWindow.st_usn, st_name.getText().toString()
								, st_usn.getText().toString(),
								st_email.getText().toString(), 
								st_pass.getText().toString());
						JOptionPane.showMessageDialog(null,"Profile Updated");
					} else {
						JOptionPane.showMessageDialog(null,"Error, Please Check your details or contact Software Vendor");
					}
				} catch(Exception exp) {
					JOptionPane.showMessageDialog(null,"Error, Please Check your details or contact Software Vendor");
				}
			}
		});
		update.setFont(new Font("Tahoma", Font.BOLD, 18));
		update.setBackground(new Color(144, 238, 144));
		update.setBounds(132, 557, 208, 52);
		panel.add(update);
		
		JButton cancel = new JButton("Reset");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					st_name.setText("");
					st_usn.setText("");
					st_email.setText("");
					st_pass.setText("");
					st_cpass.setText("");
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		cancel.setFont(new Font("Tahoma", Font.BOLD, 18));
		cancel.setBackground(new Color(221, 160, 221));
		cancel.setBounds(509, 557, 208, 52);
		panel.add(cancel);
		
		JButton update_image = new JButton("Upload Image");
		update_image.setFont(new Font("Tahoma", Font.BOLD, 18));
		update_image.setBackground(new Color(255, 250, 205));
		update_image.setBounds(843, 246, 208, 52);
		panel.add(update_image);
		
		JLabel lblNewLabel_1_8 = new JLabel("Update Profile");
		lblNewLabel_1_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_8.setForeground(new Color(186, 85, 211));
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_1_8.setBounds(132, 31, 625, 78);
		panel.add(lblNewLabel_1_8);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
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
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(0, 0, 76, 73);
		panel.add(btnNewButton_1);
	}
}
