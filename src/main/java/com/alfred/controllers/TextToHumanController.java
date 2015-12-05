package com.alfred.controllers;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
public class TextToHumanController {
    private static TextToSpeech service = new TextToSpeech();
    static {
        service.setUsernameAndPassword("8da0bca8-c9d8-41e8-978b-b74febe37517","lFKYnN9Z30Fu");
    }

    @RequestMapping(value="/text-to-speech",method= RequestMethod.POST)
    public ResponseEntity<InputStreamResource> getAudioFromText(@RequestBody String text) throws IOException {
        InputStream inputStream = service.synthesize(text, Voice.EN_MICHAEL, "audio/wav");
        Files.copy(inputStream, Paths.get("test.wav"));
        return ResponseEntity.ok().body(new InputStreamResource(inputStream));
    }
}
