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

import Controller.AtracaoController;
import Controller.EventoController;
import Controller.VisitanteController;
import dao.AtracaoDAO;
import dao.VisitanteDAO;
import model.Atracao;
import model.AtracaoTableMode;
import model.Evento;
import model.EventoTableMode;
import model.Visitante;
import model.VisitanteTableMode;

import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class GerenciamentoDeAtracao extends JDialog {
	private JTable table;
	
	private Evento eventoObject;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GerenciamentoDeAtracao dialog = new GerenciamentoDeAtracao(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GerenciamentoDeAtracao(Evento eventoObject) {
		setEventoObject(eventoObject);
		getContentPane().setBackground(new Color(112, 128, 144));
		setModal(true);
		setTitle("Gerenciamento de Visitantes");
		setBounds(100, 100, 809, 580);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Atra\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JLabel lbnome = new JLabel("");
		lbnome.setText("Atrações da "+getEventoObject().getNome());
		lbnome.setIcon(null);
		lbnome.setHorizontalAlignment(SwingConstants.CENTER);
		lbnome.setForeground(Color.WHITE);
		lbnome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbnome, GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(lbnome, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnExcluir = new JButton("Excluir");
		System.out.println(btnExcluir.getHeight()+btnExcluir.getWidth());
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int linhaSelecionada = table.getSelectedRow();
				Atracao atracao = new AtracaoTableMode(
						AtracaoDAO.instanciaSigleton().listaAtracoes).get(linhaSelecionada);
				new AtracaoController().remover(atracao.getId());


				JOptionPane.showMessageDialog(null, "Atração excluida com  sucesso", "Exclusão de Atração",
						JOptionPane.WARNING_MESSAGE);
			}
		});
		
		JButton btnNovo = new JButton("novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CadastroAtracoesUI cadAtracoes = new CadastroAtracoesUI(getEventoObject());
				cadAtracoes.setLocationRelativeTo(null);
				cadAtracoes.setVisible(true);
				
				
				
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int linhaSelecionada = table.getSelectedRow();
				Atracao atracao = new AtracaoTableMode(
						AtracaoDAO.instanciaSigleton().listaAtracoes).get(linhaSelecionada);
				CadastroAtracoesUI cadAtracoes = new CadastroAtracoesUI(getEventoObject());
				cadAtracoes.setAtracaoParaEdicao(atracao);
				cadAtracoes.setLocationRelativeTo(null);
				cadAtracoes.setVisible(true);
				
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(5)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNovo)
						.addComponent(btnEditar)
						.addComponent(btnExcluir))
					.addGap(48))
		);

		
		
		/*
		 * Cria um evento listener . que define quando a tela esta ativada ou nao .. 
		 * quando est aativada ela atualiza o jtable.
		 * 
		 */
		this.addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				    table = new JTable();	
				    
				    Evento evento = new Evento();
				    
				    evento.setAtracoes((ArrayList<Atracao>) new AtracaoController().listarAtracoesEvento(eventoObject.getId()));
				    
				    AtracaoTableMode model = new AtracaoTableMode(evento.getAtracoes());
				    
				    table.setModel(model);
					scrollPane.setViewportView(table);
				  
			      }
		 });
		
		
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		
		
	}

	public Evento getEventoObject() {
		return eventoObject;
	}

	public void setEventoObject(Evento eventoObject) {
		this.eventoObject = eventoObject;
	}
	
	
}
