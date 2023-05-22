package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.Canteen;
import com.upbCanteen.backend.projection.CanteenAdminView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CanteenRepository extends JpaRepository<Canteen, Long> {
    List<CanteenAdminView> findAllBy();
    Optional<Canteen> findById(Long Id);

    @Override
    void deleteById(Long aLong);

    Optional<Canteen> findByName(String name);
}
