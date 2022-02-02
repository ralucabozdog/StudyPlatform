import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class DetaliiProfesor extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetaliiProfesor frame = new DetaliiProfesor("popadorian@gmail.com");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DetaliiProfesor(String email) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 370);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ConexiuneBD con1 = new ConexiuneBD();
		con1.init();
		
		ArrayList<Integer> info = con1.getInfoProfesor(email); 
		
		JLabel lblNewLabel_1 = new JLabel("nr. minim studen\u021Bi:");
		lblNewLabel_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1.setBounds(33, 114, 155, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("nr. maxim studen\u021Bi:");
		lblNewLabel_1_2.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_2.setBounds(33, 150, 155, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("departament:");
		lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(33, 187, 122, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setForeground(new Color(128, 0, 128));
		textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(206, 114, 281, 26);
		textField.setText(String.valueOf(info.get(0)));
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setForeground(new Color(128, 0, 128));
		textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(206, 150, 281, 26);
		textField_1.setText(String.valueOf(info.get(1)));
		contentPane.add(textField_1);
		
		ConexiuneBD con2 = new ConexiuneBD();
		con2.init();
		String numeDep = con2.getNumeDep(info.get(2));
		
		JLabel lblDetaliiProfesor = new JLabel("Detalii profesor");
		lblDetaliiProfesor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetaliiProfesor.setForeground(new Color(0, 139, 139));
		lblDetaliiProfesor.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblDetaliiProfesor.setBounds(167, 11, 218, 52);
		contentPane.add(lblDetaliiProfesor);
		
		JLabel lblNewLabel_1_3 = new JLabel("email:");
		lblNewLabel_1_3.setForeground(new Color(0, 139, 139));
		lblNewLabel_1_3.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		lblNewLabel_1_3.setBounds(33, 77, 155, 26);
		contentPane.add(lblNewLabel_1_3);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setForeground(new Color(128, 0, 128));
		textField_2.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_2.setColumns(10);
		textField_2.setBounds(206, 77, 281, 26);
		textField_2.setText(email);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setForeground(new Color(128, 0, 128));
		textField_3.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(206, 187, 281, 26);
		textField_3.setText(numeDep);
		contentPane.add(textField_3);
		
		JButton btnOk = new JButton("OK");
		btnOk.setForeground(new Color(230, 230, 250));
		btnOk.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
		btnOk.setBackground(new Color(0, 139, 139));
		btnOk.setActionCommand("OK");
		btnOk.setBounds(202, 245, 138, 44);
		btnOk.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ConexiuneBD conexiune = new ConexiuneBD();
				conexiune.init();
				int nrMin = Integer.parseInt(textField.getText());
				int nrMax = Integer.parseInt(textField_1.getText());
				String mesajEroare = conexiune.adaugareDetaliiProfesor(email, nrMin, nrMax, textField_3.getText());
				if(mesajEroare != null) {
					new MesajEroare(mesajEroare).setVisible(true);
					System.out.println(mesajEroare);
				}
				else {
					setVisible(false);
				}

        	}
        });
		contentPane.add(btnOk);
	}
}
