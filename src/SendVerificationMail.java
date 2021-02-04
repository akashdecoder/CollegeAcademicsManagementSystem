import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.Database;
import database.DatabaseOperation;
import mail.SendMail;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class SendVerificationMail extends JFrame {

	private JPanel contentPane;
	private JTextField mail_id;
	
	public static String usn;
	
	public SendVerificationMail(String category) {
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setTitle("Send Verification Mail");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 586, 313);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Send Verification Mail");
		lblNewLabel.setForeground(new Color(0, 153, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(88, 15, 448, 68);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the Email id linked with the software");
		lblNewLabel_1.setForeground(new Color(204, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 116, 512, 34);
		panel.add(lblNewLabel_1);
		
		mail_id = new JTextField();
		mail_id.setFont(new Font("Tahoma", Font.BOLD, 20));
		mail_id.setBounds(10, 160, 512, 56);
		panel.add(mail_id);
		mail_id.setColumns(10);
		
		JButton send_mail = new JButton("Send Mail");
		send_mail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false, flag1 = false ;
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					SendMail mail = new SendMail();
					PreparedStatement pst;
					Statement st = conn.createStatement();
					if(category.equals("Faculty")) {
						ResultSet res = st.executeQuery("select * from faculty_database;");
						while(res.next()) {
							if(mail_id.getText().toString().equals(res.getString("faculty_email"))) {
								flag = true;
							}
						}
						if(flag == true) {
							res = st.executeQuery("select * from verification_codes;");
							while(res.next()) {
								if(res.getInt("sent_count") > 0 && 
										mail_id.getText().toString().equals(res.getString("email"))) {
									flag1 = true;
								}
							}
							if(flag1 == true) {
								String otp = mail.OTP(6);
								String email = mail_id.getText().toString();
								pst = conn.prepareStatement("update verification_codes set veri_code = ? "
										+ "where email = ?;");
								pst.setString(1, otp);
								pst.setString(2, email);
								int status = pst.executeUpdate();
								mail.sendMail(email, otp);
								JOptionPane.showMessageDialog(null,"Verification mail sent to " + email);
								dispose();
								CodeVerification frame = new CodeVerification(category);
								frame.setVisible(true);
							} else {
								String otp = mail.OTP(6);
								String email = mail_id.getText().toString();
								pst = conn.prepareStatement("insert into verification_codes(email, veri_code, sent_count)"
										+ " values (?, ?, ?);");
								pst.setString(1, email);
								pst.setString(2, otp);
								pst.setInt(3, 1);
								int status = pst.executeUpdate();
								mail.sendMail(email, otp);
								JOptionPane.showMessageDialog(null,"Verification mail sent to " + email);
								dispose();
								CodeVerification frame = new CodeVerification(category);
								frame.setVisible(true);
							}
						} else {
							JOptionPane.showMessageDialog(null,"Wrong Mail Id");
						}
					} else {
						ResultSet res = st.executeQuery("select * from student_database;");
						while(res.next()) {
							if(mail_id.getText().toString().equals(res.getString("student_email"))) {
								usn = res.getString("student_usn");
								flag = true;
							}
						}
						if(flag == true) {
							res = st.executeQuery("select * from verification_codes;");
							while(res.next()) {
								if(res.getInt("sent_count") > 0 && 
										mail_id.getText().toString().equals(res.getString("email"))) {
									flag1 = true;
								}
							}
							if(flag1 == true) {
								String otp = mail.OTP(6);
								String email = mail_id.getText().toString();
								pst = conn.prepareStatement("update verification_codes set veri_code = ? "
										+ "where email = ?;");
								pst.setString(1, otp);
								pst.setString(2, email);
								int status = pst.executeUpdate();
								mail.sendMail(email, otp);
								JOptionPane.showMessageDialog(null,"Verification mail sent to " + email);
								dispose();
								CodeVerification frame = new CodeVerification(category);
								frame.setVisible(true);
							} else {
								String otp = mail.OTP(6);
								String email = mail_id.getText().toString();
								pst = conn.prepareStatement("insert into verification_codes(email, veri_code, sent_count)"
										+ " values (?, ?, ?);");
								pst.setString(1, email);
								pst.setString(2, otp);
								pst.setInt(3, 1);
								int status = pst.executeUpdate();
								mail.sendMail(email, otp);
								JOptionPane.showMessageDialog(null,"Verification mail sent to " + email);
								dispose();
								CodeVerification frame = new CodeVerification(category);
								frame.setVisible(true);
							}
						} else {
							JOptionPane.showMessageDialog(null,"Wrong Mail Id");
						}
					}
				}catch(Exception exp) {
					JOptionPane.showMessageDialog(null,exp.getMessage());
					exp.printStackTrace();
				}
			}
		});
		send_mail.setFont(new Font("Tahoma", Font.BOLD, 18));
		send_mail.setBackground(new Color(51, 255, 0));
		send_mail.setBounds(380, 246, 142, 57);
		panel.add(send_mail);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(10, 10, 76, 73);
		panel.add(btnNewButton_1);
		
		JButton btnForgotMail = new JButton("Forgot Mail");
		btnForgotMail.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnForgotMail.setBackground(new Color(102, 255, 204));
		btnForgotMail.setBounds(10, 246, 142, 57);
		panel.add(btnForgotMail);
	}
}
