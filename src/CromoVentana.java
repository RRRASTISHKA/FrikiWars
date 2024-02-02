import java.awt.EventQueue;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;



public class CromoVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PoderCl;
	JLabel TuPoder;
	JLabel Encima;
	JLabel Debajo;
	private int numR1;
	private int numR2;
	private int numR3;
	private  static int powers[]=new int [10];
	private static int  num;
	private  int  num2;
	private boolean izButtonPressed = true;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CromoVentana frame = new CromoVentana();
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
	public CromoVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,810, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel foto1 = new JLabel("");
		foto1.setBounds(33, 295, 225, 225);
		contentPane.add(foto1);
		
		JLabel foto2 = new JLabel("");
		foto2.setBounds(289, 295, 225, 225);
		contentPane.add(foto2);
		
		JLabel foto3 = new JLabel("");
		foto3.setBounds(546, 295, 225, 225);
		contentPane.add(foto3);
		
		ImageIcon imgFondo = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\Cromo2.jpg");
		JLabel Fondo = new JLabel(imgFondo);
		Fondo.setBounds(0, -11, 796, 607);
		contentPane.add(Fondo);
		
		JButton send = new JButton("Send");
		send.setBounds(530, 562, 89, 23);
		contentPane.add(send);
		contentPane.setComponentZOrder(send,0);
		
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == send && !izButtonPressed) {
					
					generateRandomNumbersWithThisNum();
					darPoder();
					
					 ImageIcon f1 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numR1 +".jpg");
					 foto1.setIcon(f1);
					
				
					 ImageIcon f2 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numR2+".jpg");
					 foto2.setIcon(f2);
					
					 
					 ImageIcon f3 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numR3+".jpg");
					 foto3.setIcon(f3);
					 izButtonPressed=true;
					 SetText();
						
				}
			}
		});
		
		JButton eligir = new JButton("Eligir tu poder");
		eligir.setBounds(403, 562, 120, 23);
		contentPane.add(eligir);
		contentPane.setComponentZOrder(eligir,0);
		
		eligir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == eligir ) {
					 izButtonPressed=false;
					 num2=Integer.parseInt(PoderCl.getText());
					  
						
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Tu poder:");
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setBounds(235, 566, 70, 13);
		contentPane.add(lblNewLabel);
		contentPane.setComponentZOrder( lblNewLabel,0);
		
		PoderCl = new JTextField();
		PoderCl.setBounds(303, 563, 86, 20);
		contentPane.add(PoderCl);
		PoderCl.setColumns(10);
		
		Debajo = new JLabel("Numero por debajo:???");
		Debajo.setForeground(new Color(0, 255, 64));
		Debajo.setBounds(80, 522, 150, 14);
		contentPane.add(Debajo);
		contentPane.setComponentZOrder(Debajo,0);
		
		TuPoder = new JLabel("Tu poder:???");
		TuPoder.setForeground(new Color(255, 255, 128));
	    TuPoder.setBounds(350, 522, 150, 14);
		contentPane.add (TuPoder);
		contentPane.setComponentZOrder(TuPoder,0);
		
		
		Encima = new JLabel("Numero por encima:???");
		Encima.setForeground(new Color(255, 0, 0));
	    Encima.setBounds(585, 522, 150, 14);
		contentPane.add (Encima);
		contentPane.setComponentZOrder(Encima,0);
	}
	
	
	 private void generateRandomNumbersWithThisNum() {
	        List<Integer> randomNumbers = new ArrayList<>();

	       
	        while (randomNumbers.size() < 3) {
	            int randomNumber = (int) (Math.random() * 10 + 1);
	            if (!randomNumbers.contains(randomNumber)) {
	                randomNumbers.add(randomNumber);
	            }
	        }

	        Collections.shuffle(randomNumbers);

	        numR1 = randomNumbers.get(0);
	        numR2 = randomNumbers.get(1);
	        numR3 = randomNumbers.get(2);
	    }
	 private static void darPoder() {
			for(int i=0;i<10;i++) {
				 int num = (int) (Math.random() * (100 - 1)) + 1;
				 powers[i]=num;
			}
		}
	 
	 private void SetText() {
		    num2 = Integer.parseInt(PoderCl.getText());

		    if (num2 < 0 || num2 > 100) {
		        TuPoder.setText("Tu poder no es valido");
		        Debajo.setText("Número por debajo: ???");
		        Encima.setText("Número por encima: ???");
		        return; 
		    }

		    Arrays.sort(powers);
		    int index = Arrays.binarySearch(powers, num2);

		    if (index >= 0) {
		        TuPoder.setText("Tu poder es: " + num2);
		        if (index > 0) {
		            Debajo.setText("Número por debajo: " + powers[index - 1]);
		        }
		        if (index < powers.length - 1) {
		            Encima.setText("Número por encima: " + powers[index + 1]);
		        }
		    } else {
		        int index2 = -index - 1;
		        TuPoder.setText("No está en la lista");
		        if (index2 > 0) {
		            Debajo.setText("Número por debajo: " + powers[index2 - 1]);
		        }
		        if (index2 < powers.length) {
		            Encima.setText("Número por encima: " + powers[index2]);
		        }
		    }
		}
	}
