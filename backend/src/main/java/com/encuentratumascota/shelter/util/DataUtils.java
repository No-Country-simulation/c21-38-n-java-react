package com.encuentratumascota.shelter.util;

import com.encuentratumascota.shelter.dto.GeneralResponse;
import com.encuentratumascota.shelter.enums.MessageResponseEnum;

public class DataUtils {

	public static <T> GeneralResponse<T> buildResponse(MessageResponseEnum messageResponse, T body){
		return GeneralResponse.<T>builder()
				.code(messageResponse.getCode())
				.message(messageResponse.getMessage())
				.body(body).build();
	}

}
