package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJava {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/poo_base";

    private static final String USER = "root";

    private static final String PASSWORD = "1234";

    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASSWORD);

    }

}
