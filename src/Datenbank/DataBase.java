package Version_2.src.Datenbank;

import java.sql.*;

public class DataBase {
    private Connection con;

    public DataBase() {
        String sqlCreateTable = "CREATE TABLE IF NOT EXISTS gameOfLife ( " +
                "ID INTEGER NOT NULL  PRIMARY KEY AUTOINCREMENT," +
                "generationNr INT," +
                "generation TEXT);";
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

    public void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveGeneration(int[][] pGeneration, int pGenerationNr) {

        String insertSQL = "INSERT INTO gameOfLife" +
                "(generationNr, generation)" +
                "Values(" + pGenerationNr + ",\"" + GenerationSerializer.serialize(pGeneration) + "\"" + ");";


        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(insertSQL);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int[][] readGeneration(int pGenerationNr) {
        String sqlQuery = "SELECT * FROM gameOfLife WHERE generationnr = " + pGenerationNr;
        int[][] holdGeneration = new int[6][6];
        try {
            Statement stmt = con.createStatement();
            ResultSet table = stmt.executeQuery(sqlQuery);
            ResultSetMetaData metaData = table.getMetaData();
            holdGeneration = GenerationSerializer.deserialize(table.getString(3));
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return holdGeneration;
    }

    public void loescheLetzterDruchgang() {
        String sqlDelete = "DELETE FROM gameOfLife";
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
