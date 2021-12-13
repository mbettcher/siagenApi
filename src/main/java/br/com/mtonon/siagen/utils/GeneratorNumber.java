package br.com.mtonon.siagen.utils;

import java.io.Serializable;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratorNumber implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public static final String GenerateNumber() {
		
		Random random = new Random();
		Integer numero = random.nextInt(1000000000);
		BCryptPasswordEncoder numberCode = new BCryptPasswordEncoder();
		String number = numberCode.encode(String.valueOf(numero));
		return String.valueOf(number);
	}

}
