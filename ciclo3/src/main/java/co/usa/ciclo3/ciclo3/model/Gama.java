package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Gama")
public class Gama implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGama;
    private String name;
    private String description;

    @OneToMany(cascade = {CascadeType.PERSIST} , mappedBy = "gama" )
    @JsonIgnoreProperties({"gama"})
    private List<Car> cars;

    /**
     * @return the idGama
     */
    public Integer getIdGama() {
        return idGama;
    }

    /**
     * @param idGama the idGama to set
     */
    public void setIdGama(Integer idGama) {
        this.idGama = idGama;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the cars
     */
    public List<Car> getCars() {
        return cars;
    }

    /**
     * @param cars the cars to set
     */
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }



}