package com.alfred.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

@RestController
@RequestMapping("/my")
public class SpeechToTextController {
	static SpeechToText service = new SpeechToText();
	static {
		service.setUsernameAndPassword("5886b97e-bb0a-4912-9157-440a35132062", "ifdMXMXhxFt8");
	}
	
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String greeting() {
    	test();
        return "Hello Kamran";
    }
    
    @RequestMapping(value="/upload", headers = "content-type=multipart/*", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
    
    private void test() {
    
    	File audio = new File("C://Users//KAMRAN//Desktop//Untitled.flac");

    	Map<String, Object> params = new HashMap();
    	params.put("audio", audio);
//    	params.put("model", "WatsonModel");
    	params.put("content_type", "audio/flac; rate=16000");
    	params.put("word_confidence", false);
    	params.put("continuous", false);
    	params.put("timestamps", false);
    	params.put("inactivity_timeout", 30);
    	params.put("max_alternatives", 1);

    	SpeechResults transcript = service.recognize(params);
    	System.out.println("-------------Hello--------------");
    	System.out.println(transcript);
	}
}
