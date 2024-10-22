package com.encuentratumascota.shelter.service;

import com.encuentratumascota.shelter.dto.response.ImageResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ImageUploadService {

    private final EnvironmentService environmentService;

    public ImageUploadService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }


    public String uploadImage(File imageFile, String name) throws IOException {
        String API_URL = environmentService.getApiImg();
        String API_KEY = environmentService.getApiImgToken();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost uploadFile = new HttpPost(API_URL + "?key=" + API_KEY);
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addPart("name", new StringBody(name));
            builder.addBinaryBody("image", imageFile);
            HttpEntity multipart = builder.build();
            uploadFile.setEntity(multipart);
            HttpResponse response = httpClient.execute(uploadFile);
            HttpEntity responseEntity = response.getEntity();
            String jsonResponse = EntityUtils.toString(responseEntity);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, ImageResponseDTO.class).getData().getUrl();

        }
    }
}
