package janelas;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;


import daos.*;
import dbos.*;
import webServer.*;


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


	public boolean validaPessoa(){
		if(!field[0].getText().matches("[A-Za-z]{0,50}")){
			return false;
		}
		if(achaPessoa(field[0].getText()) < 0){
			return false;
		}
		if(!field[1].getText().matches("^(\\([0-9]{2}\\) )?[0-9]{4,5}-?[0-9]{4}")){
			return false;
		}
		if(!field[2].getText().matches("[0-9]{8}")){
			return false;
		}
		if(!field[3].getText().matches("[0-9]{1,}")){
			return false;
		}
		return true;
	}
	
	public int achaPessoa(String pessoa){
		try{
			for(Pessoa p : Pessoas.getPessoas()){
				if(p.getNome.equals(pessoa)){
					return p.getCodPessoa();
				}
			}
			
		}
		catch(Exception e){}
		return -1;
	}

	public Pessoa criarPessoa(){
		return new Pessoa(field[0].getText(), field[1].getText(), field[2].getText(), Integer.parseInt(field[3].getText()), field[4].getText());
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

		button[0].addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(validaPessoa()){
					try{
						Pessoas.incluir(criarPessoa());
						JOptionPane.showMessageDialog(null, "Pessoa incluida!");
					}
					catch(Exception err){}
				}
				else{
					JOptionPane.showMessageDialog(null, "Preencha corretamente!");
				}
			}
		});
		button[1].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
				try{
                                	Pessoas.excluir(achaPessoa(field[0].getText()));
                        		JOptionPane.showMessageDialog(null, "Pessoa excluida!");
				}
				catch(Exception err){
					JOptionPane.showMessageDialog(null, "Pessoa não registrada!");
				}
			}
                });
		button[2].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                                if(achaPessoa(field[0].getText()) > 0){
					Pessoa p = Pessoas.getPessoa(achaPessoa(field[0].getText()));
					field[1].setText(p.getTelefone());
					field[2].setText(p.getCep());
					field[3].setText(p.getNumero());
					field[4].setText(p.getComplemento());

					Logradouro l = (Logradouro)ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", field[2].getText());
					
					field[5].setText(l.getLogradouro());
					field[6].setText(l.getBairro());
					field[7].setText(l.getCidade());
					field[8].setText(l.getEstado());
				}
                        }
                });
		button[3].addActionListener(new ActionListener(){
                        public void actionPerformed(ActionEvent e){
                               if(validaPessoa()){
                                        try{
                                                Pessoas.incluir(criarPessoa());
                                                JOptionPane.showMessageDialog(null, "Pessoa alterada!");
                                        }
                                        catch(Exception err){}
                                }
                                else{
                                        JOptionPane.showMessageDialog(null, "Preencha corretamente!");
                                } 
                        }
                });


		this.pack();

                this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        	this.setVisible(true);

	}

}
