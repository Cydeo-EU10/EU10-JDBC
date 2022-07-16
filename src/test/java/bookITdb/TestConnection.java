package bookITdb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestConnection {

    /*
    Establish a connection
    execute queries and update the statements to the DB
    retrive the results and use it in your test cases

     */

    Connection connection;
     Statement statement;
     ResultSet resultSet;
     @BeforeEach
     public void setConnection() throws SQLException {
       String  dbUsername="qa_user";
       String  dbPassword="Cybertek11!";
       String  dbUrl="jdbc:postgresql://room-reservation-qa3.cxvqfpt4mc2y.us-east-1.rds.amazonaws.com:5432/room_reservation_qa3";
       String query = "select * from users";

         connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
         statement = connection.createStatement();
         resultSet = statement.executeQuery(query);
     }

     @AfterEach
    public void closeConnection() throws SQLException {
         resultSet.close();
         statement.close();
         connection.close();
    }


    @Test
    public void connectionTest() throws SQLException {

        while (resultSet.next()) { // moving the curser to the next row
            System.out.println(resultSet.getString(3));
        }

    }

}
