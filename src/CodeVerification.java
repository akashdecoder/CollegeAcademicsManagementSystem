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
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class CodeVerification extends JFrame {

	private JPanel contentPane;
	private JTextField code;
	
	public CodeVerification(String category) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\SIT-Tumkur-Logo.png"));
		setBackground(new Color(255, 255, 255));
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
		
		JLabel lblNewLabel = new JLabel("CODE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 134, 98, 31);
		panel.add(lblNewLabel);
		
		code = new JTextField();
		code.setFont(new Font("Tahoma", Font.BOLD, 18));
		code.setBounds(118, 134, 329, 31);
		panel.add(code);
		code.setColumns(10);
		
		JButton verify = new JButton("Verify");
		verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				try {
					DatabaseOperation dbo = new DatabaseOperation();
					Database db = new Database();
					Connection conn = dbo.getConnection(db.url, db.userName, db.userPassword);
					Statement st = conn.createStatement();
					ResultSet res = st.executeQuery("select * from verification_codes;");
					while(res.next()) {
						if(code.getText().toString().equals(res.getString("veri_code"))) {
							flag = true;
						}
					}
					if(flag == true) {
						dispose();
						ForgotPassword frame = new ForgotPassword(category);
						frame.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null,"Wrong CODE!! Check the code sent to your mail");
					}
				}catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});
		verify.setBackground(new Color(0, 255, 51));
		verify.setFont(new Font("Tahoma", Font.BOLD, 18));
		verify.setBounds(313, 222, 134, 42);
		panel.add(verify);
		
		JLabel lblNewLabel_1 = new JLabel("CODE Verification");
		lblNewLabel_1.setForeground(new Color(204, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(118, 10, 329, 61);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\icons\\left-arrow.png"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 10, 76, 73);
		panel.add(btnNewButton_1);
	}

}
