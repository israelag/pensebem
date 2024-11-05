package js;

import java.util.LinkedHashMap;
import util.RegistraLog;
import action.Revista;

public class RevistaTeste extends Revista {

	protected LinkedHashMap <Integer, String> mapaGabaritoTest = new LinkedHashMap<Integer, String>();
	
	public RevistaTeste(RegistraLog log, String numeroRevista) {
		super(log, numeroRevista);
	}

	@Override
	public void aplicaQuestionario() {
		mapaGabaritoTest = mapaGabarito;
	}
	

}
