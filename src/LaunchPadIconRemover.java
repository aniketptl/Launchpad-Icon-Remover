import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.print.DocFlavor.URL;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class LaunchPadIconRemover extends JFrame  {

	private JPanel contentPane;
	private JTextField textInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchPadIconRemover frame = new LaunchPadIconRemover();
					frame.setVisible(true);
					frame.setTitle("Launchpad Icon Remover-@aniketroxx");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LaunchPadIconRemover() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 131);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textInput = new JTextField();
		textInput.setBounds(6, 29, 438, 29);
		contentPane.add(textInput);
		textInput.setColumns(10);

		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Root
				ProcessBuilder admin=new ProcessBuilder("sh","res/admin.sh");
				Process sudo;
				
				try {
					sudo=admin.start();
					sudo.waitFor();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
				String app=textInput.getText();
				ProcessBuilder pm=new ProcessBuilder("sh","res/AppIcon.sh",app);
        		Process o;
				try {
					
					o =pm.start();
					
					InputStream s = o.getInputStream();
					
					BufferedReader in = new BufferedReader(new InputStreamReader(s));
					
					String temp;
					
					

	        		while ((temp = in.readLine()) != null) {
	        			
	        		    System.out.println(temp);
	        		      
	        		}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});

		btnRemove.setBounds(162, 70, 117, 29);
		contentPane.add(btnRemove);
		
		JLabel lblSoftwareDevlopedBy = new JLabel("Enter the Name of App");
		lblSoftwareDevlopedBy.setBounds(148, 6, 211, 16);
		contentPane.add(lblSoftwareDevlopedBy);
	}
}
