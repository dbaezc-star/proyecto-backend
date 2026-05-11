package com.donavida.donavida.repository;
import com.donavida.donavida.entity.AestheticCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.donavida.donavida.entity.AestheticCenter;
import com.donavida.donavida.repository.AestheticCenterRepository;

public interface AestheticCenterRepository extends JpaRepository<AestheticCenter, Long> {
    Optional<AestheticCenter> findByUserId(Long userID);
    Optional<AestheticCenter> findByUserEmail(String email);
}
