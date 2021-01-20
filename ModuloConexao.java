/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhiego
 */
public class ModuloConexao {
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        String DRIVER = "com.mysql.jdbc.Driver";//Chama o driver jdbc
        //armazenando informações referente ao banco
        String URL = "jdbc:mysql://localhost:3306/banco";
        String USER = "root";
        String PASS = "";
        //Estabelecendo conexão com o BD.
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
           
            
            return conexao;
            
            
            
        } catch (Exception e) {
            //System.out.println(e);
           
               
               
                return null;
              
           }
 
            
        }
        
        
        
        
        
        
        
        
        
    }
    
    

