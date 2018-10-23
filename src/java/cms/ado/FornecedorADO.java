/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cms.ado;

import base.ConnectionDAO;
import base.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Fornecedor;

/**
 *
 * @author ellias
 */
public class FornecedorADO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {

        Fornecedor forn = (Fornecedor) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = ConnectionDAO.getConnection();
            String SQL = "UPDATE fornecedor SET fornecedorNm= ?, fornecedorEnd=?, fornecedorTel=? WHERE idFornecedor=?";
            ps = conn.prepareStatement(SQL);
            ps.setString(1, forn.getFornecedorNm());
            ps.setString(2, forn.getFornecedorEnd());
            ps.setString(3, forn.getFornecedorTel());
            ps.setInt(4, forn.getIdFornecedor());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Não foi possivel atualizar!");
            }

        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }

    }

    @Override
    public void excluir(Object ob) throws Exception {

        Fornecedor fornecedor = (Fornecedor) ob;

        if (fornecedor != null) {

            PreparedStatement ps = null;
            Connection conn = null;
            ResultSet rs = null;

            try {
                conn = ConnectionDAO.getConnection();
                String SQL1 = "DELETE FROM fornecedor WHERE idFornecedor = ? ;";
                ps = conn.prepareStatement(SQL1, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, fornecedor.getIdFornecedor());

                int affectedRows = ps.executeUpdate();
                if (affectedRows == 0) {
                    throw new Exception("Não foi Possivel excluir!");
                }

            } catch (SQLException sqle) {
                throw new Exception("Erro ao excluir registro! \n Registro passado é nulo!");

            } finally {
                ConnectionDAO.closeConnection(conn, ps);
            }

        }
    }

    @Override
    public List listaTodos() throws Exception {

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Fornecedor> listaFornecedor = new ArrayList<>();

        try {

            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT * FROM fornecedor");
            rs = ps.executeQuery();

            while (rs.next()) {
                listaFornecedor.add(new Fornecedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }

        return listaFornecedor;
    }

    @Override
    public List procura(Object ob) throws Exception {

        Fornecedor forn = (Fornecedor) ob;

        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<Fornecedor> fornecedor = new ArrayList<>();
        try {
            String SQL = "Select * from fornecedor where idFornecedor = ?";

            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, forn.getIdFornecedor());
            rs = ps.executeQuery();

            while (rs.next()) {
               
                int idFornecedor = rs.getInt(1);
                String nomeFornecedor = rs.getString(2);
                String enderecoFornecedor = rs.getString(3);
                String telefoneFornecedor = rs.getString(4);
                Fornecedor f = new Fornecedor(idFornecedor, nomeFornecedor, enderecoFornecedor, telefoneFornecedor);
                fornecedor.add(f);
            }
        } catch (SQLException sqle) {
            throw new Exception("Erro ao consultar dados do fornecedor: \n" + sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
        return fornecedor;
    }

    @Override
    public void salvar(Object ob) throws Exception {

        Fornecedor p = (Fornecedor) ob;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionDAO.getConnection();

            String sql = "INSERT INTO fornecedor( `idFornecedor`, `fornecedorNm`, `fornecedorEnd`, `fornecedorTel`)" + "values( ?, ?, ?, ?)";

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, 0);
            ps.setString(2, p.getFornecedorNm());
            ps.setString(3, p.getFornecedorEnd());
            ps.setString(4, p.getFornecedorTel());
            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }

        } catch (SQLException sqle) {

            throw new Exception("Erro ao incluir registro!");

        } finally {

            ConnectionDAO.closeConnection(conn, ps);
        }
    }

}
