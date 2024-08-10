package pack;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import jakarta.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;


public class Connect {
	
	public static MongoClient getConnection() {
		
		return new MongoClient("localhost", 27017);
		
	}
	
	public static MongoDatabase getDatabase() {
		
		MongoClient client = Connect.getConnection();
		
		return client.getDatabase("pokedexdb");
		
		
	}
	
	public static MongoCollection<Document> getPokemons(){
	
		return Connect.getDatabase().getCollection("pokemons");
		
	}
	
	public static MongoCursor<Document> getPokeCursor(){
		
		return getPokemons().find().iterator();
		
	}
	
	
	public void getNextPokemon(HttpServletResponse response,MongoCursor cursor){
		
		// PrintWriter writer = response.
		
	}
	
	public void getPreviousPokemon(MongoCursor cursor){
		
	}
	
	

}
