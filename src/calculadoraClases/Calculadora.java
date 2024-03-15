package calculadoraClases;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calculadora extends JFrame {
	
	Float num1;
	Float num2;
	String signo;
	Boolean resultado = false;
	Operaciones op = new Operaciones();
	
	private JPanel contentPane;
	private JLabel pantalla;
	private JButton btnClear;
	private JButton btnDividir;
	private JButton btnMultiplicar;
	private JButton btnSumar;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn0;
	private JButton btn3;
	private JButton btnIgual;
	private JButton btn2;
	private JButton btn1;
	private JButton btnPunto;
	private JButton btnRestar;

	
	public Calculadora() {
				
		
		setResizable(false);
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pantalla = new JLabel("0");
		pantalla.setForeground(new Color(255, 255, 255));
		pantalla.setFont(new Font("Tahoma", Font.PLAIN, 40));
		pantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		pantalla.setBorder(new LineBorder(new Color(0, 0, 0)));
		pantalla.setOpaque(true);
		pantalla.setBackground(new Color(51, 51, 51));
		pantalla.setBounds(12, 13, 308, 60);
		contentPane.add(pantalla);
		
		// Botones para realizar operaciones
		
		btnDividir = new JButton("/");
		btnDividir.setFocusable(false);
		btnDividir.setBorderPainted(false);
		btnDividir.setForeground(new Color(255, 255, 255));
		btnDividir.setBackground(new Color(153, 0, 51));
		btnDividir.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!pantalla.getText().contains("Indefinido")){
					if(signo != null){
						MostrarError();
					}
					else{
						num1 = Float.parseFloat(pantalla.getText());
						signo = "/";		
						pantalla.setText("0");
					}
				}			
			}
		});
		btnDividir.setBounds(92, 95, 68, 68);
		contentPane.add(btnDividir);
		
		btnMultiplicar = new JButton("*");
		btnMultiplicar.setFocusable(false);
		btnMultiplicar.setBorderPainted(false);
		btnMultiplicar.setForeground(new Color(255, 255, 255));
		btnMultiplicar.setBackground(new Color(153, 0, 51));
		btnMultiplicar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!pantalla.getText().contains("Indefinido")){
					if(signo != null){
						MostrarError();
					}
					else{
						num1 = Float.parseFloat(pantalla.getText());
						signo = "*";		
						pantalla.setText("0");
					}
				}
			}
		});
		btnMultiplicar.setBounds(172, 95, 68, 68);
		contentPane.add(btnMultiplicar);
		
		btnSumar = new JButton("+");
		btnSumar.setFocusable(false);
		btnSumar.setBorderPainted(false);
		btnSumar.setForeground(new Color(255, 255, 255));
		btnSumar.setBackground(new Color(153, 0, 51));
		btnSumar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!pantalla.getText().contains("Indefinido")){
					if(signo != null){
						MostrarError();
					}
					else{
						num1 = Float.parseFloat(pantalla.getText());
						signo = "+";		
						pantalla.setText("0");
					}
				}
			}
		});
		btnSumar.setBounds(252, 176, 68, 149);
		contentPane.add(btnSumar);
		
		btnRestar = new JButton("-");
		btnRestar.setFocusable(false);
		btnRestar.setBorderPainted(false);
		btnRestar.setForeground(new Color(255, 255, 255));
		btnRestar.setBackground(new Color(153, 0, 51));
		btnRestar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!pantalla.getText().contains("Indefinido")){
					if(signo != null){
						MostrarError();
					}
					else{
						num1 = Float.parseFloat(pantalla.getText());
						signo = "-";		
						pantalla.setText("0");
					}
				}
			}
		});
		btnRestar.setBounds(252, 95, 68, 68);
		contentPane.add(btnRestar);
		
		btnIgual = new JButton("=");
		btnIgual.setFocusable(false);
		btnIgual.setBorderPainted(false);
		btnIgual.setForeground(new Color(255, 255, 255));
		btnIgual.setBackground(new Color(153, 0, 51));
		btnIgual.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(num1 != null && signo != null){
					num2 = Float.parseFloat(pantalla.getText());
					if(num2 == 0 && signo.equals("/")){
						pantalla.setText("Indefinido");
					}else{
						pantalla.setText(Float.toString(op.calculo(num1, num2, signo)));
						num1 = Float.parseFloat(pantalla.getText());
						resultado = true;
					}
					num2 = null;
					signo = null;
					
				}
			}
		});
		btnIgual.setBounds(252, 338, 68, 149);
		contentPane.add(btnIgual);
		
		
		// Botones para escribir los numeros
		
		btnClear = new JButton("C");
		btnClear.setFocusable(false);
		btnClear.setBorderPainted(false);
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBackground(new Color(153, 0, 51));
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pantalla.setText("0");
				num1 = null;
				num2 = null;
				signo = null;
			}
		});
		btnClear.setBounds(12, 95, 68, 68);
		contentPane.add(btnClear);
		
		btnPunto = new JButton(".");
		btnPunto.setFocusable(false);
		btnPunto.setBorderPainted(false);
		btnPunto.setBackground(new Color(51, 51, 51));
		btnPunto.setForeground(new Color(255, 255, 255));
		btnPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(!pantalla.getText().contains(".")){
					if(!pantalla.getText().contains("Indefinido")){
						pantalla.setText(pantalla.getText()+".");
					}				
					
				}
				resultado = false;
				
			}
		});
		btnPunto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPunto.setBounds(172, 419, 68, 68);
		contentPane.add(btnPunto);
		
		btn9 = new JButton("9");
		btn9.setFocusable(false);
		btn9.setBorderPainted(false);
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setBackground(new Color(51, 51, 51));
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("9");
				}
				else{
					pantalla.setText(pantalla.getText()+"9");
				}
				resultado = false;
				
			}
		});
		btn9.setBounds(172, 176, 68, 68);
		contentPane.add(btn9);
		
		btn8 = new JButton("8");
		btn8.setFocusable(false);
		btn8.setBorderPainted(false);
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setBackground(new Color(51, 51, 51));
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("8");
				}
				else{
					pantalla.setText(pantalla.getText()+"8");
				}
				resultado = false;
			}
		});
		btn8.setBounds(92, 176, 68, 68);
		contentPane.add(btn8);
		
		btn7 = new JButton("7");
		btn7.setFocusable(false);
		btn7.setBorderPainted(false);
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setBackground(new Color(51, 51, 51));
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("7");
				}
				else{
					pantalla.setText(pantalla.getText()+"7");
				}
				resultado = false;
			}
		});
		btn7.setBounds(12, 176, 68, 68);
		contentPane.add(btn7);
				
		btn6 = new JButton("6");
		btn6.setFocusable(false);
		btn6.setBorderPainted(false);
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setBackground(new Color(51, 51, 51));
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("6");
				}
				else{
					pantalla.setText(pantalla.getText()+"6");
				}
				resultado = false;
			}
		});
		btn6.setBounds(172, 257, 68, 68);
		contentPane.add(btn6);
		
		btn5 = new JButton("5");
		btn5.setFocusable(false);
		btn5.setBorderPainted(false);
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setBackground(new Color(51, 51, 51));
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("5");
				}
				else{
					pantalla.setText(pantalla.getText()+"5");
				}
				resultado = false;
			}
		});
		btn5.setBounds(92, 257, 68, 68);
		contentPane.add(btn5);
		
		btn4 = new JButton("4");
		btn4.setFocusable(false);
		btn4.setBorderPainted(false);
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setBackground(new Color(51, 51, 51));
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("4");
				}
				else{
					pantalla.setText(pantalla.getText()+"4");
				}
				resultado = false;
			}
		});
		btn4.setBounds(12, 257, 68, 68);
		contentPane.add(btn4);
		
		btn3 = new JButton("3");
		btn3.setFocusable(false);
		btn3.setBorderPainted(false);
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setBackground(new Color(51, 51, 51));
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("3");
				}
				else{
					pantalla.setText(pantalla.getText()+"3");
				}
				resultado = false;
			}
		});
		btn3.setBounds(172, 338, 68, 68);
		contentPane.add(btn3);
		
		btn2 = new JButton("2");
		btn2.setFocusable(false);
		btn2.setBorderPainted(false);
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setBackground(new Color(51, 51, 51));
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("2");
				}
				else{
					pantalla.setText(pantalla.getText()+"2");
				}
				resultado = false;
			}
		});
		btn2.setBounds(92, 338, 68, 68);
		contentPane.add(btn2);
		
		btn1 = new JButton("1");
		btn1.setFocusable(false);
		btn1.setBorderPainted(false);
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBackground(new Color(51, 51, 51));
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("1");
				}
				else{
					pantalla.setText(pantalla.getText()+"1");
				}
				resultado = false;
			}
		});
		btn1.setBounds(12, 338, 68, 68);
		contentPane.add(btn1);
		
		btn0 = new JButton("0");
		btn0.setFocusable(false);
		btn0.setBorderPainted(false);
		btn0.setBackground(new Color(51, 51, 51));
		btn0.setForeground(new Color(255, 255, 255));
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(pantalla.getText().equals("0") || pantalla.getText().equals("Indefinido") || resultado == true){
					pantalla.setText("0");
				}
				else{
					pantalla.setText(pantalla.getText()+"0");
				}
				resultado = false;
				
			}
		});
		btn0.setBounds(12, 419, 148, 68);
		contentPane.add(btn0);
				
	}
	
	//Mensaje de error
	
	
	public void MostrarError(){
		JOptionPane.showMessageDialog(null, "Solo se puede realizar una operación a la vez. Pulsa '='" , 
				"Operaciones", JOptionPane.ERROR_MESSAGE );
	}

}
