package debari.roberto.db.DaoAccess;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import debari.roberto.entity.Lista;
import debari.roberto.entity.Prenotazione;
@Dao
public interface DaoAccess_3 {
    @Insert
    void insertPrenotazione(Prenotazione prenotazione);
    @Delete
    void deletePrenotazione(Prenotazione prenotazione);
    @Update
    void updatePrenotazione(Prenotazione prenotazione);
    @Query("SELECT * FROM Prenotazione")
    LiveData<List<Prenotazione>> selectAllPrenotazione();
}
