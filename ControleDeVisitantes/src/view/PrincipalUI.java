package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class PrincipalUI extends JFrame {

	private JPanel Card;
	private JTextField txtGerenciamentoEvento;
	private JTable table;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 787, 554);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEvento = new JMenu("Evento");
		mnEvento.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnEvento);
		
		JMenuItem mntmNovoEvento = new JMenuItem("Novo Evento");
		mnEvento.add(mntmNovoEvento);
		
		JMenuItem mntmGerenciarEventos = new JMenuItem("Gerenciar Eventos");
		mntmGerenciarEventos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cd =  (CardLayout)Card.getLayout();
				cd.show(Card, "gEvento");
			}
		});
		mnEvento.add(mntmGerenciarEventos);
		
		JMenu mnVisitante = new JMenu("Visitante");
		menuBar.add(mnVisitante);
		Card = new JPanel();
		Card.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Card);
		Card.setLayout(new CardLayout(0, 0));
		
		JPanel pPrincipal = new JPanel();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/535620-10-06-23-48-SENAI_SC.jpg")));
		GroupLayout gl_pPrincipal = new GroupLayout(pPrincipal);
		gl_pPrincipal.setHorizontalGroup(
			gl_pPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPrincipal.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_pPrincipal.setVerticalGroup(
			gl_pPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pPrincipal.createSequentialGroup()
					.addGap(20)
					.addComponent(label)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		pPrincipal.setLayout(gl_pPrincipal);
		Card.add(pPrincipal, "Principal");
		
		JPanel gEvento = new JPanel();
		Card.add(gEvento, "gEvento");
		
		txtGerenciamentoEvento = new JTextField();
		txtGerenciamentoEvento.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtGerenciamentoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		txtGerenciamentoEvento.setText("Gerenciamento Evento");
		txtGerenciamentoEvento.setColumns(10);
		
		JButton bntExcluirEvento = new JButton("Excluir Evento");
		
		JButton bntEditarEvento = new JButton("Editar Evento");
		
		JButton bntGerenciarAtracoes = new JButton("Atra\u00E7\u00F5es");
		
		JButton bntVisitantes = new JButton("Visitantes");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton bntVoltar = new JButton("Voltar");
		bntVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CardLayout cd =  (CardLayout)Card.getLayout();
				cd.show(Card, "Principal");
			}
		});
		GroupLayout gl_gEvento = new GroupLayout(gEvento);
		gl_gEvento.setHorizontalGroup(
			gl_gEvento.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_gEvento.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_gEvento.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gEvento.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addGroup(gl_gEvento.createParallelGroup(Alignment.LEADING)
								.addComponent(bntVoltar, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntExcluirEvento, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntEditarEvento, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntGerenciarAtracoes, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
								.addComponent(bntVisitantes, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtGerenciamentoEvento, GroupLayout.PREFERRED_SIZE, 733, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_gEvento.setVerticalGroup(
			gl_gEvento.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_gEvento.createSequentialGroup()
					.addGap(22)
					.addComponent(txtGerenciamentoEvento, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_gEvento.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_gEvento.createSequentialGroup()
							.addComponent(bntExcluirEvento, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bntEditarEvento, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bntGerenciarAtracoes, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(bntVisitantes, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
							.addComponent(bntVoltar, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(46))
						.addGroup(gl_gEvento.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		gEvento.setLayout(gl_gEvento);
	}
}
