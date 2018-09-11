package com.bestteam.CashMoneyMarket.Repositories;

import com.bestteam.CashMoneyMarket.Models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}