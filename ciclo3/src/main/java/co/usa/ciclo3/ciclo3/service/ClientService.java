package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }

    public Client save(Client cliente){

        if(cliente.getIdClient() == null){
            return clientRepository.save(cliente);
        }
        else{
            Optional<Client> varTmp = clientRepository.getClient(cliente.getIdClient());
            if(varTmp.isPresent()){
                return cliente;
            }
            else{
                return clientRepository.save(cliente);
            }
        }
    }
}