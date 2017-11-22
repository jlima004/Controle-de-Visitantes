package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.EventoController;
import dao.EventoDAO;
import model.Evento;
import model.EventoTableMode;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;

public class GerenciamentoEvento extends JDialog {
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GerenciamentoEvento dialog = new GerenciamentoEvento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GerenciamentoEvento() {
		getContentPane().setBackground(new Color(112, 128, 144));
		setBounds(100, 100, 809, 580);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBorder(new TitledBorder(null, "Lista Eventos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 767, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(148, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addGap(49))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroEventosUI cadEvento = new CadastroEventosUI();
				cadEvento.setLocationRelativeTo(null);
				cadEvento.setVisible(true);
			}
		});
		
		
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = table_1.getSelectedRow();
				Evento evento = new EventoTableMode(EventoDAO.instanciaSingleton().listaEventos).get(linhaSelecionada);
				CadastroEventosUI cadEvento = new CadastroEventosUI();
				cadEvento.setEventoParaEdicao(evento);
				cadEvento.setLocationRelativeTo(null);
				cadEvento.setVisible(true);
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
					int linhaSelecionada = table_1.getSelectedRow();
					Evento evento = new EventoTableMode(EventoDAO.instanciaSingleton().listaEventos).get(linhaSelecionada);
					
					new EventoController().remover(evento);
				
					
					JOptionPane.showMessageDialog(null, "Excluido com Succeso!!");
				
				
				
				
				
			
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(421, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		
		/*
		 * Cria um evento listener . que define quando a tela esta ativada ou nao .. 
		 * quando est aativada ela atualiza o jtable.
		 * 
		 */
		this.addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
			       // System.out.println("Window Activated Event");
			        table_1 = new JTable();
					EventoTableMode model =  new EventoTableMode(new EventoController().listar());
					table_1.setModel(model);
					scrollPane.setViewportView(table_1);
			      }
		 });
		
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
	}
	

}
