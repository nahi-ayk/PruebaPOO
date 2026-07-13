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
    private JButton btnCrear;

    // Área de salida
    private JTextArea salida;

    public AlumnoInterfaz() {

        super("Alumno");

        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

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

        btnCrear = new JButton("Calcular");
        btnCrear.addActionListener(this);

        panel.add(btnCrear);
        panel.add(new JLabel(""));

        salida = new JTextArea(8, 30);
        salida.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(salida), BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            int lu = Integer.parseInt(txtLu.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            double nota1 = Double.parseDouble(txtNota1.getText());
            double nota2 = Double.parseDouble(txtNota2.getText());

            Alumno unAlumno = new Alumno(lu, nombre, apellido);

            unAlumno.setNota1(nota1);
            unAlumno.setNota2(nota2);

            salida.setText(unAlumno.mostrar());

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "La LU y las notas deben ser valores numéricos.");

        }

    }

    public static void main(String[] args) {

        new AlumnoInterfaz();

    }
}