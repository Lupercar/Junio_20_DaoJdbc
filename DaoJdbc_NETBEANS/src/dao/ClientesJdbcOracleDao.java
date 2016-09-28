package dao;

import dao.interfaces.DaoClientes;
import entidades.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import oracle.jdbc.OracleDriver;

public class ClientesJdbcOracleDao implements DaoClientes {

    private Properties prop = new Properties();

    public ClientesJdbcOracleDao() throws SQLException, IOException {
//        Cargar driver a la MVJ
        DriverManager.registerDriver(new OracleDriver());

//        Leemos configuración BBDD de un fichero de propiedades
        prop.load(ClientesJdbcOracleDao.class
                .getResourceAsStream("../configuracion/Oracle.properties"));
    }

    @Override
    public List<Cliente> get() throws SQLException {

        List<Cliente> clientes = new ArrayList<>();

//        Creamos conexion a BBDD
        Connection conexion = this.getConexion();

//        Hacemos la operación correspondiente
        Statement comando = conexion.createStatement();
        String sql = "SELECT * FROM cliente";
        ResultSet resultado = comando.executeQuery(sql);

//        procesamos los datos y los pasamos a objetos
        while (resultado.next()) {

            clientes.add(new Cliente(
                    resultado.getInt("id"),
                    resultado.getString("nombre")
            ));
        }

        resultado.close();
        comando.close();
        conexion.close();

        return clientes;
    }

    @Override
    public Cliente get(int id) throws SQLException {
        Cliente cliente = null;

//        Creamos conexion a BBDD
        Connection conexion = this.getConexion();

//        Hacemos la operación correspondiente
        Statement comando = conexion.createStatement();
        String sql = "SELECT * FROM cliente WHERE id =" + id;
        ResultSet resultado = comando.executeQuery(sql);

//        procesamos los datos y los pasamos a objetos
        if (resultado.next()) {

            cliente = new Cliente(
                    resultado.getInt("id"),
                    resultado.getString("nombre")
            );
        }

        resultado.close();
        comando.close();
        conexion.close();

        return cliente;
    }

    @Override
    public void add(Cliente entidad) throws SQLException {

//        Creo conexion a BBDD
        Connection conexion = this.getConexion();

//        Hacemos la operación correspondiente
//        Statement comando = conexion.createStatement();
        
//        No es la forma más correcta de poner el sql
//        String sql = "INSERT INTO "
//                + "cliente(id, nombre) "
//                + "VALUES ("+cliente.getId()+", '"
//                +cliente.getNombre()+"') "; 
//        ResultSet resultado = comando.executeUpdate(sql);
        
//        INSERT INTO cliente(id, nombre) VALUES (1,'pepito');
        
//        Hacemos la operación correspondiente
        String sql = "INSERT INTO cliente(id, nombre) VALUES (?,?)"; 
        PreparedStatement comando = conexion.prepareStatement(sql); 
        
        comando.setInt(1, entidad.getId()); 
        comando.setString(2, entidad.getNombre());
        
        comando.executeUpdate(); 
        
        comando.close();
        conexion.close();
    }

    @Override
    public void remove(Cliente entidad) throws SQLException {
//        Creo conexion a BBDD
        Connection conexion = this.getConexion();

//        Hacemos la operación correspondiente
        String sql = "DELETE FROM cliente WHERE id = ?"; 
        PreparedStatement comando = conexion.prepareStatement(sql); 
        comando.setInt(1, entidad.getId());
        comando.executeUpdate(); 
        
        comando.close();
        conexion.close();
    }

    @Override
    public void update(Cliente entidad) throws SQLException {
//        Creo conexion a BBDD
        Connection conexion = this.getConexion();

//        Hacemos la operación correspondiente
        String sql = "UPDATE CLIENTE SET nombre = ? WHERE id = ?"; 
        PreparedStatement comando = conexion.prepareStatement(sql); 
        comando.setString(1, entidad.getNombre());
        comando.setInt(2, entidad.getId());
        comando.executeUpdate(); 
        
        comando.close();
        conexion.close();
    }

    private Connection getConexion() throws SQLException {
//        Creamos conexion a BBDD
        Connection conexion = DriverManager
                .getConnection(
                        prop.getProperty("url"),
                        prop.getProperty("user"),
                        prop.getProperty("password"));
        return conexion;
    }
}//fin class dao.ClientesJdbcDao
