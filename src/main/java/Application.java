import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "ugvbfp8d";
        final String URL = "jdbc:postgresql://localhost:5432/skyproram";


        return DriverManager.getConnection(URL,user,password);



    }

