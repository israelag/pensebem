package action;

import java.util.LinkedHashMap;
import java.util.ResourceBundle;

import util.RegistraLog;

public class Gabarito {
	private RegistraLog log;
	private int qtdeQuestoesCap = 30; //defaut
	
	public Gabarito (RegistraLog log) {
		this.log = log;	
		
		setQuantidadeQuestoes();
	}
	
	private void setQuantidadeQuestoes() {
		ResourceBundle rd = ResourceBundle.getBundle("resources.config");
		this.qtdeQuestoesCap = Integer.valueOf(rd.getString("quantidade_questoes"));
		rd = null;
	}
	
	public LinkedHashMap <Integer, String> pegarRespostas (int inicioResposta, int inicioPergunta) {

		LinkedHashMap <Integer, String> mapaGabarito = new LinkedHashMap <Integer, String>();
		
		ResourceBundle rd = ResourceBundle.getBundle("resources.respostas");
		int iResp = inicioResposta;
		int iPerg = inicioPergunta;
		
		try {
	
			for(int i=1; i<=qtdeQuestoesCap; i++){
				mapaGabarito.put(iPerg, rd.getString(Integer.toString(iResp)));
		    	log.debug(iPerg + ") " + iResp + " - " + rd.getString(Integer.toString(iResp)));
		    	iResp++;
		    	iPerg++;
		    	if (iResp==150) iResp=1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapaGabarito;
	}
}
