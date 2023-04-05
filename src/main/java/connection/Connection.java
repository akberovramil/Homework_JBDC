package connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connection {
    public java.sql.Connection getConnection() throws SQLException {

        final String user = "postgres";
        final String password = "ugvbfp8d";
        final String URL = "jdbc:postgresql://localhost:5432/skyproram";

        return DriverManager.getConnection(URL,user,password);


    }

    public PreparedStatement getPreparedStatement (String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }
}
