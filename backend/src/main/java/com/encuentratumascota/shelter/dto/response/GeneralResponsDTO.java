package com.encuentratumascota.shelter.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralResponsDTO<T> {
	
	private Integer code;
	private String message;
	private T body;


}
