package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

/**
 * Servlet implementation class SearchProcess
 */
public class SearchProcess extends HttpServlet {

       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("application/json");
		 
		 Gson gson = new Gson();
		
		List<String> listBase64 = ViewProcessor.getImageStrings();
		String imagemBase64 = gson.toJson(listBase64);
		//String imagem = ViewProcessor.getImageStrings();
		
		//String nome = ViewProcessor.getDBNames();
		//String tipo = ViewProcessor.getDBTypes();
		
		//response.setContentType("application/json");
		//response.addHeader("Set-Cookie", "JSESSIONID=" + request.getSession().getId() + "; SameSite=None; Secure");
		//response.setContentType("application/json");
	   // response.getWriter().write(imagemBase64);
		
		response.getWriter().print(imagemBase64);
		//response.getWriter().print(nome);
		//response.getWriter().print(tipo);
		
		//response.getWriter().flush();
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

}