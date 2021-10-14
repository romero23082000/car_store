package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements Serializable {
    @Autowired
    private ClientRespository clientRespository;
    public List<Client> getAll(){
        return clientRespository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRespository.getClient(id);
    }
    public Client save(Client cli){
        if(cli.getId()==null){
            return clientRespository.save(cli);
        }else{
            Optional<Client> cliaux=clientRespository.getClient(cli.getId());
            if(cliaux.isEmpty()){
                return clientRespository.save(cli);
            }else{
                return cli;
            }
        }
    }
}
