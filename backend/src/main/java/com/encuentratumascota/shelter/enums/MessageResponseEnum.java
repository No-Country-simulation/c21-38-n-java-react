package com.encuentratumascota.shelter.enums;

public enum MessageResponseEnum {
	
	PETS_FOUND_SUCCESSFUL(200,"Las mascotas fueron obtenidas exitosamente."),
	PETS_NOT_FOUND(404,"No existen mascotas para mostrar."),
	PET_SAVED_SUCCESSFUL(200,"La mascota fue registrada exitosamente."),
	PET_NOT_SAVED(400,"Error al intentar guardar la mascota"),
	PET_UPDATED_SUCCESSFUL(200,"Los datos de la mascota fueron atualizados exitosamente"),
	PET_NOT_UPDATED(400,"Error al intentar actualizar los datos de la mascota"),
	PET_FOUND_SUCCESSFUL(200, "Mascota encontrada con éxito."),
	LISTS_DATA_PETS_FOUND_SUCCESSFUL(200,"El listado de datos para mascotas fue obtenido con éxito"),
	LISTS_DATA_USERS_FOUND_SUCCESSFUL(200,"El listado de datos para usuarios fue obtenido con éxito"),
	SHELTER_SAVED_SUCCESSFUL(200,"El refugio fue registrado exitosamente"),
	SHELTER_NOT_SAVED(400,"El refugio NO fue registrado"),
	ADOPTER_SAVED_SUCCESSFUL(200,"El adoptante fue registrado exitosamente"),
	ADOPTER_NOT_SAVED(400,"El adoptante NO fue registrado"),
	ADOPTION_FAILED(400,"El proceso de adopción falló"),
	ADOPTION_SUCCESSFUL(200,"El proceso de adopción fue exitoso"),

	PET_NOT_FOUND(404, "No se encontró la mascota con el Id proporcionado.");

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
