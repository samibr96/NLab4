package main.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DrawPanel extends JPanel{

    private Map<String, BufferedImage> imageMap;
    private ArrayList<Point> positions = new ArrayList<>();
    private ArrayList<String> modelNames = new ArrayList<>();


    public DrawPanel(int x, int y) {

        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);


        try {

            BufferedImage volvoImage = ImageIO.read(new File("Lab4/src/pics/Volvo240.jpg"));
            BufferedImage saabImage = ImageIO.read(new File("Lab4/src/pics/Saab95.jpg"));
            BufferedImage scaniaImage = ImageIO.read(new File("Lab4/src/pics/Scania.jpg"));

            imageMap = new HashMap<>();
            imageMap.put("Volvo240", volvoImage);
            imageMap.put("Saab95", saabImage);
            imageMap.put("Scania", scaniaImage);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void moveIt(double x, double y, String modelName) {

        positions.add(new Point((int) x, (int) y));
        modelNames.add(modelName);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < positions.size(); i++) {
            g.drawImage(imageMap.get(modelNames.get(i)), (int) positions.get(i).getX(), (int) positions.get(i).getY(), null);
        }

        positions.clear();

    }
}
