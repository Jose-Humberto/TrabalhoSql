package trabalhoBd;

import javax.swing.JOptionPane;

public class EditaArquivo {
	private String nomeDoCantor, nomeDaMusica, album, youTube, duracao;
	private int id;
	String texto;
	int posicaoNome = 0, posicaoAlbum = 0, posicaoCantor = 0, posicaoDuracao = 0, posicaoYoutube = 0, posicao = 0,
			verificaAspas = 0, verificaVirgulas = 0, verificaAbreParentese = 0, verificaFechaParentese = 0;

	public EditaArquivo() {
	}

	public EditaArquivo(String nomeDoCantor, String nomeDaMusica, String album, String youTube, int id,
			String duracao) {
		this.nomeDoCantor = nomeDoCantor;
		this.nomeDaMusica = nomeDaMusica;
		this.album = album;
		this.youTube = youTube;
		this.id = id;
		this.duracao = duracao;
	}

	public String getNomeDoCantor() {
		return nomeDoCantor;
	}

	public void setNomeDoCantor(String nomeDoCantor) {
		this.nomeDoCantor = nomeDoCantor;
	}

	public String getNomeDaMusica() {
		return nomeDaMusica;
	}

	public void setNomeDaMusica(String nomeDaMusica) {
		this.nomeDaMusica = nomeDaMusica;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getYouTube() {
		return youTube;
	}

	public void setYouTube(String youTube) {
		this.youTube = youTube;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String string) {
		this.duracao = string;
	}

	public void edicao(String sql) throws Exception {
		if (sql.contains("insert")) {
			String comandoSql = "insertintomusicas(";
			texto = sql.toLowerCase();
			texto = texto.replaceAll(" ", "");

			for (int i = 17; i < texto.length(); i++) {
				if (texto.charAt(i) == '\"') {
					verificaAspas++;
				}

				else if (texto.charAt(i) == ',') {
					verificaVirgulas++;
				}

				else if (texto.charAt(i) == '(') {
					verificaAbreParentese++;
				}

				else if (texto.charAt(i) == ')') {
					verificaFechaParentese++;
				}
			}

			if (comandoSql.equals(texto.substring(0, 18)) && texto.substring(51, 60).equals(")values(\"")
					&& verificaAspas == 8 && verificaVirgulas == 8 && verificaAbreParentese == 2
					&& verificaFechaParentese == 2 && texto.charAt((texto.length()) - 1) == ';') 
			{
				for (int i = 17; i <= 50; i++) 
				{
					// verificando nome
					if (texto.substring(i, i + 5).equals("nome)")) {
						posicaoNome = posicao++;
					}

					else if (texto.substring(i, i + 5).equals("nome,") && texto.charAt(i - 1) != '(') {
						posicaoNome = posicao++;
					}

					else if (texto.substring(i, i + 6).equals("(nome,")) {
						posicaoNome = posicao++;
					}

					// verificando autor
					else if (texto.substring(i, i + 6).equals("album)")) {
						posicaoAlbum = posicao++;
					}

					else if (texto.substring(i, i + 6).equals("album,") && texto.charAt(i - 1) != '(') {
						posicaoAlbum = posicao++;
					}

					else if (texto.substring(i, i + 7).equals("(album,")) {
						posicaoAlbum = posicao++;
					}

					// verificando cantor
					else if (texto.substring(i, i + 7).equals("cantor)")) {
						posicaoCantor = posicao++;
					}

					else if (texto.substring(i, i + 7).equals("cantor,") && texto.charAt(i - 1) != '(') {
						posicaoCantor = posicao++;
					}

					else if (texto.substring(i, i + 8).equals("(cantor,")) {
						posicaoCantor = posicao++;
					}

					// verificando duracao
					else if (texto.substring(i, i + 8).equals("duracao)")) {
						posicaoDuracao = posicao++;
					}

					else if (texto.substring(i, i + 8).equals("duracao,") && texto.charAt(i - 1) != '(') {
						posicaoDuracao = posicao++;
					}

					else if (texto.substring(i, i + 9).equals("(duracao,")) {
						posicaoDuracao = posicao++;
					}

					// verificando youtube
					else if (texto.substring(i, i + 8).equals("youtube)")) {
						posicaoYoutube = posicao++;
					}

					else if (texto.substring(i, i + 8).equals("youtube,") && texto.charAt(i - 1) != '(') {
						posicaoYoutube = posicao++;
					}

					else if (texto.substring(i, i + 9).equals("(youtube,")) {
						posicaoYoutube = posicao++;
					}
				}
				
				if ((posicaoYoutube + posicaoAlbum + posicaoCantor + posicaoDuracao + posicaoNome) == 10) 
				{
					while (sql.contains("  ")) 
					{
						sql.replaceAll("  ", " ");
					}
					
					String[] insereDado = sql.split("\"");

					insereDado[0] = insereDado[1].trim();
					insereDado[1] = insereDado[3].trim();
					insereDado[2] = insereDado[5].trim();
					insereDado[3] = insereDado[6].replaceAll(",", "").trim();
					insereDado[4] = insereDado[7].trim();

					if (insereDado[(posicaoDuracao + 4)].contains("\"")) 
					{
						JOptionPane.showMessageDialog(null, "Na posição da duração não contém \"");
						System.exit(0);
					}

					else 
					{
						setNomeDaMusica(insereDado[posicaoNome]);
						setAlbum(insereDado[posicaoAlbum]);
						setNomeDoCantor(insereDado[posicaoCantor]);
						setDuracao(String.valueOf(insereDado[posicaoDuracao]));
						setYouTube(insereDado[posicaoYoutube]);
					}
				}
				
				else 
				{
					
				}
				
				setId(LeitorDeArquivo.LerArquivo());

				EscritorDeArquivo.escreveArquivo(getId(), getNomeDaMusica(), getAlbum(), getNomeDoCantor(),
						getDuracao(), getYouTube());
			}
		}

		else if (sql.contains("delete")) {
			String comandoSql = "delete from musicas where";
			texto = sql.toLowerCase().trim();

			while (texto.contains("  ")) {
				texto.replaceAll("  ", " ");
			}

			System.out.println(comandoSql.length());
			for (int j = 2; j < texto.length(); j++) {
				if (sql.substring(21, j) != "id=") {
					System.out.println(sql.substring(21, j));
				}

				else if (sql.substring(21, j) == "nome=") {
					if (sql.substring(21) != getNomeDaMusica()) {
						JOptionPane.showMessageDialog(null, "não tem essa linha");
					}

				}

				else if (sql.substring(21, j) == "album=") {

				}

				else if (sql.substring(21, j) == "cantor=") {

				}

				else if (sql.substring(21, j) == "duracao=") {

				}

				else if (sql.substring(21, j) == "youtube=") {

				}

				else {
					JOptionPane.showMessageDialog(null, "Seu comando SQL possui informações inseridas incorretamente!");
				}
			}

		}

		else {
			JOptionPane.showMessageDialog(null, "Seu comando SQL possui informações inseridas incorretamente!");
		}

	}

	public void deletaArquivo() {

	}
}
