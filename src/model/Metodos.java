package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Cidade;

public class Metodos {
	Cidade[] cidade = new Cidade[10];

	public void showMetodos(int opcao) {
		switch (opcao) {
		case 0:
			JOptionPane.showMessageDialog(null, "Finalizado!");
			break;

		case 1:
			FCADASTRARESTATISTICA(cidade);
			break;

		case 2:
			PQDTACIDENTES(cidade);
			break;

		case 3:
			PMAIORMENOR(cidade);
			break;

		case 4:
			PACIMA(cidade);
			break;

		case 5:
			GRAVAR(cidade);
			break;

		case 6:
			LER(cidade);
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			break;
		}
	}

	private Cidade[] FCADASTRARESTATISTICA(Cidade[] cidade) {
		for (int i = 0; i < cidade.length; i++) {
			cidade[i] = new Cidade();
			String nomeCidade = JOptionPane.showInputDialog("Informe o nome da cidade");
			int codCidade = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da cidade: " + nomeCidade));
			int qtdAcidentes = Integer.parseInt(
					JOptionPane.showInputDialog("Informe a quantidade de acidentes da cidade: " + nomeCidade));
			cidade[i] = new Cidade(nomeCidade, codCidade, qtdAcidentes);
		}
		return cidade;
	}

	private void PQDTACIDENTES(Cidade[] cidade) {
		for (Cidade atual : cidade) {
			if (atual.getQtdAcidentes() > 100 && atual.getQtdAcidentes() < 500) {
				System.out.println(atual.getNomeCidade() + " possui: " + atual.getQtdAcidentes() + " acidentes\n");
			}
		}
	}

	private void PMAIORMENOR(Cidade[] cidade) {

		int maior = Integer.MIN_VALUE;
		int menor = Integer.MAX_VALUE;

		Cidade cidadeMaior = null;
		Cidade cidadeMenor = null;

		for (Cidade atual : cidade) {
			if (atual.getQtdAcidentes() > maior) {
				maior = atual.getQtdAcidentes();
				cidadeMaior = atual;
			} else if (atual.getQtdAcidentes() < menor) {
				menor = atual.getQtdAcidentes();
				cidadeMenor = atual;
			}
		}

		System.out.println("Cidade com maior número de acidentes: " + cidadeMaior);
		System.out.println("Cidade com menor número de acidentes: " + cidadeMenor);
		System.out.println();
	}

	private void PACIMA(Cidade[] cidade) {
		double estatistica = 0;

		for (Cidade atual : cidade) {
			estatistica = atual.getQtdAcidentes();
		}

		double res = (estatistica / cidade.length);
		System.out.println("Média: " + res + "\n");

		for (Cidade atual : cidade) {
			if (atual.getQtdAcidentes() > res) {
				System.out.println(atual.getNomeCidade() + " está acima da média\n");
			}
		}
	}

	private void GRAVAR(Cidade[] cidade) {
		String nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo a ser salvo");
		try {
			BufferedWriter escrita = new BufferedWriter(new FileWriter(nomeArq + ".txt"));
			for (int i = 0; i < cidade.length; i++) {
				escrita.write(cidade[i].getNomeCidade() + "\n");
				escrita.write(cidade[i].getCodCidade() + "\n");
				escrita.write(cidade[i].getQtdAcidentes() + "\n");
				escrita.newLine();

			}
			escrita.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao gravar aquivo!");
		}
	}
	
	private void LER(Cidade[] cidade) {
		String nomeArq = JOptionPane.showInputDialog("Informe o nome do arquivo a ser lido: ");
		try {
			BufferedReader leitura = new BufferedReader(new FileReader(nomeArq+".txt"));
			for(int i = 0; i < cidade.length; i++) {
				cidade[i] = new Cidade();
				cidade[i].setNomeCidade(leitura.readLine());
				cidade[i].setCodCidade(Integer.parseInt(leitura.readLine()));
				cidade[i].setQtdAcidentes(Integer.parseInt(leitura.readLine()));
				leitura.readLine();
			}
			leitura.close();
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar ler arquivo: " + nomeArq);
		}
	}
}
