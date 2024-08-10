package pack;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import javax.swing.JOptionPane;

import org.bson.Document;
import org.bson.json.JsonWriterSettings;


public class insertServlet extends HttpServlet {
	
	 public static byte[] readImageAsBytes(String imagePath) throws IOException {
	        Path path = Paths.get(imagePath);
	        return Files.readAllBytes(path);
	    }
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter writer = response.getWriter();	
			
			InputStream inputStream = request.getPart("pokeimage").getInputStream();
				
			MongoClient client = new MongoClient("localhost", 27017);
			
			MongoDatabase pokedexdb = client.getDatabase("pokedexdb");
			
			MongoCollection<Document> pokemons = pokedexdb.getCollection("pokemons");
			
			Document pokename = new Document("nome",request.getParameter("pokename"));
			
			//byte[] imageData = insertServlet.readImageAsBytes(request.getParameter("pokeimage"));
			
			//Document pokeimage = new Document("imagem", inputStream.readAllBytes());
			
			if(pokemons.find(pokename).first() != null) {
				writer.println("ESTES VALORES SAO INVALIDOS");
				response.setContentType("text/html");
				writer = response.getWriter();
				writer.println("<a href='C:\\Users\\Pichau\\eclipse-workspace\\Pokedex\\src\\main\\webapp\\insertPage.jsp'>UUUUUuU</a>");
				writer.close();
				client.close();
				return;
			}
			
			pokemons.insertOne(new Document("nome",request.getParameter("pokename")).append("tipo",request.getParameter("poketype")).append("imagem",inputStream.readAllBytes()));
			
			/*
			AggregateIterable<Document> aggregationResult = pokemons.aggregate(Arrays.asList(
	                // Estágios de agregação aqui
	                // Excluir o campo especificado dos documentos
	                Aggregates.project(Projections.fields(
	                        Projections.excludeId(), // Excluir o campo "_id"
	                        Projections.exclude("id")
	                ))
	        ));
			
			//MongoCursor<Document> cursor = pokemons.find().iterator();
			
			MongoCursor<Document> cursor = aggregationResult.iterator();
			
			JsonWriterSettings jsonWriterSettings = JsonWriterSettings.builder().indent(true).build();
			
			while(cursor.hasNext()) {
				writer.println(cursor.next().toJson(jsonWriterSettings));
			}
			
			*/
			
			
			response.sendRedirect("insertPage.jsp");
			writer.close();
			client.close();
			}catch(MongoException ex) {
				ex.printStackTrace();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
	}
	
	

}
