import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.awt.event.ActionEvent;

public class ConnectDatabase extends JFrame {

	private JPanel contentPane;
	private JTextField ip_addr;

	public ConnectDatabase() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\akashdecoder.github.io-master\\Sit.png"));
		setTitle("Connect To Database");
		setBackground(new Color(255, 248, 220));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 248, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(0, 0, 652, 367);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("IP Address");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(41, 120, 122, 31);
		panel.add(lblNewLabel);
		
		ip_addr = new JTextField();
		ip_addr.setFont(new Font("Tahoma", Font.BOLD, 14));
		ip_addr.setBounds(204, 120, 374, 31);
		panel.add(ip_addr);
		ip_addr.setColumns(10);
		
		JButton btnNewButton = new JButton("CONNECT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InetAddress localhost = InetAddress.getLocalHost();
					System.out.println(localhost.getHostAddress());
					if(ip_addr.getText().equals(localhost.getHostAddress())) {
						DashBoard frame = new DashBoard();
						frame.setVisible(true);
						dispose();
						JOptionPane.showMessageDialog(null, "Connected to Database Server");
					} else {
						JOptionPane.showMessageDialog(null, "Wrong IP Address");
					}
				} catch(Exception exp) {
					exp.printStackTrace();
					JOptionPane.showMessageDialog(null,exp.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(173, 255, 47));
		btnNewButton.setBounds(204, 217, 180, 40);
		panel.add(btnNewButton);
	}
}
