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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InscriereCurs extends JFrame {

	private JPanel contentPane;
	private JTextField txtIntroduceiNumeleCursului;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriereCurs frame = new InscriereCurs(1);
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
	public InscriereCurs(int idStudent) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u00CEnscriere curs");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 29));
		lblNewLabel.setBounds(109, 11, 215, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblCurs = new JLabel("Curs:");
		lblCurs.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurs.setForeground(new Color(0, 128, 128));
		lblCurs.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblCurs.setBounds(10, 73, 102, 30);
		contentPane.add(lblCurs);
		
		txtIntroduceiNumeleCursului = new JTextField();
		txtIntroduceiNumeleCursului.setText("Introduce\u021Bi numele cursului...");
		txtIntroduceiNumeleCursului.setForeground(new Color(128, 0, 128));
		txtIntroduceiNumeleCursului.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		txtIntroduceiNumeleCursului.setBounds(98, 77, 290, 24);
		contentPane.add(txtIntroduceiNumeleCursului);
		txtIntroduceiNumeleCursului.setColumns(10);
		
		JButton btnNewButton = new JButton("\u00CEnscriere");
		btnNewButton.setFont(new Font("Arial Narrow", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setForeground(new Color(230, 230, 250));
		btnNewButton.setBounds(160, 122, 116, 39);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	ConexiuneBD con = new ConexiuneBD();
                con.init();
                int id = con.getIdMaterie(txtIntroduceiNumeleCursului.getText());
                System.out.println(id);
            	
                 ConexiuneBD conexiune = new ConexiuneBD();
                 conexiune.init();
                 String mesajEroare = conexiune.inscriereCurs(idStudent, id);
          
                    if(mesajEroare != null) {
                         new MesajEroare(mesajEroare).setVisible(true);
                         System.out.println(mesajEroare);
                      }
                      else {
                          setVisible(false);
                        }
                    }
        });
	}
}