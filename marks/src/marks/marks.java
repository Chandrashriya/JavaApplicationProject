package marks;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class marks {

	private JFrame frame;
	private JTextField s;
	private JTextField n;
	private JTextField em;
	private JTextField m;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marks window = new marks();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public marks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 577, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel v1 = new JLabel("sno");
		v1.setBounds(66, 113, 46, 14);
		frame.getContentPane().add(v1);
		
		JLabel v2 = new JLabel("name");
		v2.setBounds(66, 175, 46, 14);
		frame.getContentPane().add(v2);
		
		JLabel v3 = new JLabel("email");
		v3.setBounds(66, 248, 46, 14);
		frame.getContentPane().add(v3);
		
		JLabel v4 = new JLabel("marks");
		v4.setBounds(66, 337, 46, 14);
		frame.getContentPane().add(v4);
		
		s = new JTextField();
		s.setBounds(155, 98, 86, 20);
		frame.getContentPane().add(s);
		s.setColumns(10);
		
		n = new JTextField();
		n.setBounds(155, 175, 86, 20);
		frame.getContentPane().add(n);
		n.setColumns(10);
		
		em = new JTextField();
		em.setBounds(155, 245, 86, 20);
		frame.getContentPane().add(em);
		em.setColumns(10);
		
		m = new JTextField();
		m.setBounds(155, 334, 86, 20);
		frame.getContentPane().add(m);
		m.setColumns(10);
		
		JButton su = new JButton("Submit");
		su.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sno=s.getText();
				String name=n.getText();
				String email=em.getText();
				String marks=m.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/display","root","mrec");
					String q= "insert into display1 values('"+sno+"','"+name+"','"+email+"','"+marks+"')";
					Statement sta=con.createStatement();
					sta.executeUpdate(q);
					con.close();
					JOptionPane.showMessageDialog(su, "done");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		su.setBounds(96, 403, 89, 23);
		frame.getContentPane().add(su);
	}

}
