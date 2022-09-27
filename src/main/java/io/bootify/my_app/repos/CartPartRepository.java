package io.bootify.my_app.repos;

import io.bootify.my_app.domain.CartPart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartPartRepository extends JpaRepository<CartPart, Long> {
}
