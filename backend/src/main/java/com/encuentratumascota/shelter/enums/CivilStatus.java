package com.encuentratumascota.shelter.enums;

public enum CivilStatus {

    SINGLE("Soltero"),
    MARRIED("Casado"),
    FREE_UNION("Unión Libre");

    private String text;
    CivilStatus(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }
}
