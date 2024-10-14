package com.encuentratumascota.shelter.enums;

public enum MessageResponseEnum {
	
	PETS_FOUND_SUCCESSFUL(200,"Las mascotas fueron obtenidas exitosamente"),
	PETS_NOT_FOUND(404,"No existen mascotas para mostrar"),
	PET_SAVED_SUCCESSFUL(200,"La mascota fue registrada exitosamente"),
	PET_NOT_SAVED(400,"Error al intentar guardar la mascota");

	
	
	private Integer code;
	private String message;

	private MessageResponseEnum(Integer code, String message) {
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public Integer getCode() {
		return this.code;
	}
}