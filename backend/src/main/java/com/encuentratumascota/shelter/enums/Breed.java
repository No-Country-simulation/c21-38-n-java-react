package com.encuentratumascota.shelter.enums;

public enum Breed {

    DOB("Doberman"),
    PDL("Poddle"),
    BCOL("Border Collie"),
    CRI("Criollo"),
    ANG("Angora"),
    SIA("Siames"),
    MCO("Maine Coon"),
    PER("Persa"),
    SPH("Sphinx"),
    OTHER("Otras");

    private String name;
    Breed(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
