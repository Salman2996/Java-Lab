import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*; 
public class ProgressBar extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JProgressBar jp = new JProgressBar();
	JButton copy_button = new JButton("Copy");
	JButton cancel_button = new JButton("Cancel");   
	JTextField fromFile = new JTextField();   
	JTextField toFile = new JTextField();   
	ProgressBarThread thread;  
	
	public ProgressBar(){     
		Container pane = getContentPane();        
		pane.setLayout(new BorderLayout());     
		jp.setStringPainted(true);            // display style of the progress bar     
		pane.add(jp, BorderLayout.NORTH);  
		
		JPanel panel1 = new JPanel(new BorderLayout());     
		panel1.setBorder(new TitledBorder("From:"));     
		panel1.add(fromFile, BorderLayout.CENTER);       
		
		JPanel panel2 = new JPanel(new BorderLayout());     
		panel2.setBorder(new TitledBorder("To:"));     
		panel2.add(toFile, BorderLayout.CENTER);       
		
		JPanel panel3 = new JPanel(new GridLayout(2,1));     
		panel3.add(panel1);     
		panel3.add(panel2);     
		pane.add(panel3, BorderLayout.CENTER);  
		
		JPanel panel4 = new JPanel(); 
		panel4.add(copy_button);     
		panel4.add(cancel_button);     
		pane.add(panel4, BorderLayout.SOUTH);  
		
		copy_button.addActionListener(this);     
		cancel_button.addActionListener(this);     
		cancel_button.setEnabled(false);   
	}  
	
	public void actionPerformed(ActionEvent e){     
		if (e.getSource() == copy_button){       
			thread = new ProgressBarThread(this, jp, fromFile, toFile);       
			thread.start();       
			copy_button.setEnabled(false);       
			cancel_button.setEnabled(true);     
		}
		else if (e.getSource() == cancel_button){       
			thread.cancel = true;       
			cancel_button.setEnabled(false);     
		}    
	} 
	
	public static void main(String[] args){        
		ProgressBar application = new ProgressBar();     
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
		application.setTitle("Copy file");     
		application.setSize(400, 180);     
		application.setVisible(true);    
	}
} 