package debari.roberto.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Nota implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String contenuto;

    public Nota() {
    }

    public Nota(String contenuto) {
        this.contenuto = contenuto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nota nota = (Nota) o;
        return Objects.equals(id, nota.id) && Objects.equals(contenuto, nota.contenuto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contenuto);
    }
}
