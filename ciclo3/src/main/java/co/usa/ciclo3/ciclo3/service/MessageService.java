package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements Serializable {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.save(m);
            }else{
                return m;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message>m=messageRepository.getMessage(message.getIdMessage());
            if(!m.isEmpty()){
                if(message.getMessageText()!=null){
                    m.get().setMessageText(message.getMessageText());
                }

                return messageRepository.save(m.get());
            }
        }
        return message;
    }

    public boolean deleteMessage(int idMessage){
        Boolean d=getMessage(idMessage).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
