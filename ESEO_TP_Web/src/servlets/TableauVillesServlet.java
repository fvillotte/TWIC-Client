package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import classes.Ville;

/**
 * Servlet implementation class TableauVillesServlet
 */
@WebServlet("/TableauVillesServlet")
public class TableauVillesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TableauVillesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpResponse<JsonNode> reponse = null;
		List<Ville> listeVilles = new ArrayList<Ville>();
		JSONObject json = null;
		JsonNode node = null;
		try {
			reponse = Unirest.get("http://localhost:8080/ville").asJson();
			node = reponse.getBody();

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int taille = node.getArray().length();
		Ville[] v = new Ville[taille];
		for(int i=0; i<node.getArray().length(); i++) {
			v[i] = new Ville((node.getArray().getJSONObject(i)).opt("codeCommune").toString(), 
					(node.getArray().getJSONObject(i)).opt("nomCommune").toString(), 
					(node.getArray().getJSONObject(i)).opt("codePostal").toString(), 
					(node.getArray().getJSONObject(i)).opt("libelleAcheminement").toString(),
					(node.getArray().getJSONObject(i)).opt("ligne_5").toString(), 
					(node.getArray().getJSONObject(i)).opt("latitude").toString(), 
					(node.getArray().getJSONObject(i)).opt("longitude").toString());
		}
		for(int i=0; i<taille; i++) {
			listeVilles.add(v[i]);
		}
		
		request.setAttribute("ListeVillesFrance", listeVilles);
		
		RequestDispatcher dispat = request.getRequestDispatcher("jsp/VisualiserTableauVilles.jsp");
		dispat.forward(request, response);
	}

}
