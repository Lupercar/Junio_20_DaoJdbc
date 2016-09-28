package dto;

import dao.ClientesJdbcOracleDao;
import dao.interfaces.DaoClientes;
import entidades.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

public class ClientesDto implements DaoClientes{
    
    private final DaoClientes dao; 

    public ClientesDto() throws SQLException, IOException {
        this.dao = new ClientesJdbcOracleDao();
    }

    @Override
    public List<Cliente> get() throws SQLException {
        List<Cliente> clientesDao = dao.get(); 
        
//        En el DTO queremos que sea una lista observable
        return ObservableCollections.observableList(clientesDao); 
    }

    @Override
    public Cliente get(int id) throws SQLException{
//        Lo que nos da DAO lo pasamos al DTO
        return dao.get(id); 
    }

    @Override
    public void add(Cliente entidad) throws SQLException{
        dao.add(entidad);
    }

    @Override
    public void remove(Cliente entidad) throws SQLException{
        dao.remove(entidad);
    }

    @Override
    public void update(Cliente entidad) throws SQLException{
        dao.update(entidad);
    }
}//fin class dto.ClienteDto
