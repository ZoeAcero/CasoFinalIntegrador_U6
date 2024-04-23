package Decoracion;

import javax.swing.*;
import java.awt.*;

public class Decoracion extends JPanel {
    private Image imagen1;
    private Image imagen2;


    public Decoracion() {
        // Cargar la imagen
        ImageIcon icono1 = new ImageIcon("src/main/resources/image-remove-preview (3).png");
        imagen1 = icono1.getImage();
        ImageIcon icono2 = new ImageIcon("src/main/resources/logoUAX-remove-preview.png");
        // Escalar la imagen
        int newWidth = icono2.getIconWidth() / 3; // Ajusta estos valores a tu gusto
        int newHeight = icono2.getIconHeight() / 3; // Ajusta estos valores a tu gusto
        imagen2 = icono2.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        Color colorlínea = new Color(54, 121, 250, 98); // Blanco semi-transparente

        // Dibujar la primera línea inclinada de izquierda a derecha
        g2d.setColor(colorlínea);
        int d = 225; // Distancia de la nueva línea a la primera
        g2d.drawLine(width / 3, 0, 0, height);

        // Rellenar el espacio entre las dos líneas
        Color colorRelleno = new Color(54, 121, 250, 98); // Azul semi-transparente
        g2d.setColor(colorRelleno);

        // Crear un polígono con los puntos de las dos líneas
        int[] xPoints = {0, width / 3, width / 3 + d, d}; // Coordenadas "x" de los puntos del polígono
        int[] yPoints = {height, 0, 0, height}; // Coordenadas "y" de los puntos del polígono
        int nPoints = 4; // Número de puntos del polígono
        g2d.fillPolygon(xPoints, yPoints, nPoints); // Dibujar y rellenar el polígono


        g2d.setColor(colorlínea);
        g2d.drawLine(width / 3 + d, 0, d, height);


        int d2 = width / 2;
        g2d.drawLine(width / 3 + d + d2, 0, d + d2, height);
        g2d.drawLine(width / 3 + d + 2 * d2, 0, d + 2 * d2, height);


        int[] xPoints2 = {width / 3 + d + d2, width / 3 + d + 2 * d2, d + 2 * d2, d + d2};
        int[] yPoints2 = {0, 0, height, height};
        g2d.fillPolygon(xPoints2, yPoints2, nPoints);



        int x2 = 0;
        int y2 = 200;
        g2d.drawImage(imagen2, x2, y2, null);

    }
}
