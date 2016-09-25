package dao;

import dao.interfaces.DaoClientes;
import entidades.Cliente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import oracle.jdbc.OracleDriver;

public class ClientesJdbcOracleDao implements DaoClientes{

    public ClientesJdbcOracleDao() throws SQLException, IOException {
//        Cargar driver a la MVJ
        DriverManager.registerDriver(new OracleDriver());
        
//        Leemos configuración BBDD de un fichero de propiedades
        Properties prop = new Properties();
        prop.load(ClientesJdbcOracleDao
                .class
                .getResourceAsStream("../configuracion/Oracle.properties"));

//        Creamos conexion a BBDD
        Connection conexion = DriverManager
                .getConnection(
                        prop.getProperty("url"), 
                        prop.getProperty("user"), 
                        prop.getProperty("password"));
    }
    
    @Override
    public List<Cliente> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Cliente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Cliente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Cliente entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}//fin class dao.ClientesJdbcDao
