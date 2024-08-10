package pack;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.Binary;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class getImages extends HttpServlet {

    private ArrayList<Register> getImageList() {

        ArrayList<Register> registers = new ArrayList<>();

        try {

            MongoClient client = new MongoClient("localhost", 27017);

            MongoDatabase db = client.getDatabase("pokedexdb");

            MongoCollection<Document> pokemons = db.getCollection("pokemons");

            FindIterable<Document> doc = pokemons.find();

            MongoCursor<Document> cursor = doc.iterator();

            while (cursor.hasNext()) {

                Document current = cursor.next();

                registers.add(new Register(current.get("nome", String.class),current.get("tipo", String.class),current.get("imagem", Binary.class)));

            }

        } catch (MongoClientException ex) {
            ex.printStackTrace();
        } catch (MongoException ex) {
            ex.printStackTrace();
        }
        return registers;
    }

    private String converterParaBase64(byte[] dados) {

        return java.util.Base64.getEncoder().encodeToString(dados);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<Register> registers = getImageList();

        response.setContentType("text/html");

        try {
            response.getWriter().println("<html><head><title>Catálogo de Imagens</title>");
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
                response.getWriter().println("<img class=\"card-img-top\" src='data:image/png;base64," + converterParaBase64(dadosImagem) + "' alt='Imagem do Pokémon'>");
                response.getWriter().println("<div class=\"card-body\">");
                response.getWriter().println("<h5 class=\"card-title\">" + register.getNome() + "</h5>");
                response.getWriter().println("</div></div></div>");
            }

            // Feche a linha
            response.getWriter().println("</div>");

            response.getWriter().println("</div>");
            response.getWriter().println("</body></html>");
        } catch (Exception e) {
            throw new ServletException("Erro ao gerar a resposta HTML", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}