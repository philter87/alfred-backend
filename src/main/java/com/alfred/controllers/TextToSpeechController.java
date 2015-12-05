package com.alfred.controllers;

import com.alfred.utils.HeaderUtils;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class TextToSpeechController {
    private String url = "https://stream.watsonplatform.net/text-to-speech/api/v1/synthesize?text=Hello";

    @Autowired
    private TextToSpeech textToSpeech;

    @RequestMapping("/text-to-speech")
    public String getAudioFromText() throws IOException {

        //HttpHeaders headers = HeaderUtils.createHeader(username,password);
        //headers.set("Response-Content-Type","audio/wav");
        //headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        String text = "Hello World";
        InputStream in = textToSpeech.synthesize(text, Voice.EN_MICHAEL, "audio/wav");
        Files.copy(in,Paths.get("test.wav"));
//        RestTemplate restTemplate = new RestTemplate();
//
//        ResponseEntity<byte[]> response;
//        response = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<String>(headers), byte[].class);
//
//        System.out.println(response);
//        System.out.println(response.getBody());
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            try {
//                Files.write(Paths.get("test.l16"), in.);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return "Hi";
    }
}
