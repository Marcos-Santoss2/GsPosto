package br.com.fiap.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.components.InputText;
import br.com.fiap.components.MeuLabel;
import br.com.fiap.components.StarRater;
import br.com.fiap.controller.BotaoListener;
import br.com.fiap.dao.PostoDao;
import br.com.fiap.model.Posto;


public class Cadastro extends JFrame {

	MeuLabel titulo = new MeuLabel("Cadastro do Posto", 24);
	MeuLabel nomeLabel = new MeuLabel("Nome");
	MeuLabel endereçoLabel = new MeuLabel("Endereço");
	MeuLabel avaliacao = new MeuLabel("Avaliação: ");
	MeuLabel rua = new MeuLabel("Rua");
	MeuLabel bairro = new MeuLabel("Bairro");
	MeuLabel cidade = new MeuLabel("Cidade");
	MeuLabel plugin = new MeuLabel("Plugin: ");
	MeuLabel precoLabel = new MeuLabel("Preço do Kwh: ");
	MeuLabel estadoLabel = new MeuLabel("Estado");
	String[] estados = { " ", "AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MS","MT","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO",};
	JComboBox<String> estado = new JComboBox<>(estados);
    StarRater starRater = new StarRater();
    
    InputText inputNome = new  InputText(10);
    InputText inputRua = new InputText(11);
    InputText inputBairro = new InputText(9);
    InputText inputCidade = new InputText(9);
    InputText inputPreco = new InputText(5);
    
    JCheckBox tipo1 = new JCheckBox("tipo1");
    JCheckBox  tipo2 = new JCheckBox("tipo2");
    JCheckBox  css2 = new JCheckBox("CSS2");
    JCheckBox chaDemo  = new JCheckBox("CHAdeMO");
    List<String> checkedBoxes = new ArrayList<String>();
	
	JPanel cadastro = new JPanel();
	JTabbedPane abas = new JTabbedPane();
	
	JPanel endereco = new JPanel(new GridLayout(0,1,0,0));
	JPanel enderecoRua= new JPanel();
	JPanel enderecoBairro= new JPanel();
	JPanel enderecoCid= new JPanel();
	JPanel enderecoEst= new JPanel();
	
	JPanel nome = new JPanel();
	JPanel outros = new JPanel(new GridLayout(0,1,0,0));
	JPanel preco = new JPanel();
	JButton salvar = new JButton("Salvar");
	JButton limpar = new JButton("Limpar");
	JButton ordenar = new JButton("Ordenar");
	
	JPanel avalia = new JPanel(new FlowLayout());
	
	BotaoListener listenerSalvar = new BotaoListener(this);
	
	String[] colunas =  {"Id", "Nome", "Rua", "Bairro", "Cidade", "Estado", "Avaliacao", "Precos"};
	DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
	JTable tabela = new JTable(tableModel);
	
	
	public Cadastro() {
		setSize(390, 370);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void init() {
		cadastro.setBorder(BorderFactory.createTitledBorder("Cadastro do Posto"));
		nome.add(nomeLabel);
		nome.add(inputNome);
		
		endereco.setBorder(BorderFactory.createTitledBorder("Informações"));
		endereco.add(nome);
		enderecoRua.add(rua);
		enderecoRua.add(inputRua);
		enderecoBairro.add(bairro);
		enderecoBairro.add(inputBairro);
		enderecoCid.add(cidade);
		enderecoCid.add(inputCidade);
		enderecoEst.add(estadoLabel);
		enderecoEst.add(estado);
		endereco.add(enderecoRua);
		endereco.add(enderecoBairro);
		endereco.add(enderecoCid);
		endereco.add(enderecoEst);
		
		outros.setBorder(BorderFactory.createTitledBorder("Outros"));
		avalia.add(avaliacao);
		avalia.add(starRater);
		outros.add(avalia);
	//	outros.add(plugin);
		outros.add(tipo1);
		outros.add(tipo2);
		outros.add(css2);
		outros.add(chaDemo);
		preco.add(precoLabel);
		preco.add(inputPreco);
		outros.add(preco);
		
		
		
		cadastro.add(endereco, BorderLayout.LINE_START);
		cadastro.add(outros, BorderLayout.LINE_END);		
		cadastro.add(salvar);
		cadastro.add(limpar);
		cadastro.add(ordenar);
		
		
		abas.add("Cadastro", cadastro);
		abas.add("Lista", new JScrollPane(tabela));
		
		add(abas);
		
		
		salvar.addActionListener(listenerSalvar);
		limpar.addActionListener(listenerSalvar);
		ordenar.addActionListener(listenerSalvar);
		setVisible(true);
		
	}
	
	public void CarregarDados() {
		
		tableModel.setRowCount(0);
		List<Posto> lista = new PostoDao().listarTodos();
		lista.forEach(posto -> tableModel.addRow(posto.getData()));
		
	}
	
	public void CarregarDadosOrdanados() {
		tableModel.setRowCount(0);
		List<Posto> list = new PostoDao().OrdenarDados();
		list.forEach(posto -> tableModel.addRow(posto.getData()));
	}
	
	public void Limpar() {
		inputNome.setText("");
		inputRua.setText("");
		inputBairro.setText("");
		inputCidade.setText("");
		estado.setSelectedIndex(0);
		tipo1.setSelected(false);
		tipo2.setSelected(false);
		css2.setSelected(false);
		chaDemo.setSelected(false);
		inputPreco.setText("");
		starRater.setSelection(0);
	}
	
	
	
	public InputText getInputText(String tipo) {
		
		switch (tipo) {
		case "nome":
			return inputNome;
		
		case "rua":
			return inputRua;

		case "bairro":
			return inputBairro;
		
		case "cidade":
			return inputCidade;
			
		case "preco":
			return inputPreco;
			
		default:
			return inputCidade;
		}
	}

	public JComboBox<String> getEstado() {
		return estado;
	}

	public List<String> getPlugs() {
		for (java.awt.Component child : outros.getComponents()) { 
			if (child instanceof JCheckBox) { 
				JCheckBox checkBox = (JCheckBox) child;
				if (checkBox.isSelected()) {
					checkedBoxes.add(checkBox.getText());
				}
			}
		}
		return checkedBoxes;
	}

	public StarRater getStarRater() {
		return starRater;
	}
}

	
	
	
	


