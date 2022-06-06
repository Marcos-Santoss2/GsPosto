package br.com.fiap.controller;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.MouseInputListener;

import br.com.fiap.dao.PostoDao;
import br.com.fiap.view.Cadastro;

public class TabbleListener implements MouseInputListener {

	PostoDao dao = new PostoDao();
	private Cadastro cadastro;

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer apagar o filme?");
			if (resposta == JOptionPane.YES_OPTION) {
				JTable tabela = (JTable) e.getSource();
				String id = (String) tabela.getValueAt(tabela.getSelectedRow(), 0);
				dao.apagar(Long.valueOf(id));
				cadastro.carregarDados();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
