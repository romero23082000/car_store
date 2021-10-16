package co.usa.ciclo3.ciclo3.service;


import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }

    public Score save(Score calificacion){

        if(calificacion.getIdScore() == null){
            return scoreRepository.save(calificacion);
        }
        else{
            Optional<Score> varTmp = scoreRepository.getScore(calificacion.getIdScore());

            if(varTmp.isPresent()){
                return calificacion;
            }
            else{
                return scoreRepository.save(calificacion);
            }
        }

    }

}