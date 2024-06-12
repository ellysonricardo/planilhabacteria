package br.ufrj.hucff.planilhabacteria.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EncontraAntibioticos {

//	Windows
	final String caminhoSt = "C:\\Users\\ellysonalmeida\\eclipse-workspace-hucff\\planilha\\antibioticos.txt";
//	Linux
//	final static String caminhoSt = "/home/ellyson/eclipse-workspace-deploy/planilha/antibioticos.txt";
	
	public String buscar(String nome) {

    String codigo = null;
	String linha = "";
	final String separa = ";";
	int i = 0; 

	try (BufferedReader br = new BufferedReader(new FileReader(caminhoSt))) {

		while ((linha = br.readLine()) != null) {

			String[] nomeBacteriaStr = linha.split(separa);
			
			if (!nomeBacteriaStr[1].isEmpty()) {
				if(nomeBacteriaStr[1].trim().equals(nome)) {
				 codigo = nomeBacteriaStr[0];
				break;
				}else {
					 codigo = nome;
				}
			}
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	return codigo;
}

}

