package aqa_lecture_10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class AddDataFromMap {

    public static void main(String[] args) {
        Map<String, String> usersData = LocalStorage.getUSerInfo();

        String url = "jdbc:mysql://109.197.216.90:13306/ATAM_db";
        String user = "root";
        String password = "6Ztz3rsrVNeWfbCH";

        String sql = "INSERT INTO Ivanova_usersDataTable (login, password) VALUES (?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for(Map.Entry<String, String> userData : usersData.entrySet()) {
                preparedStatement.setString(1, userData.getKey());
                preparedStatement.setString(2, userData.getValue());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
