package com.sathya.servlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sathya.servelt.Product;

public class ProductDao {
	//insert into table
	
		public int save(Product product)
		{
			 Connection connection=null;
			  PreparedStatement preparedStatement=null;
			  int count=0;
			  try {
				  //Get the connection

				 connection=DatabaseUtils.createconnection();
				 preparedStatement=connection.prepareStatement("insert into product_data values(?,?,?,?,?,?,?,?)");
			
				preparedStatement.setString(1,product.getProId());
				preparedStatement.setString(2,product.getProName());
				
				preparedStatement.setDouble(3,product.getProPrice());
				preparedStatement.setString(4,product.getProBrand());
				preparedStatement.setString(5,product.getProMadeIn());
				
				preparedStatement.setDate(6, product.getProMfgDate());
				preparedStatement.setDate(7, product.getProExpDate());
				
				preparedStatement.setBytes(8,product.getProImage());
							
				count=preparedStatement.executeUpdate();
			}
			catch(SQLException e) {
				  e.printStackTrace();
				  
			  }
			  finally {
				  //before release connection check the connection present or not
				  try{
					  
				     if(connection!=null)
					  connection.close();
				     if(preparedStatement!=null)
						  preparedStatement.close();
			        }
				  catch(SQLException e) {
					  e.printStackTrace();
				  }
			  }
			return count;
			
				
		}
		public List<Product> findAll() {
			
			// Create the list to store group of records
		    List<Product> productList=new ArrayList<Product>();
		    try(Connection connection =DatabaseUtils.createconnection();
		    	Statement statement =connection.createStatement();	){
		    	//execute the query to store the resultSet                                                                                
		    	ResultSet resultSet=statement.executeQuery("select * from product_data");
		    	while(resultSet.next()) {
		    		Product product=new Product();
		    		  product.setProId(resultSet.getString("proId"));
		    		  product.setProName(resultSet.getString("proName"));
		    		  product.setProPrice(resultSet.getDouble("proPrice"));
		    		  product.setProBrand(resultSet.getString("proBrand"));
		    		  product.setProMadeIn(resultSet.getString("proMadeIn"));
		    		  product.setProMfgDate(resultSet.getDate("proMfgDate"));
		    		  product.setProExpDate(resultSet.getDate("proExpDate"));
		    		 product.setProImage(resultSet.getBytes("proImage"));
		    		 
		    		  productList.add(product);
		    	
		    	}
		    }
		    	catch(SQLException e) {
		    		e.printStackTrace();
		    	}
		    	
		    
		    return productList;
		    }

	}