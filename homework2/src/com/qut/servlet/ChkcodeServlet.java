package com.qut.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/ChkcodeServlet")
public class ChkcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChkcodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width = 80;
		int height = 30;
		
		BufferedImage image= new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		
		Graphics g = image.getGraphics();
		
		g.setColor(Color.BLUE);
		
		g.fillRect(0, 0, width, height);
		
//		ImageIO.write(image, "jpeg", response.getOutputStream());		
		
		String[] codes = {"0","1","2","3","4","5","6","7","8","9"};
		StringBuilder sb = new StringBuilder();
		Random r = new Random();
		
		g.setColor(Color.WHITE);
		
		for(int i=0; i<4; i++) {
			int n = r.nextInt(10);
			String code = codes[n];
			g.drawString(code, 20*i, 15);
			sb.append(code);
		}
		
		request.getSession().setAttribute("checkcode", sb.toString());
		
		response.setContentType("image/jpeg");	
		
		response.setDateHeader("expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		
		ImageIO.write(image, "jpeg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
