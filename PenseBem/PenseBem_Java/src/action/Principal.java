package action;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.RegistraLog;
import exceptions.ApplicationException;

public class Principal {

	private static Scanner input;

	public static void main(String[] args) 
			throws ApplicationException, IOException {

		RegistraLog log = new RegistraLog();
		input = new Scanner(System.in);

		System.out.print("Qual é o nome do jogador? ---> ");
		log.gravaLog("Nome do jogador: " + input.nextLine());

		String numRevista;
		boolean result = false;
		do {
	        System.out.print("Digite o numero da revista ---> ");
	        numRevista = input.next();
	        Pattern pattern = Pattern.compile("^[0-9][0-9](1|2|3|4|5|6){1}$");
	        Matcher matcher = pattern.matcher(numRevista);
	        result = matcher.find();
		} while (!result);

		log.gravaLog("Revista: " + numRevista);
		
		Revista rv = new Revista(log, numRevista);
		rv.aplicaQuestionario();
		
		log.fechaLog();

		input.close();
        rv = null;
        log = null;
	}
}
