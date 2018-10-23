package ado;

import base.ConnectionDAO;
import base.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

/**
 *
 * @author ellias
 */
public class CategoriaADO implements DAO {
    
    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List listaTodos() throws Exception {
        
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Categoria> listaCategoria = new ArrayList<>();
        
        try {
            
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT * FROM categoria");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                listaCategoria.add(new Categoria(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        
        return listaCategoria;
        
    }
    
    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
