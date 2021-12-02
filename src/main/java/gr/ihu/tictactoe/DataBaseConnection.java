package gr.ihu.tictactoe;

import  java.sql.Connection;
import  java.sql.DriverManager;

public class DataBaseConnection {
    public Connection databaseLink;

    public  Connection getConnection(){
        String databaseName = "it175073";
        String databaseUser = "it175073";
        String databasePassword = "!Perisarrow23..";
        String url = "jdbc:myssql://locahost/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }
}
