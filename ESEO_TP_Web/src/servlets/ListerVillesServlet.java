package servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import classes.Ville;

import com.mashape.unirest.http.JsonNode;
import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;

/**
 * Servlet implementation class ListerVillesServlet
 */
@WebServlet("/ListerVillesServlet")
public class ListerVillesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerVillesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpResponse<JsonNode> reponse = null;
		List<String> listeVilles = new ArrayList<String>();
		JSONObject json = null;
		JsonNode node = null;
		try {
			reponse = Unirest.get("http://localhost:8080/ville").asJson();
			node = reponse.getBody();

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<node.getArray().length(); i++) {
			json = node.getArray().getJSONObject(i);
			listeVilles.add((json.opt("nomCommune")).toString());
		}
		
		Collections.sort(listeVilles);
		
		
		request.setAttribute("ListeVillesFrance", listeVilles);
		
		RequestDispatcher dispat = request.getRequestDispatcher("jsp/VisualiserVilles.jsp");
		dispat.forward(request, response);
	}

}
