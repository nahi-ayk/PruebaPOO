/**
 * clase ejecutable de la clase Alumno.
 *
 * @author (Meza Nahiara)
 * @version (15/08/25)
 */
public class AlumnoEjecutable{
    //metodo main de la clase ejecutable
    public static void main(String[] args){
        //ingreso por argumento del main
        int lu = Integer.valueOf(args[0]);
        String nombre = (args[1]);
        String apellido = (args[2]);
        double nota1 = Double.parseDouble(args[3]);
        double nota2 = Double.parseDouble(args[4]);

        //instancia de clase
        Alumno unAlumno = new Alumno(lu, nombre, apellido);
        unAlumno.setNota1(nota1);
        unAlumno.setNota2(nota2);

        //prueba metodo mostrar()
        unAlumno.mostrar();

        //ingreso por argumento del main de otra instancia
        int lu2 = Integer.valueOf(args[5]);
        String nombre2 = (args[6]);
        String apellido2 = (args[7]);

        Alumno otroAlumno = new Alumno(lu2, nombre2, apellido2);

        //prueba de metodo apeYNom()
        System.out.println("\nApellido y Nombre: ");
        System.out.println(otroAlumno.apeYNom());
    }
}