package com.chapter14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static java.lang.System.out;
class GameFrameAnonimWithin extends JFrame {
	private static final long serialVersionUID = 1L;
	int randomNumber = new Random().nextInt(10) + 1;
	int numGuesses = 0;
	JTextField textField = new JTextField(15);
	JButton button = new JButton("Сделать попытку");
	JLabel label = new JLabel(numGuesses + " попыток");
	String guessWord;
	
	public GameFrameAnonimWithin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		add(textField);
		add(button);
		add(label);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String textFieldText = textField.getText();
				
				if (e.getSource() == button) {
					out.println("Да, это действительно кнопка");
				}
				
				out.println("Вывод переменной \"button\"   : " + button);
				out.println("Объект вызвавший событие это: " + e.getSource());
				
				if (Integer.parseInt(textFieldText) == randomNumber) {
					button.setEnabled(false);
					textField.setText(textField.getText() + " Молодец! Угадал!");
					textField.setEnabled(false);
				} else {
					textField.setText("");
					textField.requestFocus();
				}
				
				numGuesses++;
				out.println(numGuesses);
				if (numGuesses == 1 || numGuesses == 21) {
					guessWord = " попытка";
				} else  {
					guessWord = (numGuesses <= 4 || 
				numGuesses == 22 || numGuesses == 23 || numGuesses == 24) ? 
						                           " попытки" : " попыток";
				}
				
				label.setText(numGuesses + guessWord);
			}
		});
		setSize(440, 100);
		setVisible(true);
	}
}
