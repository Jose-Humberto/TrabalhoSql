package trabalhoBd;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Tabela extends JFrame 
{
	private DefaultTableModel model;
	private JTable table;
	
	public void mostrarTabela() throws Exception 
	{
		setTitle("Cadastro de Musicas");
		
		String id, nome, album, cantor, duracao, youtube;
		
		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Nome");
		model.addColumn("Album");
		model.addColumn("Cantor");
		model.addColumn("Duracao");
		model.addColumn("Youtube");

		FileOutputStream arquivo = new FileOutputStream("cadastros.txt", true);

		Path caminho = Paths.get("cadastros.txt");
		byte[] leitor = Files.readAllBytes(caminho);
		String texto = new String(leitor);
		
		for (int i = 0; i < texto.length(); i += 307) 
		{
			id = texto.substring(i, i + 3).trim();
			nome = texto.substring(i + 3, i + 103).trim();
			album = texto.substring(i + 103, i + 153).trim();
			cantor = texto.substring(i + 153, i + 203).trim();
			duracao = texto.substring(i + 203, i + 207).trim();
			youtube = texto.substring(i + 207, i + 307).trim();

			String[] tabela = { id, nome, album, cantor, duracao, youtube };
			model.addRow(tabela);
			
		}
		
		table = new JTable(model);
		Container container = getContentPane();
		container.add(new JScrollPane(table), BorderLayout.CENTER);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(400, 300);
		setVisible(true);
	}
}
