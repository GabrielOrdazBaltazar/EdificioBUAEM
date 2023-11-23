package Control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validaciones {
	private JTextField Ingreso;
	private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
	
	boolean active = false;
	
	public Validaciones() {
		//super();
		
	}
	//Validar el tamaño y los caracteres, solo permite numeros
	public void validacionSoloNum(JTextField ingresoNum, int Limite) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean num = (value>=48 && value<=57) || value==127 || value==8;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						
					} else {
						ingresoNum.setEditable(false);
					}
			    }else {
					if (!num) {
						ingresoNum.setEditable(false);
						JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros");
						ke.consume();
					}else {
						ingresoNum.setEditable(true);
					}
				}
				
	         }
	    });
	}
	
	//Validar el tamaño y los caracteres, solo permite letras
	public void validacionSoloLetras(JTextField ingresoNum, int Limite) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean letra = ((value>=65 && value<=90) || (value>=97 && value<=122)) ||value==127 || value==8;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						
					} else {
						ingresoNum.setEditable(false);
					}
			    }else {
					if (!letra) {
						ingresoNum.setEditable(false);
						JOptionPane.showMessageDialog(null, "Solo se pueden ingresar letras mayusculas y minuscolas");
						ke.consume();
					}else {
						ingresoNum.setEditable(true);
					}
				}
				
	         }
	    });
	}

	//Validar el tamaño y los caracteres del RFC
	public void validacionRFC(JTextField ingresoNum, int Limite) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean letra = (value>=65 && value<=90) || (value>=48 && value<=57) ||value==127 || value==8;
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						
					} else {
						ingresoNum.setEditable(false);
					}
			    }else {
					if (!letra) {
						ingresoNum.setEditable(false);
						JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros y letras mayusculas");
						ke.consume();
					}else {
						ingresoNum.setEditable(true);
					}
				}
				
	         }
	    });
	}
	public void validacionNoExt(JTextField ingresoNum, int Limite) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean num =(value>=48 && value<=57) ||value==127 || value==8;
				boolean sinN =(value==115 || value == 47 || value ==110);
				boolean del = value==8;
				
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						
					} else {
						ingresoNum.setEditable(false);
					}
				}else {
					if (!num && !sinN) {
						ingresoNum.setEditable(false);
						JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros o s/n");
						ke.consume();
					}else if (ingresoNum.getText().length()>=3) {
						String cadena = ingresoNum.getText().substring(0, 3);
						
						if (cadena.equals("s/n")) {
							
							if (del==true) {
								ingresoNum.setEditable(true);
								
							} else if (num == true) {
								
								ingresoNum.setEditable(false);
							}else {
								ingresoNum.setEditable(false);
							}
							
						} else {
							ingresoNum.setEditable(true);
						}
					}else {
						ingresoNum.setEditable(true);
					}
				}
			}
	    });
	}
	//Validar el tamaño del correo
	public void validacionCorreoTamano(JTextField ingresoNum, int Limite) {
		ingresoNum.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				int value = ke.getKeyChar();
				boolean del = value==8;
				if(ingresoNum.getText().length() >= Limite){
					
					System.out.println(value);
					if (del==true) {
						ingresoNum.setEditable(true);
						
					} else {
						ingresoNum.setEditable(false);
					}
			    }
	         }
	    });
	}
	//Validar los caracteres del correo
	public static boolean emailValidator(String email)
	{
		if (email == null) {
			return false;
		}

		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}
	public boolean validacionCorreoCaracteres(String email) {
		boolean correo = false;
		if (emailValidator(email)) {
			correo = true;
		}
		else {
			JOptionPane.showMessageDialog(null, "El correo es incorrecto");
		}
		return correo;
	}
}

