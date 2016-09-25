package dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface Dao <T>{ 
    List<T> get()throws SQLException; 
    T get(int id);
    void add(T entidad); 
    void remove(T entidad); 
    void update(T entidad); 
}//fin interface dao.Dao
