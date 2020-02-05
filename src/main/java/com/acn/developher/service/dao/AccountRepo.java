package com.acn.developher.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.acn.developher.service.domain.Account;

public interface AccountRepo extends CrudRepository<Account, String>{

}
