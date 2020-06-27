package com.example.rest.util;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaDB {

        public Connection getAcceso() throws Exception {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://node226715-env-2872065.j.layershift.co.uk/rest?serverTimezone=UTC","root","HFOrio35321");
        	
        	//
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rest?serverTimezone=UTC","root","");//mysql
        	Connection conn = DriverManager.getConnection("jdbc:mysql://node226719-env-7012674.j.layershift.co.uk/rest?serverTimezone=UTC","root","OCCgaf40787");
        return conn;
    }
}
