package zeichnen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PictureTabs extends JTabbedPane{
	PictureTabsActionHandler pictureTabsActionListener = new PictureTabsActionHandler(this);
	public void addPicture(PicturePanel picturePanel){
		String tabName = new String("Unnamed Picture (" + (getTabCount() + 1) + ")");
		addTab(tabName, picturePanel);
		int index = indexOfTab(tabName);
		JPanel pnlTab = new JPanel(new GridBagLayout());
		pnlTab.setOpaque(false);
		JLabel lblTitle = new JLabel(tabName);
		JButton btnClose = new JButton("x");
		btnClose.setPreferredSize(new Dimension(25,25));
		btnClose.setOpaque(false);
		btnClose.setContentAreaFilled(false);
		btnClose.setBorderPainted(false);
		btnClose.setBorder(null);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;

		pnlTab.add(lblTitle, gbc);

		gbc.gridx++;
		gbc.weightx = 0;
		pnlTab.add(btnClose, gbc);

		setTabComponentAt(index, pnlTab);
		btnClose.addActionListener(pictureTabsActionListener);
	}
}
