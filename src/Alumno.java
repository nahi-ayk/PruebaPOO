/**
 * la clase Alumno contiene los datos personales y notas de un alummno
 * (lu, nombre, apellido, notas), calcula su promedio y determina si aprueba o no
 *
 * @author (Meza Nahiara)
 * @version (15/08/25)
 */
public class Alumno{
    //variables de instancia
    private int lu;
    private String nombre;
    private String apellido;
    private double nota1;
    private double nota2;

    /**
     * constructor de la clase Alumno
     *
     * @param p_lu libreta universitaria
     * @param p_nombre nombre de alumno
     * @param p_apellido apellido del alumno
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido){
        //inicializacion de variables de instancia
        this.setLU(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
    }

    //setters (privados)
    private void setLU(int p_lu){
        this.lu = p_lu;
    }

    private void setNombre(String p_nom){
        this.nombre = p_nom;
    }

    private void setApellido(String p_ape){
        this.apellido = p_ape;
    }

    //setters (publicos)
    public void setNota1(double p_nota){
        this.nota1 = p_nota;
    }

    public void setNota2(double p_nota){
        this.nota2 = p_nota;
    }

    //getters (publicos)
    public int getLU(){
        return this.lu;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public double getNota1(){
        return this.nota1;
    }

    public double getNota2(){
        return this.nota2;
    }

    /**
     * metodo aprueba que determina si un alumno aprobo o no
     *
     * @return true si aprobo, false si no lo hizo
     */
    private boolean aprueba(){
        //condicion para aprobar promedio 7 y ambas notas mayores o iguales a 6
        if(promedio() > 7.0 && getNota1() >= 6.0 && getNota2() >= 6.0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * metodo de leyendaAprueba que devuelve un string indicando la situacion
     *
     * @return "aprobado" si aprobo, "desaprobado" si no lo hizo
     */
    private String leyendaAprueba(){
        if(aprueba()){
            return "APROBADO";
        } else {
            return "DESAPROBADO";
        }
    }

    /**
     * metodo promedio que calcula el promedio de las notas
     *
     * @return promedio
     */
    public double promedio(){
        return (this.getNota1() + this.getNota2()) / 2;
    }

    /**
     * metodo nomYApe que devuelve un string con nombre y apellido
     *
     * @return nombre y apellido
     */
    public String nomYApe(){
        return this.getNombre() + " " + this.getApellido();
    }

    /**
     * metodo apeYNom que devuelve un string con apellido y nombre
     *
     * @return apellido y nombre
     */
    public String apeYNom(){
        return this.getApellido() + " " + this.getNombre();
    }

    /**
     * metodo mostrar que imprime en pantalla datos del alumno
     * su promedio y situacion
     */
    public String mostrar(){
        return "Nombre Y Apellido: " + this.nomYApe() +
                "\nLU: " + this.getLU() +
                "\nNotas: " + this.getNota1() + " - " + this.getNota2() +
                "\nPromedio: " + this.promedio() +
                "\n" + this.leyendaAprueba();
    }
}
