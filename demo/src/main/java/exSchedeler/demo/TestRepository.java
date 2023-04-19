package exSchedeler.demo;

import exSchedeler.demo.dto.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {

    List<Test> findAllBycreatedDateBetween(
            LocalDateTime createdDateStart,
            LocalDateTime createdDateEnd);
}
