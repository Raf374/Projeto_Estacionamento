//Classe acesso aos dados
package Estacionamento;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author 374 */
public class CarroDAO {

    //Variavel para acesso a conexão
    private Connection con;

    public CarroDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    //Método inserir
    public String inserirCarro(CarroBean carro) {
        String sql = "insert into tbcarro(placa,cor,descricao)values(?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            //Inserindo valores bd
            ps.setString(1, carro.getPlaca());
            ps.setString(2, carro.getCor());
            ps.setString(3, carro.getDescricao());

            if (ps.executeLargeUpdate() > 0) {
                return "Inserido com sucesso!";
            } else {
                return "Falha ao inserir!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    //Método update
    public String alterarCarro(CarroBean carro) {
        //Alterando registros bd
        String sql = "update tbcarro set cor= ?, descricao=? where placa= ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, carro.getCor());
            ps.setString(2, carro.getDescricao());
            ps.setString(3, carro.getPlaca());
            if (ps.executeUpdate() > 0) {
                return "Alterado com sucesso!";
            }else{
                return "Falha ao alterar!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }
    
    //Método apagar
    public String ecluirCarro(CarroBean carro){
        //Apagando carro bd
        String sql="delete from tbcarro where placa=?";
        try {
            PreparedStatement ps= getCon().prepareStatement(sql);
            ps.setString(1, carro.getPlaca());
            if(ps.executeUpdate()>0){
                return "Deletado com sucesso!";
            }else{
                return "Falaha ao deletar!";
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }
        
    }
    //Método select
}
