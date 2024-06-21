package debari.roberto.db.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import debari.roberto.db.impl.mydb.MyDatabase;
import debari.roberto.entity.Calorie;
import debari.roberto.entity.Lista;
import debari.roberto.entity.Nota;
import debari.roberto.entity.Prenotazione;

public class DBRepository {
    private final String DB_NAME = "mydb";
    private MyDatabase myDatabase;
    private ExecutorService executor = Executors.newSingleThreadExecutor();
    public DBRepository(Context context) {
        this.myDatabase = Room.databaseBuilder(context.getApplicationContext(), MyDatabase.class, DB_NAME).build();
    }
    public void insertLista(Lista lista) {
        executor.execute(() -> myDatabase.getDaoAccess().insertLista(lista));
    }
    public void updateLista(Lista lista) {
        executor.execute(() -> myDatabase.getDaoAccess().updateLista(lista));
    }
    public void deleteLista(Lista lista) {
        executor.execute(() -> myDatabase.getDaoAccess().deleteLista(lista));
    }
    public LiveData<List<Lista>> selectAllLista() {
        return myDatabase.getDaoAccess().selectAllLista();
    }
    public void insertNota(Nota nota) {
        executor.execute(() -> myDatabase.getDaoAccess_1().insertNota(nota));
    }
    public void updateNota(Nota nota) {
        executor.execute(() -> myDatabase.getDaoAccess_1().updateNota(nota));
    }
    public void deleteNota(Nota nota) {
        executor.execute(() -> myDatabase.getDaoAccess_1().deleteNota(nota));
    }
    public LiveData<List<Nota>> selectAllNota() {
        return myDatabase.getDaoAccess_1().selectAllNota();
    }
public void insertCaloria(Calorie calorie){
    executor.execute(() -> myDatabase.getDaoAccess_2().insertCaloria(calorie));
}
public void deleteCaloria(Calorie calorie){
        executor.execute(() -> myDatabase.getDaoAccess_2().deleteCaloria(calorie));
    }
    public void updateCaloria(Calorie calorie){
        executor.execute(() -> myDatabase.getDaoAccess_2().updateCaloria(calorie));
    }
    public LiveData<List<Calorie>> selectAllCalorie(){
        return myDatabase.getDaoAccess_2().selectAllCalorie();
    }
    public LiveData<Integer> sumCalorie(String selectedDate){
        return myDatabase.getDaoAccess_2().sumCalorie(selectedDate);
    }
    public LiveData<List<String>> LimitCalorie(int limite) {
        return myDatabase.getDaoAccess_2().LimitCalorie(limite);
    }
    public void insertPrenotazione(Prenotazione prenotazione) {
        executor.execute(() -> myDatabase.getDaoAccess_3().insertPrenotazione(prenotazione));
    }
    public void updatePrenotazione(Prenotazione prenotazione) {
        executor.execute(() -> myDatabase.getDaoAccess_3().updatePrenotazione(prenotazione));
    }
    public void deletePrenotazione(Prenotazione prenotazione) {
        executor.execute(() -> myDatabase.getDaoAccess_3().deletePrenotazione(prenotazione));
    }
    public LiveData<List<Prenotazione>> selectAllPrenotazione() {
        return myDatabase.getDaoAccess_3().selectAllPrenotazione();
    }

}
