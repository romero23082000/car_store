package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.Gama;
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
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client>cli=clientRepository.getClient(client.getIdClient());
            if(!cli.isEmpty()){
                if(client.getName()!=null){
                    cli.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    cli.get().setAge(client.getAge());
                }
                if(client.getEmail()!=null){
                    cli.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    cli.get().setPassword(client.getPassword());
                }
                return clientRepository.save(cli.get());
            }
        }
        return client;
    }
    public boolean deleteClient(int idClient){
        Boolean d=getClient(idClient).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
}