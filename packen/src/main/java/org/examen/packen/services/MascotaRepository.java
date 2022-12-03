package org.examen.packen.services;

import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.examen.packen.configs.Conexion;
import org.examen.packen.models.Mascota;

public class MascotaRepository {
    

    public List<Mascota> getAllMascotas() {
        String consulta = "EXEC selectDeMascotas";
        List<Mascota> lista = new ArrayList<>();
        try (
            Statement statement = Conexion.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
        ) {
            while (resultSet.next()) {
                Mascota mascota = new Mascota();
                crearMascota(resultSet, mascota);
                lista.add(mascota);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }



    public List<Mascota> getMascotasByCedulaCli (String cedula) {  
        List<Mascota> lista = new ArrayList<>();
        String consulta = "EXEC selectDeMascotasByCedulaCliente ?";
        try (
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, cedula);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mascota mascota = new Mascota();
                crearMascota(resultSet, mascota);
                lista.add(mascota);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }



    public List<Mascota> getMascotasByNombre (String nombre) {  
        List<Mascota> lista = new ArrayList<>();
        String consulta = "EXEC selectDeMascotasBusqueda ?";
        try (
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mascota mascota = new Mascota();
                crearMascota(resultSet, mascota);
                lista.add(mascota);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }


    private void crearMascota (ResultSet resultSet, Mascota mascota) throws SQLException {
        mascota.setNombre(resultSet.getString("Nombre"));
        mascota.setCodmascota(resultSet.getString("Cod_Mascota"));
        mascota.setPeso(resultSet.getDouble("Peso_kg"));
        mascota.setFecha(resultSet.getString("Fecha_Nac"));
        mascota.setGenero(resultSet.getString("Genero").trim());
        mascota.setRaza(resultSet.getString("Raza").trim());
        mascota.setCedulacli(resultSet.getString("Cedula_propie"));
    }
}