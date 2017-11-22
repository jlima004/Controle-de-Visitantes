package view;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CadastroAtracaoUI extends JDialog {
	private JTextField JtxtNomeAtracao;
	private JTextField JtxtData;
	private JTextField JtxtHoraInicio;
	private JTextField JtxtHoraTermino;
	private JTextField JtxtTipo;
	public CadastroAtracaoUI() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JLabel JlbNomeDaAtracao = new JLabel("Nome da Atracao");
		
		JtxtNomeAtracao = new JTextField();
		JtxtNomeAtracao.setColumns(10);
		
		JLabel JlbData = new JLabel("Data");
		
		JtxtData = new JTextField();
		JtxtData.setColumns(10);
		
		JLabel JlblHoraDeInicio = new JLabel("Hora de inicio");
		
		JtxtHoraInicio = new JTextField();
		JtxtHoraInicio.setColumns(10);
		
		JLabel JlblHoraDeTermino = new JLabel("Hora de Termino");
		
		JtxtHoraTermino = new JTextField();
		JtxtHoraTermino.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		
		JtxtTipo = new JTextField();
		JtxtTipo.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTipo)
							.addGap(18)
							.addComponent(JtxtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(JlblHoraDeTermino)
							.addGap(18)
							.addComponent(JtxtHoraTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(JlblHoraDeInicio)
							.addGap(18)
							.addComponent(JtxtHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(JlbData)
							.addGap(18)
							.addComponent(JtxtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(JlbNomeDaAtracao)
							.addGap(18)
							.addComponent(JtxtNomeAtracao, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(JtxtNomeAtracao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(JlbNomeDaAtracao))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(JlbData)
						.addComponent(JtxtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(JlblHoraDeInicio)
						.addComponent(JtxtHoraInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(JlblHoraDeTermino)
						.addComponent(JtxtHoraTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(JtxtTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
