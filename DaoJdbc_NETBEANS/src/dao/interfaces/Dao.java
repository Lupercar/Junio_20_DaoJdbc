package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T> { 
    List<T> get()throws SQLException; 
    T get(int id)throws SQLException;
    void add(T entidad)throws SQLException; 
    void remove(T entidad)throws SQLException; 
    void update(T entidad)throws SQLException; 
}//fin interface dao.Dao
