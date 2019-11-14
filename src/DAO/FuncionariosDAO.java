/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConexaoSql;
import Dados.Funcionarios;
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
public class FuncionariosDAO {
    
    private ConexaoSql conn;
    
    public FuncionariosDAO() {
        
        try {
            this.conn=new ConexaoSql();
        } 
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(FuncionariosDAO.class.getName()).log(Level.SEVERE,null,ex);
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(FuncionariosDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    public boolean inserir(Funcionarios func) {
        try {
            String sql="INSERT INTO funcionarios (nome_func,cpf_func,tel_func)VALUES (?,?,?)";
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            ps.setString(1,func.getNome_func());
            ps.setString(2,func.getCpf_func());
            ps.setString(3,func.getTel_func());
            ps.execute();
            this.conn.confirmar();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean alterar(Funcionarios func) {
        try {
            String sql="UPDATE funcionrios set nome_func=?,cpf_func=?,tel_func=? WHERE cod_func=?";
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            ps.setString(1,func.getNome_func());
            ps.setString(2,func.getCpf_func());
            ps.setString(3,func.getTel_func());
            ps.setInt(4,func.getCod_func());
            ps.executeUpdate();
            this.conn.confirmar();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Funcionarios buscarPorCod(Integer cod_func) {
        try {
            String sql="SELECT * from funcionarios WHERE cod_func="+cod_func;
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            Funcionarios f=new Funcionarios();
            while(rs.next()) {
                f.setNome_func(rs.getString("nome"));
                f.setCpf_func(rs.getString("cpf"));
                f.setTel_func(rs.getString("telefone"));
            }
            return f;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ArrayList<Funcionarios> buscarTodos() {
        try {
            String sql="SELECT * from funcionarios";
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            ArrayList<Funcionarios>arrayFuncionarios=new ArrayList<>();
            while(rs.next()) {
                Funcionarios f=new Funcionarios();
                f.setCod_func(rs.getInt("cod"));
                f.setNome_func(rs.getString("nome"));
                f.setCpf_func(rs.getString("cpf"));
                f.setTel_func(rs.getString("telefone"));
                arrayFuncionarios.add(f);
            }
            return arrayFuncionarios;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean excluir(int codFuncionariosExcluir) {
        try {
            String sql="DELETE from funcionarios WHERE id="+codFuncionariosExcluir+"";
            System.out.println(sql);
            PreparedStatement ps=this.conn.getConexao().prepareStatement(sql);
            ps.executeUpdate();
            this.conn.confirmar();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
