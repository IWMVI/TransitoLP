package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import model.Metodos;

public class Principal {
	public static void main(String[] args) throws IOException {
		Metodos m = new Metodos();
		int opcao;
		
		do {
			opcao = showMenu();
			m.showMetodos(opcao);
		} while (opcao != 0);
	}

	private static int showMenu() {
		int opcao = Integer.parseInt(JOptionPane
				.showInputDialog("MENU\n01. Cadastro" + "\n02. Consulta Quantidade Acidentes\n03. Consulta Estatísticas"
						+ "\n04. Cidades Acima da Média\n05. Gravar Dados\n06. Ler Dados" + "\n00. Finalizar"));
		return opcao;
	}
}
