package com.donavida.donavida.repository;
import com.donavida.donavida.entity.AestheticCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface AestheticCenterRepository extends JpaRepository<AestheticCenter, Long>{
    Optional<AestheticCenter> findByUserId(Long userID);
}
