package br.com.fiap.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.function.ToIntFunction;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import br.com.fiap.dao.PostoDao;
import br.com.fiap.view.Cadastro;
import br.com.fiap.model.Posto;



public class BotaoListener implements ActionListener{

	 private Cadastro janela; 
	 PostoDao dao = new PostoDao();
	 
	 public BotaoListener(Cadastro janela) {
			this.janela = janela;
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="Salvar"){
			
			Posto postos = new Posto();
			postos.setNome(janela.getInputText("nome").getText());
			postos.setRua(janela.getInputText("rua").getText());
			postos.setBairro(janela.getInputText("bairro").getText());
			postos.setCidade(janela.getInputText("cidade").getText());
			float preco = Float.parseFloat(janela.getInputText("preco").getText());
			postos.setPrecoKwh(preco);
			postos.setPlugins(janela.getPlugs());
			postos.setEstado(janela.getEstado().getSelectedItem().toString());
			postos.setStarRate(janela.getStarRater().getSelection());
			dao.inserir(postos);
	     	janela.CarregarDados();
	     	
		}
		if(e.getActionCommand()=="Limpar"){
			janela.Limpar();
		}
		if(e.getActionCommand()=="Ordenar"){
			janela.CarregarDadosOrdanados();
		}
	}
}


//	@Override
//	public void mouseClicked(MouseEvent e) {
//		if(e.getClickCount() == 2) {
//			int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer apagar o filme?");
//			if(resposta == JOptionPane.YES_OPTION) {
//				JTable tabela = (JTable) e.getSource();
//				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
//				dao.apagar(Long.valueOf(id));
//				janela.CarregarDados();
//			}
//		}	
//	}

