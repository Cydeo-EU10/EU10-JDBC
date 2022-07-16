package bookITdb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

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
       String query = "select firstname, lastname, role, t.name,t.batch_number, c.location\n" +
               "from users u join team t on u.team_id = t.id\n" +
               "             join campus c on u.campus_id=c.id\n" +
               "where firstname='Ase'";

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

    @Test
    public void rsmdTest() throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int columnCount = resultSetMetaData.getColumnCount();
        System.out.println("columnCount = " + columnCount);
        System.out.println("resultSetMetaData = " + resultSetMetaData.getColumnName(5));
        Map<String,Object> resultOfQuery = new LinkedHashMap<>();

        resultSet.next();
        for (int i = 1; i <= columnCount; i++) {
            resultOfQuery.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));
     }

        System.out.println("resultOfQuery = " + resultOfQuery);
    }

}
