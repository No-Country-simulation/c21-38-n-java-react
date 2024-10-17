package com.encuentratumascota.shelter.util;

import com.encuentratumascota.shelter.dto.DataDTO;
import com.encuentratumascota.shelter.dto.GeneralResponsDTO;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class DataUtils {

	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private static final int CODE_LENGTH = 6;
	private static final SecureRandom RANDOM = new SecureRandom();

	public static <T> GeneralResponsDTO<T> buildResponse(MessageResponseEnum messageResponse, T body){
		return GeneralResponsDTO.<T>builder()
				.code(messageResponse.getCode())
				.message(messageResponse.getMessage())
				.body(body).build();
	}

	public static <T> GeneralResponsDTO<T> buildResponseWithError(MessageResponseEnum messageResponse, String errorMessage, T body){
		return GeneralResponsDTO.<T>builder().code(messageResponse.getCode()).message(messageResponse.getMessage() + errorMessage).body(body).build();
	}

	public static String generateCode() {
		StringBuilder code = new StringBuilder(CODE_LENGTH);
		for (int i = 0; i < CODE_LENGTH; i++) {
			int index = RANDOM.nextInt(CHARACTERS.length());
			code.append(CHARACTERS.charAt(index));
		}
		return code.toString();
	}

	public static List<DataDTO> generateListDataSize() {
		List<DataDTO> result = new ArrayList<>();
		result.add(new DataDTO("P","Pequeño"));
		result.add(new DataDTO("M","Mediano"));
		result.add(new DataDTO("G","Grande"));
		return  result;
	}

	public static List<DataDTO> generateListDataGender() {
		List<DataDTO> result = new ArrayList<>();
		result.add(new DataDTO("H","Hembra"));
		result.add(new DataDTO("M","Macho"));
		return  result;
	}

}
