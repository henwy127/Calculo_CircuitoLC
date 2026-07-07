package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import system.Funcionamento;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelPrincipal;

	private JTextField campoIndutancia_mH;
	private JTextField campoCapacitancia_uF;
	private JTextField campoCorrenteInicial_A;
	private JTextArea areaResultado;
	private JButton botaoCalcular;
	private JButton botaoResetar;

	private final Color COR_FUNDO = new Color(18, 18, 18);
	private final Color COR_PAINEL = new Color(28, 28, 28);
	private final Color COR_CAMPO = new Color(40, 40, 40);
	private final Color COR_BORDA = new Color(70, 70, 70);
	private final Color COR_TEXTO = new Color(230, 230, 230);
	private final Color COR_BOTAO = new Color(55, 55, 55);
	private final Color COR_BOTAO_HOVER = new Color(75, 75, 75);
	private final Color COR_BOTAO_RESET = new Color(180, 35, 35);
	private final Color COR_BOTAO_RESET_HOVER = new Color(210, 50, 50);

	public Tela() {
		setTitle("Exercício LC Oscilante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 430);

		painelPrincipal = new JPanel();
		painelPrincipal.setLayout(null);
		painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		painelPrincipal.setBackground(COR_FUNDO);
		setContentPane(painelPrincipal);

		JLabel labelTitulo = new JLabel("Circuito LC oscilante");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		labelTitulo.setForeground(COR_TEXTO);
		labelTitulo.setBounds(20, 10, 250, 25);
		painelPrincipal.add(labelTitulo);

		JLabel labelInstrucao = new JLabel("Informe L (mH), C (\u00B5F) e I0 (A):");
		labelInstrucao.setForeground(COR_TEXTO);
		labelInstrucao.setBounds(20, 40, 260, 20);
		painelPrincipal.add(labelInstrucao);

		JLabel labelIndutancia = new JLabel("L (mH):");
		labelIndutancia.setForeground(COR_TEXTO);
		labelIndutancia.setBounds(20, 75, 70, 20);
		painelPrincipal.add(labelIndutancia);

		campoIndutancia_mH = new JTextField();
		campoIndutancia_mH.setBounds(90, 75, 100, 25);
		campoIndutancia_mH.setText("3.00");
		estilizarCampo(campoIndutancia_mH);
		painelPrincipal.add(campoIndutancia_mH);

		JLabel labelCapacitancia = new JLabel("C (\u00B5F):");
		labelCapacitancia.setForeground(COR_TEXTO);
		labelCapacitancia.setBounds(220, 75, 70, 20);
		painelPrincipal.add(labelCapacitancia);

		campoCapacitancia_uF = new JTextField();
		campoCapacitancia_uF.setBounds(290, 75, 100, 25);
		campoCapacitancia_uF.setText("2.70");
		estilizarCampo(campoCapacitancia_uF);
		painelPrincipal.add(campoCapacitancia_uF);

		JLabel labelCorrenteInicial = new JLabel("I0 (A):");
		labelCorrenteInicial.setForeground(COR_TEXTO);
		labelCorrenteInicial.setBounds(420, 75, 60, 20);
		painelPrincipal.add(labelCorrenteInicial);

		campoCorrenteInicial_A = new JTextField();
		campoCorrenteInicial_A.setBounds(470, 75, 100, 25);
		campoCorrenteInicial_A.setText("2.00");
		estilizarCampo(campoCorrenteInicial_A);
		painelPrincipal.add(campoCorrenteInicial_A);

		botaoCalcular = new JButton("Calcular");
		botaoCalcular.setBounds(20, 115, 120, 30);
		botaoCalcular.setBackground(COR_BOTAO);
		botaoCalcular.setForeground(COR_TEXTO);
		botaoCalcular.setFocusPainted(false);
		botaoCalcular.setBorder(javax.swing.BorderFactory.createLineBorder(COR_BORDA));
		botaoCalcular.setFont(new Font("Arial", Font.BOLD, 13));
		painelPrincipal.add(botaoCalcular);

		botaoResetar = new JButton("Resetar");
		botaoResetar.setBounds(150, 115, 120, 30); // ao lado do Calcular
		botaoResetar.setBackground(COR_BOTAO_RESET);
		botaoResetar.setForeground(COR_TEXTO);
		botaoResetar.setFocusPainted(false);
		botaoResetar.setBorder(javax.swing.BorderFactory.createLineBorder(COR_BORDA));
		botaoResetar.setFont(new Font("Arial", Font.BOLD, 13));
		painelPrincipal.add(botaoResetar);

		Funcionamento function = new Funcionamento(this);

		botaoCalcular.addActionListener(e -> function.calcular());

		botaoCalcular.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				botaoCalcular.setBackground(COR_BOTAO_HOVER);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				botaoCalcular.setBackground(COR_BOTAO);
			}
		});

		botaoResetar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoIndutancia_mH.setText("3.00");
				campoCapacitancia_uF.setText("2.70");
				campoCorrenteInicial_A.setText("2.00");
				areaResultado.setText("");
			}
		});

		botaoResetar.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				botaoResetar.setBackground(COR_BOTAO_RESET_HOVER);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				botaoResetar.setBackground(COR_BOTAO_RESET);
			}
		});

		JLabel labelSaida = new JLabel("Resultado:");
		labelSaida.setForeground(COR_TEXTO);
		labelSaida.setBounds(20, 155, 100, 20);
		painelPrincipal.add(labelSaida);

		areaResultado = new JTextArea();
		areaResultado.setEditable(false);
		areaResultado.setLineWrap(true);
		areaResultado.setWrapStyleWord(true);
		areaResultado.setBounds(20, 180, 550, 185);
		areaResultado.setBackground(COR_PAINEL);
		areaResultado.setForeground(COR_TEXTO);
		areaResultado.setCaretColor(COR_TEXTO);
		areaResultado.setBorder(javax.swing.BorderFactory.createLineBorder(COR_BORDA));
		areaResultado.setFont(new Font("Consolas", Font.PLAIN, 13));
		painelPrincipal.add(areaResultado);
	}

	private void estilizarCampo(JTextField campo) {
		campo.setBackground(COR_CAMPO);
		campo.setForeground(COR_TEXTO);
		campo.setCaretColor(COR_TEXTO);
		campo.setBorder(javax.swing.BorderFactory.createLineBorder(COR_BORDA));
		campo.setFont(new Font("Arial", Font.PLAIN, 13));
	}

	public JTextField getCampoIndutancia_mH() {
		return campoIndutancia_mH;
	}

	public void setCampoIndutancia_mH(JTextField campoIndutancia_mH) {
		this.campoIndutancia_mH = campoIndutancia_mH;
	}

	public JTextField getCampoCapacitancia_uF() {
		return campoCapacitancia_uF;
	}

	public void setCampoCapacitancia_uF(JTextField campoCapacitancia_uF) {
		this.campoCapacitancia_uF = campoCapacitancia_uF;
	}

	public JTextField getCampoCorrenteInicial_A() {
		return campoCorrenteInicial_A;
	}

	public void setCampoCorrenteInicial_A(JTextField campoCorrenteInicial_A) {
		this.campoCorrenteInicial_A = campoCorrenteInicial_A;
	}

	public void setResultado(String texto) {
		areaResultado.setText(texto);
	}
}