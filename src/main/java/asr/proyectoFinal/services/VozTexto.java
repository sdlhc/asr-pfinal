package asr.proyectoFinal.services;

import java.io.File;

import com.ibm.watson.developer_cloud.service.exception.UnsupportedException;
import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

public class VozTexto 
{
	public static String speechToText(String path_audio) throws UnsupportedException
	{  		
		String ext = path_audio.substring(path_audio.lastIndexOf(".")+1);
		System.out.println(path_audio);
		System.out.println(ext);
		SpeechToText service = new SpeechToText();
		service.setUsernameAndPassword("2c575910-bb36-4c03-8e02-55bc26b0f837", "2ibaiMks2x7k");
		
		RecognizeOptions options = new RecognizeOptions.Builder()
				  .contentType("audio/"+ext).timestamps(true)
				  .model("es-ES_BroadbandModel")
				  .interimResults(false)
				  .wordAlternativesThreshold(0.7)
				  .build();

		SpeechResults result = service.recognize(new File(path_audio), options).execute();
		String texto;
		System.out.println(result);
		if(result.getResults().isEmpty())
			return null;
		texto =result.getResults().get(0).getAlternatives().get(0).getTranscript();		
		return texto;
	}
}