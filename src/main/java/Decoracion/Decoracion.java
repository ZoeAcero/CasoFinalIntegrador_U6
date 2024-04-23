package Decoracion;

import javax.swing.*;
import java.awt.*;

public class Decoracion extends JPanel {


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

        // Draw centered text
        String text = "UAX";
        Font font = new Font("Arial", Font.BOLD, 100);
        g2d.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        int x = (width - metrics.stringWidth(text)) / 2;
        int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
    }

    //main method

    public static void main(String[] args) {
        JFrame frame = new JFrame("Decoracion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new Decoracion());
        frame.setVisible(true);
    }
}
