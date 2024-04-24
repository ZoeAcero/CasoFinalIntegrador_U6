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

        JButton gestionDatosDinamicosButton = new JButton("Gestión de Datos Dinámicos \uD83D\uDCC8\u200B\uD83D\uDCC9\u200B");
        gestionDatosDinamicosButton.setOpaque(false);
        gestionDatosDinamicosButton.addActionListener(e -> new PairListGUI());
        buttonPanel.add(gestionDatosDinamicosButton, gbc);

        JButton analisisOrganizacionButton = new JButton("Análisis y Organización de Información \uD83D\uDDC4\uFE0F\u200Bℹ\uFE0F\u200B");
        analisisOrganizacionButton.setOpaque(false);
        analisisOrganizacionButton.addActionListener(e -> new AnalisisRegistros());
        buttonPanel.add(analisisOrganizacionButton, gbc);

        JButton mapasAsociacionButton = new JButton("Mapas y Asociación de Datos \uD83D\uDDFA\uFE0F\u200B\uD83D\uDCCA\u200B");
        mapasAsociacionButton.setOpaque(false);
        mapasAsociacionButton.addActionListener(e -> new GestionRelaciones());
        buttonPanel.add(mapasAsociacionButton, gbc);

        JButton indexadorVisualizacionButton = new JButton("Indexador y Visualización de Archivos \uD83D\uDC41\uFE0F\u200B\uD83D\uDDC3\uFE0F\u200B");
        indexadorVisualizacionButton.setOpaque(false);
        indexadorVisualizacionButton.addActionListener(e -> new IndexacionRecursiva());
        buttonPanel.add(indexadorVisualizacionButton, gbc);

    }
