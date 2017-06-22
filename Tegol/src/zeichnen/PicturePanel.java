package zeichnen;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import brush.WobbleStroke;
import shape.TegolLine;
import shape.TegolObject;
import shape.TegolOval;
import shape.TegolRectangle;
import shape.TegolShape;

public class PicturePanel extends JPanel implements MouseListener, MouseMotionListener
{
	Graphics2D g2;
	Graphics g;
	private static boolean toolActive;
	private static double clickMouseX;
	private static double clickMouseY;
	private static double clickMouseXold;
	private static double clickMouseYold;
	private static double moveMouseX;
	private static double moveMouseY;
	private static double moveMouseXold;
	private static double moveMouseYold;
	private static double releaseMouseX;
	private static double releaseMouseY;
	private static TegolObject lastTegolObject;
	private static long lastPaint = 0;
	private SpecialBufferedImage image = null;
	private TegolMain mainFrame;
	private ArrayList<TegolShape> tegolShapes = new ArrayList();
	
	public PicturePanel(TegolMain mainFrame)
	{
		this(mainFrame, 900, 900);
	}
	
	public PicturePanel(TegolMain mainFrame, int width, int height)
	{
		this.mainFrame = mainFrame;
		this.setBackground(Color.LIGHT_GRAY);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		image = new SpecialBufferedImage(width, height, Transparency.BITMASK);
		
//		Runnable run = new Runnable() {
//		    public void run() {
//		            repaint();
//		    }
//		 };
//		 new Thread(run).start();
	}
	
	public Graphics2D initializeGraphics(Graphics2D graphics){
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//		graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
//		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//		graphics.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 100);
//		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
//		graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_PURE);
		return graphics;
	}
	
	public void paint(Graphics g)
	{
		if(image != null){
		super.paint(g);
		
		g2 = (Graphics2D) g;
		g2 = image.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, image.getHeight(), image.getWidth());
		g2 = initializeGraphics(g2);
		
		if(tegolShapes.size() > 0){
			drawShapes();
		}
		
		int width = (int)moveMouseY - (int)clickMouseY;
		int height = (int)moveMouseX - (int)clickMouseX;
		Color color = Color.red;
		int brushSize = 1;
		
		switch(mainFrame.getControlTop().getSelectedTool())
		{
		case 1:
			paintPoint();
		case 2:
			paintRectangleBrush();
			break;
		case 3:
			paintPoint();
			break;
		case 4:
			if(toolActive){
			TegolRectangle tRect = new TegolRectangle((int)clickMouseX, (int)clickMouseY, height, width, brushSize, color);
			tRect.draw(g2);
			}
			break;
		case 5:
			if(toolActive){
			TegolOval tOval = new TegolOval((int)clickMouseX, (int)clickMouseY, height, width, brushSize, color);
			tOval.draw(g2);
			}
			break;
		case 6:
			if(toolActive){
			TegolLine tLine = new TegolLine((int)clickMouseX, (int)clickMouseY, (int)moveMouseX, (int)moveMouseY, brushSize, color);
			tLine.draw(g2);
			}
			break;
		case 7:
			break;
		case 8:
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
		
		lastPaint = System.currentTimeMillis();
		g.drawImage(image,(this.getWidth() - image.getWidth()) / 2,(this.getHeight() - image.getHeight()) / 2, image.getWidth(), image.getHeight(), null);
		
	}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		toolActive = true;
		clickMouseXold = clickMouseX;
		clickMouseYold = clickMouseY;
		clickMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		clickMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		moveMouseXold = moveMouseX;
		moveMouseYold = moveMouseY;
		moveMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		moveMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		if(!(clickMouseX < 0) && !(clickMouseX > image.getWidth()) && !(clickMouseY < 0) && !(clickMouseY > image.getHeight()))
		{
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		toolActive = false;
		releaseMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		releaseMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		
		int selectedTool = mainFrame.getControlTop().getSelectedTool();
		int width = (int)releaseMouseY - (int)clickMouseY;
		int height = (int)releaseMouseX - (int)clickMouseX;
		Color color = getActiveColor();
		int brushSize = mainFrame.getControlWest().getControlTabs().getBrushControl().getBrushSize();
		
		switch(selectedTool){
			case 4:
				addTegolShape(new TegolRectangle((int)clickMouseX, (int)clickMouseY, height, width, brushSize, color));
				break;
			case 5:
				addTegolShape(new TegolOval((int)clickMouseX, (int)clickMouseY, height, width, brushSize, color));
				break;
			case 6:
				addTegolShape(new TegolLine((int)clickMouseX, (int)clickMouseY, (int)releaseMouseX, (int)releaseMouseY, brushSize, color));
				break;
			default:
				break;
		}	
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) 
	{
		moveMouseXold = moveMouseX;
		moveMouseYold = moveMouseY;
		moveMouseX = arg0.getX() - (this.getWidth() - image.getWidth()) / 2;
		moveMouseY = arg0.getY() - (this.getHeight() - image.getHeight()) / 2;
		if(!(moveMouseX < 0) && !(moveMouseX > image.getWidth()) && !(moveMouseY < 0) && !(moveMouseY > image.getHeight()))
		{
			repaint();
		}
	}
	
	private void paintRectangleBrush()
	{
		Color color = getActiveColor();
		int brushSize = mainFrame.getControlWest().getControlTabs().getBrushControl().getBrushSize();
		
		if(lastTegolObject == null || lastTegolObject.getBrushSize() != brushSize || lastTegolObject.getColor() != color){
			addTegolShape(new TegolObject(image.getHeight(), image.getWidth(), brushSize, color));
			lastTegolObject = (TegolObject) tegolShapes.get(tegolShapes.size()-1);
		}
		
		Graphics2D tempG = (Graphics2D) g;
		
		tempG = lastTegolObject.getObject().createGraphics();
		tempG.setColor(color);
		tempG = initializeGraphics(tempG);
		
		if(System.currentTimeMillis() - lastPaint < 60)
		{
			tempG.setStroke(new WobbleStroke(4, 2));
			tempG.drawLine((int)moveMouseXold, (int)moveMouseYold, (int)moveMouseX, (int)moveMouseY);
		}
		else
		{
			tempG.setStroke(new WobbleStroke(4, 2));
			tempG.drawLine((int)moveMouseX, (int)moveMouseY, (int)moveMouseX, (int)moveMouseY);
		}
	}
	
	private void paintPoint()
	{
		Color color = getActiveColor();
		int brushSize = mainFrame.getControlWest().getControlTabs().getBrushControl().getBrushSize();
		
		if(lastTegolObject == null || lastTegolObject.getBrushSize() != brushSize || lastTegolObject.getColor() != color){
			addTegolShape(new TegolObject(image.getHeight(), image.getWidth(), brushSize, color));
			lastTegolObject = (TegolObject) tegolShapes.get(tegolShapes.size()-1);
		}
		
		Graphics2D tempG = (Graphics2D) g;
		tempG = lastTegolObject.getObject().createGraphics();
		tempG.setColor(color);
		tempG = initializeGraphics(tempG);
		
		if(System.currentTimeMillis() - lastPaint < 60)
		{
			tempG.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			tempG.drawLine((int)moveMouseXold, (int)moveMouseYold, (int)moveMouseX, (int)moveMouseY);
		}
		else
		{
			tempG.setStroke(new BasicStroke(brushSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
			tempG.drawLine((int)moveMouseX, (int)moveMouseY, (int)moveMouseX, (int)moveMouseY);
		}
	}
	
	private void drawShapes(){
		for (TegolShape tegolShape : tegolShapes) {
			tegolShape.draw(g2);
		}
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
	
	public Color getActiveColor(){
//		return mainFrame.getControlWest().getControlTabs().getFlatColors().getActiveColorPanel().getColor();
		return mainFrame.getControlWest().getControlTabs().getColorControl().getColorChooser().getColor();
	}
}
