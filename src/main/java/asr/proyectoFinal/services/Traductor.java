package asr.proyectoFinal.services;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.watson.developer_cloud.language_translator.v2.LanguageTranslator;
import com.ibm.watson.developer_cloud.language_translator.v2.util.Language;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions.Builder;
import com.ibm.watson.developer_cloud.language_translator.v2.model.TranslateOptions;


public class Traductor {
	public static String translate(String palabra)
	{
		if(palabra==null)
			return "Repite por favor";
		LanguageTranslator service = new LanguageTranslator();
		service.setUsernameAndPassword("58d7d671-1c6e-46f1-b854-69f96372a405", "FYQ5ztkPIGr8");
		
		TranslateOptions translateOptions = new TranslateOptions.Builder()
				.addText(palabra)
				.modelId("es-en")
				.build();
		com.ibm.watson.developer_cloud.language_translator.v2.model.TranslationResult translationResult = service.translate(translateOptions).execute();
		System.out.println(translationResult);
		
		String traductionJSON = translationResult.toString();
		
		JsonParser parser = new JsonParser();
		JsonObject rootObj = parser.parse(traductionJSON).getAsJsonObject();
		String wordCount = rootObj.get("word_count").getAsString();
		JsonArray traducciones = rootObj.getAsJsonArray("translations");
		String traduccionPrimera = palabra;
		if(traducciones.size()>0)
			traduccionPrimera = traducciones.get(0).getAsJsonObject().get("translation").getAsString();
		
		return traduccionPrimera;
		
		
	}

}



