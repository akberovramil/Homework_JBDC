import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String password = "ugvbfp8d";
        final String URL = "jdbc:postgresql://localhost:5432/skyproram";

        try(final Connection connection = DriverManager.getConnection(URL,user,password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE id = (?)")) {

            statement.setInt(1,1);

            final ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                // С помощью методов getInt и getString получаем данные из resultSet
                String firstName = "First_name: " + resultSet.getString("first_name");
                String lastName = "Last_name: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString("gender");
                int age = resultSet.getInt(5);
                String city = "city_id: " + resultSet.getString("city_id");

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(city);




            }





        }
        }

    }

