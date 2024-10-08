package com.encuentratumascota.shelter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneralResponse<T> {
	
	private Integer code;
	private String message;
	private T body;
}
