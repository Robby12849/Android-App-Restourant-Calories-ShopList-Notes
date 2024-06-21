package debari.roberto.db.impl.mydb;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import debari.roberto.db.DaoAccess.DaoAccess;
import debari.roberto.db.DaoAccess.DaoAccess_1;
import debari.roberto.db.DaoAccess.DaoAccess_2;
import debari.roberto.db.DaoAccess.DaoAccess_3;
import debari.roberto.entity.Calorie;
import debari.roberto.entity.Lista;
import debari.roberto.entity.Nota;
import debari.roberto.entity.Prenotazione;

@Database(entities ={Lista.class, Nota.class, Calorie.class, Prenotazione.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase {
    public abstract DaoAccess getDaoAccess();
    public abstract DaoAccess_1 getDaoAccess_1();
    public abstract DaoAccess_2 getDaoAccess_2();
    public abstract DaoAccess_3 getDaoAccess_3();
}


