package gr.ihu.tictactoe;

import  java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.SQLException;
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
    //1try
//    public  Connection getConnection(){
//        String databaseName = "user_account";
//        String databaseUser = "user";
//        String databasePassword = "!PutYourPassword!";
//        String url = "jdbc:mysql://users.it.ihu.gr:3333/it175073/mysql/data/quarto_db/" + databaseName;
//
//        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
//        }catch (Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
//
//        return databaseLink;
//    }


}
