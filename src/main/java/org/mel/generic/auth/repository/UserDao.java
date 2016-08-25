package org.mel.generic.auth.repository;

import org.mel.generic.auth.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

}
