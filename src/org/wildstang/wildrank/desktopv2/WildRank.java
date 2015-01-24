package org.wildstang.wildrank.desktopv2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WildRank implements ActionListener
{
	static JFrame frame;
	static JFrame userFrame;
	JPanel panel;
	JButton users;
	
	public static void main(String[] args)
	{
		new WildRank();
	}
	
	public WildRank()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e)
		{
			e.printStackTrace();
		}
		users = new JButton("Manage Users");
		users.addActionListener(this);
		frame = new JFrame("WildRank Desktop v2");
		panel = new GetEventData();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(300, 100));
		frame.add(panel, BorderLayout.PAGE_START);
		frame.add(users, BorderLayout.PAGE_END);
		frame.pack();
		//frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(users))
		{
			userFrame = new JFrame("WildRank Desktop v2: User Manager");
			userFrame.setPreferredSize(new Dimension(350, 500));
			userFrame.setLocation(frame.getX(), frame.getY() + 100);
			userFrame.add(new ModifyUsers());
			userFrame.pack();
			userFrame.setVisible(true);
		}
	}

}