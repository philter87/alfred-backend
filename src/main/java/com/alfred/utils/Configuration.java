package com.alfred.utils;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Configuration {

    @Bean
    public TextToSpeech getTextToSpeechService(){
        TextToSpeech service = new TextToSpeech();
        service.setUsernameAndPassword("8da0bca8-c9d8-41e8-978b-b74febe37517","lFKYnN9Z30Fu");
        return service;
    }

    @Bean
    public SpeechToText getSpeechToText(){
        SpeechToText speechToText = new SpeechToText();
        speechToText.setUsernameAndPassword("","");
        return speechToText;
    }

}
