package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashape.unirest.http.Unirest;

import classes.Ville;

/**
 * Servlet implementation class ModifierVilleServlet
 */
@WebServlet("/ModifierVilleServlet")
public class ModifierVilleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierVilleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomCommune = request.getParameter("nomCommuneT");
		String codeCommune = request.getParameter("codeCommuneT");
		String codePostal = request.getParameter("codePostalT");
		String libelleAcheminement = request.getParameter("libelleAcheminementT");
		String ligne_5 = request.getParameter("ligne_5T");
		String longitude = request.getParameter("longitudeT");
		String latitude = request.getParameter("latitudeT");
		
		Ville ville = new Ville(codeCommune, nomCommune, codePostal, libelleAcheminement,
			ligne_5, latitude, longitude);
		
		String codeCommuneIni = request.getParameter("codeCommuneIni");
		
		Unirest.put("http://localhost:8080/ville");
		
		
		RequestDispatcher dispat = request.getRequestDispatcher("index.html");
		dispat.forward(request, response);
	}

}
