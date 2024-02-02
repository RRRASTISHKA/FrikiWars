import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.FileWriter;
import java.io.Writer;
import java.util.regex.*;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.awt.Color;

public class StarWars extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarWars frame = new StarWars();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private int num;
    private int numOc;
    private int numOcCent;
    private int numOcDr;
    private int counter=0;
    private int tiradas=0;
    private boolean izButtonPressed = false;
    private boolean centButtonPressed = false;
    private boolean drButtonPressed = false;
    
    
    private static final String FILE_PATH = "C:\\Users\\Profesor\\Documents\\Proyectos Java\\StarWars\\src\\";
    private Writer writer;
    
    
	
	public StarWars() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 810, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		num=(int) (Math.random() * 10 + 1);
		
		//file writer
		
		try {
	        writer = new FileWriter(FILE_PATH+"frikiWars.txt", true); 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

		ImageIcon imgMuneco = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\"+num+".jpg");
		JLabel Muneco = new JLabel(imgMuneco);
		Muneco.setBounds(293, 32, 225, 225);
		contentPane.add(Muneco);
		contentPane.setComponentZOrder(Muneco,0);
		
		ImageIcon imgFondo = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\Fondo pantalla.jpg");
		JLabel fondo= new JLabel(imgFondo);
		fondo.setBackground(new Color(0, 0, 64));
		fondo.setForeground(new Color(255, 255, 255));
		fondo.setBounds(0,0,810,635);
		contentPane.add(fondo);
		
		ImageIcon imgOculto = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\traseraCromo.jpg");
		JLabel oculto1 = new JLabel(imgOculto);
		oculto1.setBounds(36, 311, 225, 225);
		contentPane.add(oculto1);
		contentPane.setComponentZOrder(oculto1,0);
		
		ImageIcon imgOculto2 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\traseraCromo.jpg");
		JLabel oculto2 = new JLabel(imgOculto2);
		oculto2.setBounds(293, 311, 225, 225);
		contentPane.add(oculto2);
		contentPane.setComponentZOrder(oculto2,0);
		
		ImageIcon imgOculto3 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\traseraCromo.jpg");
		JLabel oculto3 = new JLabel(imgOculto3);
		oculto3.setBounds(549, 311, 225, 225);
		contentPane.add(oculto3);
		contentPane.setComponentZOrder(oculto3,0);
		
		JButton iz = new JButton("o Aqui");
		iz.setBounds(36, 540, 225, 30);
		contentPane.add(iz);
		contentPane.setComponentZOrder(iz,0);
		iz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == iz && !izButtonPressed) {
					 generateRandomNumbersWithThisNum();
					 
					 if(numOc==num) {
						 tiradas++;
					 ImageIcon Oc1 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOc+"ok"+".jpg");
					 oculto1.setIcon(Oc1);
					 izButtonPressed = true;
					 }else {
						 ImageIcon Oc1 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOc+"bad"+".jpg");
						 oculto1.setIcon(Oc1);
						 izButtonPressed = true;
					 }
				
					 ImageIcon Oc2 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcCent + ".jpg");
					 oculto2.setIcon(Oc2);
					 centButtonPressed = true;
					 
					 ImageIcon Oc3 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcDr + ".jpg");
					 oculto3.setIcon(Oc3);
					 drButtonPressed = true;
					 
					 String result = "Cromo " + numOc + " - Cromo " + numOcCent + " - Cromo " + numOcDr + " - "
			                    + (numOc == num) + "\n";

			            try {
			                writer.write(result);
			                writer.flush();
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            }
				}
			}
		});
		
		
		JButton cent = new JButton("Aqui");
		cent.setBounds(291, 540, 225, 30);
	
		contentPane.add(cent);
		contentPane.setComponentZOrder(cent,0);
	
	     cent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == cent && !centButtonPressed) {
					 generateRandomNumbersWithThisNum();
					 ImageIcon Oc1 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOc +".jpg");
					 oculto1.setIcon(Oc1);
					 izButtonPressed = true;
					 
					 if(numOcCent==num) {
						 tiradas++;
					 ImageIcon Oc2 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcCent+"ok"+ ".jpg");
					 oculto2.setIcon(Oc2);
					 centButtonPressed = true;
					 }else {
						 ImageIcon Oc2 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcCent+"bad"+ ".jpg");
						 oculto2.setIcon(Oc2);
						 centButtonPressed = true;
					 }
					 
					 ImageIcon Oc3 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcDr + ".jpg");
					 oculto3.setIcon(Oc3);
					 drButtonPressed = true;	
					 
					 
					 String result = "Cromo " + numOc + " - Cromo " + numOcCent + " - Cromo " + numOcDr + " - "
			                    + (numOcCent == num) + "\n";

			            try {
			                writer.write(result);
			                writer.flush();
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            }
					 }
				
			}
		});
		
		JButton dr = new JButton("aqui");
		dr.setBounds(550, 540, 225, 30);
		contentPane.add(dr);
		contentPane.setComponentZOrder(dr,0);
		
		dr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == dr && !drButtonPressed) {
					 generateRandomNumbersWithThisNum();
					 ImageIcon Oc1 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOc +".jpg");
					 oculto1.setIcon(Oc1);
					 izButtonPressed = true;
				
					 ImageIcon Oc2 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcCent+ ".jpg");
					 oculto2.setIcon(Oc2);
					 centButtonPressed = true;
					 
					 if(numOcDr==num) {
				     tiradas++;
					 ImageIcon Oc3 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcDr+"ok"+ ".jpg");
					 oculto3.setIcon(Oc3);
					 drButtonPressed = true;
					 }else {
						 ImageIcon Oc3 = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + numOcDr+"bad"+ ".jpg");
						 oculto3.setIcon(Oc3);
						 drButtonPressed = true;
						 }
					 
					 String result = "Cromo " + numOc + " - Cromo " + numOcCent + " - Cromo " + numOcDr + " - "
			                    + (numOcDr == num) + "\n";

			            try {
			                writer.write(result);
			                writer.flush();
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            }
				}
			}
		});
		
		JButton volver = new JButton("Volver a lanzar");
		volver.setBounds(31, 573, 738, 30);
		contentPane.add(volver);
		contentPane.setComponentZOrder(volver,0);
		
		JLabel lblNewLabel = new JLabel("llevas "+tiradas+" acierto");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(42, 286, 99, 14);
		contentPane.add(lblNewLabel);
		contentPane.setComponentZOrder(lblNewLabel,0);
		
		
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==volver) {
					 num=(int) (Math.random() * 10 + 1);
					 ImageIcon newImgMuneco = new ImageIcon("C:\\Users\\Profesor\\Desktop\\StarWars\\" + num + ".jpg");   
					 Muneco.setIcon(newImgMuneco);
			            oculto1.setIcon(imgOculto);
			            oculto2.setIcon(imgOculto2);
			            oculto3.setIcon(imgOculto3);
			            izButtonPressed = false;
			            centButtonPressed = false;
			            drButtonPressed = false;
			            counter++;
			            lblNewLabel.setText("llevas "+tiradas+" acierto");
			            
			            
			            if (counter == 10) {
			            	try {
			            		JOptionPane.showMessageDialog(contentPane, "Has jugado 10 veces \n "+tiradas+"/10 acierto");
			                    writer.close(); 
			                } catch (IOException ex) {
			                    ex.printStackTrace();
			                }
			                dispose();
			             
			            }
				}
			}
		});
	}

	 private void generateRandomNumbersWithThisNum() {
	        List<Integer> randomNumbers = new ArrayList<>();
	        randomNumbers.add(num);

	        while (randomNumbers.size() < 3) {
	            int randomNumber = (int) (Math.random() * 10 + 1);
	            if (!randomNumbers.contains(randomNumber)) {
	                randomNumbers.add(randomNumber);
	            }
	        }

	        Collections.shuffle(randomNumbers);

	        numOc = randomNumbers.get(0);
	        numOcCent = randomNumbers.get(1);
	        numOcDr = randomNumbers.get(2);

	        izButtonPressed = true;
	        centButtonPressed = true;
	        drButtonPressed = true;
	    }
}
