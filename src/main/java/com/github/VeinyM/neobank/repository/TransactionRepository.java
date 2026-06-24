package com.github.VeinyM.neobank.repository;

import com.github.VeinyM.neobank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
