package Version_2.src;

import java.sql.*;

public class DataBase {
    Connection con;

    public DataBase() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:sqlite: gameOfLife.db [;Attribut=Wert]*");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS GAMEOFLIFE ("
                + "ID INT AUTO_INCREMENT PRIMARY KEY,"
                + "GENERATION TEXT,"
                + "INHALT INT);";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlCreateTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }


}
