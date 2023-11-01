import java.sql.*;

public class Test {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://192.168.56.101:4567/madang", "root", "1234");
			Statement stmt = con.createStatement();

			System.out.println("시작\n");
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			System.out.println("\nbookid 21번, 22번 삭제\n");

			int update = stmt.executeUpdate("DELETE FROM Book WHERE bookid = '21'");
			System.out.println("\n 21번 삭제 결과: " + update + "\n");
			update = stmt.executeUpdate("DELETE FROM Book WHERE bookid = '22'");
			System.out.println("\n 22번 결과: " + update + "\n");

			rs = stmt.executeQuery("SELECT * FROM Book");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			System.out.println("\n아름다운 강산 삽입\n");

			update = stmt.executeUpdate(
					"INSERT INTO Book(bookid, bookname, publisher, price) VALUES(11, '아름다운 강산', '충북대학교', 20000)");
			System.out.println("\n Insert 결과: " + update + "\n");

			rs = stmt.executeQuery("SELECT * FROM Book");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}
			
			System.out.println("\nbookid 11번 검색\n");
			
			rs = stmt.executeQuery("SELECT * FROM Book WHERE bookid='11'");

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
