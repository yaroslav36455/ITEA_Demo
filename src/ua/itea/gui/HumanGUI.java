package ua.itea.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ua.itea.model.Human;
import ua.itea.service.HumanService;

public class HumanGUI extends JFrame {
	private JTextField jTextFieldName;
	private JTextField jTextFieldHealth;
	private JLabel jLabelName;
	private JLabel jLabelHealth;
	private JButton jButtonSave;
	private JButton jButtonLoad;
	private JButton jButtonBack;
	private JPanel jPanel = new JPanel();
	
	private HumanService humanService;
	
	public HumanGUI(HumanService humanService) {
		super();
		
		this.humanService = humanService;
		
		jTextFieldName = new JTextField();
		jTextFieldHealth = new JTextField();
		jLabelName = new JLabel("Name");
		jLabelHealth = new JLabel("Health");
		jButtonSave = new JButton("Save to DB");
		jButtonLoad = new JButton("Load from DB");
		jButtonBack = new JButton("Back");
		
		jPanel = getJPanel();
		add(jPanel);
		
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initListeners();
	}

	private void initListeners() {
		jButtonLoad.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadFromDB();
			}
			
		});
		
		jButtonSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveToDB();
			}
			
		});
		
		jButtonBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				add(getJPanel());
			}
		});
	}
	
	private JPanel getJPanel() {
		jPanel.setVisible(false);
		
		jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(3, 2));
		jPanel.add(jLabelName);
		jPanel.add(jLabelHealth);
		jPanel.add(jTextFieldName);
		jPanel.add(jTextFieldHealth);
		jPanel.add(jButtonSave);
		jPanel.add(jButtonLoad);
		
		jPanel.setVisible(true);
		return jPanel;
	}
	
	private void loadFromDB() {
		Human human = humanService.load();
		
		jLabelName.setText(human.getName());
		jLabelHealth.setText(String.valueOf(human.getHealth()));
	}
	
	private void saveToDB() {
		jPanel.setVisible(false);
		jPanel = new JPanel();
		
		humanService.save(jTextFieldName.getText(),
						  Integer.valueOf(jTextFieldHealth.getText()));
		
		jPanel.setLayout(new GridLayout(1, 2));
		
		jTextFieldName.setText("success");
		jPanel.add(jTextFieldName);
		
		jPanel.add(jButtonBack);
		jPanel.setVisible(true);
		add(jPanel);
	}
}
