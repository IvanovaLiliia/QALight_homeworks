package aqa_lecture_10;

import org.testng.internal.collections.Pair;

import java.sql.*;

public class DBDataProvider {

    public static Pair <String, String> getUserInfo() {
        Pair<String, String> usersData = null;

        String url = "jdbc:mysql://109.197.216.90:13306/ATAM_db";
        String user = "root";
        String password = "6Ztz3rsrVNeWfbCH";


        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            String sql = "SELECT login, password FROM Ivanova_usersDataTable";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                String userEmail = result.getString("login");
                String userPassword = result.getString("password");
                usersData = Pair.of(userEmail, userPassword);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usersData;
    }
}
