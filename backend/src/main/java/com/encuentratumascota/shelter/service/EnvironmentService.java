package com.encuentratumascota.shelter.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class EnvironmentService {

    @Value("${api.img.url}")
    private String apiImg;

    @Value("${api.img.token}")
    private String apiImgToken;

}
