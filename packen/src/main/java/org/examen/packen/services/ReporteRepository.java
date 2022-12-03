package org.examen.packen.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.examen.packen.configs.Conexion;
import org.examen.packen.models.Reporte;

public class ReporteRepository{

    public List<Reporte> getAllReporte() {
        String consulta = "EXEC P_busqueda";
        List<Reporte> lista = new ArrayList<>();
        try (
            Statement statement = Conexion.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(consulta);
        ) {
            while (resultSet.next()) {
                Reporte reporte = new Reporte();
                crearReporte(resultSet, reporte);
                lista.add(reporte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    private void crearReporte (ResultSet resultSet, Reporte reporte) throws SQLException {
        reporte.setServicios(resultSet.getString("sercicios"));
        reporte.setNombremascota(resultSet.getString("Nombre"));
        reporte.setNombreclie(resultSet.getString("Nombre_Clie"));
        reporte.setFecha(resultSet.getString("Fecha"));
        reporte.setDiagnostico(resultSet.getString("Diagnostico"));
        reporte.setTratamiento(resultSet.getString("Tratamiento"));

    }
}