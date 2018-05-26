package asr.proyectoFinal.services;

import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;

import asr.proyectoFinal.dominio.Palabra;


public class AnalizadorTono {

	public static void analizar(Palabra texto)
	{
		ToneAnalyzer service = new ToneAnalyzer("2017-09-21");
		service.setUsernameAndPassword("9f3b937a-4300-4fb3-af8c-8789bb30e333", "wEJrob2oamkN");

		    
		ToneOptions toneOptions = new ToneOptions.Builder().text(texto.getIngles()).build();
		ToneAnalysis tone = service.tone(toneOptions).execute();
		if(tone.getDocumentTone().getTones().isEmpty())
			return;
		String tono=tone.getDocumentTone().getTones().get(0).getToneName();
		double puntuacionTono=tone.getDocumentTone().getTones().get(0).getScore();	
		
		System.out.println(tone);
	    System.out.println(tono+" : "+puntuacionTono);
	    texto.setPuntuacionTono(puntuacionTono);
	    texto.setTono(tono);
	    //return tone.toString();
	}
	
}
