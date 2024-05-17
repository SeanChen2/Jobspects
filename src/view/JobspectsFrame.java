package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;

import javax.swing.*;
import javax.swing.SwingUtilities;

public class JobspectsFrame extends JFrame {
		
	//Constants for the frame size
	public final static int FRAME_WIDTH = 1920;
	public final static int FRAME_HEIGHT = 1080;
	
	//Constants for the colour scheme
	public final static Color DARK_PURPLE = new Color(104, 2, 87);
	
	//Background panel
	private CircularGradientPanel gradientPanel = new CircularGradientPanel();
	
	static class CircularGradientPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();

            // Define the center and radius of the circular gradient
            Point2D center = new Point2D.Float(width / 2, height / 2);
            float radius = Math.min(width, height) / 2;

            // Define the colors
            Color color1 = new Color(60,1,35); // red (Top color)
            Color color2 = new Color(60,1,35); // reddish purple (Middle color)
            Color color3 = new Color(20,0,56); // purple (Bottom color)


            // Define the fractions for the gradient
            float[] fractions = {0.0f, 0.5f, 1.0f};
            Color[] colors = {color1, color2, color3};

            // Create the radial gradient paint
            RadialGradientPaint rgp = new RadialGradientPaint(center, radius, fractions, colors);

            // Set the paint and fill the entire panel
            g2d.setPaint(rgp);
            g2d.fillRect(0, 0, width, height);
        }
    }
	
	public JobspectsFrame(){
		
		setUpFrame();
	}
	
	public CircularGradientPanel getGradientPanel() {
		return gradientPanel;
	}
	
	private void setUpFrame() {
		
		setSize(1920, 1080);
		
	    gradientPanel.setLayout(null);
	    setContentPane(gradientPanel);

	}

		
		
}