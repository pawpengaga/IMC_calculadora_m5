package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;
import modelo.UsuarioDAO;

import java.io.IOException;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
  private UsuarioDAO userDAO = new UsuarioDAO();     

	public UsuarioServlet() {
			super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion");
		if ("registrar".equals(accion)) {
			
			String nombre = request.getParameter("nombre");
			String correo = request.getParameter("correo");
			String clave = request.getParameter("clave");

			try {
				if (userDAO.registrarUsuario(new Usuario(nombre, clave, correo))) {
					request.setAttribute("mensaje", "Usuario registrado");
				} else {
					request.setAttribute("mensaje", "Error al registrar usuario");
				}
				request.getRequestDispatcher("pantalla.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("login".equals(accion)) {
			
			// Tal como lo vio en login.jsp
			String correo = request.getParameter("usuario");
			String clave = request.getParameter("clave");

			try {
				Usuario usr = userDAO.esUsuarioValido(correo, clave);
				if (usr != null) {
					HttpSession session = request.getSession();
					session.setAttribute("usuario", usr.getNombre()); // Tengo dudas.
					response.sendRedirect("");
				} else {
					request.setAttribute("error", "Usuario o clave invalida!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				request.setAttribute("error", "Error: " + e.getMessage());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
