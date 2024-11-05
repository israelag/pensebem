package util;

import java.io.BufferedWriter;
import java.io.File;
import java.util.logging.Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class RegistraLog {

	private String tipoLog = "";
	private String arqLog = "";
	private static Logger logador = Logger.getLogger(RegistraLog.class.getName());
	private BufferedWriter writer;
	
 	public RegistraLog() {
		ResourceBundle rd = ResourceBundle.getBundle("resources.config");

		tipoLog = rd.getString("log_execucao");
		arqLog = rd.getString("arquivo_log");

		rd = null;

		try{
			File arquivoEscrever = new File(arqLog);

			if(!arquivoEscrever.exists()){
				arquivoEscrever.createNewFile();
			}

			writer = new BufferedWriter(new FileWriter(arquivoEscrever,true));

			gravaLog("--------------------------");
			gravaLog("Inicio: " + getDateTime());

		}catch (IOException e) {
			logador.finest(e.getMessage());
		    e.printStackTrace();
		}
	}

	private String getDateTime(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	
	public void debug(String mensagem) {
		if ( tipoLog.equals("DEBUG") ) {
			System.out.println(mensagem);
		}
	}
	
	public void fechaLog() {
		try{
			gravaLog("Fim: " + getDateTime());
			writer.close();
		}catch (IOException e) {
			logador.finest(e.getMessage());
		    e.printStackTrace();
		}
	}
	
	public void gravaLog(String mensagem) {
		
		try{
			writer.append(mensagem);
			writer.newLine();
		}catch (IOException e) {
			logador.finest(e.getMessage());
		    e.printStackTrace();
		}
	
	}
	
	

}
