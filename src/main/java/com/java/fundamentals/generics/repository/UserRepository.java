package com.java.fundamentals.generics.repository;

import com.java.fundamentals.generics.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Long> {
}
