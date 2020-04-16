package janelas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.EventQueue;

import javax.swing.*;

public class JanelaPrin extends JFrame { 
	private JPanel[] panelField = new JPanel[9];
	private JTextField[] field = new JTextField[9];
	
	private JPanel[] panelButton = new JPanel[2];
	private JButton[] button = new JButton[4];

	private String[] label = {"Nome: ", "Telefone: ", "CEP: ", "Número: ", "Complemento: ", "Rua: ", "Bairro: ", "Cidade: ", "Estado: "};
	private String[] buttonName = {"Adicionar", "Deletar", "Vizualizar", "Atualizar"};


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrin frame = new JanelaPrin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public JanelaPrin() {
		super("Manutenção de pessoas");

		this.setLayout(new GridLayout(11, 2));
	        
		for(int i = 0; i < panelField.length; i++){
			panelField[i] = new JPanel();
			panelField[i].setLayout(new GridLayout(1, 0));

			field[i] = new JTextField(20);

			panelField[i].add(new JLabel(label[i]));
			panelField[i].add(field[i]);

			this.add(panelField[i]);
		}
		for(int i = 5; i < field.length;i++){
			field[i].setEditable(false);
		}

		for(int i = 0, j = 0; i < panelButton.length; i ++, j += 2){
                        panelButton[i] = new JPanel();
                        panelButton[i].setLayout(new GridLayout(1, 2));

                        button[j] = new JButton(buttonName[j]);
			button[j+1] = new JButton(buttonName[j+1]);

                        panelButton[i].add(button[j]);
                        panelButton[i].add(button[j+1]);

                        this.add(panelButton[i]);
                }


		this.pack();

                this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	this.setVisible(true);

	}

}
