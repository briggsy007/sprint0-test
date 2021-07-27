package com.earlytalenttest.test;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

@Repository
public interface SnackRepository extends JpaRepository<Snack, UUID> {

}

