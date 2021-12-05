package gr.ihu.tictactoe;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {
    //1try
    //public Connection databaseLink;

    private static String HOST = "127.0.0.1";
        private static int PORT = 3306;
        private static String DB_NAME= "user_account";
        private static String USERNAME = "root";
        private static String PASSWORD = "";
        private static Connection databaseLink;

        public static Connection getConnection(){
            try {
                databaseLink = DriverManager.getConnection(String.format("jdbc:mysql://%s:%d/%s", HOST,PORT,DB_NAME),USERNAME,PASSWORD);
            }
            catch (SQLException e) {
                Logger.getLogger(DataBaseConnection.class.getName()).log(Level.SEVERE,null, e );
            }
            return databaseLink;
        }
}
