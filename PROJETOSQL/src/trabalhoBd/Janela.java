package trabalhoBd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class Janela extends JFrame implements ActionListener
{
	JLabel labelComando;
	JTextArea txtComando;
	JButton btnComando1, btnComando2, btnComando3, btnComando4, btnComando5, btnComando6;
	JScrollPane jsp;
	
	public Janela() 
	{
		super("Trabalho Banco De Dados");
		setSize(1000, 400);
		setLayout(null);
		
		
		
		labelComando = new JLabel("Comando SQL:");
		labelComando.setBounds(30, 30, 150, 50);
		labelComando.setVisible(true);
		add(labelComando);
		
		txtComando = new JTextArea();
		txtComando.setFont(new Font("TimesRoman",Font.BOLD,12)); 
		txtComando.setBackground(Color.blue);
		txtComando.setForeground(Color.white);
		txtComando.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		jsp = new JScrollPane(txtComando);
		jsp.setBounds(30, 70, 940, 200);
		setVisible(true);
		add(jsp);
		
		btnComando5 = new JButton("limpar");
		btnComando5.setBounds(420, 310, 100, 50);
		btnComando5.setVisible(true);
		btnComando5.setSize(120, 30);
		add(btnComando5);
		btnComando5.addActionListener(this);
		
		btnComando4 = new JButton("Selecionar");
		btnComando4.setBounds(30, 310, 100, 50);
		btnComando4.setVisible(true);
		btnComando4.setSize(120, 30);
		add(btnComando4);
		btnComando4.addActionListener(this);
		
		btnComando2 = new JButton("Inserir");
		btnComando2.setBounds(160, 310, 100, 50);
		btnComando2.setVisible(true);
		btnComando2.setSize(120, 30);
		add(btnComando2);
		btnComando2.addActionListener(this);
		
		btnComando3 = new JButton("deletar");
		btnComando3.setBounds(290, 310, 100, 50);
		btnComando3.setVisible(true);
		btnComando3.setSize(120, 30);
		add(btnComando3);
		btnComando3.addActionListener(this);
		
		btnComando1 = new JButton("Executar");
		btnComando1.setBounds(850, 310, 100, 50);
		btnComando1.setVisible(true);
		btnComando1.setSize(120, 30);
		add(btnComando1);
		btnComando1.addActionListener(this);
		//btnComando.setBackground(); muda a cor
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(btnComando1))
		{
			try 
			{
				EditaArquivo ed = new EditaArquivo();
				ed.edicao(txtComando.getText());
			} 
			
			catch (Exception e1)
			{
				System.out.println("Erro no botão execultar");
			}
		}
		
		else if(e.getSource().equals(btnComando2))
		{
			try 
			{
				txtComando.setText("insert into musicas (nome, album, cantor, duracao, youtube) values (\"estrela de ouro\", \"estrela\", \"gino e geno\", 123, \"www\");");
			} 
			
			catch (Exception e1)
			{
				System.out.println("Erro no botão Inserir");
			}
		}
		
		else if(e.getSource().equals(btnComando3))
		{
			try 
			{
				txtComando.setText("delete from musicas where id = 1");
			} 
			
			catch (Exception e1)
			{
				System.out.println("Erro no botão Deletar");
			}
		}
		
		else if(e.getSource().equals(btnComando4))
		{
			try 
			{
				txtComando.setText("select * From musicas");
			} 
			
			catch (Exception e1)
			{
				System.out.println("Erro no botão Selecionar");
			}
		}
		
		else if(e.getSource().equals(btnComando5))
		{
			try 
			{
				txtComando.setText("");
			} 
			
			catch (Exception e1)
			{
				System.out.println("Erro no botão Limpar");
			}
		}
	}
}
