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
}
