package com.alfred.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

@RestController
@RequestMapping("/speech-to-text")
public class SpeechToTextController {
	private static String AUDIO_FILE = "C://Users//KAMRAN//Desktop//test.wav";
	private static String CONTENT_TYPE = "audio/wav; rate=16000";
	private static String RATE = "; rate=16000";
	@Autowired
	SpeechToText service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String speechToText() {
		//		testWebSocket();
		return extractText();
	}

	//	private void testWebSocket() {
	//		try {
	//			// open websocket
	//			final WebSocketClient clientEndPoint = new WebsocketClient(new URI("wss://real.okcoin.cn:10440/websocket/okcoinapi"));
	//
	//			// add listener
	//			clientEndPoint.addMessageHandler(new WebsocketClientEndpoint.MessageHandler() {
	//				public void handleMessage(String message) {
	//					System.out.println(message);
	//				}
	//			});
	//
	//			// send message to websocket
	//			clientEndPoint.sendMessage("{'event':'addChannel','channel':'ok_btccny_ticker'}");
	//
	//			// wait 5 seconds for messages from websocket
	//			Thread.sleep(5000);
	//
	//		} catch (InterruptedException ex) {
	//			System.err.println("InterruptedException exception: " + ex.getMessage());
	//		} catch (URISyntaxException ex) {
	//			System.err.println("URISyntaxException exception: " + ex.getMessage());
	//		}
	//	}

	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
			@RequestParam("file") MultipartFile file) {
		if (!file.isEmpty()) {
			try {
				File inputFile = new File(name);
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream =
						new BufferedOutputStream(new FileOutputStream(inputFile));
				stream.write(bytes);
				stream.close();
				return extractText(inputFile, FilenameUtils.getExtension(name));
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name + " because the file was empty.";
		}
	}

	private String extractText() {

		File audioFile = new File(AUDIO_FILE);

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("audio", audioFile);
		params.put("content_type", CONTENT_TYPE);
		params.put("word_confidence", false);
		params.put("continuous", false);
		params.put("timestamps", false);
		params.put("inactivity_timeout", 30);
		params.put("max_alternatives", 1);

		SpeechResults transcript = service.recognize(params);
		return transcript.getResults().get(0).getAlternatives().get(0).getTranscript();
	}
	
	private String extractText(File inputFile, String fileExtension) {

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("audio", inputFile);
		params.put("content_type", "audio/" + fileExtension + RATE);
		params.put("word_confidence", false);
		params.put("continuous", false);
		params.put("timestamps", false);
		params.put("inactivity_timeout", 30);
		params.put("max_alternatives", 1);

		SpeechResults transcript = service.recognize(params);
		return transcript.getResults().get(0).getAlternatives().get(0).getTranscript();
	}
}