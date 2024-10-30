package com.encuentratumascota.shelter.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GeneralResponsDTO<T> {
	
	private Integer code;
	private String message;
	private T body;
	private List<String> errors;


}
