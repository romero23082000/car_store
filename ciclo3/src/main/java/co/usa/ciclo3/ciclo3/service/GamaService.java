package co.usa.ciclo3.ciclo3.service;


import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.repository.GamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Service
public class GamaService implements Serializable {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll(){
        return gamaRepository.getAll();
    }
    public Optional<Gama> getGama(int id){
        return gamaRepository.getGama(id);
    }
    public Gama save(Gama g){
        if(g.getIdGama()==null){
            return gamaRepository.save(g);
        }else{
            Optional<Gama> gaux=gamaRepository.getGama(g.getIdGama());
            if(gaux.isEmpty()){
                return gamaRepository.save(g);
            }else{
                return g;
            }
        }
    }
}
