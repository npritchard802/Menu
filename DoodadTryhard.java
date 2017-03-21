
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;


public class DoodadTryhard{	
	private int height, width, xAxis, yAxis;
	private String name;
	private BufferedImage image;
//	private Enum visible;
	
//	private enum Visibility{
//		PLAYER_1, PLAYER_2, PLAYER_3
//	}
	
	//Get the image
	
	
	
	
	public DoodadTryhard(int xAxis, int yAxis, String name) throws IOException {
		this.name = name;
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
	
	public void addToFramer(){
		
	}
	
	public void addToFrame(JFrame jf){
		JLabel label = new JLabel(new ImageIcon(image));
		jf.add(label);
		
		// Give the window an elliptical shape.
        jf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                jf.setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
            }
        });
		
        jf.setUndecorated(true);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.getContentPane().add(label);
        jf.pack();
        jf.setLocation(getxAxis(),getyAxis()); 
        jf.setVisible(true);
	}
	
	//DragListener makes movement happen
	public void addDragListener (JLabel jf){
		
		//create the draglistener
		DragListenerTryhard drag = new DragListenerTryhard();
        jf.addMouseListener(drag);
        jf.addMouseMotionListener(drag);	
        
        // Give the window an elliptical shape.
        /* jf.addComponentListener(new ComponentAdapter() {
             @Override
             public void componentResized(ComponentEvent e) {
                 jf.setShape(new Ellipse2D.Double(0,0,getWidth(),getHeight()));
           }
        });
        */
        

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
	
	public String getName(){
		return this.name;
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