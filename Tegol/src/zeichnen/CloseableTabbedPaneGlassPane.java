package zeichnen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

class CloseableTabbedPaneGlassPane extends JPanel {
	  private final Point pt = new Point(-100, -100);
	  private final JButton button = new JButton("x") {
	    @Override public Dimension getPreferredSize() {
	      return new Dimension(16, 16);
	    }
	  };
	  private final JTabbedPane tabbedPane;
	  private final Rectangle buttonRect = new Rectangle(button.getPreferredSize());

	  public CloseableTabbedPaneGlassPane(JTabbedPane tabbedPane) {
	    super();
	    this.tabbedPane = tabbedPane;
	    MouseAdapter h = new Handler();
	    tabbedPane.addMouseListener(h);
	    tabbedPane.addMouseMotionListener(h);
	    button.setBorder(BorderFactory.createEmptyBorder());
	    button.setFocusPainted(false);
	    button.setBorderPainted(false);
	    button.setContentAreaFilled(false);
	    button.setRolloverEnabled(false);
	  }
	  @Override public void paintComponent(Graphics g) {
	    Point glassPt = SwingUtilities.convertPoint(tabbedPane, 0, 0, this);
	    for (int i = 0; i < tabbedPane.getTabCount(); i++) {
	      Rectangle tabRect = tabbedPane.getBoundsAt(i);
	      int x = tabRect.x + tabRect.width - buttonRect.width - 2;
	      int y = tabRect.y + (tabRect.height - buttonRect.height) / 2;
	      buttonRect.setLocation(x, y);
	      button.setForeground(buttonRect.contains(pt) ? Color.RED : Color.BLACK);
	      buttonRect.translate(glassPt.x, glassPt.y);
	      SwingUtilities.paintComponent(g, button, this, buttonRect);
	    }
	  }
	  class Handler extends MouseAdapter {
	    @Override public void mouseClicked(MouseEvent e) {
	      pt.setLocation(e.getPoint());
	      int index = tabbedPane.indexAtLocation(pt.x, pt.y);
	      if (index >= 0) {
	        Rectangle tabRect = tabbedPane.getBoundsAt(index);
	        int x = tabRect.x + tabRect.width - buttonRect.width - 2;
	        int y = tabRect.y + (tabRect.height - buttonRect.height) / 2;
	        buttonRect.setLocation(x, y);
	        if (buttonRect.contains(pt)) {
	          tabbedPane.removeTabAt(index);
	        }
	      }
	      tabbedPane.repaint();
	    }
	    @Override public void mouseMoved(MouseEvent e) {
	      pt.setLocation(e.getPoint());
	      int index = tabbedPane.indexAtLocation(pt.x, pt.y);
	      if (index >= 0) {
	        tabbedPane.repaint(tabbedPane.getBoundsAt(index));
	      } else {
	        tabbedPane.repaint();
	      }
	    }
	  }
}