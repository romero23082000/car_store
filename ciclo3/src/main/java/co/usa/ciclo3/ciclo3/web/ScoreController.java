package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Score;
import co.usa.ciclo3.ciclo3.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getCalificaciones(){
        return scoreService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Score> getCalificacion(@PathVariable("id")int id){
        return scoreService.getScore(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score calificacion){
        return scoreService.save(calificacion);
    }
}
