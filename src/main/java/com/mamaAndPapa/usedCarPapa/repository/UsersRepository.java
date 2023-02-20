package com.mamaAndPapa.usedCarPapa.repository;


import com.mamaAndPapa.usedCarPapa.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByUserIdAndUserPw(String userId, String userPw);


    Optional<Users> findByUserId(String UserId);
}
