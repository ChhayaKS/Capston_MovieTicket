package org.capston.mymovie.repository;

import java.util.List;

import org.capston.mymovie.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long>{

	List<Cart> findAllByUserId(Long id);
}
