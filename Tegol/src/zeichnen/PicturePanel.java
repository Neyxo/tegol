package zeichnen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import shape.TegolRectangle;
import shape.TegolShape;

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener
{
	Graphics2D g2;
	Graphics g;
	int initialize = 0;
	private static int clickMouseX;
	private static int clickMouseY;
	private static int clickMouseXold;
	private static int clickMouseYold;
	private static int releaseMouseX;
	private static int releaseMouseY;
	private static long lastPaint = 0;
	private SpecialBufferedImage image = null;
	private TegolMain mainFrame;
	private ArrayList<TegolShape> tegolShapes = new ArrayList();
	
	public PicturePanel(TegolMain mainFrame)
	{
		this(mainFrame, 100, 100);
	}
	
	public PicturePanel(TegolMain mainFrame, int width, int height)
	{
		this.mainFrame = mainFrame;
		this.setBackground(Color.LIGHT_GRAY);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		image = new SpecialBufferedImage(width, height, Transparency.BITMASK);
		initialize = 0;
	}
	
	public void paint(Graphics g)
	{
		if(image != null){
		super.paint(g);
		
		g2 = (Graphics2D) g;
		g2 = image.createGraphics();
		
		
		
		switch(mainFrame.getControlTop().getSelectedTool())
		{
		case 1:
			paintPoint();
			break;
		case 2:
			paintPoint();
			break;
		case 3:
			paintPoint();
			break;
		case 4:
			break;
		case 5:
			paintPoint();
			break;
		case 6:
			paintPoint();
			break;
		case 7:
			paintPoint();
			break;
		case 8:
			paintPoint();
			break;
		case 9:
			paintPoint();
			break;
		case 10:
			paintPoint();
			break;
		case 11:
			paintPoint();
			break;
		case 12:
			paintPoint();
			break;
		case 13:
			paintPoint();
			break;
		}
		
		if(tegolShapes.size() > 0){
			drawShapes();
		}
		
		if(initialize == 0)
		{
			g2.setColor(Color.WHITE);
			g2.fillRect(0, 0, image.getHeight(), image.getWidth());
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
			g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			g2.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
			g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
			initialize = 1;
		}
		
		lastPaint = System.currentTimeMillis();
		g.drawImage(image,(this.getWidth() - image.getWidth()) / 2,(this.getHeight() - image.getHeight()) / 2, image.getWidth(), image.getHeight(), null);
		
	}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		clickMouseXold = clickMouseX;
		clickMouseYold = clickMouseY;
		clickMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		clickMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		if(!(clickMouseX < 0) && !(clickMouseX > image.getWidth()) && !(clickMouseY < 0) && !(clickMouseY > image.getHeight()))
		{
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		releaseMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		releaseMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		
		int selectedTool = mainFrame.getControlTop().getSelectedTool();
		switch(selectedTool){
			case 4:
				int width = releaseMouseX - clickMouseX;
				int height = releaseMouseX - clickMouseX;
				addTegolShape(new TegolRectangle(releaseMouseX, releaseMouseY, height, width));
				break;
			case 5:
				break;
			case 6:
				break;
			default:
				break;
		}	
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		clickMouseXold = clickMouseX;
		clickMouseYold = clickMouseY;
		clickMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		clickMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		if(!(clickMouseX < 0) && !(clickMouseX > image.getWidth()) && !(clickMouseY < 0) && !(clickMouseY > image.getHeight()))
		{
			repaint();
		}
	}
	
	private void paintRectangleBrush()
	{
		int brushSize = mainFrame.getControlWest().getControlTabs().getBrushControl().getBrushSize();
		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		if(System.currentTimeMillis() - lastPaint < 30)
		{
			g2.drawLine(clickMouseXold, clickMouseYold, clickMouseX, clickMouseY);
		}
		else
		{
			g2.drawLine(clickMouseX, clickMouseY, clickMouseX, clickMouseY);
		}
	}
	
	private void paintPoint()
	{
		g2.setColor(Color.BLACK);
		int brushSize = mainFrame.getControlWest().getControlTabs().getBrushControl().getBrushSize();
		if(System.currentTimeMillis() - lastPaint < 20)
		{
			g2.setStroke(new BasicStroke(brushSize * 2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2.drawLine(clickMouseXold, clickMouseYold, clickMouseX, clickMouseY);
		}
		else
		{
			g2.setStroke(new BasicStroke(brushSize));
			g2.drawRoundRect(clickMouseX - 5, clickMouseY - 5, brushSize, brushSize, 200, 200);
		}
	}
	
	private void drawShapes(){
		for (TegolShape tegolShape : tegolShapes) {
			if(tegolShape instanceof TegolRectangle){
				drawRectangle((TegolRectangle) tegolShape);
			}
		}
	}
	
	private void drawRectangle(TegolRectangle shape){
		g2.setColor(Color.RED);
		int brushSize = mainFrame.getControlWest().getControlTabs().getBrushControl().getBrushSize();
		g2.setStroke(new BasicStroke(brushSize * 2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2.drawRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeigth());
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int getImageWidth() {
		return image.getWidth();
	}

	public void setImageWidth(int imageWidth) {
//		PicturePanel.image.getWidth() = imageWidth;
	}

	public int getImageHeight() {
		return image.getHeight();
	}

	public void setImageHeight(int imageHeight) {
//		PicturePanel.imageHeight = imageHeight;
	}
	
	public void addTegolShape(TegolShape shape){
		tegolShapes.add(shape);
	}
}
