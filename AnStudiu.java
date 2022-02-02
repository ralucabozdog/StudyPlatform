import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class AnStudiu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AnStudiu dialog = new AnStudiu("amarieigeorge@gmail.com");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AnStudiu(String email) {
		setBounds(100, 100, 627, 342);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		contentPanel.setBackground(new Color(230, 230, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblNewLabel_1_1_1 = new JLabel("an studiu:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(113, 93, 100, 26);
		contentPanel.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setForeground(new Color(128, 0, 128));
		textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(245, 93, 240, 30);
		textField_1.setText(email);
		contentPanel.add(textField_1);
		{
			JLabel lblAnDeStudiu = new JLabel("Anul de studiu");
			lblAnDeStudiu.setBounds(178, 11, 253, 52);
			lblAnDeStudiu.setHorizontalAlignment(SwingConstants.CENTER);
			lblAnDeStudiu.setForeground(new Color(0, 139, 139));
			lblAnDeStudiu.setFont(new Font("Arial Narrow", Font.BOLD, 29));
			contentPanel.add(lblAnDeStudiu);
		}
		{
			JLabel lblNewLabel_1_1 = new JLabel("an studiu:");
			lblNewLabel_1_1.setBounds(113, 138, 100, 26);
			lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
			lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
			contentPanel.add(lblNewLabel_1_1);
		}
		
		ConexiuneBD con1 = new ConexiuneBD();
		con1.init();
		ArrayList<Integer> info = con1.getInfoStudent(textField_1.getText());
		int an = info.get(0);
		int nrOre = info.get(1);
		String[] anStudiu = {"1", "2", "3", "4", "5", "6"};				//se vor alege doar materiile la care profesorul ii preda respectivului elev
		JComboBox comboBox = new JComboBox(anStudiu);
		comboBox.setForeground(new Color(128, 0, 128));
		comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		comboBox.setBounds(245, 138, 240, 26);
		comboBox.setSelectedIndex(an - 1);
		contentPanel.add(comboBox);
		{
			JButton btnOk = new JButton("OK");
			btnOk.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		ConexiuneBD conexiune = new ConexiuneBD();
					conexiune.init();
					int o = Integer.parseInt(textField.getText());
					String mesajEroare = conexiune.anStudiu(email, comboBox.getSelectedIndex() + 1, o);
					if(mesajEroare != null) {
						new MesajEroare(mesajEroare).setVisible(true);
						System.out.println(mesajEroare);
					}
					else {
						setVisible(false);
					}
	        	}
	        });
			btnOk.setForeground(new Color(230, 230, 250));
			btnOk.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
			btnOk.setBackground(new Color(0, 139, 139));
			btnOk.setActionCommand("OK");
			btnOk.setBounds(245, 245, 138, 44);
			contentPanel.add(btnOk);
		}
		Integer val = new Integer(nrOre);
		String ore = val.toString();
		JLabel lblNewLabel_1_1 = new JLabel("num\u0103r de ore:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(113, 187, 116, 26);
		contentPanel.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setBounds(245, 193, 240, 20);
		textField.setText(ore);
		contentPanel.add(textField);
		textField.setColumns(10);
	}
}

