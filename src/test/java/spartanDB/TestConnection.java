package spartanDB;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class TestConnection {

    // connection string
    String dbURL ="jdbc:oracle:thin:@44.202.119.26:1521:xe";
    String dbUsername = "SP";
    String dbPassword = "SP";
    String query = "select name from spartans";
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @BeforeEach
    public void connectDB() throws SQLException {
        connection = DriverManager.getConnection(dbURL,dbUsername,dbPassword); // step 1 connect
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY); // 2. for sending query I need statement object
        resultSet = statement.executeQuery(query);
    }
    @AfterEach
    public void closeDB() throws SQLException {
        resultSet.close();
        statement.close();
        connection.close();
    }
    @Test
    public void test1() throws SQLException {
        resultSet.next(); // move cursor to next row
        int row = resultSet.getRow();
        System.out.println("row = " + row);

        // go to last row and get rownumber : for this one we need to configure statement object insensetive
        resultSet.last();
        System.out.println("resultSet = " + resultSet.getRow());
    }
}
