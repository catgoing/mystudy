package window;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import dao.Add;

public class Window extends Frame implements WindowListener{
	
	Label title;
	Button btadd, btdel, btsear, btmod, btsav;
	
	
	
	public Window() {
		
		setLayout(null);
		
		title = new Label("Player Management Program");
		title.setBounds(250, 70, 300, 70);
		title.setBackground(Color.LIGHT_GRAY);
		title.setAlignment(Label.CENTER);
		add(title);
		
		btadd = new Button();
		btadd.setLabel("Add Player");
		btadd.setBounds(300, 170, 200, 70);
		btadd.setBackground(Color.orange);
		btadd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Add();
				
			}
		});
		add(btadd);
		
		btdel = new Button();
		btdel.setLabel("Delete Player");
		btdel.setBounds(300, 250, 200, 70);
		btdel.setBackground(Color.orange);
		btdel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(btdel);
		
		btsear = new Button();
		btsear.setLabel("Search Player");
		btsear.setBounds(300, 330, 200, 70);
		btsear.setBackground(Color.orange);
		btsear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(btsear);
		
		btmod = new Button();
		btmod.setLabel("Modify Player");
		btmod.setBounds(300, 410, 200, 70);
		btmod.setBackground(Color.orange);
		btmod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(btmod);
		
		btsav = new Button();
		btsav.setLabel("Save Data");
		btsav.setBounds(300, 490, 200, 70);
		btsav.setBackground(Color.orange);
		btsav.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(btsav);
		
		
		setBounds(100, 100, 800, 650);
		setVisible(true);
		
		addWindowListener(this);
	}



	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
