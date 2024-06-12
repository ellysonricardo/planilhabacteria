package br.ufrj.hucff.planilhabacteria.importar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.ufrj.hucff.planilhabacteria.modelo.Bacteria;
import br.ufrj.hucff.planilhabacteria.util.EncontraAntibioticos;
import br.ufrj.hucff.planilhabacteria.util.EncontraBacteria;

public class Writesheet3 {


//	Windows
	final static String caminhoSt = "C:\\Users\\ellysonalmeida\\eclipse-workspace-hucff\\planilha\\";
//	Linux
//	final static String caminhoSt = "/home/ellyson/eclipse-workspace-deploy/planilha/";

	static String linha = "";
	final static String separa = ";";

	static EncontraBacteria numeroBacteria = new EncontraBacteria();
	static EncontraAntibioticos antibioticos = new EncontraAntibioticos();

	public static void main(String[] args) throws Exception {
		FileInputStream file = new FileInputStream(caminhoSt + "tabela.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.getSheetAt(0);

		// Create row object
		XSSFRow row;

		// This data needs to be written (Object[])
		Map<Integer, Object[]> empinfo = new TreeMap<Integer, Object[]>();
		empinfo.put(1, new Object[] { "id_estabelecimento", "co_matriz", "id_lab_executor", "id_material", "co_amostra",
				"nu_amostra", "dt_coleta", "ds_motivo", "dt_cadastro", "id_paciente", "cns_paciente", "no_paciente",
				"no_mae", "dt_nascimento", "co_genero", "co_municipio", "co_tipo_atendimento", "dt_internacao",
				"co_origem", "co_unidade_origem", "co_desfecho", "id_microrganismo", "co_perfil", "rs_sorotipo",
				"rs_beta_lactamase", "rs_esbl", "rs_carbapenemase", "rs_mrsa", "rs_icr", "dt_liberacao",
				"id_antibiotico", "co_criterio_tsa", "co_metodo_tsa", "co_resultado", "vl_resultado" });

		int i = 2;

		try (BufferedReader br = new BufferedReader(new FileReader(caminhoSt + "pacientes.txt"))) {

			while ((linha = br.readLine()) != null) {
				Bacteria bacteria = new Bacteria();

				String[] bacteriaStr = linha.split(separa);

			
				if (!bacteriaStr[0].isEmpty()) {
					bacteria.setId_estabelecimento(bacteriaStr[0]);
				}
				if (!bacteriaStr[1].isEmpty()) {
					bacteria.setCo_matriz(bacteriaStr[1]);
				}
				if (!bacteriaStr[2].isEmpty()) {
					bacteria.setId_lab_executor(bacteriaStr[2]);
				}
				if (!bacteriaStr[3].isEmpty()) {
					bacteria.setId_material(bacteriaStr[3]);
				}
				if (!bacteriaStr[4].isEmpty()) {
					bacteria.setCo_amostra(bacteriaStr[4]);
				}
				if (!bacteriaStr[5].isEmpty()) {
					bacteria.setNu_amostra(bacteriaStr[5]);
				}
				if (!bacteriaStr[6].isEmpty()) {
					bacteria.setDt_coleta(bacteriaStr[6]);
				}
				if (!bacteriaStr[7].isEmpty()) {
					bacteria.setDs_motivo(bacteriaStr[7]);
				}
				if (!bacteriaStr[8].isEmpty()) {
					bacteria.setDt_cadastro(bacteriaStr[8]);
				}
				if (!bacteriaStr[9].isEmpty()) {
					bacteria.setId_paciente(bacteriaStr[9]);
				}
				if (!bacteriaStr[10].isEmpty()) {
					bacteria.setCns_paciente(bacteriaStr[10]);
				}
				if (!bacteriaStr[11].isEmpty()) {
					bacteria.setNo_paciente(bacteriaStr[11]);
				}
				if (!bacteriaStr[12].isEmpty()) {
					bacteria.setNo_mae(bacteriaStr[12]);
				}
				if (!bacteriaStr[13].isEmpty()) {
					bacteria.setDt_nascimento(bacteriaStr[13]);
				}
				if (!bacteriaStr[14].isEmpty()) {
					bacteria.setCo_genero(bacteriaStr[14]);
				}
				if (!bacteriaStr[15].isEmpty()) {
					bacteria.setCo_municipio(bacteriaStr[15]);
				}
				if (!bacteriaStr[16].isEmpty()) {
					bacteria.setCo_tipo_atendimento(bacteriaStr[16]);
				}
				if (!bacteriaStr[17].isEmpty()) {
					bacteria.setDt_internacao(bacteriaStr[17]);
				}
				if (!bacteriaStr[18].isEmpty()) {
					bacteria.setCo_origem(bacteriaStr[18]);
				}
				if (!bacteriaStr[19].isEmpty()) {
					bacteria.setCo_unidade_origem(bacteriaStr[19]);
				}
				if (!bacteriaStr[20].isEmpty()) {
					bacteria.setCo_desfecho(bacteriaStr[20]);
				}
				if (!bacteriaStr[21].isEmpty()) {
					bacteria.setId_microrganismo(numeroBacteria.buscar(bacteriaStr[21]));
				}
				if (!bacteriaStr[22].isEmpty()) {
					bacteria.setCo_perfil(bacteriaStr[22]);
				}
				if (!bacteriaStr[23].isEmpty()) {
					bacteria.setRs_sorotipo(bacteriaStr[23]);
				}
				if (!bacteriaStr[24].isEmpty()) {
					bacteria.setRs_beta_lactamase(bacteriaStr[24]);
				}
				if (!bacteriaStr[25].isEmpty()) {
					bacteria.setRs_esbl(bacteriaStr[25]);
				}
				if (!bacteriaStr[26].isEmpty()) {
					bacteria.setRs_carbapenemase(bacteriaStr[26]);
				}
				if (!bacteriaStr[27].isEmpty()) {
					bacteria.setRs_mrsa(bacteriaStr[27]);
				}
				if (!bacteriaStr[28].isEmpty()) {
					bacteria.setRs_icr(bacteriaStr[28]);
				}
				if (!bacteriaStr[29].isEmpty()) {
					bacteria.setDt_liberacao(bacteriaStr[29]);
				}
				if (!bacteriaStr[30].isEmpty()) {
					bacteria.setId_antibiotico(antibioticos.buscar(bacteriaStr[30]));
				}
				if (!bacteriaStr[31].isEmpty()) {
					bacteria.setCo_criterio_tsa(bacteriaStr[31]);
				}
				if (!bacteriaStr[32].isEmpty()) {
					bacteria.setCo_metodo_tsa(bacteriaStr[32]);
				}
				if (!bacteriaStr[33].isEmpty()) {
					bacteria.setCo_resultado(bacteriaStr[33]);
				}
				if (bacteriaStr.length != 35) {
					bacteria.setVl_resultado("-");
				}else{
					bacteria.setVl_resultado(bacteriaStr[34]);
				}

                   
				empinfo.put(i, new Object[] { bacteria.getId_estabelecimento(), bacteria.getCo_matriz(),	
						bacteria.getId_lab_executor(), bacteria.getId_material(),bacteria.getCo_amostra(),bacteria.getNu_amostra(),
						bacteria.getDt_coleta(),bacteria.getDs_motivo(),bacteria.getDt_cadastro(),bacteria.getId_paciente(),
						bacteria.getCns_paciente(),bacteria.getNo_paciente(),bacteria.getNo_mae(),bacteria.getDt_nascimento(),
						bacteria.getCo_genero(),bacteria.getCo_municipio(),bacteria.getCo_tipo_atendimento(),bacteria.getDt_internacao(),
						bacteria.getCo_origem() ,bacteria.getCo_unidade_origem(),bacteria.getCo_desfecho(),bacteria.getId_microrganismo() ,
						bacteria.getCo_perfil() ,bacteria.getRs_sorotipo(),bacteria.getRs_beta_lactamase(),bacteria.getRs_esbl(),
						bacteria.getRs_carbapenemase(),bacteria.getRs_mrsa(),bacteria.getRs_icr() ,bacteria.getDt_liberacao(),
						bacteria.getId_antibiotico() ,bacteria.getCo_criterio_tsa(),bacteria.getCo_metodo_tsa(),
						bacteria.getCo_resultado(),bacteria.getVl_resultado() });
				++i;
				System.out.println(i);
				System.out.println("tamanho -> "+bacteriaStr.length);
			}
		}

		// Iterate over data and write to sheet
		Set<Integer> keyid = (Set<Integer>) empinfo.keySet();
		int rowid = 0;

		for (Integer key : keyid) {
			row = spreadsheet.createRow(rowid++);
			Object[] objectArr = empinfo.get(key);
			int cellid = 0;

			for (Object obj : objectArr) {
				Cell cell = row.createCell(cellid++);
				cell.setCellValue((String) obj);
			}
		}
		// Write the workbook in file system
		FileOutputStream out = new FileOutputStream(new File(caminhoSt + "/tabela.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("Terminou de Gravar o arquivo excel");
	}
}