package com.sathya.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.sathya.servelt.Product;


@WebServlet("/AddProductServlet")
@MultipartConfig
public class AddProductServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Read the Data	
	String proId =request.getParameter("proId");
	String proName =request.getParameter("proName");
	double proPrice =Double.parseDouble(request.getParameter("proPrice"));
	String proBrand =request.getParameter("proBrand"); 
	
	String proMadeIn =request.getParameter("proMadeIn");
	Date proMfgDate =Date.valueOf(request.getParameter("proMfgDate"));
	Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
	
	Part part=request.getPart("proImage");
	InputStream inputStream=part.getInputStream();
	// conversion of inputStream into byte[]
	byte[] proImage=IOUtils.toByteArray(inputStream);
	
	
	//Using above Details create the Product Object
	Product product =new Product();
	product.setProId(proId);
	product.setProName(proName);
	product.setProPrice(proPrice);
	product.setProBrand(proBrand);
	product.setProMadeIn(proMadeIn);  
	product.setProMfgDate(proMfgDate);
	product.setProExpDate(proExpDate);
	product.setProImage(proImage);
	
     // Giving the Product object to DAO layer
	ProductDao productDao=new ProductDao();
	int result=productDao.save(product);
	
	response.setContentType("text/html");
	PrintWriter writer =response.getWriter();
	writer.println("Data Inserted sucessfully..."+result);
	}

}