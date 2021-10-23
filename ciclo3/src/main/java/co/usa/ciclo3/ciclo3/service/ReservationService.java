package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Gama;
import co.usa.ciclo3.ciclo3.model.Reservation;
import co.usa.ciclo3.ciclo3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements Serializable {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> raux=reservationRepository.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return r;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation>r=reservationRepository.getReservation(reservation.getIdReservation());
            if(!r.isEmpty()){
                if(reservation.getStartDate()!=null){
                    r.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    r.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                return reservationRepository.save(r.get());
            }
        }
        return reservation;
    }

    public boolean deleteReservation(int idReservation){
        Boolean d=getReservation(idReservation).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
}
