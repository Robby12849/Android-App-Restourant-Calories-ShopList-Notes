package debari.roberto.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.util.Objects;
@Entity(tableName = "Lista",
        foreignKeys = @ForeignKey(entity = Nota.class,
                parentColumns = "id",
                childColumns = "parent_id",
                onDelete = ForeignKey.CASCADE))
public class Lista implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String numero;
    private String oggetto;
    @ColumnInfo(name = "parent_id")
    Integer parent_id;

    public Lista() {
    }
    public Lista(String numero, String oggetto){
        this.numero = numero;
        this.oggetto = oggetto;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getOggetto() {
        return oggetto;
    }
    public void setOggetto(String oggetto) {
        this.oggetto = oggetto;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
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
        Lista lista = (Lista) o;
        return Objects.equals(id, lista.id) && Objects.equals(numero, lista.numero) && Objects.equals(oggetto, lista.oggetto) && Objects.equals(parent_id, lista.parent_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, oggetto, parent_id);
    }
}


