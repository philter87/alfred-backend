package com.alfred;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;

@SpringBootApplication
public class Alfred {
    public static void main(String[] args) {
    	SpeechToText service = new SpeechToText();
    	service.setUsernameAndPassword("5886b97e-bb0a-4912-9157-440a35132062", "ifdMXMXhxFt8");
    	
        SpringApplication.run(Alfred.class, args);
    }
}
