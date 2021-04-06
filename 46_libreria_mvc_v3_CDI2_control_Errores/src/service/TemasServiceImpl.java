
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import excepciones.ErrorConexionException;
import model.Tema;
//AGREGAR EL ARCHIVO beans.xml !!! !!! !!! !! !!!  CDI  solo valido desde JAVA EE 7
@Named("temasService")
@RequestScoped
 public class TemasServiceImpl implements TemasService {
	 
 
    @Override
	public List<Tema> obtenerTemas() throws ErrorConexionException{
        List<Tema> lista=new ArrayList<> ();
           
        try(Connection cn=DatosLocator.getConnection()) {                       
            String sql="select * from temas";
            Statement st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);            
            while(rs.next()){
                lista.add(new Tema(rs.getInt("idTema"),rs.getString("tema")));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
            throw new ErrorConexionException(ex.getMessage());
        }   
        return lista;
    }

	@Override
	public Tema recuperarTemaPorId(int idTema) throws ErrorConexionException{
		Tema tema=null;
        
        try(Connection cn=DatosLocator.getConnection()) {                       
            String sql="select * from temas where idTema=?";
            PreparedStatement st=cn.prepareStatement(sql);
            st.setInt(1, idTema);
            ResultSet rs=st.executeQuery();            
            if(rs.next()){
                tema=new Tema(rs.getInt("idTema"),rs.getString("tema"));
            }
        }  catch (SQLException ex) {
            ex.printStackTrace();
            throw new ErrorConexionException(ex.getMessage());
        }   
        return tema;
	}
}
