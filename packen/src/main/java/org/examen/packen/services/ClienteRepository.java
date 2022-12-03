package org.examen.packen.services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.examen.packen.configs.Conexion;
import org.examen.packen.models.Cliente;

public class ClienteRepository {

    public List<Cliente> getAllClientes () {  
        List<Cliente> lista = new ArrayList<>();
        String consulta = "SELECT * FROM Cliente";
        try (
            Statement statement = Conexion.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
        ) {
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                crearClienteConElResultSet(resultSet, cliente);
                lista.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cliente getClienteByCedula (String cedula) {  
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM Cliente where Cedula_Clie = ?";
        try (
            PreparedStatement preparedStatement= Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, cedula);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                crearClienteConElResultSet(resultSet, cliente);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public List<Cliente> getClientesListaByCedulaYEmail (String cedula, String correo) {  
        List<Cliente> lista = new ArrayList<>();
        String consulta = "SELECT * FROM Cliente where Cedula_Clie = ? OR Correo_Clie = ?";
        try (
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, cedula);
            preparedStatement.setString(2, correo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                crearClienteConElResultSet(resultSet, cliente);
                lista.add(cliente);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Cliente getClienteByPassYEmail (String contra, String correo) {  
        Cliente cliente = new Cliente();
        String consulta = "SELECT * FROM Cliente where Contra = ? and Correo_Clie = ?";
        try (
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, contra);
            preparedStatement.setString(2, correo);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                crearClienteConElResultSet(resultSet, cliente);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public void setCliente (Cliente cliente){
        String consulta = "Insert into Cliente values (?,?,?,?,?,?)";
        try (
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, cliente.getCedula());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setString(5, cliente.getCorreo());
            preparedStatement.setString(6, cliente.getContra());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateCliente (Cliente cliente){
        String consulta = "update Cliente set Nombre_Clie = ?, Apellido_Clie = ?, Direc_Clie = ? where Cedula_Clie = ?";
        try (
            PreparedStatement preparedStatement = Conexion.getConexion().prepareStatement(consulta);
        ) {
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getCedula());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void crearClienteConElResultSet (ResultSet resultSet, Cliente cliente) throws SQLException{
        cliente.setNombre(resultSet.getString("Nombre_Clie").trim());
        cliente.setApellido(resultSet.getString("Apellido_Clie").trim());
        cliente.setCedula(resultSet.getString("Cedula_Clie"));
        cliente.setDireccion(resultSet.getString("Direc_Clie"));
        cliente.setCorreo(resultSet.getString("Correo_Clie"));
        cliente.setContra(resultSet.getString("Contra"));
    }
}