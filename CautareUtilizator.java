import java.awt.BorderLayout;
import java.awt.EventQueue;

 

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

 

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

 

public class CautareUtilizator extends JFrame {

 

    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel_1;
    private JTextField textField_1;

 

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CautareUtilizator frame = new CautareUtilizator();
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
    public CautareUtilizator() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 460);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblCutareUtilizator = new JLabel("C\u0103utare utilizator");
        lblCutareUtilizator.setHorizontalAlignment(SwingConstants.CENTER);
        lblCutareUtilizator.setForeground(new Color(0, 139, 139));
        lblCutareUtilizator.setFont(new Font("Arial Narrow", Font.BOLD, 29));
        lblCutareUtilizator.setBounds(109, 11, 218, 52);
        contentPane.add(lblCutareUtilizator);
        
        JLabel lblNewLabel_1_1 = new JLabel("nume:");
        lblNewLabel_1_1.setForeground(new Color(0, 139, 139));
        lblNewLabel_1_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(45, 74, 136, 26);
        contentPane.add(lblNewLabel_1_1);
        
        textField = new JTextField();
        textField.setForeground(new Color(128, 0, 128));
        textField.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        textField.setColumns(10);
        textField.setBounds(181, 74, 193, 26);
        contentPane.add(textField);
        
        lblNewLabel_1 = new JLabel("prenume:");
        lblNewLabel_1.setForeground(new Color(0, 139, 139));
        lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_1.setBounds(45, 111, 136, 26);
        contentPane.add(lblNewLabel_1);
        
        textField_1 = new JTextField();
        textField_1.setForeground(new Color(128, 0, 128));
        textField_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        textField_1.setColumns(10);
        textField_1.setBounds(181, 111, 193, 26);
        contentPane.add(textField_1);
        
        JLabel lblNewLabel1 = new JLabel("");
        ImageIcon img = new ImageIcon(new ImageIcon("src\\CautareUtilizator.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lblNewLabel1.setIcon(img);
        lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel1.setBounds(0, 206, 434, 113);
        contentPane.add(lblNewLabel1);
        
        String[] materii = {"student", "profesor", "*toate"};                //se vor alege doar materiile la care profesorul ii preda respectivului elev
        JComboBox<String> comboBox = new JComboBox<String>(materii);
        comboBox.setForeground(new Color(128, 0, 128));
        comboBox.setFont(new Font("Arial Narrow", Font.BOLD, 18));
        comboBox.setBounds(181, 148, 193, 26);
        contentPane.add(comboBox);
        
        JButton btnCautare = new JButton("Cautare");
        btnCautare.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConexiuneBD conexiune = new ConexiuneBD();
                conexiune.init();
                String selected = comboBox.getSelectedItem().toString();
                conexiune.cautareUtilizator(textField.getText(), textField_1.getText(), selected);
                
                new UtilizatoriGasiti().setVisible(true);
                
            }
        });
        btnCautare.setForeground(new Color(230, 230, 250));
        btnCautare.setFont(new Font("Arial Nova Light", Font.BOLD, 14));
        btnCautare.setBackground(new Color(0, 139, 139));
        btnCautare.setActionCommand("OK");
        btnCautare.setBounds(148, 345, 138, 44);
        contentPane.add(btnCautare);
        
        JLabel lblNewLabel_1_2 = new JLabel("tip utilizator:");
        lblNewLabel_1_2.setForeground(new Color(0, 139, 139));
        lblNewLabel_1_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        lblNewLabel_1_2.setBounds(45, 148, 136, 26);
        contentPane.add(lblNewLabel_1_2);
    }
}