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
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setBounds(100, 100, 800, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
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
				GerenciamentoVisitanteUI gVisitante = new GerenciamentoVisitanteUI();
				gVisitante.setLocationRelativeTo(null);
				gVisitante.setVisible(true);
			}
		});
		bntGerenciamentoVisitante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/Visitante-icon.png")));
		
		JLabel bntGerenciamentoPalestrante = new JLabel("");
		bntGerenciamentoPalestrante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/palestrantre-icon.png")));
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bntGerenciamentoEvento)
						.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addComponent(bntGerenciamentoPalestrante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(119)
					.addComponent(bntGerenciamentoEvento)
					.addGap(18)
					.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(bntGerenciamentoPalestrante, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(182, Short.MAX_VALUE))
		);
		
		JLabel lbFolder = new JLabel("");
		lbFolder.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/Cartaz 2017 NOVO.jpg")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lbFolder, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 668, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lbFolder, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
=======
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
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PrincipalUI extends JFrame {

	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		JPanel panel = new JPanel();

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
				GerenciamentoVisitanteUI gVisitante = new GerenciamentoVisitanteUI();
				gVisitante.setLocationRelativeTo(null);
				gVisitante.setVisible(true);
			}
		});
		bntGerenciamentoVisitante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/Visitante-icon.png")));

		JLabel bntGerenciamentoPalestrante = new JLabel("");
		bntGerenciamentoPalestrante.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/palestrantre-icon.png")));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 668, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(bntGerenciamentoEvento)
						.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(bntGerenciamentoPalestrante, GroupLayout.PREFERRED_SIZE, 65,
								GroupLayout.PREFERRED_SIZE))
				.addGap(24)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(119).addComponent(bntGerenciamentoEvento)
						.addGap(18)
						.addComponent(bntGerenciamentoVisitante, GroupLayout.PREFERRED_SIZE, 65,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(bntGerenciamentoPalestrante, GroupLayout.PREFERRED_SIZE, 65,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(182, Short.MAX_VALUE)));

		JLabel lbFolder = new JLabel("");
		lbFolder.setIcon(new ImageIcon(PrincipalUI.class.getResource("/img/Cartaz 2017 NOVO.jpg")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lbFolder,
				Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 668, Short.MAX_VALUE));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lbFolder,
				Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
