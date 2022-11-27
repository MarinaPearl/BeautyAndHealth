package ru.Demchuck.BeautyAndHealth.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" +
                dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

    public void insertProduct(String brand, String shortDescription, String volume, int price, String description, int key) throws SQLException, ClassNotFoundException {
        String table = null;
        switch (key) {
            case 0 -> table = Const.EYECREAM_TABLE;
            case 1 -> table = Const.HANDCREAM_TABLE;
            case 2 -> table = Const.SHAMPOO_TABLE;
        }
        String insert = "INSERT INTO " + table + "(" + Const.BRAND +
                "," + Const.SHORTDESCRIPTION + "," + Const.VOLUME + "," +
                Const.PRICE + "," + Const.DESCRIPTION + ")" +
                "VALUES(?,?,?,?,?)";
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        prSt.setString(1, brand);
        prSt.setString(2, shortDescription);
        prSt.setString(3, volume);
        prSt.setInt(4, price);
        prSt.setString(5, description);
        prSt.executeUpdate();

    }
}
