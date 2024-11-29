package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.IMCResultado;
import modelo.IMCResultadoDAO;
import modelo.Usuario;

import java.io.IOException;

/**
 * Servlet implementation class ImcServlet
 */
@WebServlet("/ImcServlet")
public class ImcServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IMCResultadoDAO imcDAO = new IMCResultadoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImcServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("imc.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userId = Integer.parseInt(request.getParameter("userId"));
		float peso = Float.parseFloat(request.getParameter("peso"));
		float altura = Float.parseFloat(request.getParameter("altura"));

		IMCResultado imc = new IMCResultado(userId, peso, altura);
		try {
			if (imcDAO.grabarIMC(imc)) {
				request.setAttribute("mensaje", "IMC Registrado! Valor: " + imc.getImc());
				// Manejar aqui una redireccion a una tabla o algo de IMC
			} else {
				request.setAttribute("mensaje", "Error al registrar...");
			}
			request.getRequestDispatcher("imc.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
