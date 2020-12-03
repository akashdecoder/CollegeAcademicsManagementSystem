import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField new_pass;
	private JTextField Username;
	private String Category;

	public ForgotPassword(String category) {
		Category = category;
		setBackground(Color.WHITE);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setTitle("Reset Password");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 245, 238));
		panel.setBounds(0, 0, 786, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 142, 274, 33);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("New Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(20, 185, 274, 33);
		panel.add(lblPassword);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm New Password");
		lblConfirmNewPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmNewPassword.setBounds(20, 228, 274, 33);
		panel.add(lblConfirmNewPassword);
		
		Username = new JTextField();
		Username.setFont(new Font("Tahoma", Font.BOLD, 18));
		Username.setBounds(304, 142, 338, 33);
		panel.add(Username);
		
		new_pass = new JTextField();
		new_pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		new_pass.setBounds(304, 185, 338, 33);
		panel.add(new_pass);
		
		JTextField con_new_pass = new JTextField();
		con_new_pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		con_new_pass.setBounds(304, 228, 338, 33);
		panel.add(con_new_pass);
		
		JLabel lblNewLabel_1 = new JLabel("Reset Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(176, 10, 413, 93);
		panel.add(lblNewLabel_1);
		
		JButton update_pass = new JButton("Update Password");
		update_pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				PreparedStatement pst;
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					if(category.equals("Student")) {
						System.out.println("Student database");
						ResultSet res = st.executeQuery("select * from student_database;");
						while(res.next()) {
							if((Username.getText().toString().equals(res.getString("student_usn"))) && 
									(new_pass.getText().toString().equals(con_new_pass.getText().toString()))) {
								flag = true;
							}
						}
						if(flag == true) {
							String query= "update student_database set student_password = ? where student_usn = ?;";
							pst = conn.prepareStatement(query);
							pst.setString(1, new_pass.getText().toString());
							pst.setString(2, Username.getText().toString());
							int status = pst.executeUpdate();
							JOptionPane.showMessageDialog(null,"Reset of Password is Successful.");
						} else {
							JOptionPane.showMessageDialog(null,"Error, User doesn not exists. Register first.");
						}
					} else if(category.equals("Faculty")) {
						ResultSet res = st.executeQuery("select * from faculty_database;");
						while(res.next()) {
							if((Username.getText().toString().equals(res.getString("faculty_name"))) && 
									(new_pass.getText().toString().equals(con_new_pass.getText().toString()))) {
								flag = true;
							}
						}
						if(flag == true) {
							String query= "update faculty_database set faculty_password = ? where faculty_name = ?;";
							pst = conn.prepareStatement(query);
							pst.setString(1, new_pass.getText().toString());
							pst.setString(2, Username.getText().toString());
							int status = pst.executeUpdate();
							JOptionPane.showMessageDialog(null,"Reset of Password is Successful.");
						} else {
							JOptionPane.showMessageDialog(null,"Error, User doesn not exists. Register first.");
						}
					}
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		update_pass.setBackground(new Color(102, 255, 102));
		update_pass.setFont(new Font("Tahoma", Font.BOLD, 18));
		update_pass.setBounds(269, 322, 232, 60);
		panel.add(update_pass);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Category.equals("Student")) {
						LoginWindow frame = new LoginWindow("Student");
						frame.setVisible(true);
						dispose();
					} else if(Category.equals("Faculty")) {
						FacultyLoginWindow frame = new FacultyLoginWindow();
						frame.setVisible(true);
						dispose();
					}
				} catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		btnNewButton_1.setBackground(new Color(255, 245, 238));
		btnNewButton_1.setBounds(10, 10, 76, 73);
		panel.add(btnNewButton_1);
	}
}
