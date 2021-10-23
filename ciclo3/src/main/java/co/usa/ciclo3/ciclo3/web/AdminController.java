package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/all")
    public List<Admin> getAdmins(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id")int id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return adminService.save(admin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return adminService.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId) {
        return adminService.deleteAdmin(adminId);
    }
}
