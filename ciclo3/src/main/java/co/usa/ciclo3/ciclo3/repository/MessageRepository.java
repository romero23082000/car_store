package co.usa.ciclo3.ciclo3.repository;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.crud.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll(){return (List<Message>)messageCrudRepository.findAll();}
    public Optional<Message> getMessage(int id){return messageCrudRepository.findById(id);}
    public Message save(Message m){return messageCrudRepository.save(m);}
}
