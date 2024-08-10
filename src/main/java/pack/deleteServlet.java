package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import org.bson.Document;
import org.bson.json.JsonWriterSettings;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Projections;

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter writer = response.getWriter();	
				
			MongoClient client = new MongoClient("localhost", 27017);
			
			MongoDatabase pokedexdb = client.getDatabase("pokedexdb");
			
			MongoCollection<Document> pokemons = pokedexdb.getCollection("pokemons");
			
			pokemons.deleteOne(new Document("nome",request.getParameter("pokename")));
			
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
			
			response.sendRedirect("deletePage.jsp");
			writer.close();
			client.close();
			}catch(MongoException ex) {
				ex.printStackTrace();
			}catch(IOException ex) {
				ex.printStackTrace();
			} 
		//PrintWriter writer = response.getWriter();
		//writer.println("TESTE");
	}

}
