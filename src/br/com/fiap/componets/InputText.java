package br.com.fiap.componets;

import java.awt.Color;

import javax.swing.JTextField;

public class InputText extends JTextField {
	
	private static final long serialVersionUID = 1L;

	public InputText() {
		super(20);
		init();
	}
	
	public InputText(int tam) {
		super(tam);
		init();
	}

	private void init() {
		this.setForeground(new Color(50,50,50));
		this.setBackground(Color.WHITE);
		this.setSize(100,10);
		
		this.setBorder(BorderFactory.criar()); 
	}

}