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

public class CadastroVisitanteUI extends JDialog {
	private JTextField txtfNomeVisitante;
	private JTextField txtfEmail;
	private JTextField txtfTelefone;
	private JTextField txtfBairro;
	private JComboBox<String> cbSexo = new JComboBox<String>();
	private Visitante visitanteParaEdicao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroVisitanteUI dialog = new CadastroVisitanteUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroVisitanteUI() {
		setResizable(false);
		setModal(true);
		setTitle("Cadastrar Visitante");
		setBounds(100, 100, 470, 274);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JLabel lblNome = new JLabel("Nome");
		
		txtfNomeVisitante = new JTextField();
		txtfNomeVisitante.setColumns(10);
		
		JLabel lblTelefone = new JLabel("E-mail");
		
		txtfEmail = new JTextField();
		txtfEmail.setColumns(10);
		
		JLabel lblTelefone_1 = new JLabel("Telefone");
		
		txtfTelefone = new JTextField();
		txtfTelefone.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro");
		
		txtfBairro = new JTextField();
		txtfBairro.setColumns(10);
		
		JLabel lblSexo = new JLabel();
		
		cbSexo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Masculino", "Feminino"}));
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblTelefone_1)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblTelefone)
								.addComponent(lblNome)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(lblBairro)))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtfNomeVisitante, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtfBairro, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txtfTelefone, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addGap(9)
								.addComponent(lblSexo)
								.addGap(18)
								.addComponent(cbSexo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(txtfEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE)))
					.addGap(7))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(txtfNomeVisitante, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro)
						.addComponent(txtfBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefone)
						.addComponent(txtfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTelefone_1)
								.addComponent(txtfTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSexo)
								.addComponent(cbSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (visitanteParaEdicao == null) {
						System.out.println(cbSexo.getSelectedItem().toString().charAt(0));
						Visitante visitante = new Visitante();
						visitante.setNome(txtfNomeVisitante.getText());
						visitante.setEmail(txtfEmail.getText());
						visitante.setBairro(txtfBairro.getText());
						visitante.setSexo(cbSexo.getSelectedItem().toString());
						visitante.setTelefone(txtfTelefone.getText());

						new VisitanteController().salvar(visitante);

						JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!!");

					} else {

						visitanteParaEdicao.setNome(txtfNomeVisitante.getText());
						visitanteParaEdicao.setEmail(txtfEmail.getText());
						visitanteParaEdicao.setBairro(txtfBairro.getText());
						visitanteParaEdicao.setSexo(cbSexo.getSelectedItem().toString());
						visitanteParaEdicao.setTelefone(txtfTelefone.getText());

						new VisitanteController().editar(visitanteParaEdicao);

						JOptionPane.showMessageDialog(null, "Visitante Editado com sucesso!!");

					}
					dispose();	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e.getMessage());
					e.printStackTrace();
				}

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(180)
					.addComponent(btnCadastrar)
					.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrar)
					.addContainerGap(29, Short.MAX_VALUE))
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
		if (visitanteParaEdicao != null) {
			txtfNomeVisitante.setText(visitanteParaEdicao.getNome());
			txtfEmail.setText(visitanteParaEdicao.getEmail());
			txtfBairro.setText(visitanteParaEdicao.getBairro());
			txtfTelefone.setText(visitanteParaEdicao.getTelefone());
			cbSexo.setSelectedItem(visitanteParaEdicao.getSexo());
		}
	}

}
