package trabalhoBd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class EscritorDeArquivo 
{
	public static void escreveArquivo(int id, String nome, String album, String cantor, String duracao, String youTube) throws IOException
	{
		FileOutputStream arquivo = new FileOutputStream("cadastros.txt",true);
		PrintStream escrita = new PrintStream(arquivo);
		
		escrita.print(id);
		if (id < 10)
		escrita.print("  ");
		
		else if (id >= 10 || id < 100)
		escrita.print(" ");
		
		else 
		escrita.print("");

		escrita.print(nome);
		for (int i = nome.length(); i < 100; i++) 
		{
			escrita.print(" ");
		}
		
		escrita.print(album);
		for (int i = album.length(); i < 50; i++) 
		{
			escrita.print(" ");
		}
		
		escrita.print(cantor);
		for (int i = cantor.length(); i < 50; i++) 
		{
			escrita.print(" ");
		}
		
		escrita.print(duracao);
		if (duracao.length() == 1)
		escrita.print("   ");
			
		else if (duracao.length() == 2)
		escrita.print("  ");
			
		else if (duracao.length() == 3)
		escrita.print(" ");
		
		else 
		escrita.print("");	
		
		
		escrita.print(youTube);
		for (int i = youTube.length(); i < 100; i++) 
		{
			escrita.print(" ");
		}
		
		escrita.close();
	}
	
}
