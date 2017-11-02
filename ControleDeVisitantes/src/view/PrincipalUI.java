package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.naming.ContextNotEmptyException;
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
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class PrincipalUI extends JFrame {
	
	

	private  JPanel contentPane;
	
	

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
		setBounds(100, 100, 800, 570);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEvento = new JMenu("Evento");
		mnEvento.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnEvento);
		
		JMenuItem mntmNovoEvento = new JMenuItem("Novo Evento");
		mntmNovoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		mnEvento.add(mntmNovoEvento);
		
		JMenuItem mntmGerenciarEventos = new JMenuItem("Gerenciar Eventos");
		mntmGerenciarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			 
				
				
				
			}
		});
		mnEvento.add(mntmGerenciarEventos);
		
		JMenu mnVisitante = new JMenu("Visitante");
		menuBar.add(mnVisitante);
		
		JMenuItem mntmCadastrarVisitante = new JMenuItem("Novo Visitante");
		mntmCadastrarVisitante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVisitanteUI cadVisitante = new CadastroVisitanteUI();
				cadVisitante.setLocationRelativeTo(null);
				cadVisitante.setVisible(true);
				
			}
		});
		mnVisitante.add(mntmCadastrarVisitante);
		
		JMenuItem mntmGerenciamentoVisitantes = new JMenuItem("Gerenciar Visitantes");
		mntmGerenciamentoVisitantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GerenciamentoVisitanteUI gVisitante = new GerenciamentoVisitanteUI();
				gVisitante.setLocationRelativeTo(null);
				gVisitante.setVisible(true);
				
			
			}
		});
		mnVisitante.add(mntmGerenciamentoVisitantes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/535620-10-06-23-48-SENAI_SC.jpg")));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 784, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 511, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(lblNewLabel);
	}
}
