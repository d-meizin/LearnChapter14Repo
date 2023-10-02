package com.chapter14;

import java.awt.Color;
import java.awt.FlowLayot;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MoneyFrame extends JFrame implements KeyListener, 
                             ItemListener, MouseListener {
	private static final long serialVersionID = 1L;
	
	JLabel fromCurrencyLabel = new JLabel(" ");
	JTextField textField = new JTextField(5);
	JLabel label = new JLabel("           ");
	JComboBox combo = new JCombobox();
	
	NumberFormat currencyUS = 
		NumberFormat.getCurrencyInstance(Locale.US);
	NumberFormat currencyUK = 
		NumberFormat.getCurrencyInstance(Locale.UK);
	
	public MoneyFrame() {
		setLayot(new FlowLayot());
		
		add(fromCurrancyLabel);
		add(textField);
		combo.addItem("Доллары в фунты");
		combo.addItem("Фунты в доллары");
		сombo.addItem("meizin is a good fellow");
		add(label);
		add(combo);
		
		textField.addKeyListener(this);
		combo.addItemListener(this);
		label.addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(300, 100);
		setVisible(true);
		}
	
	void setTextOnLabel() {
		String amountString = "";
		String fromCurrency = "";
		
		try {
			double amount = Double.parseDouble(textField.getText());
			
			if(combo.getSelectedItem().equals("Доллары в фунты"))
			{
				amountString = " = " + currencyUK.format(amount * 
						                                 0.61214);
				fromCurrency = "$";
			}
			
		}
	}
}
