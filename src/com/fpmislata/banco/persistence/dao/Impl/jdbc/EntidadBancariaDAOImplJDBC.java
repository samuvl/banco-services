package com.fpmislata.banco.persistence.dao.impl.jdbc;

import com.fpmislata.banco.persistence.jdbc.ConnectionFactory;
import com.fpmislata.banco.business.domain.EntidadBancaria;
import com.fpmislata.banco.persistence.dao.EntidadBancariaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alumno
 */
public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    @Autowired
    ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(int idEntidadBancaria) {
        EntidadBancaria entidadBancaria;
        Connection conexion = connectionFactory.getConnection();
        try {
            String query = "SELECT * FROM EntidadBancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, idEntidadBancaria);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria(resultSet.getString("nombre"), resultSet.getInt("codigoEntidad"));
                entidadBancaria.setCif(resultSet.getString("CIF"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
            } else {
                entidadBancaria = null;
            }

            connectionFactory.close(conexion);

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return entidadBancaria;
    }

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        int id = 0;
        EntidadBancaria entidadBancariaDevolver = null;
        Connection conexion = connectionFactory.getConnection();
        try {
            String query = "INSERT INTO EntidadBancaria (nombre, codigoEntidad, fechaCreacion, direccion, CIF) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setDate(3, entidadBancaria.getFechaCreacion());
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            entidadBancariaDevolver = this.get(id);
            connectionFactory.close(conexion);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return entidadBancariaDevolver;
    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        EntidadBancaria entidadBancariaDevolver = null;
        Connection conexion = connectionFactory.getConnection();
        try {
            String query = "UPDATE EntidadBancaria SET nombre = ?, codigoEntidad = ?, fechaCreacion = ?, direccion = ?, CIF = ? WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setInt(2, entidadBancaria.getCodigoEntidad());
            preparedStatement.setDate(3, entidadBancaria.getFechaCreacion());
            preparedStatement.setString(4, entidadBancaria.getDireccion());
            preparedStatement.setString(5, entidadBancaria.getCif());
            preparedStatement.setInt(6, entidadBancaria.getIdEntidadBancaria());
            int filasActualizadas = preparedStatement.executeUpdate();

            if (filasActualizadas == 1) {
                entidadBancariaDevolver = this.get(entidadBancaria.getIdEntidadBancaria());
            } else if (filasActualizadas == 0) {
                throw new RuntimeException("No se ha actualizado ninguna fila: " + filasActualizadas);
            } else {
                throw new RuntimeException("Soy un paranoico" + filasActualizadas);
            }
            connectionFactory.close(conexion);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return entidadBancariaDevolver;
    }

    @Override
    public boolean delete(int idEntidadBancaria) {
        boolean exito = false;
        Connection conexion = connectionFactory.getConnection();
        try {
            String query = "DELETE FROM EntidadBancaria WHERE idEntidadBancaria = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setInt(1, idEntidadBancaria);
            int filasBorradas = preparedStatement.executeUpdate();

            if (filasBorradas == 0) {
                exito = false;
            } else if (filasBorradas == 1) {
                exito = true;
            } else if (filasBorradas > 1) {
                throw new RuntimeException("Demasiadas filas borrasdas: " + filasBorradas);
            } else {
                throw new RuntimeException("Soy un paranoico" + filasBorradas);
            }
            connectionFactory.close(conexion);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return exito;
    }

    @Override
    public List<EntidadBancaria> findAll() {
        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        Connection conexion = connectionFactory.getConnection();

        try {
            String query = "SELECT * FROM EntidadBancaria";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(resultSet.getString("nombre"), resultSet.getInt("codigoEntidad"));
                entidadBancaria.setCif(resultSet.getString("CIF"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("identidadBancaria"));
                entidadesBancarias.add(entidadBancaria);
            }
            //Thread.sleep(14000);
            connectionFactory.close(conexion);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return entidadesBancarias;

    }

    @Override
    public List<EntidadBancaria> findByNombre(String nombre) {
        List<EntidadBancaria> entidadesBancarias = new ArrayList<>();
        Connection conexion = connectionFactory.getConnection();

        try {
            String query = "SELECT * FROM EntidadBancaria where nombre = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(query);
            preparedStatement.setString(1, nombre);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EntidadBancaria entidadBancaria = new EntidadBancaria(resultSet.getString("nombre"), resultSet.getInt("codigoEntidad"));
                entidadBancaria.setCif(resultSet.getString("CIF"));
                entidadBancaria.setDireccion(resultSet.getString("direccion"));
                entidadBancaria.setFechaCreacion(resultSet.getDate("fechaCreacion"));
                entidadBancaria.setIdEntidadBancaria(resultSet.getInt("idEntidadBancaria"));
                entidadesBancarias.add(entidadBancaria);
            }
            connectionFactory.close(conexion);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());

        }
        return entidadesBancarias;
    }
}
