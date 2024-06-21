package debari.roberto.db.DaoAccess;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import debari.roberto.entity.Nota;
@Dao
public interface DaoAccess_1 {
    @Insert
    void insertNota(Nota nota);
    @Delete
    void deleteNota(Nota nota);
    @Update
    void updateNota(Nota nota);
    @Query("SELECT * FROM Nota")
    LiveData<List<Nota>> selectAllNota();
}
