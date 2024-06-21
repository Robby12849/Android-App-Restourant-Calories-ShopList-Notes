package debari.roberto.db.DaoAccess;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import debari.roberto.entity.Lista;
import debari.roberto.entity.Nota;

@Dao
public interface DaoAccess {
    @Insert
    void insertLista(Lista lista);
    @Delete
    void deleteLista(Lista lista);
    @Update
    void updateLista(Lista lista);
    @Query("SELECT * FROM Lista")
    LiveData<List<Lista>> selectAllLista();

}
