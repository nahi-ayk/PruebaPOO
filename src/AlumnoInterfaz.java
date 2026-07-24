import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AlumnoInterfaz extends JFrame implements ActionListener {

    // Campos de texto
    private JTextField txtLu;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtNota1;
    private JTextField txtNota2;

    // Botón
    private JButton btnGuardar;
    private JButton btnBuscar;
    private JButton btnModificar;
    private JButton btnEliminar;

    // Área de salida
    private JTextArea salida;

    public AlumnoInterfaz() {

        super("Alumno");

        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7,2,5,5));

        panel.add(new JLabel("LU:"));
        txtLu = new JTextField();
        panel.add(txtLu);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panel.add(txtApellido);

        panel.add(new JLabel("Nota 1:"));
        txtNota1 = new JTextField();
        panel.add(txtNota1);

        panel.add(new JLabel("Nota 2:"));
        txtNota2 = new JTextField();
        panel.add(txtNota2);

        btnGuardar = new JButton("Guardar");
        btnBuscar = new JButton("Buscar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");

        btnGuardar.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnModificar.addActionListener(this);
        btnEliminar.addActionListener(this);

        panel.add(btnGuardar);
        panel.add(btnBuscar);
        panel.add(btnModificar);
        panel.add(btnEliminar);

        salida = new JTextArea(8, 30);
        salida.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(salida), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            Object boton = e.getSource();
            if (boton == btnGuardar) {

                int lu = Integer.parseInt(txtLu.getText());
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                double nota1 = Double.parseDouble(txtNota1.getText());
                double nota2 = Double.parseDouble(txtNota2.getText());

                Alumno unAlumno = new Alumno(lu, nombre, apellido);

                unAlumno.setNota1(nota1);
                unAlumno.setNota2(nota2);

                AlumnoDAO dao = new AlumnoDAO();
                dao.guardar(unAlumno);

                salida.setText(unAlumno.mostrar());

            }

            if (boton == btnBuscar) {

                try {

                    int lu = Integer.parseInt(txtLu.getText());

                    AlumnoDAO dao = new AlumnoDAO();

                    Alumno alumno = dao.buscar(lu);

                    if (alumno != null) {

                        txtNombre.setText(alumno.getNombre());
                        txtApellido.setText(alumno.getApellido());
                        txtNota1.setText(String.valueOf(alumno.getNota1()));
                        txtNota2.setText(String.valueOf(alumno.getNota2()));

                        salida.setText(alumno.mostrar());

                    } else {

                        JOptionPane.showMessageDialog(this,
                                "No existe un alumno con esa LU.");

                    }

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(this,
                            "Ingrese una LU válida.");

                }

            }

            if (boton == btnModificar) {

                try {

                    int lu = Integer.parseInt(txtLu.getText());

                    Alumno alumno = new Alumno(
                            lu,
                            txtNombre.getText(),
                            txtApellido.getText());

                    alumno.setNota1(Double.parseDouble(txtNota1.getText()));
                    alumno.setNota2(Double.parseDouble(txtNota2.getText()));

                    AlumnoDAO dao = new AlumnoDAO();

                    dao.modificar(alumno);

                    salida.setText(alumno.mostrar());

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(this,
                            "Datos incorrectos.");

                }

            }

            if (boton == btnEliminar) {

                try {

                    int lu = Integer.parseInt(txtLu.getText());

                    AlumnoDAO dao = new AlumnoDAO();

                    dao.eliminar(lu);

                    txtLu.setText("");
                    txtNombre.setText("");
                    txtApellido.setText("");
                    txtNota1.setText("");
                    txtNota2.setText("");

                    salida.setText("");

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(this,
                            "Ingrese una LU válida.");

                }

            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "La LU y las notas deben ser valores numéricos.");

        }

    }

    public static void main(String[] args) {

        new AlumnoInterfaz();

    }
}