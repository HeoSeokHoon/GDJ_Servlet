package com.forest.app.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.forest.app.Regions.RegionDAO;
import com.forest.app.Regions.RegionDTO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String contextPath = request.getContextPath();
//		System.out.println("Context : "+contextPath);
//		
//		String method = request.getMethod();
//		System.out.println("method : "+method);
//		
//		String pathinfo = request.getPathInfo();
//		System.out.println("pathinfo : "+pathinfo);
//		
//		String url = request.getRequestURL();
//		System.out.println(names.length);
//		for(int i=0;i<names.length;i++) {
//			System.out.println(names[i]);
//		}
//		
//		System.out.println("uri : "+uri);
//		System.out.println("url : "+url);
		String uri = request.getRequestURI();
		String [] names = uri.split("/");
		System.out.println(names.length);
		
		String v = "/WEB-INF/Views/index.jsp";
		try {
			if(names[1].equals("regions")) {
				//regionDAO 사용
				RegionDAO rDao = new RegionDAO();
				if(names[2].equals("list")) {
					List<RegionDTO> ar = rDao.getList();
					request.setAttribute("list", ar);
					v = "/WEB-INF/Views/Regions/List.jsp";
				}else if(names[2].equals("detail")) {
					String id = request.getParameter("region_id");
					RegionDTO rD = new RegionDTO();
					rD.setRegion_id(Integer.parseInt(id));
					rD = rDao.getDetail(rD);
					request.setAttribute("detail", rD);
					v = "/WEB-INF/Views/Regions/Detail.jsp";
				}
				
			}else if(names[1].equals("countries")) {
				//countriesDAO 사용
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(v);
		view.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
