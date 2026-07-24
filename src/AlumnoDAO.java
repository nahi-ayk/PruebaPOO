import conexion.ConexionJava;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AlumnoDAO {

    public void guardar(Alumno alumno) {

        String sql = "INSERT INTO alumno(lu,nombre,apellido,nota1,nota2) VALUES(?,?,?,?,?)";

        try {

            Connection con = ConexionJava.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, alumno.getLU());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDouble(4, alumno.getNota1());
            ps.setDouble(5, alumno.getNota2());

            ps.executeUpdate();

            System.out.println("Alumno guardado correctamente.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Alumno buscar(int lu){
        Alumno alumno = null;

        String sql = "SELECT * FROM alumno WHERE lu = ?";

        try {

            Connection con = ConexionJava.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, lu);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                alumno = new Alumno(
                        rs.getInt("lu"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );

                alumno.setNota1(rs.getDouble("nota1"));
                alumno.setNota2(rs.getDouble("nota2"));

            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return alumno;
    }

    public void modificar(Alumno alumno) {

        String sql = """
            UPDATE alumno
            SET nombre = ?, apellido = ?, nota1 = ?, nota2 = ?
            WHERE lu = ?
            """;

        try {

            Connection con = ConexionJava.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setDouble(3, alumno.getNota1());
            ps.setDouble(4, alumno.getNota2());
            ps.setInt(5, alumno.getLU());

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public void eliminar(int lu) {

        String sql = "DELETE FROM alumno WHERE lu = ?";

        try {

            Connection con = ConexionJava.conectar();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, lu);

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}