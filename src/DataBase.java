package Version_2.src;

import java.sql.*;

public class DataBase {
    Connection con;

    public DataBase() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS gameOfLife ("
                + "ID INT AUTO_INCREMENT PRIMARY KEY  ,"
                + "generationNr INT,"
                + "generation TEXT)";
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite: gameOfLife.db");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlCreateTable);
            stmt.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveGeneration(int[][] pGeneration, int pGenerationNr) {

        String insertSQL = "INSERT INTO gameOfLife" +
                "(generationNr, generation)" +
                "Values(" + pGenerationNr +",\"" + GenerationSerializer.serialize(pGeneration) + "\"" + ");";

        System.out.println(insertSQL);

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(insertSQL);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
