package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;

import Controller.VisitanteController;
import dao.VisitanteDAO;
import model.Visitante;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CadastroEventosUI extends JDialog {
	private JTextField txtfNomeVisitante;
	private Visitante visitanteParaEdicao;
	private JTextField txtfDataInicio;
	private JTextField txtfDataTermino;
	private JTextField txtfHoraInicio;
	private JTextField txtfHoraTermino;
	private JTextField txtfNomeResponsavel;
	private JTextField txtfAreaRelacionada;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroEventosUI dialog = new CadastroEventosUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroEventosUI() {
		setResizable(false);
		setModal(true);
		setTitle("Cadastrar Evento");
		setBounds(100, 100, 524, 519);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNomeEvento = new JLabel("Nome do Evento");
		
		txtfNomeVisitante = new JTextField();
		txtfNomeVisitante.setColumns(10);
		
		JLabel lbDataInicio = new JLabel("Data Inicio");
		
		txtfDataInicio = new JTextField();
		txtfDataInicio.setColumns(10);
		
		JLabel lblDataTermino = new JLabel("Data Termino");
		
		txtfDataTermino = new JTextField();
		txtfDataTermino.setColumns(10);
		
		JLabel lbHoraInicio = new JLabel("Hora Inicio");
		
		txtfHoraInicio = new JTextField();
		txtfHoraInicio.setColumns(10);
		
		JLabel lblHoraTermino = new JLabel("Hora Termino");
		
		txtfHoraTermino = new JTextField();
		txtfHoraTermino.setColumns(10);
		
		JLabel lblNomeResponsavel = new JLabel("Nome Responsavel");
		
		txtfNomeResponsavel = new JTextField();
		txtfNomeResponsavel.setColumns(10);
		
		JLabel label = new JLabel("");
		
		JButton btnEscolher = new JButton("Escolher");
		
		JLabel lblBannerDoEvento = new JLabel("Banner do Evento");
		
		JLabel lblAreaRelacionada = new JLabel("Area Relacionada");
		
		txtfAreaRelacionada = new JTextField();
		txtfAreaRelacionada.setColumns(10);
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNomeResponsavel)
								.addComponent(lbDataInicio)
								.addComponent(lblNomeEvento)
								.addComponent(lbHoraInicio)
								.addComponent(lblAreaRelacionada))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtfDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblDataTermino)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtfDataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtfNomeVisitante, GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(txtfHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblHoraTermino)
									.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
									.addComponent(txtfHoraTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtfNomeResponsavel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtfAreaRelacionada)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblBannerDoEvento)
							.addPreferredGap(ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEscolher)
							.addGap(25)))
					.addGap(21))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeEvento)
						.addComponent(txtfNomeVisitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbDataInicio)
						.addComponent(txtfDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataTermino)
						.addComponent(txtfDataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbHoraInicio)
						.addComponent(txtfHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHoraTermino)
						.addComponent(txtfHoraTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeResponsavel)
						.addComponent(txtfNomeResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAreaRelacionada)
						.addComponent(txtfAreaRelacionada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(91)
							.addComponent(lblBannerDoEvento))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(87)
							.addComponent(btnEscolher)))
					.addGap(510))
		);
		panel.setLayout(gl_panel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				dispose();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addGap(203))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public Visitante getVisitanteParaEdicao() {
		return visitanteParaEdicao;
	}
	
	public void setVisitanteParaEdicao(Visitante visitanteParaEdicao) {
		this.visitanteParaEdicao = visitanteParaEdicao;
		preencherCamposParaEdicao();
	}
	
	public void preencherCamposParaEdicao() {
		
		
	}
}
