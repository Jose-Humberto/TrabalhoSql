package trabalhoBd;

import java.nio.file.Files;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LeitorDeArquivo 
{	
	public static int LerArquivo() throws Exception
	{
		int id = 0;
		
		FileOutputStream arquivo = new FileOutputStream("cadastros.txt",true);
		
		Path caminho = Paths.get("cadastros.txt");
		byte [] leitor = Files.readAllBytes(caminho);
		
		String texto = new String(leitor);
		String textoEdita, textoRecebe;
		
		if ((texto.length()/307) > 0)
		{
			textoRecebe = (texto.substring(((texto.length()/307)-1) * 306, (((texto.length()/307)-1) * 307) + 3));
			textoEdita = textoRecebe.replaceAll(" ", "");
			id = Integer.parseInt(textoEdita);
			id = id + 1;
		}
		
		return id;
	}
}
