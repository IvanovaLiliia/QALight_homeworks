package aqa_lecture_10;

import java.sql.*;

public class GetTableInfo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://109.197.216.90:13306/ATAM_db";
        String user = "root";
        String password = "6Ztz3rsrVNeWfbCH";
        String tableName = "Ivanova_usersDataTable";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connection is success!\n");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tableName + "`");

            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print(String.format("%-20s", rsMeta.getColumnName(i)));
            }
            System.out.println();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print("--------------------");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    System.out.print(String.format("%-20s", value));
                }
                System.out.println();
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
