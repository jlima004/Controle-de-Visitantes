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
import Controller.VisitanteController;
import dao.VisitanteDAO;
import model.EventoTableMode;
import model.Visitante;
import model.VisitanteTableMode;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class GerenciamentoVisitanteUI extends JDialog {
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GerenciamentoVisitanteUI dialog = new GerenciamentoVisitanteUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GerenciamentoVisitanteUI() {
		setModal(true);
		setTitle("Gerenciamento de Visitantes");
		setBounds(100, 100, 809, 580);

		JPanel panel = new JPanel();
		panel.setBorder(
				new TitledBorder(null, "Lista de Visitantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				groupLayout.createSequentialGroup().addContainerGap(114, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JScrollPane scrollPane = new JScrollPane();

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int linhaSelecionada = table.getSelectedRow();
				Visitante visitante = new VisitanteTableMode(VisitanteDAO.instanciaSingleton().listaVisitantes)
						.get(linhaSelecionada);
				new VisitanteController().remover(visitante);


				JOptionPane.showMessageDialog(null, "Visitante excluido com  sucesso", "ExclusÃ£o de visitante",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		
		JButton btnNovo = new JButton("novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroVisitanteUI cadVisitante = new CadastroVisitanteUI();
				cadVisitante.setLocationRelativeTo(null);
				cadVisitante.setVisible(true);
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int linhaSelecionada = table.getSelectedRow();
				Visitante visitante = new VisitanteTableMode(
						VisitanteDAO.instanciaSingleton().listaVisitantes).get(linhaSelecionada);
				CadastroVisitanteUI cadVisitante = new CadastroVisitanteUI();
				cadVisitante.setVisitanteParaEdicao(visitante);
				cadVisitante.setLocationRelativeTo(null);
				cadVisitante.setVisible(true);
				
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addGap(7)
							.addComponent(btnExcluir))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExcluir)
						.addComponent(btnNovo)
						.addComponent(btnEditar))
					.addGap(99))
		);

		
		
		/*
		 * Cria um evento listener . que define quando a tela esta ativada ou nao .. 
		 * quando est aativada ela atualiza o jtable.
		 * 
		 */
		this.addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				 table = new JTable();
					VisitanteTableMode model = new VisitanteTableMode(new VisitanteController().listar());
					table.setModel(model);
					scrollPane.setViewportView(table);
			      }
		 });
		
		
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		
		
	}
}
