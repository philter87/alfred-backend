package com.alfred.controllers;

import com.alfred.utils.HeaderUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class TextToSpeechController {
    private String url = "https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?text=Hello";
    private String username = "8da0bca8-c9d8-41e8-978b-b74febe37517";
    private String password ="lFKYnN9Z30Fu";

    @RequestMapping("/text-to-speech")
    public String getAudioFromText(){
        HttpHeaders headers = HeaderUtils.createHeader(username,password);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response;
        response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), Object.class);
        System.out.println(response);
        System.out.println(response.getBody());
//        if (response.getStatusCode() == HttpStatus.OK) {
//            try {
//                Files.write(Paths.get("test.wav"), response.getBody());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return "Hi";
    }
}
