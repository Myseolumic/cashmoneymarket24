package com.bestteam.CashMoneyMarket.Repositories;

import com.bestteam.CashMoneyMarket.Models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
