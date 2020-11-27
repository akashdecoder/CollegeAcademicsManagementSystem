package database;

import java.net.InetAddress;

public class Database {
	
	public String getIpAddr() {
		String ipAddress = "";
		try {
			InetAddress ipAddr = InetAddress.getLocalHost();
			ipAddress = ipAddr.getHostAddress();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return ipAddress;
	}
	
	public String url = "jdbc:mysql://" + getIpAddr() +  ":3306/cams_database?allowPublicKeyRetrieval=true&useSSL=false";
	public String userName = "root";
	public String userPassword = "Github@2020";
}
