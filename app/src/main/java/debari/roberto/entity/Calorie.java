package debari.roberto.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Objects;

@Entity(tableName = "Calorie",
        foreignKeys = @ForeignKey(entity = Nota.class,
                parentColumns = "id",
                childColumns = "parent_id",
                onDelete = ForeignKey.CASCADE))
public class Calorie implements Serializable {
@PrimaryKey(autoGenerate = true)
Integer id;
     Integer ncalorie;
     String data;
     String pasto;
     String nomepasto;
    @ColumnInfo(name = "parent_id")
    public Integer parent_id;

    public Calorie() {
    }
    public Calorie(Integer ncalorie, String data, String pasto, String nomepasto ){
        this.ncalorie=ncalorie;
        this.data=data;
        this.pasto=pasto;
        this.nomepasto=nomepasto;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getNcalorie() {
        return ncalorie;
    }
    public void setNcalorie(Integer ncalorie) {
        this.ncalorie = ncalorie;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getPasto() {
        return pasto;
    }
    public void setPasto(String pasto) {
        this.pasto = pasto;
    }
    public String getNomepasto() {
        return nomepasto;
    }
    public void setNomepasto(String nomepasto) {
        this.nomepasto = nomepasto;
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
        Calorie calorie = (Calorie) o;
        return Objects.equals(id, calorie.id) && Objects.equals(ncalorie, calorie.ncalorie) && Objects.equals(data, calorie.data) && Objects.equals(pasto, calorie.pasto) && Objects.equals(nomepasto, calorie.nomepasto) && Objects.equals(parent_id, calorie.parent_id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, ncalorie, data, pasto, nomepasto, parent_id);
    }
}
