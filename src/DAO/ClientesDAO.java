/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConexaoSql;
import Dados.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author 277111
 */
public class ClientesDAO {
    
    private ConexaoSql conn;
    
    public ClientesDAO() {
        
        try{
            this.conn = new ConexaoSql();
        }
        
        catch(ClassNotFoundException ex){
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        catch(SQLException ex){
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean inserir(Clientes cli){
        try{
            String sql = "INSERT INTO clientes (cod, nome, cpf, telefone)VALUES(?,?,?)";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ps.setString(1,cli.getNome_cli());
            ps.setString(2,cli.getCpf_cli());
            ps.setString(3,cli.getTel_cli());
            
            ps.execute();
            
            this.conn.confirmar();
            return true;
        } 
        catch(Exception e){
            e.printStackTrace();
        }
            
            return false;        
    }
    
    public boolean alterar(Clientes cli){
        try{
            String sql ="UPDATE clientes set cod=?, nome=?, cpf=?, telefone=? WHERE id = ?";
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            
            ps.setString(1,cli.getNome_cli());
            ps.setString(2,cli.getCpf_cli());
            ps.setString(3,cli.getTel_cli());
            
            ps.executeUpdate();
            
            this.conn.confirmar();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
       public Clientes buscarPorCod(Integer cod){
        try{
            String sql ="SELECT * from clientes WHERE cod = " + cod;
            PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Clientes cli = new Clientes();
            
            while(rs.next()){
             cli.setNome_cli(rs.getString("Nome"));
             cli.setCpf_cli(rs.getString("CPF"));
             cli.setTel_cli(rs.getString("Telefone"));
             
            }
            
            return cli;    
            
        }
        
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
       
       public ArrayList<Clientes> buscarTodos(){
           try{
               String sql ="SELECT * from clientes";
               PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
               
               ArrayList<Clientes> arrayClientes = new ArrayList<>();
               
               
               while(rs.next()){
                   Clientes cli = new Clientes();
                   cli.setCod_cli("Cod");
                   cli.setNome_cli(rs.getString("Nome"));
                   cli.setCpf_cli(rs.getString("CPF"));
                   cli.setTel_cli(rs.getString("Telefone"));
               }
               
               return arrayClientes;
               
           }
           
           catch(Exception e){
               e.printStackTrace();
               return null;
           }
           
           
       }
       
       public boolean excluir(int codClienteExcluir){
           try{
               
               String sql = "DELETE from clientes WHERE cod" + codClienteExcluir+ "";
               System.out.println("sql");
               PreparedStatement ps = this.conn.getConexao().prepareStatement(sql);
               ps.executeUpdate();
               this.conn.confirmar();
               return true;
           }
           
           catch(Exception e){
               e.printStackTrace();
               return false;
               
           }
       }
    
}


