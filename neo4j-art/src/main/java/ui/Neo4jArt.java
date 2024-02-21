package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import queries.Queries;

import javax.swing.JSeparator;

public class Neo4jArt extends JFrame {
	
	private Queries queries;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlConsultas;
	private JButton btnConsulta1;
	private JButton btnConsulta2;
	private JButton btnConsulta3;
	private JButton btnConsulta4;
	private JButton btnConsulta5;
	private JButton btnConsulta6;
	private JLabel lblConsultas;
	private JScrollPane scrollResultado;
	private JScrollPane scrollConsulta;
	private JLabel lblNocheEstrellada;
	private JLabel lblNeo4jArt;
	private JLabel lblConsultaRealizada;
	private JLabel lblResultado;
	private JMenuBar menuBar;
	private JMenu menuApp;
	private JLabel lblGirasol1;
	private JLabel lblCreditos;
	private JLabel lblGirasol2;
	private JLabel lblGirasol3;
	private JTextPane textResultado;
	private JTextPane textConsulta;
	private JMenuItem menuItemSalir;
	private JMenu menuAyuda;
	private JMenuItem menuItemAcercaDe;
	private JSeparator separator;
	private JMenuItem menuItemInstrucciones;

	/**
	 * Create the frame.
	 */
	public Neo4jArt(Queries q) {
		
		this.queries = q;
		
		setTitle("Neo4j Art");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 600);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 64, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Neo4jArt.class.getResource("/img/flor.png")));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnlConsultas());
		contentPane.add(getLblConsultas());
		contentPane.add(getScrollResultado());
		contentPane.add(getScrollConsulta());
		contentPane.add(getLblGirasol1());
		contentPane.add(getLblNocheEstrellada());
		contentPane.add(getLblNeo4jArt());
		contentPane.add(getLblConsultaRealizada());
		contentPane.add(getLblResultado());
		contentPane.add(getLblCreditos());
		contentPane.add(getLblGirasol2());
		contentPane.add(getLblGirasol3());
		
	}
	private JPanel getPnlConsultas() {
		if (pnlConsultas == null) {
			pnlConsultas = new JPanel();
			pnlConsultas.setBorder(new LineBorder(new Color(166, 210, 255), 4, true));
			pnlConsultas.setBackground(new Color(166, 210, 255));
			pnlConsultas.setBounds(10, 269, 396, 145);
			pnlConsultas.setLayout(new GridLayout(0, 3, 5, 5));
			pnlConsultas.add(getBtnConsulta1());
			pnlConsultas.add(getBtnConsulta2());
			pnlConsultas.add(getBtnConsulta3());
			pnlConsultas.add(getBtnConsulta4());
			pnlConsultas.add(getBtnConsulta5());
			pnlConsultas.add(getBtnConsulta6());
		}
		return pnlConsultas;
	}
	private JButton getBtnConsulta1() {
		if (btnConsulta1 == null) {
			btnConsulta1 = new JButton("Consulta 1");
			btnConsulta1.setMnemonic('1');
			btnConsulta1.setForeground(new Color(179, 125, 0));
			btnConsulta1.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta1.setBackground(new Color(255, 255, 202));
			btnConsulta1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {


					ImageIcon iconoOriginal = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
					Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					
					String nombrePintor = (String) JOptionPane.showInputDialog(null, "Introduce el nombre del pintor:", "Neo4j Art - Datos para la consulta",
							JOptionPane.OK_CANCEL_OPTION, iconoEscalado, null, null);

					if (nombrePintor != null) {
						String res = queries.consulta_1(nombrePintor);
						getTextResultado().setText(res);
						// Colocar scroll por defecto en posición 0
						scrollResultado.getViewport().setViewPosition(new Point(0,0));
						getTextConsulta().setText("Consulta 1: Obtener todos los cuadros pintados por " + nombrePintor + ".");
					}

				}
			});
			btnConsulta1.setToolTipText("Consulta 1: Obtener todos los cuadros pintados por un pintor concreto.");
		}
		return btnConsulta1;
	}
	private JButton getBtnConsulta2() {
		if (btnConsulta2 == null) {
			btnConsulta2 = new JButton("Consulta 2");
			btnConsulta2.setMnemonic('2');
			btnConsulta2.setForeground(new Color(179, 125, 0));
			btnConsulta2.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta2.setBackground(new Color(255, 255, 202));
			btnConsulta2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ImageIcon iconoOriginal = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
					Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					
					String nombreTecnica = (String) JOptionPane.showInputDialog(null, "Introduce el nombre de la técnica:", "Neo4j Art - Datos para la consulta",
							JOptionPane.OK_CANCEL_OPTION, iconoEscalado, null, null);

					if (nombreTecnica != null) {
						String res = queries.consulta_2(nombreTecnica);
						getTextResultado().setText(res);
						// Colocar scroll por defecto en posición 0
						scrollResultado.getViewport().setViewPosition(new Point(0,0));
						getTextConsulta().setText("Consulta 2: Obtener todos los pintores que han utilizado " + nombreTecnica + " como técnica para algún cuadro");
					}

				}
			});
			btnConsulta2.setToolTipText("Consulta 2: Obtener todos los pintores que han utilizado una técnica concreta como técnica para algún cuadro.");
		}
		return btnConsulta2;
	}
	private JButton getBtnConsulta3() {
		if (btnConsulta3 == null) {
			btnConsulta3 = new JButton("Consulta 3");
			btnConsulta3.setMnemonic('3');
			btnConsulta3.setForeground(new Color(179, 125, 0));
			btnConsulta3.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta3.setBackground(new Color(255, 255, 202));
			btnConsulta3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String res = queries.consulta_3();
					getTextResultado().setText(res);
					// Colocar scroll por defecto en posición 0
					scrollResultado.getViewport().setViewPosition(new Point(0,0));
					getTextConsulta().setText("Consulta 3: Obtener todas las técnicas que han sido utilizadas en más de 5 obras.");
				}
			});
			btnConsulta3.setToolTipText("Consulta 3: Obtener todas las técnicas que han sido utilizadas en más de 5 obras.");

		}
		return btnConsulta3;
	}
	private JButton getBtnConsulta4() {
		if (btnConsulta4 == null) {
			btnConsulta4 = new JButton("Consulta 4");
			btnConsulta4.setMnemonic('4');
			btnConsulta4.setForeground(new Color(179, 125, 0));
			btnConsulta4.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta4.setBackground(new Color(255, 255, 202));
			btnConsulta4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String res = queries.consulta_4();
					getTextResultado().setText(res);
					// Colocar scroll por defecto en posición 0
					scrollResultado.getViewport().setViewPosition(new Point(0,0));
					getTextConsulta().setText("Consulta 4: Obtener todos los cuadros pintados por un pintor que haya influido en al menos otro pintor.");
				}
			});
			btnConsulta4.setToolTipText("Consulta 4: Obtener todos los cuadros pintados por un pintor que haya influido en al menos otro pintor.");
		}
		return btnConsulta4;
	}
	private JButton getBtnConsulta5() {
		if (btnConsulta5 == null) {
			btnConsulta5 = new JButton("Consulta 5");
			btnConsulta5.setMnemonic('5');
			btnConsulta5.setForeground(new Color(179, 125, 0));
			btnConsulta5.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta5.setBackground(new Color(255, 255, 202));
			btnConsulta5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String res = queries.consulta_5();
					getTextResultado().setText(res);
					// Colocar scroll por defecto en posición 0
					scrollResultado.getViewport().setViewPosition(new Point(0,0));
					getTextConsulta().setText("Consulta 5: Obtener todas las influencias directas e indirectas entre los pintores.");
				}
			});
			btnConsulta5.setToolTipText("Consulta 5: Obtener todas las influencias directas e indirectas entre los pintores.");
		}
		return btnConsulta5;
	}
	private JButton getBtnConsulta6() {
		if (btnConsulta6 == null) {
			btnConsulta6 = new JButton("Consulta 6");
			btnConsulta6.setMnemonic('6');
			btnConsulta6.setForeground(new Color(179, 125, 0));
			btnConsulta6.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnConsulta6.setBackground(new Color(255, 255, 202));
			btnConsulta6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String res = queries.consulta_6();
					getTextResultado().setText(res);
					// Colocar scroll por defecto en posición 0
					scrollResultado.getViewport().setViewPosition(new Point(0,0));
					getTextConsulta().setText("Consulta 6: Obtener el pintor que haya tenido más influencia en otros pintores.");
				}
			});
			btnConsulta6.setToolTipText("Consulta 6: Obtener el pintor que haya tenido más influencia en otros pintores.");
		}
		return btnConsulta6;
	}
	private JLabel getLblConsultas() {
		if (lblConsultas == null) {
			lblConsultas = new JLabel("Selecciona una consulta:");
			lblConsultas.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblConsultas.setForeground(new Color(255, 255, 255));
			lblConsultas.setBounds(10, 230, 396, 40);
		}
		return lblConsultas;
	}
	private JScrollPane getScrollResultado() {
		if (scrollResultado == null) {
			scrollResultado = new JScrollPane();
			scrollResultado.setBounds(454, 371, 549, 157);
			scrollResultado.setBorder(new LineBorder(new Color(166, 210, 255), 2, true));
			scrollResultado.setViewportView(getTextResultado());
			// Colocar scroll por defecto en posición 0
			scrollResultado.getViewport().setViewPosition(new Point(0,0));
		}
		return scrollResultado;
	}
	private JScrollPane getScrollConsulta() {
		if (scrollConsulta == null) {
			scrollConsulta = new JScrollPane();
			scrollConsulta.setBounds(454, 270, 549, 46);
			scrollConsulta.setBorder(new LineBorder(new Color(166, 210, 255), 2, true));
			scrollConsulta.setViewportView(getTextConsulta());
		}
		return scrollConsulta;
	}
	private JLabel getLblNocheEstrellada() {
		if (lblNocheEstrellada == null) {
			lblNocheEstrellada = new JLabel();
			lblNocheEstrellada.setBounds(0, 0, 633, 190);
			lblNocheEstrellada.setIcon(new ImageIcon(Neo4jArt.class.getResource("/img/background_noche_estrellada.png")));
			
		}
		return lblNocheEstrellada;
	}
	private JLabel getLblNeo4jArt() {
		if (lblNeo4jArt == null) {
			lblNeo4jArt = new JLabel("Neo4j Art");
			lblNeo4jArt.setForeground(new Color(255, 255, 255));
			lblNeo4jArt.setHorizontalAlignment(SwingConstants.CENTER);
			lblNeo4jArt.setFont(new Font("Chiller", Font.BOLD, 95));
			lblNeo4jArt.setBounds(641, 11, 372, 96);
		}
		return lblNeo4jArt;
	}
	private JLabel getLblConsultaRealizada() {
		if (lblConsultaRealizada == null) {
			lblConsultaRealizada = new JLabel("Consulta realizada:");
			lblConsultaRealizada.setForeground(Color.WHITE);
			lblConsultaRealizada.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblConsultaRealizada.setBounds(454, 230, 396, 40);
		}
		return lblConsultaRealizada;
	}
	private JLabel getLblResultado() {
		if (lblResultado == null) {
			lblResultado = new JLabel("Resultado:");
			lblResultado.setForeground(Color.WHITE);
			lblResultado.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblResultado.setBounds(454, 332, 396, 40);
		}
		return lblResultado;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMenuApp());
			menuBar.add(getMenuAyuda());
		}
		return menuBar;
	}
	private JMenu getMenuApp() {
		if (menuApp == null) {
			menuApp = new JMenu("Neo4j Art");
			menuApp.setMnemonic('N');
			menuApp.add(getMenuItemInstrucciones());
			menuApp.add(getSeparator());
			menuApp.add(getMenuItemSalir());
		}
		return menuApp;
	}
	private JLabel getLblGirasol1() {
		if (lblGirasol1 == null) {
			lblGirasol1 = new JLabel();
			lblGirasol1.setBounds(522, -24, 145, 145);
			

	        ImageIcon icon = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
	        Image image = icon.getImage();
	        Image scaledImage = image.getScaledInstance(lblGirasol1.getWidth(), lblGirasol1.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);

	        lblGirasol1.setIcon(scaledIcon);
		}
		return lblGirasol1;
	}
	private JLabel getLblCreditos() {
		if (lblCreditos == null) {
			lblCreditos = new JLabel("Aplicación realizada para Repositorios de Información por Coral Izquierdo Muñiz");
			lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 10));
			lblCreditos.setForeground(new Color(0, 128, 192));
			lblCreditos.setVerticalAlignment(SwingConstants.BOTTOM);
			lblCreditos.setBounds(10, 504, 434, 24);
		}
		return lblCreditos;
	}
	private JLabel getLblGirasol2() {
		if (lblGirasol2 == null) {
			lblGirasol2 = new JLabel();
			lblGirasol2.setBounds(10, 411, 105, 105);
			

	        ImageIcon icon = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
	        Image image = icon.getImage();
	        Image scaledImage = image.getScaledInstance(lblGirasol2.getWidth(), lblGirasol2.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);

	        lblGirasol2.setIcon(scaledIcon);
		}
		return lblGirasol2;
	}
	private JLabel getLblGirasol3() {
		if (lblGirasol3 == null) {
			lblGirasol3 = new JLabel();
			lblGirasol3.setBounds(104, 415, 72, 72);

	        ImageIcon icon = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
	        Image image = icon.getImage();
	        Image scaledImage = image.getScaledInstance(lblGirasol3.getWidth(), lblGirasol3.getHeight(), Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledImage);

	        lblGirasol3.setIcon(scaledIcon);
		}
		return lblGirasol3;
	}
	private JTextPane getTextResultado() {
		if (textResultado == null) {
			textResultado = new JTextPane();
			textResultado.setFont(new Font("Tahoma", Font.PLAIN, 12));
			textResultado.setBackground(new Color(166, 210, 255));
			textResultado.setEditable(false);
		}
		return textResultado;
	}
	private JTextPane getTextConsulta() {
		if (textConsulta == null) {
			textConsulta = new JTextPane();
			textConsulta.setEditable(false);
			textConsulta.setBackground(new Color(166, 210, 255));
			textConsulta.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		return textConsulta;
	}
	private JMenuItem getMenuItemSalir() {
		if (menuItemSalir == null) {
			menuItemSalir = new JMenuItem("Salir");
			menuItemSalir.setMnemonic('S');
			menuItemSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					queries.close();
					dispose();
				}
			});
		}
		return menuItemSalir;
	}
	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu("Ayuda");
			menuAyuda.setMnemonic('Y');
			menuAyuda.add(getMenuItemAcercaDe());
		}
		return menuAyuda;
	}
	private JMenuItem getMenuItemAcercaDe() {
		if (menuItemAcercaDe == null) {
			menuItemAcercaDe = new JMenuItem("Acerca de");
			menuItemAcercaDe.setMnemonic('C');
			menuItemAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ImageIcon iconoOriginal = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
					Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					
					JOptionPane.showMessageDialog(null, "Neo4j Art\nAplicación realizada para Repositorios de Información 2023-24\nCoral Izquierdo Muñiz", "Neo4j Art - Acerca de",
							JOptionPane.OK_CANCEL_OPTION, iconoEscalado);
				}
			});
		}
		return menuItemAcercaDe;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMenuItemInstrucciones() {
		if (menuItemInstrucciones == null) {
			menuItemInstrucciones = new JMenuItem("Instrucciones");
			menuItemInstrucciones.setMnemonic('N');
			menuItemInstrucciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ImageIcon iconoOriginal = new ImageIcon(Neo4jArt.class.getResource("/img/flor.png"));
					Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
					ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
					
					JOptionPane.showMessageDialog(null, "1. Selecciona una de las 6 consultas.\n2. Si eliges la consulta 1 o 2, se te pedirá más información en una nueva ventana.\n3. La consulta se mostrará en el panel derecho junto al resultado obtenido.", "Neo4j Art - Instrucciones",
							JOptionPane.OK_CANCEL_OPTION, iconoEscalado);
				}
			});
		}
		return menuItemInstrucciones;
	}
}
