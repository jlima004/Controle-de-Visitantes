package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.naming.ContextNotEmptyException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controller.EventoController;
import dao.EventoDAO;
import model.Evento;
import model.EventoTableMode;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JComboBox;

public class PrincipalUI extends JFrame {
	
	

	private  JPanel contentPane;
	ArrayList<Evento> lista = new ArrayList<>();
	JComboBox comboBox;
	private int valorBox;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI frame = new PrincipalUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalUI() {
		setTitle("Controle de Evento Senai");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 569);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(112, 128, 144));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		
		comboBox = new JComboBox();
		addComboBox();
		
		JLabel bntGerenciamentoEvento = new JLabel("");
		bntGerenciamentoEvento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GerenciamentoEvento gEvento = new GerenciamentoEvento();
				bntGerenciamentoEvento.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-evento2.png")));
				gEvento.setLocationRelativeTo(null);
				gEvento.setVisible(true);
				
			}
		});
		
		
		JLabel bntGerenciamentoVisitante = new JLabel("");
		bntGerenciamentoVisitante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GerenciamentoVisitanteUI gVisitante = new GerenciamentoVisitanteUI((Evento)comboBox.getSelectedItem());
				bntGerenciamentoVisitante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-visitante2.png")));
				gVisitante.setLocationRelativeTo(null);
				gVisitante.setVisible(true);
					
			}
		});
		
		
		JLabel labelFolder = new JLabel("");
		
		ImageIcon image = new ImageIcon(PrincipalUI.class.getResource("/img/logosenai.png"));
		Image img = image.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		
		labelFolder.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/logosenai.png")));
		
		JLabel lblIndiqueOEvento = new JLabel("Indique o Evento");
		lblIndiqueOEvento.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblIndiqueOEvento.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel bntAtracoes = new JLabel("");
		bntAtracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				bntAtracoes.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-atracao2.png")));
				GerenciamentoDeAtracao gAtracao = new GerenciamentoDeAtracao((Evento)comboBox.getSelectedItem());
				gAtracao.setLocationRelativeTo(null);
				gAtracao.setVisible(true);
			}
			
		});
		
		JLabel btnRelatorio = new JLabel("");
		btnRelatorio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnRelatorio.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-relatorio2.png")));
				RelatorioUI relatorio = new RelatorioUI();
				relatorio.setLocationRelativeTo(null);
				relatorio.setVisible(true);
				
			}
			
			
			
		
		});
		btnRelatorio.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-relatorio.png")));
		
		
		
		
		
		
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addComponent(lblIndiqueOEvento, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelFolder, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnRelatorio, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntAtracoes, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntGerenciamentoEvento))))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIndiqueOEvento, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(labelFolder, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)
					.addGap(32))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addComponent(bntGerenciamentoEvento)
					.addGap(18)
					.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(bntAtracoes, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRelatorio, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(119, Short.MAX_VALUE))
		);
		
		this.addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				addComboBox();
				bntGerenciamentoVisitante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-visitante.png")));
				bntGerenciamentoEvento.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-evento.png")));
				bntAtracoes.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-atracao.png")));
				btnRelatorio.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/icon-relatorio.png")));
				
			 }
		 });
		
		contentPane.setLayout(gl_contentPane);
		
		
		
	}
	
	public void addComboBox(){
		 lista = (ArrayList<Evento>) new EventoDAO().listaEvento();
		 	
		 DefaultComboBoxModel<Evento> modelEvento = new DefaultComboBoxModel<>();
		 
		 for (Evento e : lista){
			 modelEvento.addElement(e);
		 }
		 
		 comboBox.setModel(modelEvento);
	      
	}
	

	public int getValorBox() {
		return valorBox;
	}

	public void setValorBox(int valorBox) {
		this.valorBox = valorBox;
	}
}
