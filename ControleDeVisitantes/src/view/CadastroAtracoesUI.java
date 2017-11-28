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

import com.mysql.fabric.xmlrpc.base.Data;

import Controller.AtracaoController;
import Controller.EventoController;
import Controller.VisitanteController;
import dao.EventoDAO;
import dao.VisitanteDAO;
import model.Atracao;
import model.Evento;
import model.Visitante;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class CadastroAtracoesUI extends JDialog {
	private JTextField txtfNomeAtracao;
	private Atracao atracaoParaEdicao;
	
	
	private Evento eventoObject;
	private JTextField txtfData;
	private JTextField txtfHoraInicio;
	private JTextField txtfHoraTermino;
	private JTextField txtfDescricao;
	
	
    SimpleDateFormat sp =new SimpleDateFormat("dd/MM/yyyy");
	
	SimpleDateFormat sph =new SimpleDateFormat("HH:mm");
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroAtracoesUI dialog = new CadastroAtracoesUI(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroAtracoesUI(Evento eventoObject) {
		setEventoObject(eventoObject);
		getContentPane().setBackground(new Color(112, 128, 144));
		setResizable(false);
		setModal(true);
		setTitle("Cadastrar Atra\u00E7\u00F5es\r\n");
		setBounds(100, 100, 524, 356);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome");
		
		txtfNomeAtracao = new JTextField();
		txtfNomeAtracao.setColumns(10);
		
		JLabel lblSexo = new JLabel();
		
		JLabel lblData = new JLabel("Data");
		
		txtfData = new JTextField();
		txtfData.setColumns(10);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio");
		
		txtfHoraInicio = new JTextField();
		txtfHoraInicio.setColumns(10);
		
		JLabel lblHoraTermino = new JLabel("Hora Termino");
		
		txtfHoraTermino = new JTextField();
		txtfHoraTermino.setColumns(10);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		
		txtfDescricao = new JTextField();
		txtfDescricao.setColumns(10);
		
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNome)
						.addComponent(lblData))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
								.addComponent(lblSexo)
								.addGap(181))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(9)
								.addComponent(txtfNomeAtracao, GroupLayout.PREFERRED_SIZE, 405, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(txtfData, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblHoraInicio)
							.addGap(18)
							.addComponent(txtfHoraInicio, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblHoraTermino)
							.addGap(18)
							.addComponent(txtfHoraTermino, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addGap(112))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtfDescricao, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)))
					.addGap(18))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(12)
					.addComponent(lblDescrio)
					.addContainerGap(466, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(13)
									.addComponent(lblNome))
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtfNomeAtracao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(32)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(36)
									.addComponent(lblSexo))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(19)
									.addComponent(lblDescrio))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(49)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtfData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblData)
								.addComponent(lblHoraInicio)
								.addComponent(txtfHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHoraTermino)
								.addComponent(txtfHoraTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtfDescricao, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(atracaoParaEdicao ==null){
					Atracao atracao = new Atracao();
					atracao.setNome(txtfNomeAtracao.getText());
					atracao.setDescricao(txtfDescricao.getText());
					atracao.setIdEvento(eventoObject.getId());
					try {
						atracao.setData(new Date(sp.parse(txtfData.getText()).getTime()));
						atracao.setHoraInicio(new Time(sph.parse(txtfHoraInicio.getText()).getTime()));
						atracao.setHorarioTermino(new Time(sph.parse(txtfHoraTermino.getText()).getTime()));
					new AtracaoController().salvar(atracao);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");
				}else{
					atracaoParaEdicao.setNome(txtfNomeAtracao.getText());
					atracaoParaEdicao.setDescricao(txtfDescricao.getText());
					try {
						atracaoParaEdicao.setData(new Date(sp.parse(txtfData.getText()).getTime()));
						atracaoParaEdicao.setHoraInicio(new Time(sph.parse(txtfHoraInicio.getText()).getTime()));
						atracaoParaEdicao.setHorarioTermino(new Time(sph.parse(txtfHoraTermino.getText()).getTime()));
						new AtracaoController().editar(atracaoParaEdicao);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				dispose();
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(222, Short.MAX_VALUE)
					.addComponent(btnCadastrar)
					.addGap(215))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCadastrar)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	public Atracao getAtracaoParaEdicao() {
		return atracaoParaEdicao;
	}
	
	public void setAtracaoParaEdicao(Atracao atracaoParaEdicao) {
		this.atracaoParaEdicao = atracaoParaEdicao;
		preencherCamposParaEdicao();
	}
	
	public void preencherCamposParaEdicao() {
		if (atracaoParaEdicao != null) {
			txtfNomeAtracao.setText(atracaoParaEdicao.getNome());
			txtfData.setText(String.valueOf(sp.format(atracaoParaEdicao.getData())));
			
			txtfHoraInicio.setText(String.valueOf(sph.format(atracaoParaEdicao.getHoraInicio())));
			txtfHoraTermino.setText(String.valueOf(sph.format(atracaoParaEdicao.getHorarioTermino())));
			txtfDescricao.setText(atracaoParaEdicao.getDescricao());
			
		}
	}

	public Evento getEventoObject() {
		return eventoObject;
	}

	public void setEventoObject(Evento eventoObject) {
		eventoObject = eventoObject;
	}
}
