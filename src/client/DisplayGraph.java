package client;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * @SER516 Project2_Team03
 * @Version 1.0
 */
public class DisplayGraph extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int MAX_VALUE = 20;
    private static final int WIDTH = 430;
    private static final int HEIGHT = 430;
    private static final int BORDER_GAP = 10;
    private static final Color GRAPH_COLOR = Color.GREEN;
    private static final Color GRAPH_POINT_COLOR = GRAPH_COLOR;
    private static final Stroke GRAPH_STROKE = new BasicStroke(1f);
    private static final int GRAPH_POINT_WIDTH = 7;
    private List<Integer> values;
    
    /**
     * Accepts the list of integers to be plotted.
     * @param values
     */
    public DisplayGraph(List<Integer> values){
    	this.values = values;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2 = (Graphics2D)g;
       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

       double xScale = ((double) getWidth() - 2 * BORDER_GAP) / (values.size() - 1);
       double yScale = ((double) getHeight() - 2 * BORDER_GAP) / (MAX_VALUE - 1);
       
       //creates coordinate values from the provided list.
       List<Point> graphPoints = new ArrayList<Point>();
       for (int i = 0; i < values.size(); i++) {
          int x1 = (int) (i * xScale + BORDER_GAP);
          int y1 = (int) ((MAX_VALUE - values.get(i)) * yScale + BORDER_GAP);
          graphPoints.add(new Point(x1, y1));
       }
       
       //creates x and y axes.
       g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, BORDER_GAP, BORDER_GAP);
       g2.drawLine(BORDER_GAP, getHeight() - BORDER_GAP, getWidth() - BORDER_GAP, getHeight() - BORDER_GAP);

       //plots the lines.
       Stroke oldStroke = g2.getStroke();
       g2.setColor(GRAPH_COLOR);
       g2.setStroke(GRAPH_STROKE);
       for (int i = 0; i < graphPoints.size() - 1; i++) {
          int x1 = graphPoints.get(i).x;
          int y1 = graphPoints.get(i).y;
          int x2 = graphPoints.get(i + 1).x;
          int y2 = graphPoints.get(i + 1).y;
          g2.drawLine(x1, y1, x2, y2);         
       }
       
       //plots the points.
       g2.setStroke(oldStroke);      
       g2.setColor(GRAPH_POINT_COLOR);
       for (int i = 0; i < graphPoints.size(); i++) {
          int x = graphPoints.get(i).x - GRAPH_POINT_WIDTH / 2;
          int y = graphPoints.get(i).y - GRAPH_POINT_WIDTH / 2;;
          int ovalW = GRAPH_POINT_WIDTH;
          int ovalH = GRAPH_POINT_WIDTH;
          g2.fillOval(x, y, ovalW, ovalH);
       }
    }

    //Gets the dimensions of the outer panel.
    @Override
    public Dimension getPreferredSize() {
       return new Dimension(WIDTH, HEIGHT);
    }
}
