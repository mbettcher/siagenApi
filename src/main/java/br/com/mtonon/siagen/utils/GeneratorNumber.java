package br.com.mtonon.siagen.utils;

import java.io.Serializable;
import java.util.Random;

public class GeneratorNumber implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String GenerateNumber() {
		
		Random random = new Random();
		Integer numero = random.nextInt(1000000000);
		return String.valueOf(numero);
	}

}
