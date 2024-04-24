package Indexacion_VisualizacionArchivos;

import Mapas_AsociacionDatos.RecuperacionEficiente;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;

public class MainIndexacion extends Component {
    private final IndexacionRecursiva indexadorRecursivo = new IndexacionRecursiva();
    private final RecuperacionEficiente ordenadorYListador = new RecuperacionEficiente();

    public MainIndexacion() {
        ordenadorYListador.setLayout(new FlowLayout());
        ordenadorYListador.getContentPane().setBackground(Color.LIGHT_GRAY);

        ImageIcon imageIcon = new ImageIcon("src/main/resources/image-icono-subida-archivos.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // redimensiona la imagen
        imageIcon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.LIGHT_GRAY);
        imagePanel.add(imageLabel);

        add(imagePanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 20, 10, 0));
        buttonPanel.setBackground(Color.LIGHT_GRAY);

        CustomButton indexarButton = new CustomButton("Indexar Archivos");
        indexarButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int seleccion = fileChooser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File directorio = fileChooser.getSelectedFile();
                indexadorRecursivo.indexar(directorio);
                for (Map.Entry<Object, Object> entrada : indexadorRecursivo.getIndex().entrySet()) {
                    ordenadorYListador.agregar((String) entrada.getKey(), (String) entrada.getValue());
                }
                JOptionPane.showMessageDialog(this, "Indexación completada");
            }
        });

        CustomButton listarButton = new CustomButton("Listar Archivos");
        listarButton.addActionListener(e -> {
            List<String> lista = ordenadorYListador.listar();
            JTextArea textArea = new JTextArea(20, 50);
            for (String s : lista) {
                textArea.append(s + "\n");
            }
            JOptionPane.showMessageDialog(this, new JScrollPane(textArea));
        });

        buttonPanel.add(indexarButton);
        buttonPanel.add(Box.createVerticalStrut(10));
        buttonPanel.add(listarButton);

        add(buttonPanel);

        setSize(500, 240);
        ordenadorYListador.setTitle("Listado de Archivos");
        ordenadorYListador.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ordenadorYListador.setLocationRelativeTo(null);
        setVisible(true);
    }

    private void add(JPanel buttonPanel) {
    }

    public static void main(String[] args) {
        new MainIndexacion();
    }

    class CustomButton extends JButton {
        public CustomButton(String text) {
            super(text);
            setFont(new Font("Arial", Font.BOLD, 14));
            setForeground(Color.WHITE);
            setBackground(Color.DARK_GRAY);
        }
    }
}

