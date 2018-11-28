package library;

import java.sql.*;

public class DatabaseConnectivity {

	public static String DBURL = "jdbc:oracle:thin:@ldap://oid.inf.fedex.com:3060/PLEFS_FIPS_UPD_SVC1_EDC_L4,cn=OracleContext,dc=ute,dc=fedex,dc=com";
	public static String USERNAME = "PLEFS_FIPS_RO_APP";
	public static String PASSWORD = "z71JHfmIXuzrwVQ8yYrziQBTE";
	public static String DbData = null;

	public static String dataBaseConnetion(String testData, String query) throws Exception {

		String data = testData;
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
			System.out.println(query);
			PreparedStatement stmt = con.prepareStatement("select STATUS_CD from FILE_STORAGE where FILE_STORAGE_SEQ_NBR =?");
			stmt.setString(1, data);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DbData = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return DbData;
	}
}