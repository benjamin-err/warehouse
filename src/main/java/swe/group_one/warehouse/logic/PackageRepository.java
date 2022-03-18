package swe.group_one.warehouse.logic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swe.group_one.warehouse.domain.Order;

import java.util.Optional;

@Repository // Interface for data access
public interface PackageRepository extends JpaRepository<Order, Integer> {


    @Query("SELECT p FROM Order p WHERE p.billAddr.email = ?1")
    Optional<Order> findPackageByEmail(String email);

    @Query("SELECT p FROM Order p WHERE p.billAddr.name = ?1")
    Optional<Order> findPackageByName(String name);
}
