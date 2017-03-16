package kpt;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DoodadWorking {	
	private int height, width, xAxis, yAxis;
	private BufferedImage image;
//	private Enum visible;
	
//	private enum Visibility{
//		PLAYER_1, PLAYER_2, PLAYER_3
//	}
	
	//Get the image
	
	
	
	
	public DoodadWorking(int xAxis, int yAxis, String name) throws IOException {
		
		//Gets the image 
		File file = new File(name);
		//displays image?
		image = ImageIO.read(file);
		//width and height are set from the picture imported
		width = image.getWidth();
		height = image.getHeight();

		this.xAxis = xAxis;
		this.yAxis = yAxis;
//		this.visible = visible;
	}
	
	//DragListener makes movement happen
	public void addDragListener(){
		
		//Create the icon and the frame
		JLabel label = new JLabel(new ImageIcon(image));
		JFrame f = new JFrame();
		
		//create the draglistener
		DragListener drag = new DragListener();
        f.addMouseListener(drag);
        f.addMouseMotionListener(drag);	
        
        // Give the window an elliptical shape.
        f.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                f.setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
            }
        });

        //sets up picture
        f.setUndecorated(true);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setLocation(getxAxis(),getyAxis()); 
        f.setVisible(true);
	}
	
	//getters and setters
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}

	public int getxAxis() {
		return xAxis;
	}
	public void setxAxis(int xAxis) {
		this.xAxis = xAxis;
	}

	public int getyAxis() {
		return yAxis;
	}
	public void setyAxis(int yAxis) {
		this.yAxis = yAxis;
	}

	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	/*
	public Enum getVisible(){
		return visible;
	}
	public void setVisible(){
		this.visible = visible;
	}
	 */
}