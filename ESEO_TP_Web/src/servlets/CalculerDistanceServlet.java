package servlets;

import java.io.IOException;
import java.text.DecimalFormat;
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
 * Servlet implementation class CalculerDistanceServlet
 */
@WebServlet("/CalculerDistanceServlet")
public class CalculerDistanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculerDistanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nomCommune1 = request.getParameter("ville1");
		String nomCommune2 = request.getParameter("ville2");
		
		
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
		
		Ville ville1 = null;
		Ville ville2 = null;
		for(Ville ville : listeVilles) {
			if(ville.getNomCommune().equals(nomCommune1)) {
				ville1 = ville;
			}
			if(ville.getNomCommune().equals(nomCommune2)) {
				ville2 = ville;
			}
		}
		
		Double longitude1 = Double.parseDouble(ville1.getLongitude());
		Double latitude1 = Double.parseDouble(ville1.getLatitude());
		Double longitude2 = Double.parseDouble(ville2.getLongitude());
		Double latitude2 = Double.parseDouble(ville2.getLatitude());
		
		Double distance = null;
		
		distance = Math.acos(Math.sin(Math.toRadians(longitude1))*Math.sin(Math.toRadians(longitude2))
				+Math.cos(Math.toRadians(longitude1))*Math.cos(Math.toRadians(longitude2))*Math.cos(Math.toRadians(latitude1-latitude2)))*6371;
		
		String masque = new String("#0.##"); 
		DecimalFormat form = new DecimalFormat(masque);
		
		
		request.setAttribute("Ville1", ville1.getNomCommune());
		request.setAttribute("Ville2", ville2.getNomCommune());
		request.setAttribute("Distance", form.format(distance));
		
		RequestDispatcher dispat = request.getRequestDispatcher("jsp/VisualiserDistanceVilles.jsp");
		dispat.forward(request, response);
		
	}

}
