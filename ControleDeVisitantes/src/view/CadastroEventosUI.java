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
import javax.swing.text.html.parser.Parser;

import com.mysql.fabric.xmlrpc.base.Data;

import Controller.EventoController;
import Controller.VisitanteController;
import dao.VisitanteDAO;
import model.Evento;
import model.EventoTableMode;
import model.Visitante;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CadastroEventosUI extends JDialog {
	private JTextField txtfNomeEvento;
	private Visitante visitanteParaEdicao;
	private JTextField txtfDataInicio;
	private JTextField txtfDataTermino;
	private JTextField txtfHoraInicio;
	private JTextField txtfHoraTermino;
	private JTextField txtfNomeResponsavel;
	
	JComboBox<String> boxArea = new JComboBox<String>();
	
	
	private Evento eventoParaEdicao;
	
	SimpleDateFormat sp =new SimpleDateFormat("dd/MM/yyyy");
	
	SimpleDateFormat sph =new SimpleDateFormat("HH:mm");
	
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
		getContentPane().setBackground(new Color(112, 128, 144));
		setResizable(false);
		setModal(true);
		setTitle("Cadastrar Evento");
		setBounds(100, 100, 562, 316);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		
		JLabel lblNomeEvento = new JLabel("Nome do Evento");
		
		txtfNomeEvento = new JTextField();
		txtfNomeEvento.setColumns(10);
		
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
		
		JLabel lblAreaRelacionada = new JLabel("Area Relacionada");
		
		
		boxArea.setModel(new DefaultComboBoxModel(new String[] {"Selecione","Programação de Jogos","Analise e Desenvolvimento de Sistemas","Automação Indutrial","Literaria","Design","Animação","Outras"}));
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(eventoParaEdicao==null){
					try {
						
					
					Evento evento = new Evento();
					evento.setNome(txtfNomeEvento.getText());
					
					
						evento.setDataInicio(new Date(sp.parse(txtfDataInicio.getText()).getTime()));
						evento.setDataTermino(new Date(sp.parse(txtfDataTermino.getText()).getTime()));
						evento.setHoraInicio(new Time(sph.parse(txtfHoraInicio.getText()).getTime()));
						evento.setHoraTermino(new Time(sph.parse(txtfHoraTermino.getText()).getTime()));
						
					
					
						evento.setResponsavel(txtfNomeResponsavel.getText());
						evento.setAreaRelacionada(boxArea.getSelectedItem().toString());
					
					new EventoController().salvar(evento);
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
					
					
				}else{
					eventoParaEdicao.setNome(txtfNomeEvento.getText());
					try {
						eventoParaEdicao.setDataInicio(new Date(sp.parse(txtfDataInicio.getText()).getTime()));
						eventoParaEdicao.setDataTermino(new Date(sp.parse(txtfDataTermino.getText()).getTime()));
						eventoParaEdicao.setHoraInicio(new Time(sph.parse(txtfHoraInicio.getText()).getTime()));
						eventoParaEdicao.setHoraTermino(new Time(sph.parse(txtfHoraTermino.getText()).getTime()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						
					}
					eventoParaEdicao.setResponsavel(txtfNomeResponsavel.getText());
					eventoParaEdicao.setAreaRelacionada(boxArea.getSelectedItem().toString());
					
					new EventoController().editar(eventoParaEdicao);
					
					JOptionPane.showMessageDialog(null, "Evento Editado com sucesso!!");
					
					
					
				}
				
				dispose();
				
			}
		});
		
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNomeResponsavel)
								.addComponent(lbDataInicio)
								.addComponent(lblNomeEvento)
								.addComponent(lbHoraInicio)
								.addComponent(lblAreaRelacionada))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtfDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblDataTermino)
											.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
											.addComponent(txtfDataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtfNomeEvento, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtfHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblHoraTermino)
											.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
											.addComponent(txtfHoraTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtfNomeResponsavel, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE))
									.addGap(21))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(43)
									.addComponent(boxArea, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addGap(210))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeEvento)
						.addComponent(txtfNomeEvento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(boxArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addComponent(btnCadastrar)
					.addGap(31))
		);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public Evento geteventoParaEdicao() {
		return eventoParaEdicao;
	}
	
	public void setEventoParaEdicao(Evento eventoParaEdicao) {
		this.eventoParaEdicao = eventoParaEdicao;
		preencherCamposParaEdicao();
	}
	
	public void preencherCamposParaEdicao() {
		if(eventoParaEdicao!= null){
			txtfNomeEvento.setText(eventoParaEdicao.getNome());
			txtfDataInicio.setText(String.valueOf(sp.format(eventoParaEdicao.getDataInicio())));
			txtfDataTermino.setText(String.valueOf(sp.format(eventoParaEdicao.getDataTermino())));
			txtfHoraInicio.setText(String.valueOf(sph.format(eventoParaEdicao.getHoraInicio())));
			txtfHoraTermino.setText(String.valueOf(sph.format(eventoParaEdicao.getHoraTermino())));
			txtfNomeResponsavel.setText(eventoParaEdicao.getResponsavel());
			boxArea.setSelectedItem(eventoParaEdicao.getAreaRelacionada());
		}
		
		
	}
}
