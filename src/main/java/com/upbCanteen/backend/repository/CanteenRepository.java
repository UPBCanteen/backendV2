package com.upbCanteen.backend.repository;

import com.upbCanteen.backend.model.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanteenRepository extends JpaRepository<Canteen, Long> {
}
