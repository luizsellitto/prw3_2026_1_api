package br.edu.ifsp.prw3.prw3_2026_1_api.conserto;

import org.springframework.data.jpa.repository.JpaRepository;

// o JpaRepository já traz o save(), findAll(), etc.
public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
}
