package io.bootify.my_app.repos;

import io.bootify.my_app.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
