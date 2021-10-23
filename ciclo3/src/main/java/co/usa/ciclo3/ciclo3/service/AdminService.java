package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.model.Car;
import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements Serializable {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return adminRepository.save(admin);
        }else{
            Optional<Admin> adminaux=adminRepository.getAdmin(admin.getIdAdmin());
            if(adminaux.isEmpty()){
                return adminRepository.save(admin);
            }else{
                return admin;
            }
        }
    }
    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>a=adminRepository.getAdmin(admin.getIdAdmin());
            if(!a.isEmpty()){
                if(admin.getName()!=null){
                    a.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    a.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    a.get().setPassword(admin.getPassword());
                }

                return adminRepository.save(a.get());
            }
        }
        return admin;
    }
    public boolean deleteAdmin(int idAdmin){
        Boolean d=getAdmin(idAdmin).map(admin -> {
            adminRepository.delete(admin);
            return true;
        }).orElse(false);
        return d;
    }

}
