import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Decoracion.*;
import Analisis_OrganizacionInformacion.*;
import Gestion_DatosDinamicos.*;
import Indexacion_VisualizacionArchivos.*;
import Mapas_AsociacionDatos.*;

public class Main extends JFrame{
    public Main() {
        setLayout(new BorderLayout());
        setTitle("Sistema de Gestión Y Análisis de Datos Multidimensionales");

        Decoracion decoPanel = new Decoracion();
        decoPanel.setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel(new GridBagLayout());
        titlePanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel titleLabel = new JLabel("<html><h1 style='font-size: 60px;'><font color='black'>U</font><font color='black'>A</font><font color='#3679FA'>X</font></h1></html>");
        titleLabel.setOpaque(false);
        titlePanel.add(titleLabel, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        JLabel universityLabel = new JLabel("<html><h2 style='font-size: 16px;'>Universidad Alfonso <font color='#3679FA'>X</font> el Sabio</h2></html>");
        universityLabel.setOpaque(false);
        titlePanel.add(universityLabel, gbc);

        JLabel subtitleLabel = new JLabel("<html><h2 style='font-size: 20px;'>Sistema de Gestión y Análisis de Datos</h2></html>");
        subtitleLabel.setOpaque(false);
        titlePanel.add(subtitleLabel, gbc);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weighty = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.ipady = 0;

        JButton gestionDatosDinamicosButton = new JButton("Gestión de Datos Dinámicos");
        gestionDatosDinamicosButton.setOpaque(false);
        gestionDatosDinamicosButton.addActionListener(e -> new PairListGUI());
        buttonPanel.add(gestionDatosDinamicosButton, gbc);

        JButton analisisOrganizacionButton = new JButton("Análisis y Organización de Información");
        analisisOrganizacionButton.setOpaque(false);
        analisisOrganizacionButton.addActionListener(e -> new AnalisisRegistros());
        buttonPanel.add(analisisOrganizacionButton, gbc);

        JButton mapasAsociacionButton = new JButton("Mapas y Asociación de Datos");
        mapasAsociacionButton.setOpaque(false);
        mapasAsociacionButton.addActionListener(e -> new GestionRelaciones());
        buttonPanel.add(mapasAsociacionButton, gbc);

        JButton indexadorVisualizacionButton = new JButton("Indexador y Visualización de Archivos \uD83D\uDC41\uFE0F\u200B\uD83D\uDDC3\uFE0F\u200B");
        indexadorVisualizacionButton.setOpaque(false);
        indexadorVisualizacionButton.addActionListener(e -> new IndexacionRecursiva());
        buttonPanel.add(indexadorVisualizacionButton, gbc);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.add(titlePanel);
        centerPanel.add(buttonPanel);
        decoPanel.add(centerPanel, BorderLayout.CENTER);

        JPanel iconPanel = new JPanel();
        iconPanel.setLayout(new BoxLayout(iconPanel, BoxLayout.Y_AXIS));
        iconPanel.setOpaque(false);
        

        JButton homeButton = new JButton(new ImageIcon(new ImageIcon("src/main/resources/image-icono-home.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        homeButton.setBorderPainted(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setFocusPainted(false);
        homeButton.setOpaque(false);
        homeButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Ya estás en casa"));
        iconPanel.add(homeButton);

        JButton correoButton = new JButton(new ImageIcon(new ImageIcon("src/main/resources/image-icono-correo.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        correoButton.setBorderPainted(false);
        correoButton.setContentAreaFilled(false);
        correoButton.setFocusPainted(false);
        correoButton.setOpaque(false);
        correoButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "zacerrui@myuax.com"));
        iconPanel.add(correoButton);

        JButton usuarioButton = new JButton(new ImageIcon(new ImageIcon("src/main/resources/image-icono-usuario.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
        usuarioButton.setBorderPainted(false);
        usuarioButton.setContentAreaFilled(false);
        usuarioButton.setFocusPainted(false);
        usuarioButton.setOpaque(false);
        usuarioButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Creado por Zoe Acero Ruiz"));
        iconPanel.add(usuarioButton);

        decoPanel.add(iconPanel, BorderLayout.EAST);

        add(decoPanel, BorderLayout.CENTER);

        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}


