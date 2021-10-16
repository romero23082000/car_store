package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCar;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "idGama")
    @JsonIgnoreProperties({"cars","gama"})
    private Gama gama;

    //El  many hace referencia a la clase car y el one hace referencia a la otra tabla en este caso message
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "car")
    @JsonIgnoreProperties({"car","client"})
    private List<Reservation> reservations;





    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gama getGama() {
        return gama;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public List<Message> getMessage() {
        return messages;
    }

    public void setMessage(List<Message> message) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
