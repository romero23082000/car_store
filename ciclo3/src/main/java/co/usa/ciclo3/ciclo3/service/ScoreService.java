package co.usa.ciclo3.ciclo3.service;


import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class ScoreService implements Serializable {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score s){
        if(s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> saux=scoreRepository.getScore(s.getIdScore());
            if(saux.isEmpty()){
                return scoreRepository.save(s);
            }else{
                return s;
            }
        }
    }
}
