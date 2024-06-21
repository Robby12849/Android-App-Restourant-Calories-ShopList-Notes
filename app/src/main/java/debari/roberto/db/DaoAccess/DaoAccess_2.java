package debari.roberto.db.DaoAccess;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import debari.roberto.entity.Calorie;
import debari.roberto.entity.Nota;

@Dao
public interface DaoAccess_2 {
    @Insert
    void insertCaloria(Calorie calorie);
    @Delete
    void deleteCaloria(Calorie calorie);
    @Update
    void updateCaloria(Calorie calorie);
    @Query("SELECT * FROM Calorie")
    LiveData<List<Calorie>> selectAllCalorie();
    @Query("SELECT SUM(NCalorie) AS sommacalorie FROM Calorie WHERE data = :sdata")
    LiveData<Integer> sumCalorie(String sdata);

    @Query("SELECT data FROM Calorie WHERE ncalorie > :input GROUP BY data")
    LiveData<List<String>> LimitCalorie(int input);
}
