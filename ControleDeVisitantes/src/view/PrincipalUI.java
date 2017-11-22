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
				gEvento.setLocationRelativeTo(null);
				gEvento.setVisible(true);
				
				
				
			}
		});
		bntGerenciamentoEvento.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/ev.jpg")));
		
		JLabel bntGerenciamentoVisitante = new JLabel("");
		bntGerenciamentoVisitante.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GerenciamentoVisitanteUI gVisitante = new GerenciamentoVisitanteUI((Evento)comboBox.getSelectedItem());
				gVisitante.setLocationRelativeTo(null);
				gVisitante.setVisible(true);
					
			}
		});
		bntGerenciamentoVisitante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/Visitante-icon.png")));
		
		JLabel bntGerenciamentoPalestrante = new JLabel("");
		bntGerenciamentoPalestrante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/palestrantre-icon.png")));
		
		JLabel labelFolder = new JLabel("");
		
		ImageIcon image = new ImageIcon(PrincipalUI.class.getResource("/img/logosenai.png"));
		Image img = image.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		
		labelFolder.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/logosenai.png")));
		
		JLabel lblIndiqueOEvento = new JLabel("Indique o Evento");
		lblIndiqueOEvento.setForeground(UIManager.getColor("Button.disabledShadow"));
		lblIndiqueOEvento.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		
		
		
		
	
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(labelFolder, GroupLayout.PREFERRED_SIZE, 690, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(bntGerenciamentoEvento)
							.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
						.addComponent(bntGerenciamentoPalestrante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(11))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(112)
					.addComponent(lblIndiqueOEvento, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(296, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIndiqueOEvento, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(labelFolder, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(bntGerenciamentoEvento)
							.addGap(18)
							.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bntGerenciamentoPalestrante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		this.addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				addComboBox();
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
