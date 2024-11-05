package action;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.RegistraLog;

public class Revista {

	private RegistraLog log;
	private String numeroRevista = "000";
	private int inicioResposta = 0;
	private int inicioPergunta = 0;
	private int capitulo = 0;
	protected LinkedHashMap <Integer, String> mapaGabarito = new LinkedHashMap<Integer, String>();

	public Revista (RegistraLog log, String numeroRevista) {
		this.log = log;	
		this.numeroRevista = numeroRevista;
		
		setPosicaoRevista(numeroRevista);

		obterGabarito();
	}

	private void setPosicaoRevista(String numeroRevista) {
		this.numeroRevista = numeroRevista;
		this.capitulo = Integer.valueOf(numeroRevista.substring(2, 3)) - 1;	
		this.inicioResposta = Integer.valueOf(numeroRevista.substring(0, 2)) + (capitulo * 30);
		this.inicioPergunta = (capitulo * 30) + 1;
		
		log.gravaLog("numeroRevista: " + numeroRevista);
		log.gravaLog("capitulo: " + capitulo);
		log.gravaLog("inicioResposta: " + inicioResposta);
		log.gravaLog("inicioPergunta: " + inicioPergunta);
	}
	
	private void obterGabarito(){
		Gabarito gr = new Gabarito(log);
		mapaGabarito = gr.pegarRespostas(inicioResposta, inicioPergunta);
		gr = null;
	}
	
	public String getNumeroRevista() {
		return numeroRevista;
	}

	public void aplicaQuestionario() {

		String respostaAluno = "";
		Scanner inputResposta = new Scanner(System.in);
		
		for (int questao : mapaGabarito.keySet()) {
			
			System.out.printf("%s.) R: ---> ", questao);
			log.gravaLog(" Pergunta: " + questao);
			boolean result = false;
			do {				
				respostaAluno = inputResposta.nextLine();
		        Pattern pattern = Pattern.compile("^[A-D|a-d]");
		        Matcher matcher = pattern.matcher(respostaAluno);
		        result = matcher.find();
		        
		        if ((result) && !respostaAluno.toUpperCase().equals(mapaGabarito.get(questao))) {
		        	System.out.println("Resposta errada. Tente novamente ---> ");
		        	log.gravaLog("  Resposta errada: " + respostaAluno.toUpperCase());
		        	result = false;
				} else if (!result) {
					System.out.print("Digite uma resposta entre [A/B/C/D] --->");
				} else {
					System.out.println("PARABENS! Resposta correta.");
					log.gravaLog("  Resposta correta: " + respostaAluno.toUpperCase());
				}
			} while (!result);
		}

		System.out.println("PARABENS! Todas as perguntas foram respondidas.");
		System.out.print("--------FIM--------");		

		inputResposta.close();
	}
}
