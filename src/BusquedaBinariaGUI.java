import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaBinariaGUI {
    private JTextField inputField;
    private JButton agregarButton;
    private JButton ordenarButton;
    private JButton buscarBinarioButton;
    private JTextArea txtResultado;
    private JPanel pGeneral;
    private JButton mostrarButton;

    Lista lista = new Lista();

    public BusquedaBinariaGUI() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor, txtResultado);
                    inputField.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenarBurbuja(txtResultado);
                JOptionPane.showMessageDialog(null, "Lista ordenada con el método Burbuja.");
            }
        });
        buscarBinarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                try {
                    int valor = Integer.parseInt(input);
                    int posicion = lista.buscarBinario(valor, txtResultado);
                    if (posicion == -1) {
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Elemento encontrado en posición: " + (posicion + 1));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduce un número entero válido.");
                }
            }
        });
        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.mostrarLista(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaBinariaGUI");
        frame.setContentPane(new BusquedaBinariaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}