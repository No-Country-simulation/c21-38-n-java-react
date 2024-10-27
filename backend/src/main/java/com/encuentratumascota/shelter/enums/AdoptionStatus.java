package com.encuentratumascota.shelter.enums;

public enum AdoptionStatus {

    IN_PROCESS("En proceso"),
    DENIED("Negado"),
    ACCEPTED("Aceptado");

    private String name;

    private AdoptionStatus(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
