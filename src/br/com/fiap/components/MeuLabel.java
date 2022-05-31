package br.com.fiap.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class MeuLabel extends JLabel{

	
	private static final long serialVersionUID = 1L;

	public MeuLabel (String text){
		super(text);
		init();
	}
	
	public MeuLabel(String text, int tamanho) {
		super(text);
		titulo(tamanho);
	}

	private void titulo(int tamanho) {
		this.setFont(new Font("Calibri", Font.BOLD, tamanho));
		
	}

	private void init() {
		
		this.setForeground(Color.black);
		
	}
	
	

}
