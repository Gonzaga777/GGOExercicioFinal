package controller;

import java.io.IOException;




import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAO;
import model.Veiculos;

/**
 * Servlet implementation class CRUDController
 */
@WebServlet("/ServletVeiculos")
public class ServletVeiculos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAO cont;       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVeiculos() {
    	super();
        // TODO Auto-generated constructor stub
        this.cont = new DAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String option = request.getParameter("option");
		if (option == null) {
			option = "qualquer coisa";
		}
		switch(option) {
			case ("insertForm"):
				showInsertVeiculos(request, response);
			break;
			case ("updateForm"):
				showUpdateVeiculos(request, response);
			break;
			case ("update"):
				updateVeiculos(request, response);
			break;
			case ("delete"):
				deleteVeiculos(request, response);
			break;
			case ("insert"):
				insertVeiculos(request, response);
			break;
			default:
				selectAllVeiculos(request, response);
		}
	}
	
	private void showInsertVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("cod_veiculo"));
		Veiculos u = this.cont.buscarVeiculo(id);
		request.setAttribute("veiculo", u);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void insertVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nomeVeiculoBack = request.getParameter("nome_veiculo");
		String marca = request.getParameter("marca");
		Integer ano = Integer.parseInt(request.getParameter("ano_veiculo"));
		if ((nomeVeiculoBack != null) && (marca != null) && (ano != null)) {
			if (!nomeVeiculoBack.equals("")){
				Veiculos veiculo = new Veiculos(nomeVeiculoBack, marca, ano);
				this.cont.adicionarVeiculo(veiculo);
			}
		}
		response.sendRedirect("ServletVeiculos");
	}
	
	private void selectAllVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println(this.cont.selectAll());
		request.setAttribute("listVeic", this.cont.exibirVeiculos());
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	private void deleteVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("cod_veiculo");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.cont.deletarVeiculos(id);
		}
		response.sendRedirect("ServletVeiculos");
	}
	
	private void updateVeiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeVeiculoBack = request.getParameter("nome_veiculo");
		String marcaBack = request.getParameter("marca");
		String anoVeiculoBack = request.getParameter("ano_veiculo");
		String idBack = request.getParameter("cod_veiculo");
		if ((nomeVeiculoBack != null) && (marcaBack != null) && (anoVeiculoBack != null) && (idBack != null)) {
			if (!nomeVeiculoBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Integer anoVeiculoBack1= Integer.parseInt(anoVeiculoBack);
				Veiculos veiculo = new Veiculos(nomeVeiculoBack,marcaBack , anoVeiculoBack1);
				veiculo.setCod_veiculo(id);;
				this.cont.AtualizarVeiculos(veiculo);
			}
		}
		response.sendRedirect("ServletVeiculos");
	}
	
}
