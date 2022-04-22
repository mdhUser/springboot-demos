package org.maxwell.springboot.dao;

import org.maxwell.springboot.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/26 12:58
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {




}
