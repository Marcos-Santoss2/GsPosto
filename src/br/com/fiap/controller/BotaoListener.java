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

public class BotaoListener implements ActionListener {

	private Cadastro janela;
	PostoDao dao = new PostoDao();

	public BotaoListener(Cadastro janela) {
		this.janela = janela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "Salvar") {
			try {
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
				janela.carregarDados();
				janela.limpar();
				JOptionPane.showMessageDialog(null, "Posto criado com sucesso");
			} catch (Exception error) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos vazios");
			}
		}
		if (e.getActionCommand() == "Ordenar") {
			janela.carregarDadosOrdenados();
			JOptionPane.showMessageDialog(null, "Lista de Postos Ordenadas de acordo com estado");
		}
	}
}
