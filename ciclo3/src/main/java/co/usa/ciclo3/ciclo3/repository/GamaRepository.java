package co.usa.ciclo3.ciclo3.repository;


import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.repository.crud.GamaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Repository
public class GamaRepository implements Serializable {
    @Autowired
    private GamaCrudRepository gamaCrudRepository;
    //Metodos del crud repositoy
    public List<Gama> getAll(){
        return (List<Gama>) gamaCrudRepository.findAll();
    }
    public Optional<Gama> getGama(int idGama){
        return gamaCrudRepository.findById(idGama);
    }
    public Gama save(Gama g){
        return gamaCrudRepository.save(g);
    }
    public void delete(Gama gama){
        gamaCrudRepository.delete(gama);
    }
}
