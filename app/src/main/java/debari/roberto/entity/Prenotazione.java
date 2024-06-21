package debari.roberto.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "Prenotazione",
        foreignKeys = @ForeignKey(entity = Nota.class,
                parentColumns = "id",
                childColumns = "parent_id",
                onDelete = ForeignKey.CASCADE))
public class Prenotazione implements Serializable {
    @PrimaryKey(autoGenerate = true)
    Integer id;
    String paese;
    Integer seggiolino;
    String nomeristorante;
    String data;
    String ora;
    Integer tavoli;
    Integer npersone;
    @ColumnInfo(name = "parent_id")
    Integer parent_id;

    public Prenotazione(){
    }
public Prenotazione(String paese, String nomeristorante, String data, String ora, Integer seggiolino, Integer tavoli, Integer npersone){
        this.paese=paese;
        this.nomeristorante=nomeristorante;
        this.data=data;
        this.ora=ora;
        this.seggiolino=seggiolino;
        this.tavoli=tavoli;
        this.npersone=npersone;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPaese() {
        return paese;
    }
    public void setPaese(String paese) {
        this.paese = paese;
    }
    public String getNomeristorante() {
        return nomeristorante;
    }
    public void setNomeristorante(String nomeristorante) {
        this.nomeristorante = nomeristorante;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getOra() {
        return ora;
    }
    public void setOra(String ora) {
        this.ora = ora;
    }

    public Integer getNpersone() {
        return npersone;
    }

    public void setNpersone(Integer npersone) {
        this.npersone = npersone;
    }

    public Integer getSeggiolino() {
        return seggiolino;
    }

    public void setSeggiolino(Integer seggiolino) {
        this.seggiolino = seggiolino;
    }

    public Integer getTavoli() {
        return tavoli;
    }

    public void setTavoli(Integer tavoli) {
        this.tavoli = tavoli;
    }

    public Integer getParent_id() {
        return parent_id;
    }
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id) && Objects.equals(paese, that.paese) && Objects.equals(seggiolino, that.seggiolino) && Objects.equals(nomeristorante, that.nomeristorante) && Objects.equals(data, that.data) && Objects.equals(ora, that.ora) && Objects.equals(tavoli, that.tavoli) && Objects.equals(npersone, that.npersone) && Objects.equals(parent_id, that.parent_id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, paese, seggiolino, nomeristorante, data, ora, tavoli, npersone, parent_id);
    }
}

