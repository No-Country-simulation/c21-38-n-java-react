package com.encuentratumascota.shelter.enums;

public enum Specie {

    DOG("Perro"),
    CAT("Gato");

    private String text;
    Specie(String text){
        this.text = text;
    }
    public String getText(){
        return text;
    }


}
