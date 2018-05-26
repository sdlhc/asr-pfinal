package asr.proyectoFinal.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ibm.watson.developer_cloud.service.exception.UnsupportedException;

import asr.proyectoFinal.dao.CloudantPalabraStore;
import asr.proyectoFinal.dominio.Palabra;
import asr.proyectoFinal.services.AnalizadorTono;
import asr.proyectoFinal.services.Traductor;
import asr.proyectoFinal.services.VozTexto;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = {"/listar","/translate"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB 
				maxFileSize=1024*1024*10,      // 10MB
				maxRequestSize=1024*1024*50)   // 50MB
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CloudantPalabraStore store = new CloudantPalabraStore();
	String savedFile = "";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getServletPath().equals("/listar"))
		{
				List<Palabra> palabras;
				if(store.getDB() == null)
					palabras = new ArrayList<Palabra>();
				else
				{
					palabras=store.getAll();
				}
				Collections.sort(palabras);
				request.setAttribute("palabras", palabras);
				if(request.getParameter("nuevaPalabra")!=null)
					request.setAttribute("nuevaPalabra", request.getParameter("nuevaPalabra"));
				request.getRequestDispatcher("listar.jsp").forward(request,response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("POST");
		// gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + "audio";
        System.out.println(savePath);
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        
        for (Part part : request.getParts()) {
        	if(part.getName().equals("audioFile")){
	            String fileName = extractFileName(part);
	            // refines the fileName in case it is an absolute path
	            fileName = new File(fileName).getName();
	            savedFile=savePath + File.separator + fileName;
	            part.write(savedFile);
        	}
        }
        try {
        	String palabraEspañol = VozTexto.speechToText(savedFile);
	        String palabraIngles = Traductor.translate(palabraEspañol);
	        Palabra palabra = new Palabra();
	        if(palabraEspañol==null)
			{
				//out.println("usage: /insertar?palabra=palabra_a_traducir");
			}
			else
			{
				if(store.getDB() == null) 
				{
				}
				else
				{
					if(!(palabraIngles.equals(null))) {
						palabra.setEspanol(palabraEspañol);
						palabra.setIngles(palabraIngles);
						palabra.setFecha(new Date());
						AnalizadorTono.analizar(palabra);
						palabra=store.persist(palabra);
					}
				}
			}
	        response.sendRedirect("listar?nuevaPalabra="+palabra.get_id());
        }catch(UnsupportedException e)
        {
        	response.sendRedirect("index.html?error");
        }
	}  
	
	/**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
