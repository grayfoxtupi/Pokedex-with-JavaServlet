package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.Binary;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ViewProcessor {
	
	 private static List<Register> getImageList() {

	        List<Register> registers = new ArrayList<>();

	        try {

	            MongoClient client = new MongoClient("localhost", 27017);

	            MongoDatabase db = client.getDatabase("pokedexdb");

	            MongoCollection<Document> pokemons = db.getCollection("pokemons");

	            FindIterable<Document> doc = pokemons.find();

	            MongoCursor<Document> cursor = doc.iterator();

	            while (cursor.hasNext()) {

	                Document current = cursor.next();

	                registers.add(new Register(current.get("nome", String.class),current.get("tipo", String.class), current.get("imagem", Binary.class)));

	            }

	        } catch (MongoClientException ex) {
	            ex.printStackTrace();
	        } catch (MongoException ex) {
	            ex.printStackTrace();
	        }
	        return registers;
	    }
	 
	 
	 private static List<Register> getSearch(String userInput) {

	        List<Register> registers = new ArrayList<>();

	        try {

	            MongoClient client = new MongoClient("localhost", 27017);

	            MongoDatabase db = client.getDatabase("pokedexdb");

	            MongoCollection<Document> pokemons = db.getCollection("pokemons");

	            FindIterable<Document> doc = pokemons.find();

	            MongoCursor<Document> cursor = doc.iterator();

	            while (cursor.hasNext()) {

	                Document current = cursor.next();
	                
	                if(userInput == current.getString("pokename") || userInput == current.getString("poketype")) {

	                registers.add(new Register(current.get("nome", String.class),current.get("tipo", String.class), current.get("imagem", Binary.class)));
	                
	                }
	            }

	        } catch (MongoClientException ex) {
	            ex.printStackTrace();
	        } catch (MongoException ex) {
	            ex.printStackTrace();
	        }
	        return registers;
	    }

	    private static String converterParaBase64(byte[] dados) {

	        return java.util.Base64.getEncoder().encodeToString(dados);
	    }
	
	public static void showAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		 List<Register> registers = ViewProcessor.getImageList();

	        response.setContentType("text/html");

	        try {
	            response.getWriter().println("Catálogo de Imagens");
	            response.getWriter()
	                    .println("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" media=\"screen\" />");
	            response.getWriter().println("</head><body>");
	            response.getWriter().println("<div class=\"container mt-4\">");
	            response.getWriter().println("<h1>Catálogo de Pokémons</h1>");
	            
	            // Adicione uma linha para envolver os cards
	            response.getWriter().println("<div class=\"row\">");

	            for (Register register : registers) {
	                byte[] dadosImagem = (register.getDados() != null) ? register.getDados().getData() : new byte[0];

	                response.getWriter().println("<div class=\"col-md-4 mb-4\">");
	                response.getWriter().println("<div class=\"card\">");
	                response.getWriter().println("<img class=\"card-img-top\" src='data:image/png;base64," + ViewProcessor.converterParaBase64(dadosImagem) + "' alt='Imagem do Pokémon'>");
	                response.getWriter().println("<div class=\"card-body\">");
	                response.getWriter().println("<h5 class=\"card-title\">" + register.getNome() + "</h5>");
	                response.getWriter().println("</div></div></div>");
	            }

	            // Feche a linha
	            response.getWriter().println("</div>");

	            response.getWriter().println("</div>");
	           
	        } catch (Exception e) {
	            throw new ServletException("Erro ao gerar a resposta HTML", e);
	        }
	    }
	
	public static List<String> getImageStrings(){
		List<Register> registers = getImageList();
		
		List<String> stringList = new ArrayList<>();
		
		for(Register register : registers) {
			stringList.add(java.util.Base64.getEncoder().encodeToString(register.getDados().getData()));
		}
		
	    return stringList;
		
	}

public static List<String> getDBNames(){
	List<Register> registers = getImageList();
	
	List<String> stringList = new ArrayList<>();
	
	for(Register register : registers) {
		stringList.add(register.getNome());
	}
	
	return stringList;
}


public static List<String> getDBTypes(){
	List<Register> registers = getImageList();
	
	List<String> stringList = new ArrayList<>();
	
	for(Register register : registers) {
		stringList.add(register.getTipo());
	}
	
	return stringList;
}

public static List<List<String>> getDBCards(){
	List<Register> registers = getImageList();
	
	List<List<String>> stringList = new ArrayList<>();
	
	for(Register register : registers) {
		List<String> cell = new ArrayList<>();
		cell.add(java.util.Base64.getEncoder().encodeToString(register.getDados().getData()));
		cell.add(register.getNome());
		cell.add(register.getTipo());
		stringList.add(cell);
	}
	
    return stringList;
}
	
}

  
	


