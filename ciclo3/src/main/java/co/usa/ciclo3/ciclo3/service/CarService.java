package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Car;
import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class CarService implements Serializable {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll(){
        return carRepository.getAll();
    }
    public Optional<Car>getCar(int id){
        return carRepository.getCar(id);
    }
    public Car save(Car c){
        if(c.getIdCar()==null){
            return carRepository.save(c);
        }else{
            Optional<Car> caux=carRepository.getCar(c.getIdCar());
            if(caux.isEmpty()){
                return carRepository.save(c);
            }else{
                return c;
            }
        }
    }
    public Car update(Car car){
        if(car.getIdCar()!=null){
            Optional<Car>c=carRepository.getCar(car.getIdCar());
            if(!c.isEmpty()){
                if(car.getName()!=null){
                    c.get().setName(car.getName());
                }
                if(car.getBrand()!=null){
                    c.get().setBrand(car.getBrand());
                }
                if(car.getYear()!=null){
                    c.get().setYear(car.getYear());
                }
                if(car.getDescription()!=null){
                    c.get().setDescription(car.getDescription());
                }
                if(car.getGama()!=null){
                    c.get().setGama(car.getGama());
                }
                return carRepository.save(c.get());
            }
        }
        return car;
    }
    public boolean deleteCar(int idCar){
        Boolean d=getCar(idCar).map(car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);
        return d;
    }

}
