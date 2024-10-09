package com.encuentratumascota.shelter.enums;

public enum Breed {

    //Dogs
    DOBERMAN("Doberman"),
    POODLE("Poddle"),
    BORDER_COLLIE("Border Collie"),
    CRIOLLO("Criollo"),

    // Cats
    ANGORA("Angora"),
    SIAMESE("Siames"),
    MAINE_COON("Maine Coon"),
    PERSIAN("Persa"),
    SPHINX("Sphinx");

    //Birds

    //Reptiles
    private String text;

    private Breed(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }



}
