package com.upbCanteen.backend.service;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.projection.CanteenAdminView;
import com.upbCanteen.backend.repository.CanteenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanteenService {
    private CanteenRepository canteenRepository;

    public CanteenService(CanteenRepository canteenRepository) {
        this.canteenRepository = canteenRepository;
    }

    public void save(Canteen canteen) {
        canteenRepository.save(canteen);
    }

    public void delete(Long id) {
        canteenRepository.deleteById(id);
    }

    public List<CanteenAdminView> findAll() {
        return canteenRepository.findAllBy();
    }

    public Optional<Canteen> findById(Long id) { return canteenRepository.findById(id);}

    public Optional<Canteen> findByName(String name) { return canteenRepository.findByName(name);}

    public Long getNrCanteens(){
        return canteenRepository.countCanteensBy();
    }
}
