package org.examen.packen.services;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.examen.packen.configs.Conexion;
import org.examen.packen.models.Nosotros;

public class NosotrosRepository{

    public List<Nosotros> getAllNosotros(){
        List<Nosotros> lista = new ArrayList<>();
        String consulta = "select * from nosotros";
        try (
            Statement statement = Conexion.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
        ){
            while (resultSet.next()) {
                Nosotros nosotros = new Nosotros();
                crearNosotros(resultSet,nosotros);
                lista.add(nosotros);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private void crearNosotros (ResultSet resultset, Nosotros nosotros)throws SQLException{
        nosotros.setDescrip(resultset.getString("descrip"));
        nosotros.setFoto(resultset.getString("foto"));
    }

}