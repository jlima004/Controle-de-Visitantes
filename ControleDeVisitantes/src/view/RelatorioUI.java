package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Controller.RelatorioController;
import model.Evento;
import model.Visitante;
import model.VisitanteTableMode;

public class RelatorioUI extends JDialog {
	private JTable table;
	
	
	private List<Visitante> visitantes;
	ArrayList<Evento> lista = new ArrayList<>();
	JComboBox<String> boxArea = new JComboBox<String>();

	private JTable table_1;
	private JTextField txtfTotal;
	private JTextField txtfTotalEventos;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RelatorioUI dialog = new RelatorioUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RelatorioUI() {
	
		getContentPane().setBackground(new Color(112, 128, 144));
		setModal(true);
		setTitle("Relatorio de Eventos");
		setBounds(100, 100, 809, 580);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		boxArea.setModel(new DefaultComboBoxModel(new String[] {"Selecione","Programa��o de Jogos","Analise e Desenvolvimento de Sistemas","Automa��o Indutrial","Literaria","Design","Anima��o","Outras"}));
		
		
		
		JLabel lblSelecioneArea = new JLabel("Selecione \u00C1rea ");
		lblSelecioneArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSelecioneArea.setForeground(Color.WHITE);
		
		JButton btnExibir = new JButton("Exibir");
		btnExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizaTable();
				 numeroVisitantes();
				  txtfTotal.setText(String.valueOf(numeroVisitantes()));
				  numeroDeEventos();
				  txtfTotalEventos.setText(String.valueOf(numeroDeEventos()));
			}
		});
		
		JLabel lblTotalDeVisitantes = new JLabel("Total de Visitantes Desta \u00C1rea");
		lblTotalDeVisitantes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalDeVisitantes.setForeground(Color.WHITE);
		
		txtfTotal = new JTextField();
		txtfTotal.setEditable(false);
		txtfTotal.setText(String.valueOf(numeroVisitantes()));
		txtfTotal.setColumns(10);
		
		JLabel lbtotalEventos = new JLabel("Total de Eventos  Desta \u00C1rea");
		lbtotalEventos.setForeground(Color.WHITE);
		lbtotalEventos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtfTotalEventos = new JTextField();
		txtfTotalEventos.setEditable(false);
		txtfTotalEventos.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(8))
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(200)
							.addComponent(lblSelecioneArea, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(lbtotalEventos, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtfTotalEventos, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(boxArea, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnExibir))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52)
							.addComponent(lblTotalDeVisitantes)
							.addGap(18)
							.addComponent(txtfTotal, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSelecioneArea, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(boxArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnExibir))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtfTotalEventos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbtotalEventos, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTotalDeVisitantes)
						.addComponent(txtfTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(13, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 752, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);

		
		
		/*
		 * Cria um evento listener . que define quando a tela esta ativada ou nao .. 
		 * quando est aativada ela atualiza o jtable.
		 * 
		 */
		this.addWindowListener(new WindowAdapter() {
			 public void windowActivated(WindowEvent e) {
				  atualizaTable();
				  numeroVisitantes();
				  numeroDeEventos();
				  txtfTotal.setText(String.valueOf(numeroVisitantes()));
				  txtfTotalEventos.setText(String.valueOf(numeroDeEventos()));
			      }
		 });
		
		
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		
		
	}

	
	public void atualizaTable(){
		VisitanteTableMode model = new VisitanteTableMode(new RelatorioController().listarPorArea(boxArea.getSelectedItem().toString()));
		table_1.setModel(model);
		
	}
	public int numeroVisitantes(){
		 return  new RelatorioController().listarPorArea(boxArea.getSelectedItem().toString()).size();
	}
	
	public int numeroDeEventos(){
		return new RelatorioController().totalEventos(boxArea.getSelectedItem().toString());
	}
}
